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

public class EliminarProductoWindow {

    private JPanel panel;  // Panel principal que contendrá los componentes.
    private JTextField idField;  // Campo de texto para ingresar el ID del producto a eliminar.
    private SistemaGestionInventarios sistema;

    /**
     * Constructor para crear un objeto de la clase EliminarProductoWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que gestiona la lógica de la aplicación.
     * @param usuario Un objeto de la clase usuario que gestiona el rol del usuario.
     */
    public EliminarProductoWindow(SistemaGestionInventarios sistema, Usuario usuario) {
        this.sistema = sistema;
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel idLabel = new JLabel("ID del Producto a Eliminar:");
        idField = new JTextField();

        JButton eliminarButton = new JButton("Eliminar Producto");

        JButton regresarButton = new JButton("Regresar al Menú Principal");

        panel.add(idLabel);
        panel.add(idField);
        panel.add(new JLabel("")); // Espacio en blanco
        panel.add(eliminarButton);
        panel.add(new JLabel("")); // Espacio en blanco
        panel.add(regresarButton);

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    Producto productoAEliminar = sistema.buscarProductoEnInventario(id);

                    if (productoAEliminar != null) {
                        // Realiza la eliminación del producto en el inventario
                        sistema.eliminarProducto(usuario, productoAEliminar);
                    } else {
                        JOptionPane.showMessageDialog(panel, "Producto no encontrado en el inventario.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Por favor, ingrese un ID válido.");
                }
                idField.setText("");
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
