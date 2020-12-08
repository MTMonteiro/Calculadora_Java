package model;

import java.util.Stack;

public class CalcularInt {
    public static Stack<Double> buffer = new Stack<>();
    // private String input;

    public CalcularInt(String input) {
        if (isInteger(input))
            buffer.push(Double.parseDouble(input));
    }

    public double soma() {
        double result = (buffer.empty()) ? 0 : buffer.pop();
        if (!buffer.empty())
            result = buffer.pop() + result;
            
        buffer.push(result);
        
        return result;
        // return n1 + n2;
    }

    public double subtracao() {
        double result = (buffer.empty()) ? 0 : buffer.pop();
        if (!buffer.empty())
            result = buffer.pop() - result;
            
        buffer.push(result);
        
        return result;
    }

    public double divisao() {
        double result = (buffer.empty()) ? 0 : buffer.pop();
        if (!buffer.empty())
            result = buffer.pop() / result;
            
        buffer.push(result);
        
        return result;
    }

    public double multiplicacao() {
        double result = (buffer.empty()) ? 0 : buffer.pop();
        if (!buffer.empty())
            result = buffer.pop() * result;
            
        buffer.push(result);
        
        return result;
    }

    public static boolean isInteger(String input) {
        return input.matches("[0-9.]*");
    }
}
