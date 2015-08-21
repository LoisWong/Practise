import locale
import psutil, os

#Return system language code, encoding
locale.getdefaultlocale()
print locale.getdefaultlocale()

#Get current focus window
import win32gui
w = win32gui
#HWND = w.getFocus()
#HWND = GetActiveWindow()
w.GetWindowText(w.GetForegroundWindow())

#Using another library
import wnck
screen = wnck.screen_get_default()
window = screen.get_active_window()
pid = window.get_pid()

#Returns the real process ID of the current process.
p = os.getpid()
print p

#Return the process name base on ProcessID
print psutil.Process(450).name

#Return the id of the current process group.
#print os.getpgrp()

#Use the msvcrt module.
#This is a standard Windows-specific extension module.
#It defines a function kbhit() which checks whether a
#keyboard hit is present, and getch() which gets one
#character without echoing it.

# this solution will work only in Windows, as msvcrt is a Windows only package

import thread
import time


try:
    from msvcrt import getch  # try to import Windows version
except ImportError:
    def getch():   # define non-Windows version
        import sys, tty, termios
        fd = sys.stdin.fileno()
        old_settings = termios.tcgetattr(fd)
        try:
            tty.setraw(sys.stdin.fileno())
            ch = sys.stdin.read(1)
        finally:
            termios.tcsetattr(fd, termios.TCSADRAIN, old_settings)
        return ch

char = None

def keypress():
    global char
    char = getch()

thread.start_new_thread(keypress, ())

while True:
    if char is not None:
        print "Key pressed is " + char
        break
    print "Program is running"
    time.sleep(5)
	
#Opens and identifies the given image file.	
Image.open(file)

#convert image into black and white
img = img.convert('1')
black, white = img.getcolors()
print black[0]
print white[0]

#Returns the contents of an image as a sequence object containing pixel values.
img.getdata()
    
#the list that contains all the pixel values which can be printed
pix_val = list(img.getdata())
#Testing
#print pix_val
