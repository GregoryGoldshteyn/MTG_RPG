import cv2
import numpy as np

def iconify(in_string, out_string):
	
	in_image = cv2.imread(in_string)
	if(in_image == None):
		return 1
	height = 34
	width = 46
	
	out_image = range(34)
	for i in range(34):
		out_image[i] = []
		for j in range(46):
			out_image[i] += [[1, 2, 3]]
	
	out_image = np.array(out_image)
	
	for i in range(37,173,4):
		for j in range(19,203,4):
			out_image[(i - 37)/4][(j - 19)/4] = in_image[i][j]
			
	cv2.imwrite(out_string, out_image)
	
iconify("DoomBladReference.bmp", "DoomIcon.bmp")
for i in range(204972, 213630):
	iconify("../m2011pics/PIX_" + str(i) + ".jpg", "../m2011pics/ICON_" + str(i) + ".bmp")