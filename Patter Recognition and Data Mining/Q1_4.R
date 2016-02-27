#install.packages("gdata")
#install.packages("akima")
setwd("C:/Seema/SCU/5th QUARTER/PATTERN RECOGNITION AND DATA MINING/HOMEWORK/HW4/Data")
platform = "windows"
rfhome = "C:/RuleFit3"
install.packages("akima", lib=rfhome)
source("C:/Program Files/R/R-3.2.2/RuleFit3/rulefit.r")
library(akima, lib.loc = rfhome)
library(gdata)

data <- read.xls("Diamond_Data.xls", sheet = 1, perl = "C:/Strawberry/Perl/perl/bin/perl.exe")
head(data, 2)

summary(data)

hist(data$Price, col="red", labels = TRUE)
hist(as.numeric(data$Cut),col = "red", labels = TRUE)

sampleData <- (5/6) * nrow(data)
training <- sample(1:nrow(data), sampleData, replace = FALSE)
trainingData <- data[training,]
testData <- data[-training,]

x <- trainingData[,2:8]
y <- trainingData$Price

categorical <- c("Cut", "Color", "Clarity", "Polish", "Symmetry", "Report")

fit <- rulefit(x,y,cat.vars = categorical,test.reps = 10, test.fract = 0.1)
rfmodinfo(fit)


