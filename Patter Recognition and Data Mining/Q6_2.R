library(boot)

set.seed(1)
y = rnorm(100)
x = rnorm(100)
y = x-2* x^2+ rnorm (100)

#n = 100, p = 2
#Y = X ??? 2*x^2 + ??.

plot(x,y)


DSet = data.frame(x, y)
set.seed(1)

fit = glm(y ~ x)
cv.glm(DSet, fit)$delta

fit = glm(y ~ poly(x^2))
cv.glm(DSet, fit)$delta

fit = glm(y ~ poly(x^3))
cv.glm(DSet, fit)$delta

fit = glm(y ~ poly(x^4))
cv.glm(DSet, fit)$delta

set.seed(5)

fit = glm(y ~ x)
cv.glm(DSet, fit)$delta

fit = glm(y ~ poly(x^2))
cv.glm(DSet, fit)$delta

fit = glm(y ~ poly(x^3))
cv.glm(DSet, fit)$delta

fit = glm(y ~ poly(x^4))
cv.glm(DSet, fit)$delta

#exact same results

# 2nd model

summary(fit)

