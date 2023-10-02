package Ejercicio_2;

public class Ejercicio_2 {
    
    public static void main(String[] args){
        
        double dolar = 1.137;
        double salario = 2125.70;
        double salario_en_dolar;
        String nombre = "Manuel";
        
        salario_en_dolar = salario * dolar;
        
        System.out.println("El salario de dolares de " + nombre + " es " + salario_en_dolar);
    }
}
