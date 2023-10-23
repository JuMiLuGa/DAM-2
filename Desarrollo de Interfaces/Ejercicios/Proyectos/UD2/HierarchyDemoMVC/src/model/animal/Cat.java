/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.animal;

/**
 *
 * @author fermigo
 */
public class Cat extends Animal {

    private static final String MEOWING = "Meowing...";

    public String meow() {
        return this.MEOWING;
    }

    @Override
    public String eat() {
        return "CAT: " + super.eat();
    }

}
