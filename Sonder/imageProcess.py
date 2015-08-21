#!/usr/bin/python
from PIL import Image
import os,sys

"""This is a part of lan_win or any image processing"""

class ImageProcessing(imgPath)

    """This part only for testing image import and processing
    #TODO(Lois): Recover when testing
    path = os.getcwd()
    layout = os.path.join(path,'Keylayouts/Custom/test.png')#Specified file's path
    """

    #Open image and resize it. Convert the resized image into B&W.
    base = 100
    try:
        im = Image.open(imgPath)
        im = im.resize((base,base), Image.ANTIALIAS)
        im = im.convert('1')
        #Testing resize and convert result
        #TODO(Lois): Recover im.save function when testing
        #im.save('resized.png')
    except IOError:
        print "cannot create thumbnail for", infile

    pix = im.load()
    width, height = img.size
    all_pixels = []
    for x in range(width):
        for y in range(height):
            cpixel = pix[x,y]
            all_pixels.append(cpixel)
    #Testing pixels' array and its value
    #TODO(Lois): Recover print function when testing, x could between 0-100*100
    #print all_pixels[x]

    return all_pixels