#!/usr/bin/python
from PIL import Image
import os,sys

path = os.getcwd()
layout = os.path.join(path,'Keylayouts/Custom/test.png')
width = 1440
height = 480
#base = 100
try:
    im = Image.open(layout)
    im = im.resize((width,height), Image.ANTIALIAS)
    im = im.convert('L')#L for luma transform, 1 for a bilevel image
    im.save('resized.png')
except IOError:
    print "cannot create thumbnail for", layout
try:
    box = (200,10,300,110)#x,y could be get from key's value, (x,y,width+x,height+y)
    im = im.crop(box)
    im.save('croped.png')
except IOError:
    print "cannot crop thumbnail for", Key

#pix = im.convert('1').load()
#width, height = im.size
#all_pixels = []
#for x in range(width):
#    for y in range(height):
#       cpixel = pix[x,y]
#       all_pixels.append(cpixel)
#return all_pixels

