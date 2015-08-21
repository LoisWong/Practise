import locale
import win32gui
import Image
import os

class getLayout()
    def language()
        """Return system language code, encoding"""
        lan =locale.getdefaultlocale()
        return lan

    def Application()
        """Return foreground Window information to identify the Application in using"""
        w = win32gui
        win = w.GetWindowText(w.GetForegroundWindow())
        #return win
        path = os.getcwd()
        if "Photoshop" in win:
            layout = os.path.join(path,'Keylayouts/Custom/photoshop.png')
            #TODO(Lois) transfer layout path to getPixelArray
            getPixelArray(layout)
        elif "Chrome" in win:
            layout = os.path.join(path,'Keylayouts/Custom/Chrome.png')
            getPixelArray(layout)
        elif "Flash" in win:
            layout = os.path.join(path,'Keylayouts/Custom/flash.png')
            getPixelArray(layout)
        elif "Illustrustor" in win:
            layout = os.path.join(path,'Keylayouts/Custom/illustrustor.png')
            getPixelArray(layout)
        elif "Indesign" in win:
            layout = os.path.join(path,'Keylayouts/Custom/Indesign.png')
            getPixelArray(layout)
        #TODO(Lois) More Application could be identified here

class getPixelArray(ImgPath)
    img = Image.open(ImgPath)
    img.show()

    pix = img.convert('1').load()#Convert image into black and white and get pixel
    width, height = img.size
    all_pixels = []
    for x in range(width):
        for y in range(height):
            cpixel = pix[x,y]
            all_pixels.append(cpixel)
    #return all_pixels[100]