package mlr_agent;

/**
 *
 * @author ftm
 */
public class MLRNormalEquation {
    double predictY;
    
    public double NormalEquationApproach(double [] beta, double x1, double x2){
        predictY = beta[0]+(beta[1]*x1)+(beta[2]*x2);

        return predictY;
    }
   
}
