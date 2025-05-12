package com.aluracursos.conversorDeMonedas;

import com.aluracursos.conversorDeMonedas.ui.ConversorDeMonedasUI;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConversorDeMonedasUI converter = new ConversorDeMonedasUI();
            converter.show();
        });
    }
}