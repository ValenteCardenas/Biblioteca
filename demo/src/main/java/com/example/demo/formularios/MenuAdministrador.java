package com.example.demo.formularios;

import javax.swing.*;

public class MenuAdministrador extends JFrame {

    private JButton btnAnadirLibros, btnGenerarReportes, btnGestionarUsuarios;
    private JLabel jLabelTitulo;
    
    public MenuAdministrador() {
        initComponents();
    }
    
    private void initComponents() {
        jLabelTitulo = new JLabel("Menú de Administrador");
        
        btnAnadirLibros = new JButton("Añadir libros");
        btnGenerarReportes = new JButton("Generar reportes");
        btnGestionarUsuarios = new JButton("Gestionar usuarios");
        
        // Configurar acción de botones
        btnAnadirLibros.addActionListener(e -> {
            new FormularioLibros().setVisible(true);
            this.dispose();
        });
        
        btnGenerarReportes.addActionListener(e -> {
            new Reportes().setVisible(true);
            this.dispose();
        });
        
        btnGestionarUsuarios.addActionListener(e -> {
            new GestionUsuarios().setVisible(true);
            this.dispose();
        });
        
        // Diseño simple con FlowLayout
        JPanel panel = new JPanel();
        panel.add(btnAnadirLibros);
        panel.add(btnGenerarReportes);
        panel.add(btnGestionarUsuarios);
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        jLabelTitulo.setAlignmentX(CENTER_ALIGNMENT);
        panel.setAlignmentX(CENTER_ALIGNMENT);
        getContentPane().add(jLabelTitulo);
        getContentPane().add(Box.createVerticalStrut(20));
        getContentPane().add(panel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuAdministrador().setVisible(true));
    }
}
