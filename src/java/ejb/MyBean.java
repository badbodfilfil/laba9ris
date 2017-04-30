/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Random;

@ManagedBean
@SessionScoped
public class MyBean {

    final Random random = new Random();
    private String n;
    private String m;
    private String r;
    private String result;
    private String matrix;

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMatrix() {
        return matrix;
    }

    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }

    public void doSomething() {
        try {
            int n = Integer.valueOf(this.n);
            int m = Integer.valueOf(this.m);
            int r = Integer.valueOf(this.r);
            int[][] mtrx = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mtrx[i][j] = random.nextInt(r);
                    System.out.println(mtrx[i][j]);
                }
            }
            String matrixStr = new String();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrixStr = matrixStr + mtrx[i][j]+" ";
                }
                if(i!=n-1)
                matrixStr += "---";
            }
            int[][] transpMtrx = transp(mtrx);
            String transpStr = new String();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    transpStr = transpStr + transpMtrx[i][j]+" ";
                }
                if(i!=n-1)
                transpStr += "---";
            }
            this.result =transpStr;

            this.matrix = matrixStr;
        } catch (Exception ignored) {
            this.result = "Your fields are not valid! Check all and try again";
        }

    }

    public static int[][] transp(int[][] m) {
        int buffer[][] = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                buffer[j][i] = m[i][j];
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = buffer[i][j];
            }
        }
        return m;
    }
}
