#==============================準備資料==============================
require(datasets)
str(iris)  #使用iris並查看資料結構
#Sepal.Length → 花萼長度,Sepal.Width → 花萼寬度,Petal.Length → 花瓣長度,Petal.Width → 花瓣寬度,Species → 品種

#==============================畫散佈圖==============================
require(ggplot2)
ggplot(data = iris) + geom_point(aes(x=Petal.Length,y=Petal.Width,color=Species))   
#geom_point為點狀圖,color=Species為依照不同品種上色

#==============================迴歸分析==============================
#單迴歸
s_model = lm(formula = Sepal.Length ~ Sepal.Width ,data=iris)
#迴歸函式:lm(Y ~ X, data=...) 
summary(s_model)

#分析結果:
#         1.此模型為:Sepal.Length = 6.5262 - 0.2234xSepal.Width
#         2.在'此模型'下,X變數之p-value對Y不顯著
#         3.在'此模型'下,adj R-squared = 0.007159,表示模型預測能力非常差

#複迴歸
m_model = lm(formula = Sepal.Length ~ Sepal.Width + Petal.Length + Petal.Width,data=iris)
#迴歸函式:lm(Y ~ X1+X2+..., data=...) 
summary(m_model)
#分析結果:
#         1.此模型為:Sepal.Length = 1.85600 + 0.65084xSepal.Width + 0.70913xPetal.Length - 0.55648xPetal.Width
#         2.在'此模型'下,三個X變數之p-value對Y都顯著
#         3.在'此模型'下,adj R-squared = 0.8557,表示模型預測能力不錯

#================================預測================================
#當建立好迴規模型後就可以來預測
new_iris = data.frame(Sepal.Width=3.456, Petal.Length=1.535, Petal.Width=0.341)  #假設一筆新的iris資料
predict(m_model, new_iris)    #可預測出新的iris的Sepal.Length值為5.004048






