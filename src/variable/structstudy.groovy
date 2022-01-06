package variable

//=========================== switch语句 ===========================
def x = 5
def result
switch (x) {
    case "foo":
        result = "fund foo"
        break
    case 1.23:
        result = 1.23
        break
    case [4, 5, 6, "list"]:
        result = "list"
        break
    case 12..30:
        result = "区间"
        break
    default:
        result = "not found"
        break
}
println result


//=========================== for循环 ===========================

//区间循环
def sum = 0
for (i in 0..100) {
    sum += i
}
println sum
sum = 0
//list循环
for (i in [1, 2, 3, 4, 5, 6, 7, 8, 9,]) {
    sum += i
}
println sum
sum = 0

//Map循环
for (i in ["one": 1, "two": 2, "three": 3]) {
    sum += i.value
}
println sum



