package objectorention

class Cat implements DefaultTrait{
    @Override
    void eat() {
        println "eat method call"
    }

    @Override
    void play() {
        super.play()
        println "play method call"
    }
}
