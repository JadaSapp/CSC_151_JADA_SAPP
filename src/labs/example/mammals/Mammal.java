/*
@author: Jada Sapp
@Date: 1/27/2025-2/3/2025
@purpose: Mammal Java Class
*/

package labs.example.mammals;

public class Mammal {

    protected String hairColor;
    protected String eyeColor;
    protected String bodyTemp;
    protected String height;
    protected String weight;
    protected String age;
    protected String name;

public void mammal(String name){

}

public void getMammalDetails(){
    System.out.println(this.name + "hair color is");
    System.out.println(this.name + "eye color is");
    System.out.println(this.name + "body temperature is");
    System.out.println(this.name + "height is");
    System.out.println(this.name + "weight is");
    System.out.println(this.name + "age is");
}

public void setName (String name){
    this.name = name;
}

public void sit (){
    System.out.println(this.name + " is sitting.");
}

public void stand (){
    System.out.println(this.name + " is standing.");
}

public void eat (){
    System.out.println(this.name + " is eating, tasty food!");
}

 public void run(){
    System.out.println(this.name + " is running, where to?");
}

 public void sleep (){
    System.out.println(this.name + " is asleep. peaceful dreams.");
}

public void scratch(){
    System.out.println(this.name + " is scratching, be careful!");
}

public void fly(){
    System.out.println(this.name + " is flying, the places they can go!");
}

public void hunt(){
    System.out.println(this.name + " is hunting, make sure to not be spotted!");
}

public void stalk(){
    System.out.println(this.name + " is stalking, they will now move slow and carefully.");
}

public void locate(){
    System.out.println(this.name + " is locating, who are they trying to find?");
}

public void migrate(){
    System.out.println(this.name + " is migrating, where will be their next home?");
}

public void pollinate(){
    System.out.println(this.name + " is pollinating, time to protect the plants!");
}

public void swim(){
    System.out.println(this.name + " is swimming, the water can allow you to travel far!");
}

public void haul(){
    System.out.println(this.name + " is hauling, their body temperature is beginning to regulate.");
}

public void molt(){
    System.out.println(this.name + " is molting, their fur will stay healthy!");
}

public void dive(){
    System.out.println(this.name + " is diving, what food will they find?");

}

public void bark(){
    System.out.println(this.name + " is barking.");
}

}
