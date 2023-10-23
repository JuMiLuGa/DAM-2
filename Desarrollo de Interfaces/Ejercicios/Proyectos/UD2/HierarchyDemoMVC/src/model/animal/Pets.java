/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.animal;

import java.util.ArrayList;

/**
 *
 * @author fermigo Singleton design pattern
 */
public class Pets {

    private static ArrayList<Animal> petList = null;
    private static Pets pets = null;

    private Pets() {
        Pets.petList = new ArrayList<>();
    }

    public static Pets getPets() {
        if (Pets.pets == null) {
            Pets.pets = new Pets();
        }
        return pets;
    }


    public void addPet(Animal a) {
        if (Pets.pets != null) {
            Pets.petList.add(a);
        }
    }


    public ArrayList<Animal> getPetList() {
        return Pets.petList;
    }

}
