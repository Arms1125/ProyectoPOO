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

public class EditarProductoWindow extends JPanel {

    private JTextField idField;  // Campo de texto para ingresar el ID del producto a editar.
    private JTextField nuevoValorField;  // Campo de texto para ingresar el nuevo valor del campo.
    private SistemaGestionInventarios sistema;
    private JComboBox<String> rolComboBox;

    /**
     * Constructor para crear un objeto de la clase EditarProductoWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que
     * gestiona la lógica de la aplicación.
     * @param usuario Un objeto de la clase usuario que gestiona el rol del
     * usuario.
     */
    public EditarProductoWindow(SistemaGestionInventarios sistema, Usuario usuario) {
        this.sistema = sistema;
        setLayout(new GridLayout(4, 2));

        JLabel idLabel = new JLabel("ID del Producto a Editar:");
        idField = new JTextField();

        JLabel campoLabel = new JLabel("Campo a Editar");
        String[] roles = {"nombre", "descripcion", "existencia","precio"};
        rolComboBox = new JComboBox<>(roles);

        JLabel nuevoValorLabel = new JLabel("Nuevo Valor:");
        nuevoValorField = new JTextField();

        JButton editarButton = new JButton("Editar Producto");

        JButton regresarButton = new JButton("Regresar al Menú Principal");

        add(idLabel);
        add(idField);
        //panel.add(new JLabel("")); // Espacio en blanco
        add(campoLabel);
        add(rolComboBox);
        //panel.add(new JLabel("")); // Espacio en blanco
        add(nuevoValorLabel);
        add(nuevoValorField);
        //panel.add(new JLabel("")); // Espacio en blanco
        add(editarButton);
        add(regresarButton);

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String campo = (String) rolComboBox.getSelectedItem();
                    String nuevoValor = nuevoValorField.getText();

                    Producto producto = sistema.buscarProductoEnInventario(id);

                    if (producto != null) {
                        sistema.editarProducto(usuario, producto, campo, nuevoValor);
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado en el inventario.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos.");
                }
                idField.setText("");
                nuevoValorField.setText("");
            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Realizar acciones adicionales si es necesario
                // ...
                setVisible(false); // Ocultar el panel actual
            }
        });
    }

}
