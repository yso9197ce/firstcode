
library("forecast")
sales= read.table("2.csv", header = FALSE, sep = ",")#讀取csv利用"，"做分隔
sales2 = sales[4]#將銷量取出
sale = ts(sales2,start=1,frequency=12)#將資料轉成timeseries
salearima = auto.arima(sale,trace=T)#利用auto.arima這個參數可以產生最適模型，trace=T，程式自動回報最佳模型解
saleforecast =forecast(salearima,h=5,level=c(68))#h為所要預測期數，level為信心水準
saleforecast
plot(saleforecast)
