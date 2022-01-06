package variable


//===========================================字符串定义 Start===========================================
def name = 'a single string'
println name.class

def name1 = '''
Line one
Line two
Line three
'''
println name1

def name2 = "Android"
def sayHello = "Hello:${name2}"
println sayHello
println name2.class
println sayHello.class


def sum = "The sum of 2 and 4 equals ${2 + 3}"
println sum
println sum.class
def result = echo(sum)
println(result + "!!!")

private String echo(String s) {
    return s
}
//===========================================字符串定义 End===========================================

