package com.ken10.Phase3;


import com.ken10.Phase1.OdeFunction;

public class TitanLanderODE implements OdeFunction {
    private double g; // gravity
    private double u; // main thrust
    private double v; // torque

    public TitanLanderODE(double g, double u, double v) {
        this.g = g;
        this.u = u;
        this.v = v;
    }

    @Override
    public double[] evaluate(double time, double[] state) {
        double x = state[0];
        double y = state[1];
        double theta = state[2];
        double vx = state[3];
        double vy = state[4];
        double omega = state[5];

        double[] derivatives = new double[6];
        derivatives[0] = vx;
        derivatives[1] = vy;
        derivatives[2] = omega;
        derivatives[3] = u * Math.sin(theta);
        derivatives[4] = u * Math.cos(theta) - g;
        derivatives[5] = v;

        return derivatives;
    }

}
