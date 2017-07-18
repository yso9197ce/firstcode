#import library
library(RevoUtilsMath)
#set multiThread = 4
setMKLthreads(4)
#多執行緒
getMKLthreads()
#將RAM開到最大
memory.size(max=32710)
tag = read.table('tag.csv',header = TRUE,sep = ',')
title = list('tag','β0','β1','β2')#β0=截距項，β1=銷量與雨量的相關係數，β2=銷量與體感溫度的相關係數
#下行將title寫入CSV
write.table(title, file = "weather_logical_Q3_Stemp.csv", sep = ",", append = TRUE, row.names = FALSE,col.names = FALSE)
for (i in 1:lengths(tag)){#跑所有類別的商品
  name = as.character(tag[i,1])#將tag[i,1]轉為字串
  names = paste(name,'.csv',sep="")#將tag[i,1]與'.CSV'合併才可利用其去呼叫特定的CSV
  logical<-read.table(names, header=TRUE, sep=",")#呼叫特定的CSV
  attach(logical)#attach()是為了使我們方便呼叫logical內的欄位   ex:logical$Stemp → Stemp
  #half = median(sale)#以中位數做為是否熱賣的標準
  half = quantile(sale, 0.75)#以第3四分位數做為是否熱賣的標準
  #half = mean(sale)*2#以平均的2倍做為是否熱賣的標準
  Sales={}#將sale分類成0跟1
  Sales[sale > half] = 1
  Sales[sale <= half] = 0
  table(Sales)#看Sales的結果
  detach(logical)#將logical drop掉
  logical2 = cbind(logical,cbind(Sales))#將logical 與Sales合併成新table
  logical2$Sales = as.factor(logical2$Sales)#Sales轉為類別變數
  model<-glm(formula=Sales~ring+Stemp, data=logical2, family=binomial(link="logit"), na.action=na.exclude)#跑邏輯思回歸
  if( summary(model)$coefficients[3,4]<0.001){#只取得p-value顯著相關結果
    final = list()
    final = append(final,name)
    final = append(final, summary(model)$coefficients[[1]])#截距項
    final = append(final , summary(model)$coefficients[[2]])#銷量與雨量的相關係數
    final = append(final, summary(model)$coefficients[[3]])#銷量與體感溫度的相關係數
    #寫入csv
    write.table(final, file = "weather_logical_Q3_Stemp.csv", sep = ",", append = TRUE, row.names = FALSE,col.names = FALSE)
  }
}


