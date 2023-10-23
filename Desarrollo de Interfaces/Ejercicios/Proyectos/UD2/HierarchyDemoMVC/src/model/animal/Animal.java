/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.animal;

/**
 *
 * @author fermigo
 */
public abstract class Animal {

    private static final String ANIMAL_EATING = "Eating...";

    public String eat() {
        return this.ANIMAL_EATING;
    }
}
