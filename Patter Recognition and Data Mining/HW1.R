college<-read.csv("College.csv", header = T)

rownames (college )=college [,1]
 fix (college )

summary(college)

pairs(college[,1:10])

str(college$Private)
plot(college$Private, college$Outstate, col=c(2,3), varwidth=T, xlab = "Private University", ylab = "OutState", main = "Outstate Vs Private")


Elite =rep ("No",nrow(college ))
Elite [college$Top10perc >50]=" Yes"
Elite =as.factor (Elite)
college =data.frame(college ,Elite)

summary(Elite)
plot(college$Elite, college$Outstate, col=c(2,3), varwidth=T, xlab = "Elite", ylab = "OutState", main = "Outstate Vs Private")

par(mfrow=c(2,2))
hist(college$Enroll, col=1, breaks = 50, xlab = "Enroll", ylab = "Count", main = "Histogram_Enroll")
hist(college$Top10perc, col=2, breaks = 50, xlab = "Personal", ylab = "Count", main = "Histogram_Personal")
hist(college$Terminal, col=3, breaks = 50, xlab = "Terminal", ylab = "Count", main = "Histogram_Terminal")
hist(college$Expend, col=4, breaks = 50, xlab = "Expend", ylab = "Count", main = "Histogram_Expend")

subset(college, Top10perc == max(Top10perc))
subset(college, Accept/Apps == min(Accept/Apps))
