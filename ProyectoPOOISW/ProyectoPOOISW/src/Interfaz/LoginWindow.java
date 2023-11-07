/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

/**
 *
 * @author arman
 */
import Archivos.GuardarArchivo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Proyecto.*;

/**
 * La clase LoginWindow representa la ventana de inicio de sesión de la
 * aplicación.
 */
public class LoginWindow {

    private JFrame frame;  // Marco de la ventana.
    private JTextField usernameField;  // Campo de texto para el nombre de usuario.
    private JPasswordField passwordField;  // Campo de contraseña.

    /**
     * Constructor para crear un objeto de la clase LoginWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que
     * gestiona la lógica de la aplicación.
     */
    public LoginWindow(SistemaGestionInventarios sistema) {
        frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 1));

        JLabel usernameLabel = new JLabel("Nombre de Usuario:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Iniciar Sesión");

        JButton closeButton = new JButton("Cerrar Aplicación");

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(new JLabel(""));
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(new JLabel("")); // Espacio en blanco
        frame.add(loginButton);
        frame.add(closeButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                if (sistema.iniciarSesion(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso.");
                    frame.dispose(); // Cierra la ventana de inicio de sesión
                    // Continuar con la aplicación principal o mostrar otro menú, etc.
                    new MainMenuWindow(sistema, sistema.usuarioLogueado);
                } else {
                    JOptionPane.showMessageDialog(frame, "Inicio de sesión fallido. Verifica tus credenciales.");
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Guardar usuarios en un archivo
                GuardarArchivo.guardarUsuarios("usuarios.csv", sistema.getUsuarios());

                // Guardar productos en un archivo
                GuardarArchivo.guardarProductos("productos.csv", sistema.getInventario().getProductos());
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
