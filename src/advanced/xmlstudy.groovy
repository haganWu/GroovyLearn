package advanced

import groovy.xml.MarkupBuilder


//======================= 解析xml Start =======================
final String xml = '''
    <response version-api="2.0">
        <value>
            <books id="1" classification="android">
                <book available="20" id="1">
                    <title>疯狂Android讲义</title>
                    <author id="1">李刚</author>
                </book>
                <book available="14" id="2">
                   <title>第一行代码</title>
                   <author id="2">郭林</author>
               </book>
               <book available="13" id="3">
                   <title>Android开发艺术探索</title>
                   <author id="3">任玉刚</author>
               </book>
               <book available="5" id="4">
                   <title>Android源码设计模式</title>
                   <author id="4">何红辉</author>
               </book>
           </books>
           <books id="2" classification="web">
               <book available="10" id="1">
                   <title>Vue从入门到精通</title>
                   <author id="4">李刚</author>
               </book>
           </books>
       </value>
    </response>
'''

//解析xml数据
def xmlSlurper = new XmlSlurper()
def response = xmlSlurper.parseText(xml)
//println response.value.books[0].book[0].title //获取“疯狂Android讲义”
//println response.value.books[0].book[0].@available//获取“available="20"”

//xml遍历查询 查找作者是“李刚”的所有的书名
response.value.books.each {
    it.book.each { book ->
        if (book.author.text() == "李刚") {
//            println book.title.text()
        }
    }
}

//深度遍历
//def resultList = response.depthFirst().findAll {
//    return ("李刚" == it.author.text())
//}
//println resultList.toListString()

//广度遍历
def resultList = response.value.books.children().findAll { node ->
    node.name() == 'book' && node.@id == "1"
}.collect { it ->
    return it.title
}
//println resultList.toListString()

//======================= 解析xml End =======================


//======================= 生成xml Start =======================


/**
 * 生成xml格式数据
 * <langs type='current' count='3' mainstream='true'>
 <language flavor='static' version='1.5'>Java</language>
 <language flavor='dynamic' version='1.6.0'>Groovy</language>
 <language flavor='dynamic' version='1.9'>JavaScript</language>
 </langs>
 */


def sw = new StringWriter()
def xmlMarkBuilder = new MarkupBuilder(sw)//用于生成xml数据的核心类
//创建根节点langs
xmlMarkBuilder.langs(type: 'current', count: '3', mainstream: 'true') {
    //第一个language节点
    language(flavor: 'static', version: '1.5', 'Java')
    language(flavor: 'dynamic', version: '1.6.0', 'Groovy')
    language(flavor: 'dynamic', version: '1.9', 'JavaScript')
}
println sw

//======================= 生成xml End =======================

