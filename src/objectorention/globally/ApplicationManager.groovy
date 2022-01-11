package objectorention.globally

import objectorention.Dog

class ApplicationManager {
    static void init() {
        ExpandoMetaClass.enableGlobally()
        //为第三方类注入方法
        Dog.metaClass.static.createDog = {
            String name, int age -> new Dog(name: name, age: age)
        }
    }
}
