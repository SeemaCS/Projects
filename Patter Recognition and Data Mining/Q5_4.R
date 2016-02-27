setwd("C:/Seema/SCU/5th QUARTER/PATTERN RECOGNITION AND DATA MINING/HOMEWORK/HW4/Data")

#install.packages("recommenderlab")

ratingsData <- matrix(scan("ratings.txt", sep = "|"), ncol = 3, byrow = TRUE)
#ratingsData[[2]]
#class(ratingsData) <- "numeric"
sMatrix = sparseMatrix(i=ratingsData[,1],j=ratingsData[,2],x=ratingsData[,3], index1=FALSE)
sMatrix
dim(sMatrix)

colnames(sMatrix) <- c(1:7224)
rownames(sMatrix) <- c(1:10001)

library(recommenderlab)

newSparseM <- new("realRatingMatrix", data = sMatrix)

rec <- Recommender(newSparseM[1:nrow(newSparseM)],method="UBCF", param=list(normalize = "Z-score",method="Cosine",nn=5, minRating=1))

topM <- predict(rec, newSparseM[10000], type = "topNList", n = 5)

as(topM, "list")

topR <- predict(rec, newSparseM[500], type = "rating")
rMat <- as(topR, "matrix")
which.max(rMat[!is.na(rMat)])

