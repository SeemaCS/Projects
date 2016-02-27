houseData <- read.table("housetype_data.txt", header=TRUE, sep = ",")
set.seed(1)
houseData$sex <- as.factor(houseData$sex)
houseData$ms <- as.factor(houseData$ms)
#houseData$age <- as.factor(houseData$age)
houseData$edu <- as.factor(houseData$edu)
houseData$ocu <- as.factor(houseData$ocu)
#houseData$inc <- as.factor(houseData$inc)
#houseData$ba <- as.factor(houseData$ba)
houseData$di <- as.factor(houseData$di)
#houseData$hs <- as.factor(houseData$hs)
#houseData$hs2 <- as.factor(houseData$hs2)
houseData$hhs <- as.factor(houseData$hhs)
houseData$eth <- as.factor(houseData$eth)
houseData$lang <- as.factor(houseData$lang)

nonM <- 0.9 * nrow(houseData)

training <- sample(nrow(houseData),nonM) 
trainingData <- houseData[training,]
test = -training
testingData <- houseData[test,]

sum(is.na(houseData))
sum(is.na(trainingData))

#install.packages("rpart")
library(rpart)

classificationTree <- rpart(ht~., data = trainingData, method = "class" , cp = 0.0001)
classificationTree

plotcp(classificationTree)
print(classificationTree$cptable)
which.min(classificationTree$cptable[,"xerror"])
# minimum cross validation error = 0.6223228 (row 11)

prunedTree <- prune(classificationTree,cp= 0.0007038713)
plot(prunedTree)
text(prunedTree)

plot(prunedTree, compress=TRUE, uniform=TRUE, margin=0.1)
text(prunedTree, all=TRUE, pretty=0, splits=TRUE)

ClassificationTreeT <- rpart(ht~., data = testingData, method = "class", cp = 0.0001)
plotcp(ClassificationTreeT)
print(ClassificationTreeT$cptable)
which.min(ClassificationTreeT$cptable[,"xerror"])
predictTree <- predict(prunedTree, testingData, type = "class")
houseTypeTest <- testingData$ht
confusionMatrix <- table(predictTree, houseTypeTest)
confusionMatrix
sum(diag(confusionMatrix))
sum(confusionMatrix)
accuracy=sum(diag(confusionMatrix))/sum(confusionMatrix)
accuracy


