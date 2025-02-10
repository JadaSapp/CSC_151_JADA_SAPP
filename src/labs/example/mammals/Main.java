/*
@author: Jada Sapp
@Date: 2/3/2025
@purpose: Naming a mammal/Week 4 VSCODE
*/
package labs.example.mammals;

public class Main {
    public static void main(String[] args) throws Exception{
        Mammal mammal = new Mammal();
        Dog dog = new Dog();

        mammal.setName("Dog");
        mammal.sit();
            Thread.sleep(15000);
        mammal.stand();
            Thread.sleep(5000);
        dog.bark();

    }

}