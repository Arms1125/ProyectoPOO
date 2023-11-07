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
 * La clase EditarProductoWindow representa una ventana de diálogo para editar
 * un producto del inventario.
 */
public class EditarProductoWindow {

    private JDialog dialog;  // Ventana de diálogo.
    private JTextField idField;  // Campo de texto para ingresar el ID del producto a editar.
    private JTextField campoField;  // Campo de texto para ingresar el campo a editar (nombre, descripción, existencia o precio).
    private JTextField nuevoValorField;  // Campo de texto para ingresar el nuevo valor del campo.

    /**
     * Constructor para crear un objeto de la clase EditarProductoWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que
     * gestiona la lógica de la aplicación.
     * @param usuario Un objeto de la clase usuario que gestiona el rol del
     * usuario.
     */
    public EditarProductoWindow(SistemaGestionInventarios sistema, Usuario usuario) {
        dialog = new JDialog();
        dialog.setTitle("Editar Producto");
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(4, 2));

        JLabel idLabel = new JLabel("ID del Producto a Editar:");
        idField = new JTextField();

        JLabel campoLabel = new JLabel("Campo a Editar (nombre, descripcion, existencia o precio):");
        campoField = new JTextField();

        JLabel nuevoValorLabel = new JLabel("Nuevo Valor:");
        nuevoValorField = new JTextField();

        JButton editarButton = new JButton("Editar Producto");

        JButton regresarButton = new JButton("Regresar al Menú Principal");

        dialog.add(idLabel);
        dialog.add(idField);
        dialog.add(new JLabel("")); // Espacio en blanco
        dialog.add(campoLabel);
        dialog.add(campoField);
        dialog.add(new JLabel("")); // Espacio en blanco
        dialog.add(nuevoValorLabel);
        dialog.add(nuevoValorField);
        dialog.add(new JLabel("")); // Espacio en blanco
        dialog.add(editarButton);
        dialog.add(regresarButton);

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
                        JOptionPane.showMessageDialog(dialog, "Producto no encontrado en el inventario.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Por favor, ingrese valores válidos.");
                }
                idField.setText("");
                campoField.setText("");
                nuevoValorField.setText("");
            }
            
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Cierra la ventana de diálogo actual
                new MainMenuWindow(sistema, usuario); // Abre el menú principal
            }
        });

        dialog.setVisible(true);
    }
}
