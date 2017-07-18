#==============================準備資料==============================
require(neuralnet) #可以設定「多個隱藏層」的套件
require(nnet)      
require(caret)     #可幫助我們針對層數和節點數進行調整的套件,看怎麼樣的組合會有最小的MSE(RMSE),這樣的動作叫做tune parameters
data = iris
#此神經網路Sepal.Length、Sepal.Width、Petal.Length、Petal.Width會是input nodes,而Species是output node
#然而,由於Species是類別變數,類神經網路無法直接處理,因此這個時候必須先將Species轉變成啞變數(dummy variables)的型態
#啞變數(dummy variables)可參考: http://belleaya.pixnet.net/blog/post/30877354-%5B%E6%95%99%E5%AD%B8%5D-%5B%E7%B5%B1%E8%A8%88%5D-%E8%99%9B%E6%93%AC%E8%AE%8A%E6%95%B8-dummy-variable
head(class.ind(data$Species))    #這邊將Species轉換成三個output nodes(三種類別),使用的是class.ind函式()
data = cbind(data, class.ind(data$Species))    #將dummy variables與原資料結合

#============================訓練bpn模型============================
formula.bpn = setosa + versicolor + virginica ~ Sepal.Length + Sepal.Width + Petal.Length + Petal.Width
#             ============output=============   ==========================input========================

bpn = neuralnet(formula = formula.bpn, 
                data = data,
                hidden = c(2),       # 一個隱藏層：2個node
                learningrate = 0.01, # learning rate
                threshold = 0.01,    # partial derivatives of the error function, a stopping criteria
                stepmax = 5e5 )      # 最大的ieration數 = 500000
plot(bpn)     #結果可參考PTT p.1  

#=========================Tuning Parameters=========================
#當使用不同的隱藏層數和節點數,類神經網路的模型表現與可靠度就會改變
#當MSE最小的情況發生時,我們就可以視為是最佳的參數組合(optimal parameters),此部分稱為Tuning Parameters
smp.size = floor(0.8*nrow(data))   #取80%的資料當train data
#floor函式為回傳小於函式內的值的最小整數  ex:floor(12.7) → 12, floor(-3.4) → -4
set.seed(131)                     
train.ind = sample(seq_len(nrow(data)), smp.size)   #取80%的資料當train data
train = data[train.ind, ]
test = data[-train.ind, ]
model = train(form = formula.bpn,     
              data = train,           
              method = "neuralnet",   #使用剛訓練的bpn
              #最重要的步驟：觀察不同排列組合(第一層1~4個nodes;第二層0~4個nodes;第三層0個node)
              #即使第三層預計0層,但expand.grid函式一定要含三層,因此設為0
              #看何種排列組合(多少隱藏層,每層多少個node),會有最小的RMSE
              tuneGrid = expand.grid(.layer1=c(1:4), .layer2=c(0:4), .layer3=c(0)),               
              #以下的參數設定，和上面的neuralnet內一樣
              learningrate = 0.01,  
              threshold = 0.01,    
              stepmax = 5e5 )        
model   #最後一句會告訴你最佳參數組合
        #The final values used for the model were layer1 = 1, layer2 = 2 and layer3 = 0
        #第一隱藏層1個node，第二隱藏層2個node是最佳組合

#因此就以兩層隱藏層(1,2)，重新訓練類神經網路模型：
bpn = neuralnet(formula = formula.bpn, 
                data = train,
                hidden = c(1,2),     # 第一隱藏層1個node，第二隱藏層2個nodes
                learningrate = 0.01, # learning rate
                threshold = 0.01,    # partial derivatives of the error function, a stopping criteria
                stepmax = 5e5 )       # 最大的ieration數 = 500000(5*10^5)
plot(bpn)

#=============================預測=============================
pred = compute(bpn, test[, 1:4])  
#compute函式可用已建好的neural network做預測,使用test資料集的前4個欄位
pred
pred.result = round(pred$net.result)   #將結果轉為0/1
pred.result = as.data.frame(pred.result)   #轉為data frame
pred.result$Species = ""    #在pred.result開一個新欄位
for(i in 1:nrow(pred.result)){
  if(pred.result[i, 1]==1){ pred.result[i, "Species"] = "setosa"}
  if(pred.result[i, 2]==1){ pred.result[i, "Species"] = "versicolor"}
  if(pred.result[i, 3]==1){ pred.result[i, "Species"] = "virginica"}
}
#原本用class.ind()將Species轉換成三個output nodes(三種類別)
#setosa → 1 0 0, versicolor → 0 1 0, virginica → 0 0 1
#現在轉回原本的品種名
table(real    = test$Species, 
      predict = pred.result$Species)

