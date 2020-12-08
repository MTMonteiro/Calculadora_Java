package console;

import java.util.Scanner;
import java.util.Stack;
import model.CalcularComplexos;


public class RpnCalculadora {
    private static Scanner scanner = new Scanner(System.in);
    
    private static Stack<Integer> buffer = new Stack<>();
    private static Stack<String> bufferComplex = new Stack<>();

    public static void main(String[] args) {
        System.out.println("Digite 0 para inteiro , 1 para complexos: ");
        String opType = "";
        opType = scanner.next();
        
        System.out.println("Digite inicie a operação (s para sair): ");

        String input = "";
        while (!input.equals("s")) {
            input = scanner.next();

            // loop para inteiros
            if (opType.equals("0")) {
                if (isInteger(input)) {
                    buffer.push(Integer.parseInt(input));
                } else if (isOperation(input)) {
                    int current = parseOperation(input, buffer);
                    if (buffer.size() == 0) {
                        System.out.println(">> " + current);
                    } else {
                        System.out.println("> " + current);
                    }
                    buffer.push(current);
                }
            }
            // loop para complexo
            if (opType.equals("1")) {

                if (isComplex(input)) {
                    bufferComplex.push(input);
                } else if (isOperation(input)) {
                    String current = parseOperationComplex(input, bufferComplex);
                    if (bufferComplex.size() == 0) {
                        System.out.println(">> " + current);
                    } else {
                        System.out.println("> " + current);
                    }
                    bufferComplex.push(current);
                }
            }

        }
    }

   
    public static int parseOperation(String operation, Stack<Integer> buffer) {
        int result = (buffer.empty()) ? 0 : buffer.pop();

        if (!buffer.empty()) {
            result = operateInt(operation, buffer.pop(), result);
        }

        return result;
    }

    // tratamento e utilização do metodo
    public static String parseOperationComplex(String operation, Stack<String> bufferComplex) {
        String result = (bufferComplex.empty()) ? "0" : bufferComplex.pop();

        if (!bufferComplex.empty()) {
            result = operateComplex(operation, bufferComplex.pop(), result);
        }

        return result;

    }

    // metodo para realizar operações para os numeros inteiros

    public static int operateInt(String operation, int n1, int n2) {
        switch (operation) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/": {
                if (n2 == 0) {
                    System.out.println("ERRO: divisão por 0");
                    return n1;
                }
                return n1 / n2;
            }
            default:
                return n1;
        }
    }

    
    // metodo para realizar realizar operações para numeros complexos

    public static String operateComplex(String operation, String complexo1, String complexo2) {

        switch (operation) {
            case "+":
                return new CalcularComplexos(complexo1, complexo2).soma();
            case "-":
                return new CalcularComplexos(complexo1, complexo2).subtracao();
            case "*":
                return new CalcularComplexos(complexo1, complexo2).multiplicacao();
            case "/": {
                if (complexo2 == "0") {
                    System.out.println("ERRO: divisão por 0");
                    return complexo1;
                }
                return new CalcularComplexos(complexo1, complexo2).divisao();
            }
            default:
                return complexo1;
        }
    }

    // verificar se a string pode ser convertida em inteiro
    public static boolean isInteger(String input) {
        return input.matches("[0-9.]*");
    }

    // verificar se a string pode ser convertida em numero complexo
    public static boolean isComplex(String input) {
        System.out.println(input.matches("[0-9.]*[+-][0-9.]*i"));

        return input.matches("[0-9.]*[+-][0-9.]*i");
    }

    // operações aceitas
    public static boolean isOperation(String input) {
        if (input == null)
            return false;

        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }
}