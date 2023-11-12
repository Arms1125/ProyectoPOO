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
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.BorderFactory;
import Proyecto.*;
import Archivos.*;

public class LoginWindow {

    private JFrame frame;  // Marco de la ventana.
    private JTextField usernameField;  // Campo de texto para el nombre de usuario.
    private JPasswordField passwordField;  // Campo de contraseña.
    private JPanel panel;  // Panel en el centro con labels, fields y botones.

    /**
     * Constructor para crear un objeto de la clase LoginWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que
     * gestiona la lógica de la aplicación.
     */
    public LoginWindow(SistemaGestionInventarios sistema) {
        frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Fondo de la ventana con una imagen
        ImageIcon background = new ImageIcon("src/img/fondo.png");
        Image img = background.getImage();
        Image tempImg = img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        background = new ImageIcon(tempImg);
        JLabel backgroundLabel = new JLabel(background);
        frame.setContentPane(backgroundLabel);

        // Panel en el centro con labels, fields y botones
        panel = new JPanel();
        panel.setSize(300, 170);
        panel.setLocation(40, 25);
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Nombre de Usuario:");
        usernameField = new JTextField();
        usernameField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JButton loginButton = new JButton("Iniciar Sesión");
        JButton closeButton = new JButton("Cerrar Aplicación");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(closeButton);
        frame.add(panel);
        
        // Acciones de los botones
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
