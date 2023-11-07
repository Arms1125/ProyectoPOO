/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

/**
 *
 * @author arman
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Proyecto.*;

public class CrearUsuarioWindow {
    private JFrame frame;
    private JTextField idField;
    private JTextField nombreField;
    private JPasswordField contraseñaField;
    private JComboBox<String> rolComboBox;
    private SistemaGestionInventarios sistema;

    public CrearUsuarioWindow(SistemaGestionInventarios sistema) {
        this.sistema = sistema;

        frame = new JFrame("Crear Nuevo Usuario");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID de Usuario:");
        idField = new JTextField();
        JLabel nombreLabel = new JLabel("Nombre de Usuario:");
        nombreField = new JTextField();
        JLabel contraseñaLabel = new JLabel("Contraseña:");
        contraseñaField = new JPasswordField();
        JLabel rolLabel = new JLabel("Rol:");
        String[] roles = {"Administrador", "Gestor de Inventario", "Usuario Regular"};
        rolComboBox = new JComboBox<>(roles);

        JButton crearUsuarioButton = new JButton("Crear Usuario");
        
        JButton regresarButton = new JButton("Regresar al Menú Principal");

        frame.add(idLabel);
        frame.add(idField);
        frame.add(new JLabel(""));
        frame.add(nombreLabel);
        frame.add(nombreField);
        frame.add(new JLabel(""));
        frame.add(contraseñaLabel);
        frame.add(contraseñaField);
        frame.add(new JLabel(""));
        frame.add(rolLabel);
        frame.add(rolComboBox);
        frame.add(new JLabel("")); // Espacio en blanco
        frame.add(crearUsuarioButton);
        frame.add(regresarButton);

        crearUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String nombre = nombreField.getText();
                char[] contraseñaChars = contraseñaField.getPassword();
                String contraseña = new String(contraseñaChars);
                String rol = (String) rolComboBox.getSelectedItem();

                Usuario usuarioLogueado = sistema.usuarioLogueado;

                if (usuarioLogueado != null && usuarioLogueado.getRol().equals("Administrador")) {
                    Usuario nuevoUsuario = new Usuario(id, nombre, contraseña, rol);
                    sistema.agregarUsuario(nuevoUsuario);
                    JOptionPane.showMessageDialog(frame, "Usuario creado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(frame, "No tiene permisos para crear usuarios.");
                }
            }
        });
        
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana de diálogo actual
                new MainMenuWindow(sistema, sistema.usuarioLogueado); // Abre el menú principal
            }
        });
        frame.setVisible(true);
    }
}