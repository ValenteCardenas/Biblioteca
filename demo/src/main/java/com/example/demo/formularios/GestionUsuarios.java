package com.example.demo.formularios;

import javax.swing.*;

public class GestionUsuarios extends JFrame {

    private JButton btnGenerarMulta, btnEliminarUsuario, btnGestionarPermisos, btnRegresar;
    
    public GestionUsuarios() {
        setTitle("Gestión de Usuarios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 150);
        setLocationRelativeTo(null);
        initComponents();
    }
    
    private void initComponents() {
        btnGenerarMulta = new JButton("Generar multa a usuarios");
        btnEliminarUsuario = new JButton("Eliminar usuario");
        btnGestionarPermisos = new JButton("Gestionar permisos");
        btnRegresar = new JButton("Regresar");
        
        btnGenerarMulta.addActionListener(e -> {
            new Multas().setVisible(true);
            this.dispose();
        });
        
        btnEliminarUsuario.addActionListener(e -> {
            // Lógica para eliminar usuario
            JOptionPane.showMessageDialog(this, "Funcionalidad para eliminar usuario.");
        });
        
        btnGestionarPermisos.addActionListener(e -> {
            new GestorPermisos().setVisible(true);
            this.dispose();
        });
        
        btnRegresar.addActionListener(e -> {
            new MenuAdministrador().setVisible(true);
            this.dispose();
        });
        
        JPanel panel = new JPanel();
        panel.add(btnGenerarMulta);
        panel.add(btnEliminarUsuario);
        panel.add(btnGestionarPermisos);
        panel.add(btnRegresar);
        
        getContentPane().add(panel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestionUsuarios().setVisible(true));
    }
}
