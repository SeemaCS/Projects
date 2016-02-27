library("MASS")
setwd("C:/Seema/SCU/5th QUARTER/PATTERN RECOGNITION AND DATA MINING/HOMEWORK/HW4/Data")

az <- read.table("az-5000.txt", TRUE)
set.seed(123)
training = sample(1:dim(az)[1], 4000)
print(training)

priors = c(rep(1/26, 26))
print(priors)

lda = lda(char ~., az, subset = training, prior = priors)
print(lda)


confusionMatrix = table(az[-training,]$char, predict(lda, az[-training,])$class)
print(confusionMatrix)

diag(confusionMatrix) = 0
print(confusionMatrix)

image(confusionMatrix, col = topo.colors(4), axes = FALSE)

axis(side=1,at=seq(0,1,1/25),labels=letters[1:26], cex.axis = 0.5)
axis(side=2,at=seq(0,1,1/25),labels=letters[1:26], cex.axis = 0.5)

Yellow is the worst color corresponding to v t from the confusion matrix
