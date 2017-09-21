from HTMLParser import HTMLParser
from autoimagegetter import process_image
import string
import json
import re

NULL_A = (0,0)
TITLE_A = ('class', 'cardTitle')
MANA_COST_A = ('class', 'manaCost')
MANA_CMC = ('class', 'convertedManaCost')
TYPE_A = ('class', 'typeLine')
RULES_A = ('rules')
LEFT_COL_A = ('class', 'leftCol')
IMG_ID = ('IMG_ID')



DO_IMAGES = False

class CardBuilder():
	
	current_card = {('rules'):''}
	mana_cost = []

	def export_to_list(self, lst):
		lst += [self.current_card.copy()]
	
	def export(self):
		return self.current_card.copy()
	
	def reset(self):
		self.current_card.clear()
		self.current_card = {('rules'):''}
		self.mana_cost = []

class MyHTMLParser(HTMLParser):	
	IN_RULES = False
	IN_LEFT = False
	CURRENT_ATTR = NULL_A
	cb = CardBuilder()
	current_c = {}
	cardList = []
	
	def get_symbol(self, att):
		for i in att:
			if i[0] == 'alt':
				return i[1]
	
	def handle_starttag(self, tag, attrs):
		if tag == 'span':
			self.CURRENT_ATTR = attrs[0]
		if tag == 'p':
			self.IN_RULES = True
		if tag == 'img':
			if self.CURRENT_ATTR == MANA_COST_A:
				self.cb.mana_cost += [self.get_symbol(attrs)]
			elif self.IN_RULES:
				self.cb.current_card[RULES_A] += self.get_symbol(attrs)
			elif self.IN_LEFT:
				if attrs[0][0] == 'src':
					if DO_IMAGES:
						process_image(attrs[0][1])
					self.cb.current_card[IMG_ID] = string.split((string.split(attrs[0][1], '=')[1]), "&")[0]
		if tag == 'td':
			if attrs[0] == LEFT_COL_A:
				self.IN_LEFT = True
	def handle_endtag(self, tag):
		if tag == 'span':
			if self.CURRENT_ATTR == MANA_COST_A:
				self.cb.current_card[self.CURRENT_ATTR] = self.cb.mana_cost
			self.CURRENT_ATTR = NULL_A
		if tag == 'p':
			self.IN_RULES = False
		if tag == 'table':
			current_c = self.cb.export()
			self.cb.export_to_list(self.cardList)
			#for i in current_c:
			#	print i, current_c[i]
			#print ''
			self.cb.reset()
		if tag == 'td':
			IN_LEFT = False
	def handle_data(self, data):
		if self.CURRENT_ATTR != NULL_A:
			self.cb.current_card[self.CURRENT_ATTR] = data#.strip()#''.join(data.split())
		elif self.IN_RULES:
			self.cb.current_card[RULES_A] += data
		
f = open("m2011allCards.html", "r")

parser = MyHTMLParser()
#parser.feed(string.split(f.read(), "<table>")[1]);
parser.feed(f.read());
f.close();
def print_all(lst):
	for i in lst:
		print ''
		print i

def export_all_json(lst):
	with open('allCards.json', 'w') as json_f:
		json.dump(lst, json_f, indent=4)

#export_all(parser.cardList)
#print_all(parser.cardList)


for i in parser.cardList:
	for j in i:
		if j == ('class', 'typeLine'):
			i[j] = re.sub(r'\W+','',i[j])
			i[j] = re.sub(r'([a-z])([A-Z])',r'\1 \2',i[j])
			i[j] = re.sub(r'([a-z])([0-9])',r'\1 \2',i[j])
			i[j] = re.sub(r'([0-9])([0-9])',r'\1 \2',i[j])
		elif j == 'rules':
			i[j] = re.sub(r' \([^)]*\)','',i[j])
			i[j] = re.sub(r'([a-z])([A-Z0-9])',r'\1.\2',i[j])
			i[j] = re.sub(r'([a-z0-9])[.]([A-Z0-9])',r'\1.\2',i[j])
			i[j] = filter(None, string.split(i[j], '.'))
		if (len(j) > 1) and (not (type(j) is str)):
			i[j[1]] = i[j]
			del i[j]
		elif not (type(j) is str):
			i[j[0]] = i[j]
			del i[j]
