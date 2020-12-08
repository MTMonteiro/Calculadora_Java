package teste;

public class test {
    public static void main(String[] args) {
        // String complex = "2 + 3i";
        String complex = "2 - 3i";

        System.out.println(complex);

        // System.out.println(complex.matches("[0-9.]* + [0-9.]*i"));
        
        // verficar se é um numero complexo
        System.out.println(complex.matches("[0-9.]* [+-] [0-9.]*i"));
        // separar parte real da imaginaria
        // colocar split e pegar o sinal digitado

        // String[] languages = linewithLeadingAndTrallingWhiteSpace.split("\\s");
        // languages = linewithLeadingAndTrallingWhiteSpace.trim().split("\\s+");

        System.out.println(complex.replaceAll("\\D+",",").split("\\s*,\\s*")[0]);
        System.out.println(complex.replaceAll("\\D+",",").split("\\s*,\\s*")[1]);
        // System.out.println(complex.replaceAll("[^0-9?!\\.]",""));

    }
}
