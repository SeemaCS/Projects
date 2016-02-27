X1 <- c(3,2,4,1,2,4,4)
X2 <- c(4,2,4,4,1,3,1)
color <- c("Red", "Red", "Red", "Red", "Blue", "Blue", "Blue")
plot(X1, X2, col = color, xlim = c(0,4), ylim = c(0,4))

#The classifiers are points (2,2),(4,4),(2,1),(4,3)
# x1,y1 = 2,1.5
# x2,y2 = 4,3.5
#point1 = y1-x1 = -0.5
#point2 = y2-y1/x2-x1 = 1

plot(X1, X2, col = color, xlim = c(0,4), ylim = c(0,4))
abline(-0.5,1)

# 0.5 - x1 + x2
# B0 = 0.5, B1 = -1, B2 = 1

plot(X1, X2, col = color, xlim = c(0,4), ylim = c(0,4))
abline(-0.5, 1)
abline(-1, 1, col = "green", lty = 3)
abline(0, 1, col = "green", lty = 3)

plot(X1, X2, col = color, xlim = c(0,4), ylim = c(0,4))
abline(-0.5, 1)
arrows(2, 1, 2, 1.5, col = "green")
arrows(2, 2, 2, 1.5, col = "green")
arrows(4, 4, 4, 3.5, col = "green")
arrows(4, 3, 4, 3.5, col = "green")

plot(X1, X2, col = color, xlim = c(0,4), ylim = c(0,4))
abline(-0.9,1)
# -0.9 - x1 + x2

plot(X1, X2, col = color, xlim = c(0,4), ylim = c(0,4))
points(c(4), c(2), col = c("red"))

