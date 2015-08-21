#!/usr/bin/python
from PIL import Image
import os,sys

path = os.getcwd()
layout = os.path.join(path,'Keylayouts/Custom/test.png')

base = 100
try:
    im = Image.open(layout)
    im = im.resize((base,base), Image.ANTIALIAS)
    im = im.convert('1')
    im.save('resized.png')
except IOError:
    print "cannot create thumbnail for", layout

pix = im.convert('1').load()
width, height = im.size
all_pixels = []
for x in range(width):
    for y in range(height):
        cpixel = pix[x,y]
        all_pixels.append(cpixel)
#return all_pixels