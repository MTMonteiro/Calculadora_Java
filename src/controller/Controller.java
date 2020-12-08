package controller;

import model.*;
import view.*;
import java.awt.event.*;
import java.util.Stack;

public class Controller {
  private static Stack<String> bufferComplex = new Stack<>();

  Model model;
  View view;

  public Controller(Model aModel, View aView) {
    model = aModel;
    view = aView;
    view.setBotaoSoma(new Soma());
    view.setBotaoSubtracao(new Subtracao());
    view.setBotaoDivisao(new Divisao());
    view.setBotaoMultiplicacao(new Multiplicacao());
    view.setBotaoEnter(new Enter());
    view.setBotaoI(new AddNumber("i"));
    view.setBotao0(new AddNumber("0"));
    view.setBotao1(new AddNumber("1"));
    view.setBotao2(new AddNumber("2"));
    view.setBotao3(new AddNumber("3"));
    view.setBotao4(new AddNumber("4"));
    view.setBotao5(new AddNumber("5"));
    view.setBotao6(new AddNumber("6"));
    view.setBotao7(new AddNumber("7"));
    view.setBotao8(new AddNumber("8"));
    view.setBotao9(new AddNumber("9"));
  }

  // VERIFICA SE É UM INTEIRO
  public static boolean isInteger(String input) {
    return input.matches("[0-9.]*");
  }

  // VERIFICA SE O NUMERO É UM NUMERO COMPLEXO
  public static boolean isComplex(String input) {
    System.out.println(input.matches("[0-9.]*[+-][0-9.]*i"));
    System.out.println(input + input.matches("[0-9.]*[+-][0-9.]*i"));
    return input.matches("[0-9.]*[+-][0-9.]*i");
  }

  public static int parseOperation(String operation, Stack<Integer> buffer) {
    int result = (buffer.empty()) ? 0 : buffer.pop();

    if (!buffer.empty()) {
      result = buffer.pop() + result;
    }

    return result;
  }

  class Enter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (view.modo() == "inteiro") {
        String textoNumero = view.getNum();
        // adicionar numero na pilha
        if (isInteger(textoNumero)) {
          // CalcularInt.buffer.push(1.2);
          CalcularInt.buffer.push(Double.parseDouble(textoNumero));
        }

        view.setNum("");

        System.out.println("Enter inteiro");

      }
      // enter para numero complexo
      else {
        String textoNumero = view.getNum();
        // adicionar numero na pilha
        System.out.println("complexo:" + isComplex(textoNumero));
        if (isComplex(textoNumero)) {
          bufferComplex.push(textoNumero);
          view.setNum("");
          System.out.println("complexo adicionado");
        }

      }
    }
  }

  class Subtracao implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (view.modo() == "inteiro") {
        System.out.println("subtracao inteiro");
        String textoNumero = view.getNum();

        double current = new CalcularInt(textoNumero).subtracao();
        view.setNum(String.valueOf(current));

      } else {
        String textoNumero = view.getNum();
        // adicionar numero na pilha
        if (isComplex(textoNumero)) {
          bufferComplex.push(textoNumero);
          view.setNum("");
          String result = (bufferComplex.empty()) ? "0 + 0i" : bufferComplex.pop();

          if (!bufferComplex.empty()) {
            result = new CalcularComplexos(bufferComplex.pop(), result).subtracao();
          }

          view.setNum(result);

        } else {
          view.setNum(textoNumero + "-");
        }

      }
    }
  }

  class Soma implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (view.modo() == "inteiro") {
        System.out.println("somar inteiro");
        String textoNumero = view.getNum();

        double current = new CalcularInt(textoNumero).soma();
        view.setNum(String.valueOf(current));

      } else {
        String textoNumero = view.getNum();
        System.out.println("somar complexo");
        System.err.println("Digitado:" + textoNumero);
        // adicionar numero na pilha
        if (isComplex(textoNumero)) {
          bufferComplex.push(textoNumero);
          view.setNum("");

          System.out.println("else if");
          String result = (bufferComplex.empty()) ? "0 + 0i" : bufferComplex.pop();

          if (!bufferComplex.empty()) {
            result = new CalcularComplexos(bufferComplex.pop(), result).soma();
          }

          view.setNum(result);

        } else {
          view.setNum(textoNumero + "+");
        }

      }
    }
  }

  class Divisao implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (view.modo() == "inteiro") {
        System.out.println("somar inteiro");
        String textoNumero = view.getNum();

        double current = new CalcularInt(textoNumero).divisao();
        view.setNum(String.valueOf(current));

      } else {
        String textoNumero = view.getNum();
        // adicionar numero na pilha
        if (isComplex(textoNumero)) {
          bufferComplex.push(textoNumero);
          view.setNum("");

          String result = (bufferComplex.empty()) ? "0 + 0i" : bufferComplex.pop();

          if (!bufferComplex.empty()) {
            result = new CalcularComplexos(bufferComplex.pop(), result).divisao();
          }

          view.setNum(result);

        }

      }
    }
  }

  class Multiplicacao implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (view.modo() == "inteiro") {
        System.out.println("somar inteiro");
        String textoNumero = view.getNum();

        double current = new CalcularInt(textoNumero).multiplicacao();
        view.setNum(String.valueOf(current));

      } else {
        String textoNumero = view.getNum();
        // adicionar numero na pilha
        if (isComplex(textoNumero)) {
          bufferComplex.push(textoNumero);
          view.setNum("");

          String result = (bufferComplex.empty()) ? "0 + 0i" : bufferComplex.pop();

          if (!bufferComplex.empty()) {
            result = new CalcularComplexos(bufferComplex.pop(), result).multiplicacao();
          }
          view.setNum(result);

        }

      }
    }
  }

  class AddNumber implements ActionListener {
    private String number;

    public AddNumber(String number) {
      this.number = number;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      String input = view.getNum();
      // concatena com o novo valor
      input += this.number;
      // adiciona o novo valor no campo input
      view.setNum(input);
    }
  }

}
