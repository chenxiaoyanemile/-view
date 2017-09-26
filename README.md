# -view
模仿郭霖微信公众号上的几款好玩的自定义View，还有我自己画的丑丑的象棋棋盘。。。

[1]View 的位置
主要由它的四个顶点来决定，分别对应于 View 的四个属性：top、left、right、bottom。
其中 top 是左上角纵坐标，left 是左上角横坐标，right是右下角横坐标，bottom是右下角纵坐标。
>![2017-9-13](http://upload-images.jianshu.io/upload_images/2245754-ba73a31d9f882cde.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
由此可知：
left = getLeft()；
right = getRight();
bottom = getBottom();
top = getTop();
width = right - left;
height = bottom - top;

[2]效果图



![2017-9-26-0.png](http://upload-images.jianshu.io/upload_images/2245754-ccac726eed0e470b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![2017-9-26-2.png](http://upload-images.jianshu.io/upload_images/2245754-5dbd5f5119afb354.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![2017-9-26-3.png](http://upload-images.jianshu.io/upload_images/2245754-8906c21eae772d7d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

[3]感谢
原文链接：
[弹跳小球](http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650241303&idx=1&sn=9a84d8c600a7c57158c39e41d12a2de6&chksm=88638878bf14016ee9e78540390fb58f4c08d9789974829edcd5ee7f05c07f7b08b67ecb6418&mpshare=1&scene=23&srcid=0916CcCLoqegW77eXV0KQpJC#rd)
[时间轴](http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650241114&idx=1&sn=185487ede9ce08ee620dcce05a780f57&chksm=88638935bf1400235cf7df2d6f6f1d8a38e5fec4f1c12a45510b3efdc21ed54887affa20dcf4&mpshare=1&scene=23&srcid=0913jXeYSxPjcbCSqiUDjmnA#rd)
