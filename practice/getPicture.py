import requests
from bs4 import BeautifulSoup
import shutil      #抓圖片的套件

res = requests.get('http://www.ske48.co.jp/profile/?id=kimoto_kanon')
soup = BeautifulSoup(res.text,'lxml')
layer = soup.select('dl.profile > dt')[0].find_all('img')[0]
link = layer['src']   #找出圖片位置的網址

res2 = requests.get(link,stream = True)
f = open('ske/picture.jpg', 'wb')   #建立檔案位置，並寫入(w)binary(b)
shutil.copyfileobj(res2.raw,f)     #使用copyfileobj方法將res2的原始碼抓下來存成f
f.close