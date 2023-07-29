from bs4 import BeautifulSoup
import urllib.request
import re

# 定义变量
name = 1
# 外层循环分页
for k in range(3, 6):
    # 网页源
    html = urllib.request.urlopen("https://www.i4.cn/wper_1_0_0_%d.html" %k)
    # 读出数据
    data = html.read()
    print("-----第%d页正在下载-----"%k)
    soup = BeautifulSoup(data, 'html.parser')
    imgs  = soup.find_all('img',attrs={'class':'wper_img'})
    # 删除0到倒数第5个
    del imgs[0:-5]
    # 循环列表
    for i in imgs:
        # 存储在本地
        urllib.request.urlretrieve(i.get('data-big'), "imgs/%d.jpg"%name)
        print("第%d个图片下载完成"%name)
        name += 1
