/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlr_agent;

/**
 *
 * @author ftm
 */
public class mlr {
    private double fin[];
    double[][] dataSet = new data().getData();
   
   public double []  mlr (){
       mlr mrl=new mlr();
       double x[][]= mrl.MatrizNormal_x(dataSet);
       double xt[][]= mrl.traspuesta_xt(dataSet);
       double multiplicar[][]=mrl.Multiplicar_x_xt(dataSet, x, xt);
       double deter= mrl.determinante(multiplicar);
       double adjunta[][]= mrl.adjunta(multiplicar,deter);
       double ma [] = mrl.Multiplicar_y_por_xt(xt, dataSet);
       fin=mrl.calcularValores(adjunta, ma);
       return fin;
    }
    public double [][] traspuesta_xt(double datos [][]){
        double traspuesta[][] = new double[datos[0].length][datos.length];
        
         for (int i = 0; i < datos.length; i++) {
                traspuesta[0][i]=1;
                traspuesta[1][i]=datos[i][0];
                traspuesta[2][i]=datos[i][1]; 
        }
        
        
         return traspuesta;
    }
    
    public double[][] MatrizNormal_x(double datos[][]){
         double matriz1[][]= new double[datos.length][datos[0].length];
         for (int i = 0; i < datos.length; i++) {
                matriz1[i][0]=1;
                matriz1[i][1]=datos[i][0];
                matriz1[i][2]=datos[i][1]; 
        }
        
        return matriz1;
    }
    
    public double []  Multiplicar_y_por_xt(double traspuesta[][], double [][]datos){
         double mult[]=new double[3];
        for (int i = 0; i < datos.length; i++) {
             
         mult[0]+=datos[i][2]*traspuesta[0][i];
         mult[1]+=datos[i][2]*traspuesta[1][i];
         mult[2]+=datos[i][2]*traspuesta[2][i];
            
        }
        
     //   System.out.println(Arrays.toString(mult));
        return mult;
    }
    
    public  double [][] Multiplicar_x_xt (double datos[][], double x[][],double xt[][]){
        double [][] x_xt = new double[3][3];
        
        for (int i = 0; i < datos.length; i++) {
            x_xt[0][0]+=x[i][0]*xt[0][i];
            x_xt[0][1]+=x[i][0]*xt[1][i];
            x_xt[0][2]+=x[i][0]*xt[2][i];
            
            x_xt[1][0]+=x[i][1]*xt[0][i];
            x_xt[1][1]+=x[i][1]*xt[1][i];
            x_xt[1][2]+=x[i][1]*xt[2][i];
            
            x_xt[2][0]+=x[i][2]*xt[0][i];
            x_xt[2][1]+=x[i][2]*xt[1][i];
            x_xt[2][2]+=x[i][2]*xt[2][i];
        }
      // System.out.println("Normal; "+ Arrays.deepToString(x_xt));
        return x_xt;
    }
    
    public  double  determinante(double x_xt[][]){
        double determinante;
        double dete[][] =new double[3][5];
        //dete=x_xt;
         
        for (int i = 0; i < x_xt.length; i++) {
            
            dete[i][0]= x_xt[i][0];
            dete[i][1]= x_xt[i][1];
            dete[i][2]= x_xt[i][2];
            dete[i][3]= x_xt[i][0];
            dete[i][4]=x_xt[i][1];
        }
        
      //  System.out.println(Arrays.deepToString(dete));
       double a = (dete[0][0]*dete[1][1]*dete[2][2])+(dete[0][1]*dete[1][2]*dete[2][3])+(dete[0][2]*dete[1][3]*dete[2][4]);
       double b = (dete[2][0]*dete[1][1]*dete[0][2])+(dete[2][1]*dete[1][2]*dete[0][3])+(dete[2][2]*dete[1][3]*dete[0][4]);
       determinante= a-b;
        return  determinante;
    }

    public double [][] adjunta (double xt[][] ,double  d){
    //calculo de adjuntos
    //para poder dividirlo entre la determunante
      double adjunta[][] =new double[3][3];
      
    
       adjunta[0][0]=((xt[1][1]*xt[2][2]) - (xt[1][2]*xt[2][1]))/d;
       adjunta[0][1]=(-((xt[1][0]*xt[2][2]) - (xt[1][2]*xt[2][0])))/d;
       adjunta[0][2]=((xt[1][0]*xt[2][1]) - (xt[1][1]*xt[2][0]))/d;
       
       adjunta[1][0]=(-((xt[0][1]*xt[2][2]) - (xt[0][2]*xt[2][1])))/d;
       adjunta[1][1]=((xt[0][0]*xt[2][2]) - (xt[0][2]*xt[2][0]))/d;
       adjunta[1][2]=(-((xt[0][0]*xt[2][1]) - (xt[0][1]*xt[2][0])))/d;
       
       adjunta[2][0]=((xt[0][1]*xt[1][2]) - (xt[0][2]*xt[1][1]))/d;
       adjunta[2][1]=(-((xt[0][0]*xt[1][2]) - (xt[0][2]*xt[1][0])))/d;
       adjunta[2][2]=((xt[0][0]*xt[1][1]) - (xt[0][1]*xt[1][0]))/d;
       
       
            return adjunta;
    }

    public  double []  calcularValores(double [][]inversa, double []y_xt){
        double[] b= new double[3];
        
         
            b[0]=(inversa[0][0]*y_xt[0])+(inversa[0][1]*y_xt[1])+(inversa[0][2]*y_xt[2]);
            b[1]=(inversa[1][0]*y_xt[0])+(inversa[1][1]*y_xt[1])+(inversa[1][2]*y_xt[2]);
            b[2]=(inversa[2][0]*y_xt[0])+(inversa[2][1]*y_xt[1])+(inversa[2][2]*y_xt[2]);
            
         
       // System.out.println(Arrays.toString(b));
        return b;
        
    }
}
