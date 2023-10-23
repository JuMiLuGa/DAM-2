/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.pets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.animal.Animal;
import model.animal.Cat;
import model.animal.Dog;
import model.animal.Pets;
import view.pets.PetsDialog;

/**
 *
 * @author fermigo
 */
public class PetsController {

    private final PetsDialog view;
    private final Pets pets;

    public PetsController(PetsDialog view, Pets pets) {
        this.view = view;
        this.pets = pets;
        this.view.addPetsButtonActionListener(this.getPetsButtonListener());
        this.view.addCatButtonActionListener(this.getCatButtonListener());
        this.view.addDogButtonActionListener(this.getDogButtonListener());
        this.view.addListPetsButtonActionListener(this.getListPetsButtonListener());
    }

    private ActionListener getPetsButtonListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.appendLine("Pets");
            }
        };
        return al;
    }

    private ActionListener getCatButtonListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets.addPet(new Cat());
                view.appendLine("New cat");
            }
        };
        return al;
    }

    private ActionListener getDogButtonListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets.addPet(new Dog());
                view.appendLine("New dog");
            }
        };
        return al;
    }

    private ActionListener getListPetsButtonListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Animal a : pets.getPetList()) {
                    if (a instanceof Cat) {
                        view.appendLine("Cat > " + ((Cat) a).meow() + a.eat());
                    } else if (a instanceof Dog) {
                        view.appendLine("Dog > " + ((Dog) a).bark() + a.eat());
                    }
                }
            }
        };
        return al;
    }

}
