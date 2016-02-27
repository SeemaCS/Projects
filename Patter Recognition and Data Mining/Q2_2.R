library("MASS")

az = read.table("az-5000.txt", header = T)

set.seed(123)

training = sample(1:dim(az)[1], 4000)
print(training)

priors = c(rep(1/26, 26))
print(priors)

lda = lda(char ~., az, subset = training, prior = priors)
print(lda)


confusionMatrix = table(az[-training,]$char, predict(lda, az[-training,])$class)
print(confusionMatrix)

diag(table(confusionMatrix[i,i]))/sum(confusionMatrix[i,])

for (i in seq(1,26)) {
  cat (row.names(confusionMatrix)[i], " ")
  cat (confusionMatrix[i,i]/sum(confusionMatrix[i,]), "\n")
}


length(which(predict(lda, az[-training,])$class == az[-training,]$char))


length(which(predict(lda, az[training,])$class == az[training,]$char))
