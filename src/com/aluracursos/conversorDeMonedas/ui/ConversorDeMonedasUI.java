package com.aluracursos.conversorDeMonedas.ui;

import com.aluracursos.conversorDeMonedas.modulos.Key;
import com.aluracursos.conversorDeMonedas.service.ExchangeRateService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;

public class ConversorDeMonedasUI {
    private final JFrame frame;
    private final JComboBox<String> fromCurrencyComboBox;
    private final JComboBox<String> toCurrencyComboBox;
    private final JTextField amountField;
    private final ExchangeRateService exchangeRateService;
    // Mapa para asociar codigos de moneda con nombres descriptivos
    private static final Map<String, String> CURRENCY_MAP = new HashMap<>();
    static {
        CURRENCY_MAP.put("USD", "Dolares Estadounidenses (USD)");
        CURRENCY_MAP.put("ARS", "Pesos Argentinos (ARS)");
        CURRENCY_MAP.put("BRL", "Reales Brasileños (BRL)");
        CURRENCY_MAP.put("COP", "Pesos Colombianos (COP)");
        CURRENCY_MAP.put("MXN", "Pesos Mexicanos (MXN)");
        CURRENCY_MAP.put("JPY", "Yenes Japoneses (JPY)");
    }

    public ConversorDeMonedasUI() {
        String apiKey = new Key().getApiKey();
        this.exchangeRateService = new ExchangeRateService(apiKey);

        frame = new JFrame("Conversor de Monedas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel fromLabel = new JLabel("Moneda de origen:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(fromLabel, gbc);

        // Llenar el ComboBox con nombres descriptivos
        fromCurrencyComboBox = new JComboBox<>(CURRENCY_MAP.values().toArray(new String[0]));
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(fromCurrencyComboBox, gbc);

        JLabel toLabel = new JLabel("Moneda de destino:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(toLabel, gbc);

        toCurrencyComboBox = new JComboBox<>(CURRENCY_MAP.values().toArray(new String[0]));
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(toCurrencyComboBox, gbc);

        JLabel amountLabel = new JLabel("Monto:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(amountLabel, gbc);

        amountField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(amountField, gbc);

        JButton convertButton = new JButton("Convertir");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        frame.add(convertButton, gbc);

        convertButton.addActionListener(this::convertirMoneda);
    }

    private void convertirMoneda(ActionEvent e) {
        try {
            // Obtener el nombre descriptivo seleccionado y extraer el codigo
            String fromCurrencyName = (String) fromCurrencyComboBox.getSelectedItem();
            String toCurrencyName = (String) toCurrencyComboBox.getSelectedItem();
            String fromCurrency = getCurrencyCode(fromCurrencyName);
            String toCurrency = getCurrencyCode(toCurrencyName);
            double amount = Double.parseDouble(amountField.getText().trim());

            if (amount <= 0) {
                JOptionPane.showMessageDialog(frame, "El monto debe ser mayor a 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double result = exchangeRateService.getExchangeRate(fromCurrency, toCurrency, amount);

            // Configurar DecimalFormat para usar puntos como separadores de miles y coma como decimal
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator('.');
            symbols.setDecimalSeparator(',');
            DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

            // Formatear el mensaje con el nuevo formato
            String message = df.format(amount) + " " + fromCurrency + " = " + df.format(result) + " " + toCurrency;

            showResultDialog(message);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor, ingrese un monto valido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(frame, "Error al realizar la conversion: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener el código de moneda a partir del nombre descriptivo
    private String getCurrencyCode(String currencyName) {
        for (Map.Entry<String, String> entry : CURRENCY_MAP.entrySet()) {
            if (entry.getValue().equals(currencyName)) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("Moneda no encontrada: " + currencyName);
    }

    private void showResultDialog(String message) {
        JDialog resultDialog = new JDialog(frame, "Resultado", true);
        resultDialog.setSize(300, 150);
        resultDialog.setLocationRelativeTo(frame);
        resultDialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel resultLabel = new JLabel(message);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        resultDialog.add(resultLabel, gbc);

        JButton anotherConversionButton = new JButton("Otra Conversion");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        resultDialog.add(anotherConversionButton, gbc);

        JButton exitButton = new JButton("Salir");
        gbc.gridx = 1;
        gbc.gridy = 1;
        resultDialog.add(exitButton, gbc);

        anotherConversionButton.addActionListener(e -> resultDialog.dispose());
        exitButton.addActionListener(e -> System.exit(0));

        resultDialog.setVisible(true);
    }

    public void show() {
        frame.setVisible(true);
    }
}