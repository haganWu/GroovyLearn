package objectorention

/**
 * Groovy中默认都是public类型
 */
class Person implements Action {
    String name
    Integer age

    void increaseAge(Integer years) {
        this.age += years
    }

    void show() {
        println "My name is ${this.name},I'm ${this.age} years old."
    }


    @Override
    void eat() {
        println "eat method call"
    }

    @Override
    void drink() {
        println "drink method call"
    }

    @Override
    void speak() {
        println "speak method call"
    }
}
