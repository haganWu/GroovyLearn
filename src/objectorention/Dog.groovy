package objectorention

class Dog implements Serializable {
    String name
    Integer age

    void increaseAge(Integer years) {
        this.age += years
    }


    //----------------------------- 元编程 Start -----------------------------
    /**
     *
     * @param name 要调用的方法名
     * @param args 方法参数
     * @return
     */
    @Override
    Object invokeMethod(String name, Object args) {
        return "invokeMethod()-> the method name is: ${name},the params is:${args}"
    }

    def methodMissing(String name, Object args) {
        return "methodMissing() -> the method name is: ${name},the params is:${args}"
    }


//----------------------------- 元编程 End -----------------------------
}