#for i in range(len(parser.cardList)):
#	print parser.cardList[i]['rules']
#	print ''
#Tokenify the rules
for i in parser.cardList:
	if 'Planeswalker' in i['typeLine']:
		print
	else:
		for j in range(len(i['rules'])):
			#Nouns
			if(i["IMG_ID"] == '205041'):
				print i['rules']
			i['rules'][j] = i['rules'][j].replace("on " + i['cardTitle'], "(THIS)")
			i['rules'][j] = i['rules'][j].replace(i['cardTitle'], "(THIS)")
			i['rules'][j] = i['rules'][j].replace("artifacts", "(ARTIFACTS)")
			i['rules'][j] = i['rules'][j].replace("basic lands", "(BASICS)")
			i['rules'][j] = i['rules'][j].replace("enchantments", "(ENCHANTMENTS)")
			i['rules'][j] = i['rules'][j].replace("creatures", "(CREATURES)")
			i['rules'][j] = i['rules'][j].replace("instants", "(INSTANTS)")
			i['rules'][j] = i['rules'][j].replace("sorceries", "(SORCERIES)")
			i['rules'][j] = i['rules'][j].replace("lands", "(LANDS)")
			i['rules'][j] = i['rules'][j].replace("spells", "(SPELLS)")
			
			i['rules'][j] = i['rules'][j].replace("artifact", "(ARTIFACT)")
			i['rules'][j] = i['rules'][j].replace("basic land", "(BASIC)")
			i['rules'][j] = i['rules'][j].replace("enchantment", "(ENCHANTMENT)")
			i['rules'][j] = i['rules'][j].replace("creature", "(CREATURE)")
			i['rules'][j] = i['rules'][j].replace("instant", "(INSTANT)")
			i['rules'][j] = i['rules'][j].replace("sorcery", "(SORCERY)")
			i['rules'][j] = i['rules'][j].replace("land", "(LAND)")
			i['rules'][j] = i['rules'][j].replace("spell", "(SPELL)")
			
			#Types of abilities
			i['rules'][j] = i['rules'][j].replace("Whenever", "[REACTIVE]")
			i['rules'][j] = i['rules'][j].replace("whenever", "[REACTIVE]")
			i['rules'][j] = i['rules'][j].replace("When", "[REACTIVE]")
			i['rules'][j] = i['rules'][j].replace("when", "[REACTIVE]")
			i['rules'][j] = i['rules'][j].replace("enters the battlefield with", "[ETBW]")
			i['rules'][j] = i['rules'][j].replace("At the beginning of", "[TIME]")
			i['rules'][j] = i['rules'][j].replace("at the beginning of", "[TIME]")
			
			#Actions to do
			i['rules'][j] = i['rules'][j].replace("becomes a Vampire in addition to it's other types", "=BECOMES_VAMPIRE=")
			i['rules'][j] = i['rules'][j].replace("Tap five untapped Vampires you control", "=TAP_FIVE_VAMPS=")
			i['rules'][j] = i['rules'][j].replace("Destroy", "=DESTROY=")
			i['rules'][j] = i['rules'][j].replace("destroy", "=DESTROY=")
			i['rules'][j] = i['rules'][j].replace("Return", "=RETURN=")
			i['rules'][j] = i['rules'][j].replace("return", "=RETURN=")
			i['rules'][j] = i['rules'][j].replace("Put a +1/+1 counter", "=ADD_+1_+1=")
			i['rules'][j] = i['rules'][j].replace("put a +1/+1 counter", "=ADD_+1_+1=")
			i['rules'][j] = i['rules'][j].replace("Puts a +1/+1 counter", "=ADDS_+1_+1=")
			i['rules'][j] = i['rules'][j].replace("puts a +1/+1 counter", "=ADDS_+1_+1=")
			i['rules'][j] = i['rules'][j].replace("Counter", "=COUNTER=")
			i['rules'][j] = i['rules'][j].replace("counter", "=COUNTER=")
			i['rules'][j] = i['rules'][j].replace("Add one mana of any color to your mana pool", "=ADD_ONE_ANY_COLOR=")
			i['rules'][j] = i['rules'][j].replace("gets", "=GETS=")
			i['rules'][j] = i['rules'][j].replace("Gains", "=GAINS=")
			i['rules'][j] = i['rules'][j].replace("gains", "=GAINS=")
			i['rules'][j] = i['rules'][j].replace("Gain control of", "=GET_CONTROL=")
			i['rules'][j] = i['rules'][j].replace("gain control of", "=GET_CONTROL=")
			i['rules'][j] = i['rules'][j].replace("untapped", "$UNTAPPED$")
			i['rules'][j] = i['rules'][j].replace("tapped", "$TAPPED$")
			i['rules'][j] = i['rules'][j].replace("Untap", "=UNTAP=")
			i['rules'][j] = i['rules'][j].replace("untap", "=UNTAP=")
			i['rules'][j] = i['rules'][j].replace("attacks you this turn if able", "=MUST_ATTACK=")
			i['rules'][j] = i['rules'][j].replace("sacrifice", "=SACRIFICE=")
			i['rules'][j] = i['rules'][j].replace("Sacrifice a", "=SACRIFICE_ONE=")
			i['rules'][j] = i['rules'][j].replace("tap", "=TAP=")
			i['rules'][j] = i['rules'][j].replace("Tap", "=TAP=")
			i['rules'][j] = i['rules'][j].replace("exile", "=EXILE=")
			i['rules'][j] = i['rules'][j].replace("Exile", "=EXILE=")
			i['rules'][j] = i['rules'][j].replace("scry 1", "=SCRY_1=")
			i['rules'][j] = i['rules'][j].replace("scry 2", "=SCRY_2=")
			i['rules'][j] = i['rules'][j].replace("scry 3", "=SCRY_3=")
			i['rules'][j] = i['rules'][j].replace("scry 4", "=SCRY_4=")
			i['rules'][j] = i['rules'][j].replace("draw a card", "=DRAW_1=")
			i['rules'][j] = i['rules'][j].replace("draw 2 cards", "=DRAW_2=")
			i['rules'][j] = i['rules'][j].replace("draw 3 cards", "=DRAW_3=")
			i['rules'][j] = i['rules'][j].replace("draw 4 cards", "=DRAW_4=")
			i['rules'][j] = i['rules'][j].replace("regenerate", "=REGENERATE=")
			i['rules'][j] = i['rules'][j].replace("Regenerate", "=REGENERATE=")
			i['rules'][j] = i['rules'][j].replace("fights", "=FIGHTS=")
			
			#Qualifiers
			i['rules'][j] = i['rules'][j].replace("with", "$WITH$")
			i['rules'][j] = i['rules'][j].replace("without", "$WITHOUT$")
			i['rules'][j] = i['rules'][j].replace("you may", "$P_OPTIONAL$")
			i['rules'][j] = i['rules'][j].replace("an opponent controls", "$OPP_CONTROLS$")
			i['rules'][j] = i['rules'][j].replace("you control", "$YOU_CONTROL$")
			i['rules'][j] = i['rules'][j].replace("until", "$UNTIL$")
			i['rules'][j] = i['rules'][j].replace("nonwhite", "$NONWHITE$")
			i['rules'][j] = i['rules'][j].replace("nonred", "$NONRED$")
			i['rules'][j] = i['rules'][j].replace("nonblack", "$NONBLACK$")
			i['rules'][j] = i['rules'][j].replace("nonblue", "$NONBLUE$")
			i['rules'][j] = i['rules'][j].replace("nongreen", "$NONGREEN$")
			i['rules'][j] = i['rules'][j].replace("Nonwhite", "$NONWHITE$")
			i['rules'][j] = i['rules'][j].replace("Nonred", "$NONRED$")
			i['rules'][j] = i['rules'][j].replace("Nonblack", "$NONBLACK$")
			i['rules'][j] = i['rules'][j].replace("Nonblue", "$NONBLUE$")
			i['rules'][j] = i['rules'][j].replace("Nongreen", "$NONGREEN$")
			i['rules'][j] = i['rules'][j].replace("white", "$WHITE$")
			i['rules'][j] = i['rules'][j].replace("red", "$RED$")
			i['rules'][j] = i['rules'][j].replace("black", "$BLACK$")
			i['rules'][j] = i['rules'][j].replace("blue", "$BLUE$")
			i['rules'][j] = i['rules'][j].replace("green", "$GREEN$")
			i['rules'][j] = i['rules'][j].replace("White", "$WHITE$")
			i['rules'][j] = i['rules'][j].replace("Red", "$RED$")
			i['rules'][j] = i['rules'][j].replace("Black", "$BLACK$")
			i['rules'][j] = i['rules'][j].replace("Blue", "$BLUE$")
			i['rules'][j] = i['rules'][j].replace("Green", "$GREEN$")
			i['rules'][j] = i['rules'][j].replace("permanent", "$PERMANENT$")
			i['rules'][j] = i['rules'][j].replace("permanents", "$PERMANENTS$")
			
			i['rules'][j] = i['rules'][j].replace("from your graveyard to your hand", "$FROM_GRAVE_TO_HAND$")
			
			
			
			
			
			#Times
			i['rules'][j] = i['rules'][j].replace("enters the battlefield", "@ETB@")
			i['rules'][j] = i['rules'][j].replace("At the begining", "@START_OF@")
			i['rules'][j] = i['rules'][j].replace("your upkeep", "@P_UPKEEP@")
			i['rules'][j] = i['rules'][j].replace("your end step", "@E_END@")
			i['rules'][j] = i['rules'][j].replace("your opponent's upkeep", "@P_UPKEEP@")
			i['rules'][j] = i['rules'][j].replace("your opponent's end step", "@E_END@")
			i['rules'][j] = i['rules'][j].replace("you gain life", "@P_GETS_LIFE@")
			i['rules'][j] = i['rules'][j].replace("end of turn", "@C_END@")
			i['rules'][j] = i['rules'][j].replace("a player casts a", "@ANYONE_CASTS@")
			
			#Keyword abilities
			i['rules'][j] = i['rules'][j].replace("haste", "*HASTE*")
			i['rules'][j] = i['rules'][j].replace("Haste", "*HASTE*")
			i['rules'][j] = i['rules'][j].replace("flying", "*FLYING*")
			i['rules'][j] = i['rules'][j].replace("Flying", "*FLYING*")
			i['rules'][j] = i['rules'][j].replace("defender", "*DEFENDER*")
			i['rules'][j] = i['rules'][j].replace("Defender", "*DEFENDER*")
			i['rules'][j] = i['rules'][j].replace("lifelink", "*LIFELINK*")
			i['rules'][j] = i['rules'][j].replace("Likelink", "*LIKELINK*")
			i['rules'][j] = i['rules'][j].replace("trample", "*TRAMPLE*")
			i['rules'][j] = i['rules'][j].replace("Trample", "*TRAMPLE*")
			i['rules'][j] = i['rules'][j].replace("reach", "*REACH*")
			i['rules'][j] = i['rules'][j].replace("Reach", "*REACH*")
			i['rules'][j] = i['rules'][j].replace("protection from Demons and from Dragons", "*PRO_DEMON_DRAGON*")
			i['rules'][j] = i['rules'][j].replace("Protection from", "*PRO*")
			i['rules'][j] = i['rules'][j].replace("protection from", "*PRO*")
			i['rules'][j] = i['rules'][j].replace("Vigilance", "*VIGILANCE*")
			i['rules'][j] = i['rules'][j].replace("vigilance", "*VIGILANCE*")
			i['rules'][j] = i['rules'][j].replace("First strike", "*FIRST_STRIKE*")
			i['rules'][j] = i['rules'][j].replace("first strike", "*FIRST_STRIKE*")
			i['rules'][j] = i['rules'][j].replace("attacks each turn if able", "*MUST_ATTACK*")
			
			

			
			
			#Things affected by ability
			i['rules'][j] = i['rules'][j].replace("target", "!TARGET!")
			i['rules'][j] = i['rules'][j].replace("Target", "!TARGET!")
			i['rules'][j] = i['rules'][j].replace("All", "!ALL!")
			i['rules'][j] = i['rules'][j].replace("all", "!ALL!")
			i['rules'][j] = i['rules'][j].replace("It's controller", "!PRIOR_T_C!")
			i['rules'][j] = i['rules'][j].replace("its controller", "!PRIOR_T_C!")
			i['rules'][j] = i['rules'][j].replace("It's owner's hand", "!PRIOR_T_O_H!")
			i['rules'][j] = i['rules'][j].replace("its owner's hand", "!PRIOR_T_O_H!")
			i['rules'][j] = i['rules'][j].replace("It", "!PRIOR_T!")
			i['rules'][j] = i['rules'][j].replace("it", "!PRIOR_T!")
			i['rules'][j] = i['rules'][j].replace("That creature", "!PRIOR_T!")
			i['rules'][j] = i['rules'][j].replace("that creature", "!PRIOR_T!")
			
			
			
export_all_json(parser.cardList)























