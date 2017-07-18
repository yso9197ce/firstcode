#==============================準備資料==============================
load("titanic.raw.rdata")
str(titanic.raw)
#Class → 乘客的艙位等級, Sex → 乘客性別, Age → 乘客年齡, Survived → 沉船之後，乘客是否存活

#==============================決策樹分析==============================
require(rpart)   #CART決策樹
set.seed(22)     #取種子號碼,之後亂數選取的數值可以以這個種子號碼來重複利用
sample = sample(x=1:nrow(titanic.raw), size=ceiling(0.8*nrow(titanic.raw) ))   
train = titanic.raw[sample, ]
test = titanic.raw[-sample, ]
#資料區分成train=0.8, test=0.2
cart_model = rpart(Survived ~. ,data=train)   #把存活與否的變數(Survived)當作Y，剩下的變數當作X

#==============================畫決策樹==============================
require(rpart.plot)
prp(cart_model,         #模型(rpart.plot內畫圖函式為prp())
    faclen=0,           #呈現的變數不要縮寫
    fallen.leaves=TRUE, #讓樹枝以垂直方式呈現
    shadow.col="gray",  #最下面的節點塗上陰影
    extra=2)            #分類結果同時會呈現yes/no的比例 

#分析結果:
#         1.第一個分枝規則是最重要的,因此性別為最重要的分枝規則
#         2.即使是女性,可是擁有的艙位若是最低下的(3rd),則大概有一半的死亡機率(82/155=53%)；但當妳的艙位高人一等時,則有相當高的存活機率(197/208=95%)
#         3.當你是男性成人時,大概有八成機率會死(1084/1348=80%)
#         4.若是男性小孩,就和艙位等級有關：高級艙位的小孩全都獲救(13/13),可是低艙位的小孩有七成機率(26/37)會死

#================================預測================================
pred = predict(cart_model, newdata=test, type="class")
confus.matrix = table(real=test$Survived, predict=pred)    #以confus matrix看預測的情況
confus.matrix
sum(diag(confus.matrix))/sum(confus.matrix)   #計算預測準確率 = 對角線的數量/總數量



