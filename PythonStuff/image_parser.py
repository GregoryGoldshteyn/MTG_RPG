import cv2
import numpy as np

def distance(pix1, pix2):
	#print pix1
	#print pix2
	#print ((pix1[0] - pix2[0]) * (pix1[0] - pix2[0])) + ((pix1[1] - pix2[1]) * (pix1[1] - pix2[1])) + ((pix1[2] - pix2[2]) * (pix1[2] - pix2[2]))
	return ((pix1[0] - pix2[0]) * (pix1[0] - pix2[0])) + ((pix1[1] - pix2[1]) * (pix1[1] - pix2[1])) + ((pix1[2] - pix2[2]) * (pix1[2] - pix2[2]))

def generate_colors():
	lst = []
	for i in range(5):
		for j in range(5):
			for k in range(5):
				lst += [[i*63, j*63, k*63]]
	return lst

COLOR_SELS = generate_colors()
NUM_COLORS = len(COLOR_SELS)
img = cv2.imread('Image-d.jpg')
color_votes = {}
voted_color_num = 0
voted_color = []
step = 4

def ret_by_prox(colors, pixel):
	min_dist = float("inf")
	ret_index = 0
	for c in range(NUM_COLORS):
		if distance(pixel, colors[c]) < min_dist:
			ret_index = c
			min_dist = distance(pixel, colors[c])
	return colors[ret_index]
	
def proc_image(use_image, out_string):
	use_image = cv2.imread(use_image)
	for i in range(37,173):
		for j in range(19,203):
			#print img[i,j]
			use_image[i, j] = ret_by_prox(COLOR_SELS, use_image[i,j])
			#print img[i,j]
		#print i

	for i in range(37,173,step):
		for j in range(19,203,step):
			voted_color_num = 0
			voted_color = []
			for ii in range(step):
				for jj in range(step):
					if tuple(use_image[i + ii, j + jj]) in color_votes:
						color_votes[tuple(use_image[i + ii, j + jj])] += 1
					else:
						color_votes[tuple(use_image[i + ii, j + jj])] = 1
			for c in color_votes:
				if color_votes[c] > voted_color_num:
					voted_color_num = color_votes[c]
					voted_color = c
			for ii in range(step):
				for jj in range(step):
					use_image[i + ii, j + jj] = list(voted_color)
			color_votes.clear()
		#print i

	cv2.imwrite(out_string, use_image)
















