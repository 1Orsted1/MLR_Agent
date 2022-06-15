package mlr_agent;

/**
 * @author : ftm
**/

public class Helper {
private double SD,D1,D2,D3;

    public Helper(double [][] systemEquations) {
        findSolution(systemEquations);
    }

    public double getSystemDeterminant() {
        return SD;
    }

    public double getDeterminant1() {
        return D1;
    }

    public double getDeterminant2() {
        return D2;
    }

    public double getDeterminant3() {
        return D3;
    }

    private double determinantOfMatrix(double mat[][]){
            double ans;
                ans = mat[0][0] * (mat[1][1] * mat[2][2] - mat[2][1] * mat[1][2])
                    - mat[0][1] * (mat[1][0] * mat[2][2] - mat[1][2] * mat[2][0])
                    + mat[0][2] * (mat[1][0] * mat[2][1] - mat[1][1] * mat[2][0]);
            return ans;
        }

    /*             0,0     0,1      0,2       0,3
                { n,      sumX1,   sumX2,   sumY },
                  1,0      1,1      1,2     1,3
                { sumX1, sumX1_2, sumX1X2, sumX1Y  },
                  2,0     2,1      2,2       2,3
                { sumX2, sumX1X2, sumX2_2, sumX2Y }
    
    */
    
        private void findSolution(double coeff[][]) {
            //determinante del sistema
            double d[][] = {
                    { coeff[0][0], coeff[0][1], coeff[0][2] },
                    { coeff[1][0], coeff[1][1], coeff[1][2] },
                    { coeff[2][0], coeff[2][1],coeff[2][2] },
            };
            
            //determinante de la matris 1
            double d1[][] = {
                    { coeff[0][3], coeff[0][1], coeff[0][2] },
                    { coeff[1][3], coeff[1][1], coeff[1][2] },
                    { coeff[2][3], coeff[2][1], coeff[2][2] },
            };

            //determinante de la matris 2
            double d2[][] = {
                    { coeff[0][0], coeff[0][3], coeff[0][2] },
                    { coeff[1][0], coeff[1][3], coeff[1][2] },
                    { coeff[2][0], coeff[2][3], coeff[2][2] },
            };

            //determinante de la matris 3
            double d3[][] = {
                    { coeff[0][0], coeff[0][1], coeff[0][3] },
                    { coeff[1][0], coeff[1][1], coeff[1][3] },
                    { coeff[2][0], coeff[2][1], coeff[2][3] },
            };
            //y si se requiriera determinante resultante n...

            
            SD = determinantOfMatrix(d);
            D1 = determinantOfMatrix(d1);
            D2 = determinantOfMatrix(d2);
            D3 = determinantOfMatrix(d3);

            }
}





