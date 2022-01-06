package variable


//===========================================字符串定义 Start===========================================
def name = 'a single string'
//println name.class

def name1 = '''
Line one
Line two
Line three
'''
//println name1

def name2 = "Android"
def sayHello = "Hello:${name2}"
//println sayHello
//println name2.class
//println sayHello.class


def sum = "The sum of 2 and 4 equals ${2 + 3}"
//println sum
//println sum.class
def result = echo(sum)
//println(result + "!!!")

private String echo(String s) {
    return s
}
//===========================================字符串定义 End===========================================


//===========================================字符串方法 Start===========================================


def str = "Groovy"
//---------------字符串填充
//println str.center(10, 'a')
//println str.padLeft(10, 'a')
//println str.padRight(10, 'a')

//---------------字符串比较
def str2 = "Hello"
//println str == str2

def g = str[0..2]
//println g

//def str3 = "llo"
//println str2 - str3

//println str.reverse()
//println str.capitalize()
def str4 = "5555"
println str.isNumber()
println str4.isNumber()

println str4.toInteger() + 1111

//===========================================字符串方法 End===========================================