from HTMLParser import HTMLParser
from autoimagegetter import process_image
import string

NULL_A = (0,0)
TITLE_A = ('class', 'cardTitle')
MANA_COST_A = ('class', 'manaCost')
MANA_CMC = ('class', 'convertedManaCost')
TYPE_A = ('class', 'typeLine')
RULES_A = ('rules')
LEFT_COL_A = ('class', 'leftCol')
IMG_ID = ('IMG_ID')

cardList = []

DO_IMAGES = True

class CardBuilder():
	
	current_card = {('rules'):''}
	mana_cost = []

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
			#for i in current_c:
			#	print i, current_c[i]
			#print ''
			self.cb.reset()
		if tag == 'td':
			IN_LEFT = False
	def handle_data(self, data):
		if self.CURRENT_ATTR != NULL_A:
			self.cb.current_card[self.CURRENT_ATTR] = data.strip()#''.join(data.split())
		elif self.IN_RULES:
			self.cb.current_card[RULES_A] += data
		
f = open("m2011allCards.html", "r")

parser = MyHTMLParser()
#parser.feed(string.split(f.read(), "<table>")[1]);
parser.feed(f.read());
f.close();
def print_all():
	for i in cardList:
		print ''
		print i

print_all()