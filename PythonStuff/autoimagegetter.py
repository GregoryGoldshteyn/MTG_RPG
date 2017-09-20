import urllib
import string
from image_parser import proc_image

MAGIC_URL = "http://gatherer.wizards.com/Handlers/"

def process_image(url_string):
	str = MAGIC_URL + string.split(url_string, "/")[-1]
	out_str = string.split((string.split(str, '=')[1]), "&")[0] + ".jpg"
	urllib.urlretrieve(str, out_str)
	proc_image(out_str, "PIX_" + out_str)
	