#思路:1.銷量與各天氣資料兩兩做迴歸看關係
#     2.社會科學中，r-square > 0.5 才是有顯著性

rowdata <- read.csv('暖暖包.csv', header=F)   #讀取csv
a <- na.omit(rowdata)#若資料中有null值用0取代
attach(a)#將資料建成表

#資料表內，v3 = 銷量，v4 = 氣壓，v5 = 氣溫，v6 = 濕度，v7 = 風速，v8 = 雨量，v9 = 日照量

outcome <- lm(V3~V4)  #跑迴歸，輸入要跑迴歸的兩兩參數
summary(outcome)   #看迴歸結果，p-value < 0.05為一顆星，R-squared > 0.75才有顯著性
if(is.na(summary(lm1)$r.squared) == FALSE){    #summary(lm1)內r.squared即是r-square值
  if (summary(lm1)$r.squared > 0.2){    #顯示r-square > 0.2的值
    print("與氣壓做迴歸:")
    print(summary(lm1)$r.squared)
    print("=========================================")
  }
}

#================================以下讓銷量兩兩跑迴歸=================================

outcome <- lm(V3~V5)  #跑迴歸，輸入要跑迴歸的兩兩參數
summary(outcome)   #看迴歸結果，p-value < 0.05為一顆星，R-squared > 0.75才有顯著性
if(is.na(summary(lm1)$r.squared) == FALSE){    #summary(lm1)內r.squared即是r-square值
  if (summary(lm1)$r.squared > 0.2){    #顯示r-square > 0.2的值
    print("與氣溫做迴歸:")
    print(summary(lm1)$r.squared)
    print("=========================================")
  }
}
outcome <- lm(V3~V6)  #跑迴歸，輸入要跑迴歸的兩兩參數
summary(outcome)   #看迴歸結果，p-value < 0.05為一顆星，R-squared > 0.75才有顯著性
if(is.na(summary(lm1)$r.squared) == FALSE){    #summary(lm1)內r.squared即是r-square值
  if (summary(lm1)$r.squared > 0.2){    #顯示r-square > 0.2的值
    print("與濕度做迴歸:")
    print(summary(lm1)$r.squared)
    print("=========================================")
  }
}
outcome <- lm(V3~V7)  #跑迴歸，輸入要跑迴歸的兩兩參數
summary(outcome)   #看迴歸結果，p-value < 0.05為一顆星，R-squared > 0.75才有顯著性
if(is.na(summary(lm1)$r.squared) == FALSE){    #summary(lm1)內r.squared即是r-square值
  if (summary(lm1)$r.squared > 0.2){    #顯示r-square > 0.2的值
    print("與風速做迴歸:")
    print(summary(lm1)$r.squared)
    print("=========================================")
  }
}
outcome <- lm(V3~V8)  #跑迴歸，輸入要跑迴歸的兩兩參數
summary(outcome)   #看迴歸結果，p-value < 0.05為一顆星，R-squared > 0.75才有顯著性
if(is.na(summary(lm1)$r.squared) == FALSE){    #summary(lm1)內r.squared即是r-square值
  if (summary(lm1)$r.squared > 0.2){    #顯示r-square > 0.2的值
    print("與雨量做迴歸:")
    print(summary(lm1)$r.squared)
    print("=========================================")
  }
}
outcome <- lm(V3~V9)  #跑迴歸，輸入要跑迴歸的兩兩參數
summary(outcome)   #看迴歸結果，p-value < 0.05為一顆星，R-squared > 0.75才有顯著性
if(is.na(summary(lm1)$r.squared) == FALSE){    #summary(lm1)內r.squared即是r-square值
  if (summary(lm1)$r.squared > 0.2){    #顯示r-square > 0.2的值
    print("與日照量做迴歸:")
    print(summary(lm1)$r.squared)
    print("=========================================")
  }
}