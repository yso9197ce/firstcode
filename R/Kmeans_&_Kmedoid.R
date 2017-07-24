#==============================準備資料==============================
library(datasets)   # load所需要的data
attitude    # 要用的data集
data = attitude[,c(1,2)]    #使用第1、2欄
plot(data)    

#===========================找出最適分群數===========================
require(factoextra)
fviz_nbclust(data, FUNcluster = hcut, method = "wss", k.max = 10) 
# FUNcluster = hcut ?
# method : 為找出最佳群數的方法，可以用wss、gap_stat、silhouette
# k.max : 要考慮到最多幾群
# 以此例子我們可選3群(再下去斜率變動不大)

#============================K-means模型============================
kmeans = kmeans(data, centers = 3, nstart = 10)
#centers為分幾群, nstart為一開始設置中心的個數，若數據很分散，此值可加大
kmeans$cluster   #分群後的結果
plot(dat, col =(kmeans$cluster) , pch=20)   # pch為圓點的表示方式(20為實心)，不重要

#===========================K-medoid模型===========================
require(cluster)
kmedoid = pam(data, k=3)
plot(dat, col =(kmeans$cluster) , pch=20)







