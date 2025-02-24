/*
@author: Jada Sapp
@Date: 2/3/2025
@purpose: Psychics Java Class
*/

package labs.example.physics;

import java.lang.Math;

public class Physics {
    final static double GRAVITY = 9.81;

    public void Physics(){

    } 

    public double getDistance(double v, double t){
        double x;
        x = v * t;
        return x;
    }

    public double getVelocity(double x, double t){
        double v;
        v = x / t;
        return v;
    }

    public double getMomentum(double m, double v){
        double p;
        p = m * v;
        return p; 
    }

    public double getForce(double m, double a){
        double f;
        f = m * a;
        return f;
    }

    public double getWork(double f, double d){
        double w;
        w = f * d;
        return w;
    }

    public double getKineticEnergy(double m, double v){
        double ke;
        ke = (1/2) * m * (v * v);
        return ke;
    }

    public double getPotentialEnergy(double m, double h){
        double pe;
        pe = m * GRAVITY * h;
        return pe;
    }

    public static double getTheta(int xVal, int yVal){
        double theta = Math.atan2(xVal,yVal) * 180/3.1415;
        return theta;
    }

    public void logInvalidAngleInfo(double angle){
        System.out.println("logging the angle " + String.format("%.2f ",angle) + "degrees. This is not the right angle.");
    }

    public void logValidAngleInfo(double angle){
        System.out.println("logging the angle " + String.format("%.2f ",angle) + "degrees. This is a valid 3-4-5 triangle");
    }

    public static double getLightSpeedInMPH(){
        double lightspeed = getSpeedOfLightInMPHS() * 3600;
        return lightspeed;
    }

    public static double getTimeFromSunToEarthInHours(){
        double timeToEarth = (getKnownDistanceToEarth() / getSpeedOfLightInMPHS()) / 3600;
        return timeToEarth;
    }

    public void logEarthToSunInvalidDistance(){
        System.out.println("The calculated distance from the Earth to the Sun is invalid.");
    }

    public static double getSpeedOfLightInMPHS(){
        double c = 186282;
        return c;
    }

    public static double getKnownDistanceToEarth(){
        double time = 92947266.72;
        return time;
    }
}