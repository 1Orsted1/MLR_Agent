/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlr_agent;

/**
 *
 * @author ftm
 * 
 * info https://assets.researchsquare.com/files/rs-191330/v1_covered.pdf?c=1631859047
 * 
 */

public class MLRCrammer {
    public MLRCrammer(double[][] data) {
        this.dataMatrix = data;
        calculate();
    }
    private double B0,B1,B2;
    private double[][] dataMatrix;

    
    public void setDataMatrix(double[][] dataMatrix) {
        this.dataMatrix = dataMatrix;
        calculate();
    }

    public double getB0() {
        return B0;
    }

    public double getB1() {
        return B1;
    }

    public double getB2() {
        return B2;
    }

    private void calculate(){
        double sumX1 = 0,sumX2 = 0,sumY = 0,sumX1Y = 0,sumX2Y = 0,sumX1_2 = 0,sumX2_2 = 0,sumX1X2 = 0,n = dataMatrix.length;
        for (int i = 0; i < dataMatrix.length; i++){
            sumX1 += dataMatrix[i][0];
            sumX2 += dataMatrix[i][1];
            sumY += dataMatrix[i][2];
            sumX1Y += dataMatrix[i][0] * dataMatrix[i][2];
            sumX2Y += dataMatrix[i][1] * dataMatrix[i][2];
            sumX1_2 += dataMatrix[i][0] * dataMatrix[i][0];
            sumX2_2 += dataMatrix[i][1] * dataMatrix[i][1];
            sumX1X2 += dataMatrix[i][0] * dataMatrix[i][1];
        }

        double[][] systemEquations = {
                { n, sumX1, sumX2, sumY },
                { sumX1, sumX1_2, sumX1X2, sumX1Y  },
                { sumX2, sumX1X2, sumX2_2, sumX2Y }
        };

        Helper helper = new Helper(systemEquations);
        
        B0 = helper.getDeterminant1()/helper.getSystemDeterminant();
        B1 = helper.getDeterminant2()/helper.getSystemDeterminant();
        B2 = helper.getDeterminant3()/helper.getSystemDeterminant();


    }
    
    public double CrammerApproach(double b0,double b1, double b2, double x1, double x2){
        double predictY;
        predictY = b0+b1*x1+b2*x2;
        return predictY;
    }
    
    
}

