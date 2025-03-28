package com.example.demo.formularios;

import com.example.demo.capapersistencia.UsuarioRepository;
import com.example.demo.capanegocio.modelo.Usuario;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GestorPermisos extends JFrame {

    private final UsuarioRepository usuarioRepository;
    
    private JList<Usuario> listaUsuarios;
    private JCheckBox chkSolicitudLibros;
    private JButton btnGuardar;
    private JButton btnRegresar;
    
    @Autowired
    public GestorPermisos(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        initComponents();
        cargarUsuarios();
    }

    GestorPermisos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void initComponents() {
        setTitle("Gestor de Permisos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());
        
        // Lista de usuarios
        listaUsuarios = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaUsuarios);
        add(scrollPane, BorderLayout.CENTER);
        
        // Panel inferior con la casilla de verificación y botones
        JPanel panelInferior = new JPanel(new FlowLayout());
        chkSolicitudLibros = new JCheckBox("Permiso de solicitud de libros");
        panelInferior.add(chkSolicitudLibros);
        
        btnGuardar = new JButton("Guardar");
        panelInferior.add(btnGuardar);
        
        btnRegresar = new JButton("Regresar");
        panelInferior.add(btnRegresar);
        
        add(panelInferior, BorderLayout.SOUTH);
        
        // Al seleccionar un usuario en la lista, se actualiza el estado del checkbox
        listaUsuarios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Usuario seleccionado = listaUsuarios.getSelectedValue();
                    if (seleccionado != null) {
                        // Se asume que el método getPermisoSolicitudLibros() devuelve un entero (0 o 1)
                        chkSolicitudLibros.setSelected(seleccionado.getPermisoSolicitudLibros() == 1);
                    }
                }
            }
        });
        
        // Acción para guardar el permiso modificado
        btnGuardar.addActionListener(e -> guardarPermiso());
        
        // Acción para regresar (cerrar la ventana actual)
        btnRegresar.addActionListener(e -> dispose());
    }
    
    private void cargarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        DefaultListModel<Usuario> modelo = new DefaultListModel<>();
        for (Usuario u : usuarios) {
            modelo.addElement(u);
        }
        listaUsuarios.setModel(modelo);
    }
    
    private void guardarPermiso() {
        Usuario seleccionado = listaUsuarios.getSelectedValue();
        if (seleccionado != null) {
            // Actualiza el atributo de permiso basado en el estado del checkbox
            seleccionado.setPermisoSolicitudLibros(chkSolicitudLibros.isSelected() ? 1 : 0);
            usuarioRepository.save(seleccionado);
            JOptionPane.showMessageDialog(this, "Permiso actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario.");
        }
    }
}

