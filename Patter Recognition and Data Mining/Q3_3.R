install.packages("e1071")
library(e1071)
set.seed(1)
email <- read.csv("spam.csv", header = TRUE)

testing <- sample(1:nrow(email), 0.15*nrow(email), replace = FALSE)
testingData <- email[ testing,]
training <- -testing
trainingData <- email[ training,]                  
tuning <- sample(1:nrow(trainingData), size = 500, replace = FALSE)
tuningData <- email[tuning,]

valueGamma <- seq(0.000001,0.001, length = 10)
valueCost <- seq(10, 100, length = 10)
  
tuningX <- model.matrix(type~., tuningData)[,-1]
tuningY <- tuningData$type
tune <- tune.svm(tuningX, tuningY, data=tuningData, kernel="radial",gamma = valueGamma, cost = valueCost)
summary(tune)

#best parameters were gamma = 0.000889 and cost = 100. Best error rate = 7.6%

trainingX <- model.matrix(type~., trainingData)[,-1]
trainingY <- trainingData$type
trainS <- svm(trainingX,trainingY,kernel="radial", gamma=0.000889, cost=100)
summary(trainS)

#No.of support vectors is 794

testX <- model.matrix(type~.,testingData)[,-1]
testY <- testingData$type
testS <- svm(testX, testY, kernel="radial", gamma=0.000889, cost=100)
testPredict <- predict(testS, testX)
summary(testPredict)
confusionMatrix <- table(testPredict, testingData$type)
confusionMatrix
accuracy <- sum(diag(confusionMatrix))/sum(confusionMatrix)
accuracy

#Accuracy is 95% on test data
