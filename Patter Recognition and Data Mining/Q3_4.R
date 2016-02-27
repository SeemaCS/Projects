setwd("C:/Seema/SCU/5th QUARTER/PATTERN RECOGNITION AND DATA MINING/HOMEWORK/HW4/Data")
data <- read.table("az-5000.txt", TRUE)

UseData <- data[,-1]

cluster <- vector()
for(i in 2:26)
{
  jc <- kmeans(UseData, centers = i, iter.max = 26)
}

dAvg <- dist(jc$centers, method = "euclidean")
dendogram <- hclust(dAvg, method="average")
plot(dendogram)

letterChar <- data[,1]
letterChar
clusterNumber <- jc$cluster
clusterNumber

commonLetter <- matrix(0,26,26)
rownames(commonLetter) <- LETTERS

for(i in 1:5000)
{
  commonLetter[letterChar[i], clusterNumber[i]] <- commonLetter[letterChar[i], clusterNumber[i]] + 1
}

final <- c()

for(j in 1:26) {
  final[j] <- which.max(commonLetter[,j])
}

plot(dendogram, labels=LETTERS[final])
