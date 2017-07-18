#分群主要可以分成兩種類型：
#階層式分群(Hierarchical Clustering)：不需指定分群數目，讓資料自動由上往下/由下往上結合起來
#分割式分群(Partitional Clustering)：需事先指定分群數目，經過不斷的迭代，直到群內的變異最小
#============================準備資料(階層式)============================
head(iris)
data = iris[ ,-5]     #由於階層式分群屬於「非監督式學習」的演算法，因此先把iris內的品種(Species)欄位拿掉(這樣就沒有類別tag)
#?
e.distange = dist(data, method = 'euclidean')   #使用歐式距離來建立資料之間的「距離矩陣」
m.distange = dist(data, method = 'manhattan')  #使用曼哈頓距離來建立資料之間的「距離矩陣」

#============================階層式分群分析============================
#以hclust()函式(給定資料之間的距離矩陣)做分群，且可選擇不同的群聚距離的算法
#不同的群聚距離的算法可參考：http://mirlab.org/jang/books/dcpr/dcHierClustering.asp?title=3-2%20Hierarchical%20Clustering%20(%B6%A5%BCh%A6%A1%A4%C0%B8s%AAk)&language=chinese
e.cluster <- hclust(e.distange, method="single")    #最近法
e.cluster <- hclust(e.distange, method="complete")  #最遠法
e.cluster <- hclust(e.distange, method="average")   #平均法
e.cluster <- hclust(e.distange, method="ward.D2")   #華德法
plot(e.cluster, xlab="歐式距離")   #這裡使用華德法看結果
#? 9?
abline(h=9, col="red")   #在圖上加上識別線來看要分幾群
#可知最佳分群為3群，因此可以利用cutree()，讓整個階層的結構縮減成三群
cut.cluster = cutree(e.cluster, k=3)
cut.cluster
#?
table(cut.cluster, iris$Species)   #可看出virginica沒有分好

#觀察散布圖可知virginica和versicolor界線不明顯，因此沒有分好
require(ggplot2)
ggplot(data = iris) + geom_point(aes(x=Petal.Length,y=Petal.Width,color=Species))

#============================準備資料(切割式)============================
data = iris[ ,-5]

#============================切割式分群分析============================
kmean = kmeans(data, center = 3)    #kmeans須先決定要分幾組
table(kmean$cluster, iris$Species)

require(cluster)
kmedoid = pam(data, k=3)    #k中心法也須先決定要分幾組
table(kmedoid$clustering, iris$Species) 
