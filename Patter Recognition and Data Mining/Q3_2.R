credit = read.table("credit_data.txt", header = T)
dim(credit)

set.seed(123)

training = sample(1:885, 0.8*885)
print(training)

table(credit$Fail[training])
table(credit$Fail[-training])

glm = glm(Fail~.-Id, family = binomial, data = credit[training,])
summary(glm)

predictP = predict(glm , credit[-training, c(1,3:15)], type = "response")
table(credit$Fail[-training], predictP >= 0.5)
