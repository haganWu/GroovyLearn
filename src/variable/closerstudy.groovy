package variable


//============================= 闭包定义 =============================
//定义闭包
def closer = { println "Hello Groovy" }

//调用闭包
//closer.call()
//closer()

//带参闭包定义
def closerWithParam = { String name -> println "Hello ${name}" }
//closerWithParam.call("XiaoYue")

//多个参数
//带参闭包定义
def closerWithMoreParam = { String name, Integer age -> println "Hello ${name},${age} years old" }
//closerWithMoreParam.call("XiaoYue", 28)

def closerDefaultParam = { println "Hello ${it}" }
//closerDefaultParam.call("XiaoYue")

def closerDefaultParam1 = { her -> println "Hello ${her}" }
//def result = closerDefaultParam1("XiaoYue")
//println result


//============================= 闭包使用 =============================

//---结合基本类型使用
/**
 * 求阶乘
 */
int fab(int number) {
    int result = 1
    1.upto(number, { result *= it })
    return result
}
/**
 * 求阶乘
 */
int fab2(int number) {
    int result = 1
    number.downto(1) {
        result *= it
    }
    return result
}

/**
 * 累计求和
 */
int sum(int number) {
    int result = 0
    number.times {
        result += it
    }
    return result
}

//println sum(8)


//---结合String类型使用
String str = "sum of 2 and 3 is 5"
//each遍历
str.each {
//    print it * 2
}

//find 查找符合条件的第一个
//println str.find() {
//    it.isNumber()
//}

//find 查找所有符合条件的值
//println str.findAll() {
//    it.isNumber()
//}

//any 只要有一个符合条件返回true
//def result = str.any {
//    it.isNumber()
//}
//println result

//every 每一项都符合条件才返回true
//def result = str.every() {
//    it.isNumber()
//}
//println result

//collect 将经条件转换的项添加到一个新的集合中
def result = str.collect {
    it.toUpperCase()
}
//println result.toListString()


//=============== 闭包三个重要变量：this，owner，delegate =============================
def scriptCloser = {
    println "scriptCloser this:" + this
    println "scriptCloser owner:" + owner
    println "scriptCloser delegate:" + delegate
}
//scriptCloser.call()

//相当于定义了一个内部类
class Person {
    def static classCloser = {
        println "classCloser this:" + this
        println "classCloser owner:" + owner
        println "classCloser delegate:" + delegate
    }

    def static say() {
        def methodCloser = {
            println "methodCloser this:" + this
            println "methodCloser owner:" + owner
            println "methodCloser delegate:" + delegate
        }
        methodCloser.call()
    }

    def say1() {
        def methodCloser = {
            println "methodCloser this:" + this
            println "methodCloser owner:" + owner
            println "methodCloser delegate:" + delegate
        }
        methodCloser.call()
    }
}

//println Person.classCloser.call()
//println Person.say()
Person p = new Person()
//p.say1()


//在闭包中定义闭包
def nestCloser = {
    def innerClose = {
        println "innerClose this:" + this
        println "innerClose owner:" + owner
        println "innerClose delegate:" + delegate
    }
    innerClose.delegate = p//修改默认delegate对象
    innerClose.call()
}
//nestCloser.call()


//=============== 闭包委托策略 =============================

class Student {
    String name
    def pretty = { "My name is ${name}" }

    String toString() {
        pretty.call()
    }
}

class Teacher {
    String name
}

def stu = new Student(name: "ZhangSan")
def teacher = new Teacher(name: "WangLaoShi")
//println stu.toString()
//修改委托指向
stu.pretty.delegate = teacher
//修改委托策略
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST
println stu.toString()


