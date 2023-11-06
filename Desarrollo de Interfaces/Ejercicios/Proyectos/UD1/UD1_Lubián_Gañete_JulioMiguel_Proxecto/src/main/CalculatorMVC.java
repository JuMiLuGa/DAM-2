
package main;


import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;
import view.MainView;



public class CalculatorMVC {
    public static void main(String[] args) {
        // Crea una instancia del modelo, vista y controlador
        
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);
        
        
        // Establece la visibilidad de la vista
        view.setVisible(true);
    }
}
