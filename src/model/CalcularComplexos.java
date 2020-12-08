package model;

import java.util.Stack;


public class CalcularComplexos {
    public static Stack<String> bufferComplex = new Stack<>();
    private int n1Real;
    private int n1Im;
    private int n2Real;
    private int n2Im;

    public CalcularComplexos(String ComplexoInput){
        String lN1[] = bufferComplex.pop().replaceAll("\\D+",",").split("\\s*,\\s*");
        String lN2[] = ComplexoInput.replaceAll("\\D+",",").split("\\s*,\\s*");

        this.n1Real = Integer.parseInt(lN1[0]);
        this.n1Im = Integer.parseInt(lN1[1]);

        this.n2Real = Integer.parseInt(lN2[0]);
        this.n2Im = Integer.parseInt(lN2[1]);
    }

    public CalcularComplexos(String Complexo1, String Complexo2){
        String lN1[] = Complexo1.replaceAll("\\D+",",").split("\\s*,\\s*");
        String lN2[] = Complexo2.replaceAll("\\D+",",").split("\\s*,\\s*");

        this.n1Real = Integer.parseInt(lN1[0]);
        this.n1Im = Integer.parseInt(lN1[1]);

        this.n2Real = Integer.parseInt(lN2[0]);
        this.n2Im = Integer.parseInt(lN2[1]);

        System.out.println("numero chegou" + Complexo1);
    }

    public String soma(){
        return (n1Real + n2Real)+"+" + (n1Im + n2Im) + "i";
        // return "01+01i";
    }

    public String subtracao(){
        return (n1Real - n2Real)+" + " + (n1Im - n2Im) + "i";
    }

    public String divisao(){
        return  ((n1Real * n2Real) - (n1Im * -n2Im))+" + " + ((n1Real * -n2Im) + (n2Real * n1Im)) + "i / "+((n1Real*n2Real) - (n1Im*n2Im));
    }

    public String multiplicacao(){
        return ((n1Real * n2Real) - (n1Im * n2Im))+" + " + ((n1Real * n2Im) + (n2Real * n1Im)) + "i";
    }

}
