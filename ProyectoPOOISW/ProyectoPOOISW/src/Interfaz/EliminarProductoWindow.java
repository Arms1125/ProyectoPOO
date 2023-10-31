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
 * La clase EliminarProductoWindow representa una ventana de diálogo para eliminar un producto del inventario.
 */
public class EliminarProductoWindow {
    private JDialog dialog;  // Ventana de diálogo.
    private JTextField idField;  // Campo de texto para ingresar el ID del producto a eliminar.

    /**
     * Constructor para crear un objeto de la clase EliminarProductoWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que gestiona la lógica de la aplicación.
     */
    public EliminarProductoWindow(SistemaGestionInventarios sistema) {
        dialog = new JDialog();
        dialog.setTitle("Eliminar Producto");
        dialog.setSize(300, 100);
        dialog.setLayout(new GridLayout(2, 2));

        JLabel idLabel = new JLabel("ID del Producto a Eliminar:");
        idField = new JTextField();

        JButton eliminarButton = new JButton("Eliminar Producto");

        dialog.add(idLabel);
        dialog.add(idField);
        dialog.add(new JLabel("")); // Espacio en blanco
        dialog.add(eliminarButton);

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    Producto productoAEliminar = sistema.buscarProductoEnInventario(id);

                    if (productoAEliminar != null) {
                        // Realiza la eliminación del producto en el inventario
                        sistema.eliminarProductoDelInventario(productoAEliminar);
                        JOptionPane.showMessageDialog(dialog, "Producto eliminado con éxito.");
                        dialog.dispose(); // Cierra la ventana de diálogo
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Producto no encontrado en el inventario.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Por favor, ingrese un ID válido.");
                }
            }
        });

        dialog.setVisible(true);
    }
}
