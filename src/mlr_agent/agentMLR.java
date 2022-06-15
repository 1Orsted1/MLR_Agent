/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlr_agent;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
/**
 *
 * @author ftm
 */
//this one needs the cramer aproach to go.
public class agentMLR extends Agent {

    private gui _myGui;
    MLRNormalEquation normal = new MLRNormalEquation();
    MLRCrammer crammer;
    public void setup() {
        System.out.println(" __  ___       __  ___         __           __   ___      ___ \n"
                + "/__`  |   /\\  |__)  |  | |\\ | / _`     /\\  / _` |__  |\\ |  |  \n"
                + ".__/  |  /~~\\ |  \\  |  | | \\| \\__>    /~~\\ \\__> |___ | \\|  |  \n"
                + "                                                              ");
        gui gui = new gui(this);
        gui.showGui();

    }

    protected void takeDown() {
        _myGui.dispose();
        System.out.println("MLR-agent " + getAID().getName() + " terminating.");
    }
    public void normalEquation(double x1, double x2) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                
                System.out.println("\n");
                System.out.println("GENERIC BEHAVIOUR: ");
                System.out.println("\n");
                
                mlr _mlr = new mlr();
                double[] fin = _mlr.mlr(); //B0              //B1                         //B2
                System.out.println("yi =" + fin[0] + " + " + fin[1] + "(x1=" + x1 + ")" +" + "+ fin[2] + "(x2=" + x2 + ")");
                System.out.println("y : " + normal.NormalEquationApproach(fin, x1, x2));
            }
        });
    }

       public void getX(final String x1,final String x2) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                System.out.println("\n");
                System.out.println("CRAMMER APPROACH: ");
                System.out.println("\n");
                
                data d = new data();
                MLRCrammer MLR = new MLRCrammer(d.getData());
                System.out.println("yi = "+MLR.getB0()+" + "+MLR.getB1()+"(x1="+x1+")"+" + "+MLR.getB2()+"(x2="+x2+")");
                System.out.print("y: ");
                System.out.println(MLR.getB0()+MLR.getB1()*Double.parseDouble(x1)+ MLR.getB2()*Double.parseDouble(x2));
            }
        });

    }


}
