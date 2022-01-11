package objectorention.globally

import objectorention.Dog

class Entry {

    static void main(String[] args) {
        println "应用程序正在启动"
        //初始化
        ApplicationManager.init()
        println "应用程序初始化完成"

        Dog d = DogManager.createDog("DaWang", 6)
        println "Globally test -> name:${d.name}, age:${d.age}"

    }
}
