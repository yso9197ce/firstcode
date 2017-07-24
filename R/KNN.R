#==============================準備資料==============================
require('kknn')
data(iris)
index = sample(1:nrow(iris), as.integer(0.8*nrow(iris)))    #sample(x, size, replace = FALSE, prob = NULL)
train = iris[index,]
test = iris[-index,]

#==============================KNN模型==============================
knn = kknn(formula = formula(Species ~ . ), train = train, test = test, k = 3, distance = 1)
                                                                      #k=分幾類，distance=中心半徑
fit = fitted(knn)
fit
table(test$Species, fit)
?fitted

