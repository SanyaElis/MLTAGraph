package com.company;

public class Main {
    public double[] solveCubicEquation(double A, double B, double C, double D) {


        double a =  B / A;
        double b =  C / A;
        double c =  D / A;

        double p = b - ((a * a) / 3.0);

        double q = (2 * Math.pow(a, 3) / 27.0) - (a * b / 3.0) + c;

        double delta = (Math.pow(q, 2) / 4) + (Math.pow(p, 3) / 27);

        if (delta > 0.001) {

            double mt1, mt2;

            double t1 = (-q / 2.0) + Math.sqrt(delta);
            double t2 = (-q / 2.0) - Math.sqrt(delta);

            if (t1 < 0) {
                mt1 = (-1) * (Math.pow(-t1, (double) 1 / 3));
            } else {
                mt1 = (Math.pow(t1, (double) 1 / 3));
            }

            if (t2 < 0) {
                mt2 = (-1) * (Math.pow(-t2, (double) 1 / 3));
            } else {
                mt2 = (Math.pow(t2, (double) 1 / 3));
            }

            double x1 = mt1 + mt2 - (a / 3.0);

            return new double[]{x1};

        } else if (delta < 0.001 && delta > -0.001) {

            if (q < 0) {

                double x1 = 2 * Math.pow(-q / 2, (double) 1 / 3) - (a / 3);
                double x2 = -1 * Math.pow(-q / 2, (double) 1 / 3) - (a / 3);

                return new double[]{x1, x2};


            } else {
                double x1 = -2 * Math.pow(q / 2, (double) 1 / 3) - (a / 3);
                double x2 = Math.pow(q / 2, (double) 1 / 3) - (a / 3);

                return new double[]{x1, x2};
            }

        } else {

            double x1 = (2.0 / Math.sqrt(3)) * (Math.sqrt(-p) * Math.sin((1 / 3.0) * Math.asin(((3 * Math.sqrt(3) * q) / (2 * Math.pow(Math.pow(-p, (double) 1 / 2), 3)))))) - (a / 3.0);
            double x2 = (-2.0 / Math.sqrt(3)) * (Math.sqrt(-p) * Math.sin((1 / 3.0) * Math.asin(((3 * Math.sqrt(3) * q) / (2 * Math.pow(Math.pow(-p, (double) 1 / 2), 3)))) + (Math.PI / 3))) - (a / 3.0);
            double x3 = (2.0 / Math.sqrt(3)) * (Math.sqrt(-p) * Math.cos((1 / 3.0) * Math.asin(((3 * Math.sqrt(3) * q) / (2 * Math.pow(Math.pow(-p, (double) 1 / 2), 3)))) + (Math.PI / 6))) - (a / 3.0);

            return new double[]{x1, x2, x3};
        }

    }

    public static void main(String[] args) {
        GraphicApp app = new GraphicApp();
        app.show();
    }
}
