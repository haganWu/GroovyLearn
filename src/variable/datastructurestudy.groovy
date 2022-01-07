package variable

import java.lang.reflect.Array

//============================== 列表 定义==============================

//list 定义
//def list = new ArrayList()
def list = [1, 2, 3, 4, 5]
//println list.class

//数组定义
def array = [1, 2, 3, 4, 5] as int[]
int[] array2 = [1, 2, 3, 4, 5]


//============================== 列表 排序==============================
def sortList = [6, 2, 3, -7, -9, 1, 5, 8]
//----Java --------------
//从小到打排序
Collections.sort(sortList)
//println sortList.toListString()
//自定义排序规则 - 按绝对值大小排序
Comparator comparator = { int a, int b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 }
Collections.sort(sortList, comparator)
//println sortList.toListString()
//----Java --------------

//----Groovy --------------
//数字排序
//从小到打排序
sortList.sort()
//println sortList.toListString()

//自定义排序规则 - 按绝对值大小排序
sortList.sort { int a, int b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 }
//println sortList.toListString()


//字符串排序
def sortStringList = ["Hello", "World", "Java", "Kotlin", "Groovy", "Gradle"]
sortStringList.sort { return it.size() }
//println sortStringList

//----Groovy --------------


//============================== 列表 查找==============================

def findList = [6, 2, 3, -7, -9, 1, 5, 8]
//返回第一个偶数
//int result = findList.find { return it % 2 == 0 }
//println result

//返回所有奇数
def resultList = findList.findAll { return it % 2 != 0 }
//println resultList.toListString()

//是否存在奇数
//def result = findList.any { return it % 2 != 0 }
//是否全部是奇数
def result = findList.every { return it % 2 != 0 }
//println result


findList.min { return Math.abs(it) }
findList.max { return Math.abs(it) }

def aa = findList.count { return it > 5 }
//println aa


//============================== 列表 添加==============================

findList.add(110)
findList << 80
findList.add(0, 100)
//println findList.toListString()

findList.each {}


def plusList = findList + 9
//println plusList.toListString()


//============================== 列表 删除==============================

def deleteList = [6, 2, 3, -7, -9, 1, 5, 8]
//println deleteList.toListString()
//deleteList.remove(0)
//println deleteList.toListString()

//deleteList.remove((Object) 80)
//println deleteList.toListString()


//deleteList.removeAt(0)
//println deleteList.toListString()

//deleteList.removeElement(80)
//println deleteList.toListString()

//deleteList.removeAll { return it % 2 == 0 }
//println deleteList.toListString()

//println deleteList - [-7,-9]

//============================== 列表 遍历==============================
def list1 = [6, 2, 3, -7, -9, 1, 5, 8]
//list1.eachWithIndex { it, index ->
//    println "the value is ${it},index is ${index}"
//}

//============================== Map 定义==============================
// ---Java 定义
//def map = new HashMap()

//---Groovy 定义
def map = ["one": 1, "two": 2, "three": 3, "four": 4, "five": 5, "six": 6, "seven": 7, "eight": 8]
//println map["one"]
//println map.one
//map["nine"] = 9
//map.ten = 10
//println map.toMapString()

//map.otherMap = [a:1,b:2]
//println map.toMapString()
def map1 = ["nine": 9, "ten": 10]
map.putAll(map1)
//println map.toMapString()
//println map.getClass()

//map.remove("one")
//map.removeAll { it.value % 2 == 0 }
//println map.toMapString()

map.one = "壹"
//println map.toMapString()

//============================== Map 操作==============================

//----遍历
def students = [
        1: [number: '0001', name: "Name1", score: 55, sex: 'male'],
        2: [number: '0002', name: "Name2", score: 62, sex: 'female'],
        3: [number: '0003', name: "Name3", score: 99, sex: 'female'],
        4: [number: '0004', name: "Name4", score: 76, sex: 'male'],
        5: [number: '0005', name: "Name5", score: 88, sex: 'female']
]

//students.each { def student ->
//    println "the key is ${student.key}, the value is ${student.value}"
//}

//students.eachWithIndex { def student, int index ->
//    println "index is ${index}, the key is ${student.key}, the value is ${student.value}"
//}

//students.each { key, value ->
//    println "the key is ${key}, the value is ${value}"
//}

//students.eachWithIndex { key, value, index ->
//    println "the key is ${key}, the value is ${value},index is ${index}"
//}


//--- 查询
//def studentResult = students.find { return it.value.score >= 60 }
//println studentResult
//def studentResult = students.findAll { return it.value.score >= 60 }
//println studentResult
//def studentResult = students.count {
//    return it.value.score >= 60 && it.value.sex == 'female'
//}
//println studentResult


//def studentNames = students.findAll {
//    return it.value.score >= 60
//}.collect { return it.value.name }
//println studentNames

//查询后分组
//def group = students.groupBy {
//    it.value.score > 60 ? '及格' : '不及格'
//}
//println group


//--- 排序 返回一个新的map
println students
def sort = students.sort { it1, it2 ->
    return it1.value.score == it2.value.score ? 0 : it1.value.score < it2.value.score ? -1 : 1
}
//println sort


//============================== 范围（区间） ==============================

def range = 1..10
//println range[0]
//println range.contains(5)
//println range.from
//println range.to
//range.each {
//    print it
//}

//range.eachWithIndex { it, index ->
//}

def getGrade(Number number) {
    def result
    switch (number) {
        case 0..20:
            result = "退学"
            break
        case 21..40:
            result = "观察"
            break
        case 41..59:
            result = "不及格"
            break
        case 60..69:
            result = "及格"
            break
        case 70..80:
            result = "良好"
            break
        case 81..90:
            result = "优秀"
            break
        case 91..98:
            result = "极优"
            break
        case 99..100:
            result = "保送"
            break
    }
    return result
}