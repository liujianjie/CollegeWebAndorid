import urllib.request
import random
import csv
from bs4 import BeautifulSoup

# 列表里放数组
csvlist = []
# 获取头
def getHeader(url):
    #谷歌
    header1={
        'Host':'book.douban.com',
        'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36'
    }
    #IE
    header2={
        'Host': 'book.douban.com',
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko'
    }
    # 获取请求
    list = [header1, header2]
    index = random.choice(list)
    req = urllib.request.Request(url=url, headers=index)
    return req

# 获取数据
def getData(url):
    req = getHeader(url)
    html = urllib.request.urlopen(req)
    data = html.read()
    #print(data)
    soup = BeautifulSoup(data, 'html.parser')
    #print(soup)
    # 1.获取一个大层div
    booksdiv = soup.select('.grid-12-12')[0]
    #print(booksdiv)
    # 2.获取图书div
    booksitem = booksdiv.select('.detail-frame')
    # 3.循环图书div
    for i in booksitem:
        # 3.1.图书名称
        booksname = i.select('a')[0].string
        # 3.2 星级
        star = i.select('.font-small')[0].string
        # 3.3作者
        authors = i.select('.color-gray')[0].string
        authorss = (str)(authors).strip()
        author = authorss[0:authorss.index('/')]
        # 3.4评价
        comment = i.select('p')[-1].string.strip()
        datas = (booksname, author, star, comment)
        csvlist.append(datas)
        #print(comment)
        #print(author)
        #print(booksname+" "+star+" "+author)

#csv操作
def csvf():
    with open('b.csv', 'w', newline='', encoding='utf-8') as openfile:
        f = csv.writer(openfile)
        data = ['书名','作者','星级','评论']
        f.writerow(data)
        # 循环写入
        for i in csvlist:
            f.writerow(i)

# 获取数据
getData('https://book.douban.com/latest?icn=index-latestbook-all');
# 写入数据
csvf()
