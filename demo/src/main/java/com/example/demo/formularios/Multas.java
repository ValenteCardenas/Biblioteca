package com.example.demo.formularios;

import javax.swing.*;
import java.awt.*;

public class Multas extends JFrame {

    private JTextField txtMonto;
    private JTextArea txtDescripcion;
    private JButton btnAdjuntar, btnGenerarMulta, btnRegresar;
    
    public Multas() {
        setTitle("Generar Multa");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);
        initComponents();
    }
    
    private void initComponents() {
        JLabel lblDescripcion = new JLabel("Descripción:");
        JLabel lblMonto = new JLabel("Monto:");
        
        txtDescripcion = new JTextArea(5, 30);
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
        txtMonto = new JTextField(10);
        
        btnAdjuntar = new JButton("Adjuntar archivos");
        btnGenerarMulta = new JButton("Generar multa");
        btnRegresar = new JButton("Regresar");
        
        btnAdjuntar.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                // Aquí puedes obtener el archivo seleccionado
                JOptionPane.showMessageDialog(this, "Archivo seleccionado: " + fc.getSelectedFile().getName());
            }
        });
        
        btnGenerarMulta.addActionListener(e -> {
            // Lógica para generar la multa
            JOptionPane.showMessageDialog(this, "Multa generada correctamente.");
        });
        
        btnRegresar.addActionListener(e -> {
            new GestionUsuarios().setVisible(true);
            this.dispose();
        });
        
        JPanel panelCampos = new JPanel(new GridLayout(3, 2, 5, 5));
        panelCampos.add(lblDescripcion);
        panelCampos.add(scrollDescripcion);
        panelCampos.add(lblMonto);
        panelCampos.add(txtMonto);
        panelCampos.add(new JLabel("")); // Espacio vacío
        panelCampos.add(btnAdjuntar);
        
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnRegresar);
        panelBotones.add(btnGenerarMulta);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelCampos, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Multas().setVisible(true));
    }
}

