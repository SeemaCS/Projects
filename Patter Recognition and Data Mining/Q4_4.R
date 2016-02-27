setwd("C:/Seema/SCU/5th QUARTER/PATTERN RECOGNITION AND DATA MINING/HOMEWORK/HW4/Data")

#install.packages("arules")

library(arules)

data <- read.transactions("ratingsAsBasket.txt", format = "basket", sep = NULL)
movie <- read.transactions("movies.txt", format = "basket", sep = "|")
summary(data)

associationRule <- apriori(data)
summary(associationRule)
#inspect(associationRule)

#tenRules <- head(associationRule,10)
inspect(associationRule[1:10])

inspect(movie[3816])

inspect(movie[3749])

listRules <- subset(associationRule, lift > 3)
inspect(listRules)
summary(listRules)


