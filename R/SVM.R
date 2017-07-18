#SVM是一種監督式學習的演算法，試圖從資料中建構一個超平面(hyperplane)，將資料區分成兩個類別，最後進行預測
#==============================準備資料==============================
require(e1071)
require("mlbench")
data(Glass, package="mlbench")
data = Glass    #兩種玻璃含的元素資料
data
size = floor(0.8*nrow(data))  #先將Glass資料分成80%的訓練資料(Train)，20%的測試資料(Test)
#floor函式為回傳小於函式內的值的最小整數  ex:floor(12.7) → 12, floor(-3.4) → -4
set.seed(516)                     
train_index = sample(seq_len(nrow(data)), size)
train = data[train_index, ] #train set
test = data[-train_index, ] #test set

#==============================SVM模型==============================
model = svm(formula = Type ~ ., data = train)
#Type為此資料的標籤(分為1號和2號玻璃)，.為剩下的X變數
#標籤的資料形態必須要是Factor

#===============================預測===============================
train_pred = predict(model, train)
#######???為啥分成7類
table(real=train$Type, predict=train_pred)
confus.matrix = table(real = train$Type, predict = train_pred)
sum(diag(confus.matrix))/sum(confus.matrix)    #train的準確率80.7%

test_pred = predict(model, test)
table(real=test$Type, predict=test_pred)
confus.matrix = table(real=test$Type, predict=test_pred)
sum(diag(confus.matrix))/sum(confus.matrix)    #test的準確率65.1%

#==================Support Vector Regression(SVR)==================
#SVR來SVM的延伸型態，能夠處理連續的預測問題
data = data.frame(x=1:20,y=c(3,4,8,2,6,10,12,13,15,14,17,18,20,17,21,22,25,30,29,31))  #手動建立一資料集
plot(data$x, data$y, pch=16, xlab="X", ylab="Y")
model = svm(y ~ x , data)    #y軸資料形態必須是numeric
pred = predict(model, data)  #建好model後將原本data帶入預測

plot(data$x, data$y, pch=16, xlab="X", ylab="Y")   #畫圖，原資料點為黑色，預測為藍色
points(pred, pch=4, col="blue")

