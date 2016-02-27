data <- read.table("az-5000.txt",header = TRUE)
set.seed(1)
training = sample(nrow(data),4000)
trainingData <- data[training,]
test <- -training
testData <- data[test,]

IntValue <- as.numeric(trainingData$char)
IntValue
toMatrix <- as.matrix(IntValue)
targetMatrix <- matrix(0,nrow = nrow(toMatrix),ncol = 26)
for(i in 1:4000) {
  temp <- IntValue[i]
  targetMatrix[i,temp] = 1
}
sum(targetMatrix == 1)


#install.packages("nnet")
library(nnet)

predictN <- list()
for(i in 1:20) {
  predictN[[i]] <- nnet(char~., data = trainingData, size = i, maxit = 1000) 
}

#install.packages("Metrics")
library(Metrics)

fittedV <- list()
for(i in 1:20) {
  fittedV[[i]] <- predictN[[i]]$fitted.values
}

mseValue <- 0
for(i in 1:20) {
  mseValue[i] <- mse(targetMatrix, fittedV[[i]])
}

IntValueTest <- as.numeric(testData$char)
toMatrixTest <- as.matrix(IntValueTest)
targetMatrixTest <- matrix(0,nrow = nrow(toMatrixTest),ncol = 26)
for(i in 1:1000) {
  tempTest <- IntValueTest[i]
  targetMatrixTest[i,tempTest] = 1
}
sum(targetMatrixTest == 1)

predictTest <- list()
for(i in 1:20) {
  predictTest[[i]] <- predict(predictN[[i]],testData)
}
mseTest <- 0
for(i in 1:20) {
  mseTest[i] <- mse(targetMatrixTest, predictTest[[i]])
}
x <- seq(1,20,1)
plot(x,mseValue,col="red",ylab="MSE",xlab="Number of hidden units",ylim=c(0,0.035),main="MSE of training and test data")
#plot(x,mseTest)
#plot(x,mseValue, col = "green", axes = F)
lines(x,mseValue,col = "red")
lines(x,mseTest,col = "blue")

table(IntValueTest)
sum(table(IntValueTest))

finalprediction=matrix(data=0,nrow=1000,ncol=1)
finalprediction=apply(predictTest[[8]],1,which.max)
table(finalprediction)

table(IntValueTest,finalprediction)
sum(diag(table(IntValueTest,finalprediction)))/sum(table(IntValueTest,finalprediction))

table(IntValue)
sum(table(IntValue))

predicttraindata8 <- predict(predictN[[8]],trainingData)

finalpredictionTraining=matrix(data=0,nrow=1000,ncol=1)
finalpredictionTraining=apply(predicttraindata8,1,which.max)
table(finalpredictionTraining)

table(IntValue,finalpredictionTraining)
sum(diag(table(IntValue,finalpredictionTraining)))/sum(table(IntValue,finalpredictionTraining))
