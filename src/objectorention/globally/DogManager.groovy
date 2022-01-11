package objectorention.globally

import objectorention.Dog

class DogManager {
    static Dog createDog(String name, int age) {
        return Dog.createDog(name, age)
    }
}
