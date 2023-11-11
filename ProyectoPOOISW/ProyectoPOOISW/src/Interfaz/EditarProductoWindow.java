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

public class EditarProductoWindow {

    private JPanel panel; // Panel principal que contendrá los componentes.
    private JTextField idField;  // Campo de texto para ingresar el ID del producto a editar.
    private JTextField campoField;  // Campo de texto para ingresar el campo a editar (nombre, descripción, existencia o precio).
    private JTextField nuevoValorField;  // Campo de texto para ingresar el nuevo valor del campo.
    private SistemaGestionInventarios sistema;

    /**
     * Constructor para crear un objeto de la clase EditarProductoWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que gestiona la lógica de la aplicación.
     * @param usuario Un objeto de la clase usuario que gestiona el rol del usuario.
     */
    public EditarProductoWindow(SistemaGestionInventarios sistema, Usuario usuario) {
        this.sistema = sistema;
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel idLabel = new JLabel("ID del Producto a Editar:");
        idField = new JTextField();

        JLabel campoLabel = new JLabel("Campo a Editar (nombre, descripcion, existencia o precio):");
        campoField = new JTextField();

        JLabel nuevoValorLabel = new JLabel("Nuevo Valor:");
        nuevoValorField = new JTextField();

        JButton editarButton = new JButton("Editar Producto");

        JButton regresarButton = new JButton("Regresar al Menú Principal");

        panel.add(idLabel);
        panel.add(idField);
        panel.add(new JLabel("")); // Espacio en blanco
        panel.add(campoLabel);
        panel.add(campoField);
        panel.add(new JLabel("")); // Espacio en blanco
        panel.add(nuevoValorLabel);
        panel.add(nuevoValorField);
        panel.add(new JLabel("")); // Espacio en blanco
        panel.add(editarButton);
        panel.add(regresarButton);

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String campo = campoField.getText();
                    String nuevoValor = nuevoValorField.getText();

                    Producto producto = sistema.buscarProductoEnInventario(id);

                    if (producto != null) {
                        sistema.editarProducto(usuario, producto, campo, nuevoValor);
                    } else {
                        JOptionPane.showMessageDialog(panel, "Producto no encontrado en el inventario.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Por favor, ingrese valores válidos.");
                }
                idField.setText("");
                campoField.setText("");
                nuevoValorField.setText("");
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
