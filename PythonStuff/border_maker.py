import cv2
import numpy as np

BORDER_RED = [0, 0, 126]
BORDER_GREEN = [0,63,0]
BORDER_BLUE = [252,126,0]
BORDER_BLACK = [0,0,0]
BORDER_WHITE = [126,252,252]
BORDER_GREY = [126, 126, 126]

MAIN_BLACK = [189, 189, 189]
MAIN_RED = [126, 126, 189]
MAIN_GREEN = [126, 189, 126]
MAIN_BLUE = [252, 189, 126]
MAIN_WHITE = [189,252,252]

EDGE_BLACK = [0,0,0]

COLOR_DICT = {"Black": BORDER_BLACK,"Red": BORDER_RED,"Green": BORDER_GREEN,"Blue": BORDER_BLUE,"White": BORDER_WHITE}
MAIN_DICT = {"Black": MAIN_BLACK,"Red": MAIN_RED,"Green": MAIN_GREEN,"Blue": MAIN_BLUE,"White": MAIN_WHITE}

def border_maker(image_name, card_color):
	img = cv2.imread(image_name)
	if(img == None):
		return 1
	#Blacken the edges
	#Left
	for i in range(310):
		for j in range(11):
			img[i][j] = EDGE_BLACK
	#Right
	for i in range(310):
		for j in range(211, 223):
			img[i][j] = EDGE_BLACK
	#Top
	for i in range(12):
		for j in range(12, 211):
			img[i][j] = EDGE_BLACK
	#Bottom
	for i in range(297, 310):
		for j in range(10, 211):
			img[i][j] = EDGE_BLACK
	
	#Blacken the dividers
	#Under title
	for i in range(33,37):
		for j in range(19,203):
			img[i][j] = EDGE_BLACK
			
	#Top of descriptor
	for i in range(173, 177):
		for j in range(19,203):
			img[i][j] = EDGE_BLACK
	
	#Bottom of descriptor
	for i in range(190, 194):
		for j in range(19,203):
			img[i][j] = EDGE_BLACK
	
	#Color the insides
	#Top
	for i in range(12, 18):
		for j in range(11, 211):
			img[i][j] = COLOR_DICT[card_color]
	#Title
	for i in range(18, 33):
		for j in range(19, 203):
			img[i][j] = MAIN_DICT[card_color]
	
	#Descriptor bar
	for i in range(176, 191):
		for j in range(19, 203):
			img[i][j] = MAIN_DICT[card_color]
			
	#Rules text
	for i in range(194, 278):
		for j in range(19, 203):
			img[i][j] = MAIN_DICT[card_color]
	
	#Left
	for i in range(18,297):
		for j in range(11, 19):
			img[i][j] = COLOR_DICT[card_color]
	
	#Bottom
	for i in range(278, 297):
		for j in range(19, 211):
			img[i][j] = COLOR_DICT[card_color]
	
	#Right
	for i in range(18, 278):
		for j in range(203, 211):
			img[i][j] = COLOR_DICT[card_color]
	cv2.imwrite(image_name, img)

border_maker("DoomBladReference.bmp", "Black")
















