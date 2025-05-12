package com.aluracursos.conversorDeMonedas.modulos;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Key {
    public String getApiKey() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Key.txt"))) {
            return reader.readLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer Key.txt: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            return null;
        }
    }
}