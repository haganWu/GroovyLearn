package objectorention

//Person p = new Person(name: "XiaoYue", age: 18)
//p.increaseAge(10)
//p.show()
//p.eat()
//p.play()

//----------------------------- 元编程 Start -----------------------------
//Dog d = new Dog(name: "XiaoQiang", age: 18)
////d.cry()// Dog中未实现invokeMethod() / methodMissing()方法编译不报错，执行报错
//println d.cry(11) //Dog中实现invokeMethod() / methodMissing() 直接调用实现invokeMethod() / methodMissing()方法

//metaClass 为类动态添加属性
//Dog.metaClass.sex = 'male'
//Dog d1 = new Dog(name: "XiaoQiang", age: 18)
//d1.sex = 'female'
//println d1.sex

//metaClass 为类动态添加普通方法
//Dog.metaClass.eat = { it -> println "I can eat ${it}" }
//Dog d1 = new Dog(name: "XiaoQiang", age: 18)
//d1.eat("Banana")

//metaClass 为类动态添加静态方法
ExpandoMetaClass.enableGlobally()
Dog.metaClass.static.createDog = {
    String name, int age -> new Dog(name: name, age: age)
}
Dog childDog = Dog.createDog("旺财", 3)
println "childrenDog -> name:${childDog.name}, age:${childDog.age}"

//----------------------------- 元编程 End -----------------------------
