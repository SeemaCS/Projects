az = read.table("az-5000.txt", header = T)
dim(az)

head(az,1)
tail(az,1)

training = sample(1:dim(az)[1], 4000)
print(training)

#train = sample(1:5000, 4000)

trainingTable = table(az$char[training])
print(trainingTable)

