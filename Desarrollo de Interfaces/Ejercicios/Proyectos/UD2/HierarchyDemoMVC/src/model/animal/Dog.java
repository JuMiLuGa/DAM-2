/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.animal;

/**
 *
 * @author fermigo
 */
public class Dog extends Animal {

    private static final String BARKING = "Barking...";

    public String bark() {
        return this.BARKING;
    }

    @Override
    public String eat() {
        return "DOG: " + super.eat();
    }
}
