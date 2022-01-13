package advanced

import objectorention.Dog

//======================= 文件读写 Start =======================

//======================= 读取file Start =======================
def file = new File('../../GroovyLearn.iml')
//file.eachLine { line ->
//    println line
//}

//读取文件内容 - 全部
//def resultText = file.getText()
def resultText = file.readLines()
//println resultText.toListString()

//读取文件内容 - 部分
def readerResult = file.withReader {
    char[] buffer = new char[100]
    it.read(buffer)
    return buffer
}
//println readerResult.toString()


//======================= 读取file End =======================


//======================= 写入file Start =======================

//def writer = file.withWriter {
//    it.write("Hello File")
//}


def copy(String sourcePath, String targetPath) {
    try {
        //创建目标文件
        def targetFile = new File(targetPath)
        if (!targetFile.exists()) {
            targetFile.createNewFile()
        }
        //读取源文件
        new File(sourcePath).withReader { reader ->
            def lines = reader.readLines()
            targetFile.withWriter { writer ->
                lines.each { line ->
                    writer.append(line).append("\r\n")
                }
            }
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }

}

//def result = copy('fileText.txt', 'fileText1.txt')

//======================= 写入file End =======================


//======================= 文件读写 End =======================


//======================= 对象读写 Start =======================

/**
 * 将对象写入文件中
 */
def saveObject(Object object, String path) {
    try {
        //创建目标文件
        def targetFile = new File(path)
        if (!targetFile.exists()) {
            targetFile.createNewFile()
        }
        targetFile.withObjectOutputStream { out ->
            out.writeObject(object)
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
}

/**
 * 从文件中读取对象
 * @param path
 * @return
 */
def readObject(String path) {
    def obj = null
    try {
        def file = new File(path)
        if (file == null || !file.exists()) {
            return null
        } else {
            file.withObjectInputStream { input ->
                obj = input.readObject()
            }
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
    return obj
}

Dog dog = new Dog(name: "旺财", age: 8)
saveObject(dog, 'dog.bin')

def object = readObject('dog.bin') as Dog
println object.name

//======================= 对象读写 End =======================



