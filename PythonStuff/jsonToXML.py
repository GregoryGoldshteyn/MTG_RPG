import json
import xml.etree.ElementTree as ET

with open('allCards.json') as data_file:
	data = json.load(data_file)
	
root = ET.Element('CardList', attrib={"set" : "m2011"})
for i in data:
	card = ET.SubElement(root, "Card")
	card.set("id", i['IMG_ID'])
	for j in i:
		if type(i[j]) is list:
			elem = ET.SubElement(card, j)
			for val in i[j]:
				sub = ET.SubElement(elem, 'Sub')
				sub.set("value", val)
		else:
			elem = ET.SubElement(card, j)
			elem.set("value", i[j])
		
print ET.tostring(root[0])

tree = ET.ElementTree(root)
tree.write('m2011cards.xml')