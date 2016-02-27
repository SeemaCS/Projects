#install.packages("tm")

library(tm)
setwd("C:/Seema/SCU/5th QUARTER/PATTERN RECOGNITION AND DATA MINING/HOMEWORK/HW4/Data/Newsgroup_data/Newsgroup_data")

source <- DirSource("C:/Seema/SCU/5th QUARTER/PATTERN RECOGNITION AND DATA MINING/HOMEWORK/HW4/Data/Newsgroup_data/Newsgroup_data/rec.autos/")

news.corpus <- Corpus(source, readerControl=list(reader=readPlain))

out <- length(news.corpus)
index <- names(news.corpus)
index

which(index %in% c(103806))

news.corpus[[980]]

rec.autos <- names(news.corpus[[980]])
print(rec.autos)

rNews <- tm_map(news.corpus, removePunctuation)
writeLines(as.character(rNews[[980]]))

rNumbers <- tm_map(news.corpus, removeNumbers)
writeLines(as.character(rNumbers[[980]]))

tLow <- tm_map(news.corpus, tolower)
writeLines(as.character(tLow[[980]]))

rWords <- tm_map(news.corpus, removeWords, stopwords("english"))
writeLines(as.character(rWords[[980]]))

sWhite <- tm_map(news.corpus, stripWhitespace)
writeLines(as.character(sWhite[[980]]))

news.corpus <- Corpus(VectorSource(news.corpus))

documentTM <- DocumentTermMatrix(news.corpus, control = list(weighting = weightTfIdf, minWordLength = 1, minDocFreq = 1))

dim(documentTM)

inspect(documentTM[980, "bmw"])
inspect(documentTM[980, "clutch"])
inspect(documentTM[980, "mother"])
