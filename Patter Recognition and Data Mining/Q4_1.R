x1_w1 <- dnorm(0.6, mean = 0, sd = 1)
print(x1_w1)
x2_w3 <- dnorm(0.1, mean = 1, sd = 1)
print(x2_w3)
x3_w3 <- dnorm(0.9, mean = 1, sd = 1)
print(x3_w3)
x4_w2 <- dnorm(1.1, mean = 0.5, sd = 1)
print(x4_w2)

prod(x1_w1, x2_w3, x3_w3, x4_w2)

W <- prod(0.5,0.25^3)
print(W)


x2_w1 <- dnorm(0.1, mean = 0, sd = 1)
print(x2_w1)
x3_w1 <- dnorm(0.9, mean = 0, sd = 1)
print(x3_w1)
x4_w1 <- dnorm(1.1, mean = 0, sd = 1)
print(x4_w1)

x1_w2 <- dnorm(0.6, mean = 0.5, sd = 1)
print(x1_w2)
x2_w2 <- dnorm(0.1, mean = 0.5, sd = 1)
print(x2_w2)
x3_w2 <- dnorm(0.9, mean = 0.5, sd = 1)
print(x3_w2)

x1_w3 <- dnorm(0.6, mean = 1, sd = 1)
print(x1_w3)
x4_w3 <- dnorm(1.1, mean = 1, sd = 1)
print(x4_w3)

library(gregmisc)

x_w = c(0,0.5,1)
x = permutations(n=3, r=4, v = x_w, repeats.allowed = T)




