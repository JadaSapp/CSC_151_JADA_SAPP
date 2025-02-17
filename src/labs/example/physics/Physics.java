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
        pe = m*GRAVITY*h;
        return pe;
    }

      public static double getLightSpeedInMPH(double c, double n){
        double ls;
       ls = c * n;
       return ls;
    }

    public double getTimeFromSunToEarthInHours(double d, double c){
        double ste;
        ste = d / c;
        return ste;
    }

    public static double getKnownDistanceToEarth(){
        double dte;
        dte = 92947266.72;
        return dte;
    } 
}