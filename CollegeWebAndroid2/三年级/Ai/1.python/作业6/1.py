import urllib.request
import re

# 定义变量
name = 1
# 外层循环分页
for k in range(5, 8):
    # 网页源
    html = urllib.request.urlopen("https://www.i4.cn/ring_1_0_%d.html"%k)
    # 读出数据
    data = html.read()
    print("-----第%d页正在下载-----"%k)
    # 筛选mp3正则表达式
    r = r"[a-zA-z]+://[^\s]*.mp3"
    # 编译正则
    pat = re.compile(r)
    # 根据正则筛选数据并变为字符串存储在rings列表中
    rings = re.findall(pat, str(data))
    # 删除0到倒数第5个
    del rings[0:-5]
    # 循环列表
    for i in rings:
        # 存储在本地
        urllib.request.urlretrieve(i, "rings/%d.mp3"%name)
        print("第%d个铃声下载完成"%name)
        name += 1
