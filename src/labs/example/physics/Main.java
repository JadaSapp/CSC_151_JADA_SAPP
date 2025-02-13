/*
@author: Jada Sapp
@Date: 2/3/2025
@purpose: Creating a main file with methods and equations
*/

package labs.example.physics;

public class Main {
    public static void main(String[] args) {
        Physics physics = new Physics();

        System.out.println("The distance would be: " + physics.getDistance(3,9) + "miles");
        System.out.println("The velocity would be: " + physics.getVelocity(9,10) + "mph");
        System.out.println("The momentum would be: " + physics.getMomentum(20,1) + "kg m/s");
        System.out.println("The force would be: " + physics.getForce(2,9) + "mg m/s^2");
        System.out.println("The work would be: " + physics.getForce(9,8) + "Joules");
        System.out.println("The kinetic energy would be: " + physics.getKineticEnergy(6,5) + "Joules");
        System.out.println("The potential energy would be: " + physics.getPotentialEnergy(4,8) + "Joules");
    }

}