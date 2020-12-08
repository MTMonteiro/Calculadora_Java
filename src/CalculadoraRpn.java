import model.*;
import view.*;
import controller.*;

public class CalculadoraRpn {
    public static void main(String[] args) {
      Model model = new Model();
      View view = new View();
      new Controller(model, view);
    }
  
  }