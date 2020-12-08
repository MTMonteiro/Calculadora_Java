package console;

import model.*;

public class CalculadoraConsole {

    public static void main(String[] args) {
        // CalcularComplexos complexo = new CalcularComplexos("1 + 2i", "2 + 3i");

        System.out.println(new CalcularComplexos("1+2i", "2+2i").soma());
        System.out.println(new CalcularComplexos("2 + 1i", "3 + 2i").multiplicacao());
        System.out.println(new CalcularComplexos("0 + 3i", "4 + 2i").divisao());
    }
}
