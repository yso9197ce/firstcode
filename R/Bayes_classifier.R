#============================準備資料============================
data(iris)
library(ggplot2)
ggplot(iris, aes(x = Sepal.Length, y = Sepal.Width)) + geom_point(aes(color = Species))   #花萼長寬分佈
ggplot(iris, aes(x = Petal.Length, y = Petal.Width)) + geom_point(aes(color = Species))   #花瓣長寬分佈

set.seed(1111)
train_ind = sample(seq_len(nrow(iris)), size = round(0.7 * (nrow(iris))))  # 70%建模，30%驗證
traindata <- iris[train_ind,]
testdata <- iris[ -train_ind,]

#===========================建立貝氏模型===========================
library(e1071)
bayes = naiveBayes(Species ~ ., data = traindata)   # 建立模型

#===========================驗證貝氏模型===========================
pred = predict(bayes, testdata)     # 將testdata放入做預測
pred
cm = table(x = testdata$Species, y = pred)
cm
naiveBayesaccuracy = sum(diag(cm)) / sum(cm)
naiveBayesaccuracy    # 看分類準確率












