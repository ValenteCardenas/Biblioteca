package com.example.demo.formularios;

import javax.swing.*;

public class Reportes extends JFrame {

    private JButton btnReporteUsuarios, btnReporteLibros, btnReporteMobiliario, btnRegresar;
    
    public Reportes() {
        setTitle("Reportes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 150);
        setLocationRelativeTo(null);
        initComponents();
    }
    
    private void initComponents() {
        btnReporteUsuarios = new JButton("Reporte usuarios");
        btnReporteLibros = new JButton("Reporte Libros");
        btnReporteMobiliario = new JButton("Reporte Mobiliario");
        btnRegresar = new JButton("Regresar");
        
        btnReporteUsuarios.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Generando reporte de usuarios...");
        });
        
        btnReporteLibros.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Generando reporte de libros...");
        });
        
        btnReporteMobiliario.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Generando reporte de mobiliario...");
        });
        
        btnRegresar.addActionListener(e -> {
            new MenuAdministrador().setVisible(true);
            this.dispose();
        });
        
        JPanel panel = new JPanel();
        panel.add(btnReporteUsuarios);
        panel.add(btnReporteLibros);
        panel.add(btnReporteMobiliario);
        panel.add(btnRegresar);
        
        getContentPane().add(panel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Reportes().setVisible(true));
    }
}
