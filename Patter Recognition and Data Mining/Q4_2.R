library(glmnet)

credit = read.table("credit_data.txt", header = TRUE)
dim(credit)

set.seed(123)

training = sample(1:885, 0.8*885)

x = as.matrix(credit[training, 3:15])
y = 2*credit$Fail[training]-1

regularized = cv.glmnet(x, y, family = "binomial")
plot(regularized)
#Error decreases between lambda min and lambda max and starts 
#flattening out after about 10 predictors have non-zero coefficients.

CVector = coef(regularized, lambda = regularized$lambda.1se)
print(CVector)
#Three predictors, OperProfit, FiscalLag and InFinan are
#equal to zero.

x.test <- as.matrix(credit[-training, c(3:15)])
y.test <- credit$Fail[-training]

yHat <- as.numeric(predict(regularized, x.test, type = "class", lambda = regularized$lambda.1se))
confusionMat <- table(y.test, yHat)
print(confusionMat)

accuracy <- sum(diag(confusionMat))/sum(confusionMat)
print(accuracy)

