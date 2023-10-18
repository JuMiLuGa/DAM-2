/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.textEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.textEditor.TextEditorDialog;

/**
 *
 * @author dides
 */
public class TextEditorController {

    private final TextEditorDialog view;

    public TextEditorController(TextEditorDialog view) {
        this.view = view;
        this.view.addOpenButtonActionListeter(this.addOpenButtonActionListener());
        this.view.addSaveButtonActionListeter(this.addSaveButtonActionListener());
    }

    private ActionListener addOpenButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("Texto", "txt");
                fc.setFileFilter(filter);
                int rt = fc.showOpenDialog(view);
                if (rt == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    Scanner reader;
                    try {
                        reader = new Scanner(file);
                        while (reader.hasNextLine()) {
                            String line = reader.nextLine();
                            view.appendLine(line);
                        }
                    } catch (FileNotFoundException ex) {
                        System.err.println("File not found");
                    }
                } else {
                    System.err.println("File not selected");
                }
            }

        };
        return al;
    }

    private ActionListener addSaveButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setDialogTitle("File to save:");
                FileFilter filter = new FileNameExtensionFilter("Texto", "txt");
                fc.setFileFilter(filter);
                int rt = fc.showSaveDialog(view);
                if (rt == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fc.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                        writer.write(view.getText());
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                } else {
                    System.err.println("File not selected");
                }
            }

        };
        return al;
    }

}
