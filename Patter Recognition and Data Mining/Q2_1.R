housedata = read.table("housetype_data.txt", header = T, sep = ',')
fix(housedata)
dim(housedata)
house[1:5,1:5]


attributeHist = function(x) {
  if(x %in% colnames(housedata))
  {
    hist(housedata[,which(colnames(housedata) == x)], main=x, xlab=x)
    numNA = sum(is.na(housedata[,which(colnames(housedata) == x)]))
    if(numNA != 0) print(paste(numNA, "missing values"))
  }
  else
    print("No such attribute")
}
attributeHist("age")
attributeHist("hello")
attributeHist("eth")

