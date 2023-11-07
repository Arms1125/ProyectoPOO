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

/**
 * La clase BuscarProductoWindow representa una ventana de búsqueda de producto
 * en el inventario.
 */
public class BuscarProductoWindow {

    private JDialog dialog;  // Ventana de diálogo.
    private JTextField idField;  // Campo de texto para ingresar el ID del producto a buscar.

    /**
     * Constructor para crear un objeto de la clase BuscarProductoWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que
     * gestiona la lógica de la aplicación.
     */
    public BuscarProductoWindow(SistemaGestionInventarios sistema) {
        dialog = new JDialog();
        dialog.setTitle("Buscar Producto");
        dialog.setSize(300, 100);
        dialog.setLayout(new GridLayout(2, 2));

        JLabel idLabel = new JLabel("ID del Producto:");
        idField = new JTextField();

        JButton buscarButton = new JButton("Buscar Producto");

        JButton regresarButton = new JButton("Regresar al Menú Principal");

        dialog.add(idLabel);
        dialog.add(idField);
        dialog.add(new JLabel("")); // Espacio en blanco
        dialog.add(buscarButton);
        dialog.add(new JLabel("")); // Espacio en blanco
        dialog.add(regresarButton);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    Producto productoBuscado = sistema.buscarProductoEnInventario(id);

                    if (productoBuscado != null) {
                        // Mostrar los detalles del producto encontrado
                        JOptionPane.showMessageDialog(dialog, "Producto encontrado:\n" + productoBuscado.toString());
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Producto no encontrado en el inventario.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Por favor, ingrese un ID válido.");
                }
                idField.setText("");
            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Cierra la ventana de diálogo actual
                new MainMenuWindow(sistema, sistema.usuarioLogueado); // Abre el menú principal
            }
        });
        dialog.setVisible(true);
    }
}
