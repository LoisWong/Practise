import locale

class Language:
    """Return system language code, encoding"""
    def _init_(self,lan):
    	self.lan = lan
    	#locale.getdefaultlocale()

    def getLan(self):
    	self.lan = locale.getdefaultlocale()
    	return self.lan
