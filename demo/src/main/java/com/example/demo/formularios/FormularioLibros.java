package com.example.demo.formularios;

import javax.swing.*;
import java.awt.*;

public class FormularioLibros extends JFrame {

    private JTextField txtTitulo, txtAutor, txtEdicion, txtISBN, txtGenero;
    private JButton btnGuardar, btnRegresar;
    
    public FormularioLibros() {
        setTitle("Añadir Libro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        initComponents();
    }
    
    private void initComponents() {
        JLabel lblTitulo = new JLabel("Título:");
        JLabel lblAutor = new JLabel("Autor:");
        JLabel lblEdicion = new JLabel("Edición:");
        JLabel lblISBN = new JLabel("ISBN:");
        JLabel lblGenero = new JLabel("Género:");
        
        txtTitulo = new JTextField(20);
        txtAutor = new JTextField(20);
        txtEdicion = new JTextField(20);
        txtISBN = new JTextField(20);
        txtGenero = new JTextField(20);
        
        btnGuardar = new JButton("Guardar");
        btnRegresar = new JButton("Regresar");
        
        // Acción del botón Regresar
        btnRegresar.addActionListener(e -> {
            new MenuAdministrador().setVisible(true);
            this.dispose();
        });
        
        // Distribución simple con GridLayout
        JPanel panelCampos = new JPanel(new GridLayout(5, 2, 5, 5));
        panelCampos.add(lblTitulo);
        panelCampos.add(txtTitulo);
        panelCampos.add(lblAutor);
        panelCampos.add(txtAutor);
        panelCampos.add(lblEdicion);
        panelCampos.add(txtEdicion);
        panelCampos.add(lblISBN);
        panelCampos.add(txtISBN);
        panelCampos.add(lblGenero);
        panelCampos.add(txtGenero);
        
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnRegresar);
        panelBotones.add(btnGuardar);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelCampos, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioLibros().setVisible(true));
    }
}
