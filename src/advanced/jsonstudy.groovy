package advanced

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import objectorention.Person

def list = [new Person(name: "name1", age: 1), new Person(name: "name2", age: 2)]
def jsonString = JsonOutput.toJson(list)
//println jsonString
//实体对象 转 Json字符串
println JsonOutput.prettyPrint(jsonString)

//Json字符串 转 实体对象
def jsonSlurper = new JsonSlurper()
println jsonSlurper.parseText(jsonString)


def getNetworkData(String url) {
    //发送http请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod("GET")
    connection.connect()
    def response = connection.connect().text

    //将Json转换为实体对象
    def jsonSlurper = new JsonSlurper()
    return jsonSlurper.parseText(response)
}






