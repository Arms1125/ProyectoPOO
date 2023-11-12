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
import Proyecto.*;

public class CrearUsuarioWindow {

    private JPanel panel; // Panel principal que contendrá los componentes.
    private JTextField idField;
    private JTextField nombreField;
    private JPasswordField contraseñaField;
    private JComboBox<String> rolComboBox;
    private SistemaGestionInventarios sistema;

    /**
     * Constructor para crear un objeto de la clase CrearUsuarioWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que gestiona la lógica de la aplicación.
     */
    public CrearUsuarioWindow(SistemaGestionInventarios sistema) {
        this.sistema = sistema;
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

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

        panel.add(idLabel);
        panel.add(idField);
        //panel.add(new JLabel(""));
        panel.add(nombreLabel);
        panel.add(nombreField);
        //panel.add(new JLabel(""));
        panel.add(contraseñaLabel);
        panel.add(contraseñaField);
        //panel.add(new JLabel(""));
        panel.add(rolLabel);
        panel.add(rolComboBox);
        //panel.add(new JLabel("")); 
        panel.add(crearUsuarioButton);
        panel.add(regresarButton);

        crearUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String nombre = nombreField.getText();
                    char[] contraseñaChars = contraseñaField.getPassword();
                    String contraseña = new String(contraseñaChars);
                    String rol = (String) rolComboBox.getSelectedItem();

                    Usuario usuarioLogueado = sistema.usuarioLogueado;

                    if (usuarioLogueado != null && usuarioLogueado.getRol().equals("Administrador")) {
                        Usuario nuevoUsuario = new Usuario(id, nombre, contraseña, rol);
                        sistema.agregarUsuario(nuevoUsuario);
                    } else {
                        JOptionPane.showMessageDialog(panel, "No tiene permisos para crear usuarios.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Por favor, ingrese un ID válido.");
                }
                idField.setText("");
                nombreField.setText("");
                contraseñaField.setText("");
            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Realizar acciones adicionales si es necesario
                // ...
                panel.setVisible(false); // Ocultar el panel actual
            }
        });
    }

    /**
     * Obtén el panel principal de la ventana.
     *
     * @return El panel principal de la ventana.
     */
    public JPanel getPanel() {
        return panel;
    }
}
