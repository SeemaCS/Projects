setwd("C:/Seema/SCU/5th QUARTER/PATTERN RECOGNITION AND DATA MINING/HOMEWORK/HW4/Data")
data <- read.table("az-5000.txt", TRUE)

UseData <- data[,-1]

cluster <- vector()
for(i in 2:26)
{
  jc <- kmeans(UseData, centers = i, iter.max = 26)
  cluster[i] <- (1/i)*sum(kmeans(UseData, centers = i)$withinss)
}

par(mfrow=c(2,1))
plot(1:26, cluster, type = "b")


cluster1 <- vector()
for (i in 15:26)
{
  cluster1[i] <- (1/i)*sum(kmeans(UseData, centers=i)$withinss)
}

plot(1:26, cluster1, type="b")
