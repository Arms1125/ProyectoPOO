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
 * La clase AgregarProductoWindow representa una ventana de diálogo para agregar
 * un nuevo producto al inventario.
 */
public class AgregarProductoWindow {

    private JDialog dialog;  // Ventana de diálogo.
    private JTextField idField;  // Campo de texto para ingresar el ID del nuevo producto.
    private JTextField nombreField;  // Campo de texto para ingresar el nombre del nuevo producto.
    private JTextField descripcionField;  // Campo de texto para ingresar la descripción del nuevo producto.
    private JTextField existenciaField;  // Campo de texto para ingresar la existencia del nuevo producto.
    private JTextField precioField;  // Campo de texto para ingresar el precio del nuevo producto.

    /**
     * Constructor para crear un objeto de la clase AgregarProductoWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que
     * gestiona la lógica de la aplicación.
     * @param usuario Un objeto de la clase usuario que gestiona el rol del
     * usuario.
     */
    public AgregarProductoWindow(SistemaGestionInventarios sistema, Usuario usuario) {
        dialog = new JDialog();
        dialog.setTitle("Agregar Producto");
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(6, 2));

        JLabel idLabel = new JLabel("ID del Producto:");
        idField = new JTextField();

        JLabel nombreLabel = new JLabel("Nombre del Producto:");
        nombreField = new JTextField();

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionField = new JTextField();

        JLabel existenciaLabel = new JLabel("Existencia:");
        existenciaField = new JTextField();

        JLabel precioLabel = new JLabel("Precio:");
        precioField = new JTextField();

        JButton agregarButton = new JButton("Agregar Producto");

        JButton regresarButton = new JButton("Regresar al Menú Principal");

        dialog.add(idLabel);
        dialog.add(idField);
        dialog.add(new JLabel("")); // Espacio en blanco
        dialog.add(nombreLabel);
        dialog.add(nombreField);
        dialog.add(new JLabel("")); // Espacio en blanco
        dialog.add(descripcionLabel);
        dialog.add(descripcionField);
        dialog.add(new JLabel("")); // Espacio en blanco
        dialog.add(existenciaLabel);
        dialog.add(existenciaField);
        dialog.add(new JLabel("")); // Espacio en blanco
        dialog.add(precioLabel);
        dialog.add(precioField);
        dialog.add(new JLabel("")); // Espacio en blanco
        dialog.add(agregarButton);
        dialog.add(regresarButton);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String nombre = nombreField.getText();
                    String descripcion = descripcionField.getText();
                    int existencia = Integer.parseInt(existenciaField.getText());
                    double precio = Double.parseDouble(precioField.getText());

                    // Crear un nuevo objeto Producto con los datos ingresados
                    Producto nuevoProducto = new Producto(id, nombre, descripcion, existencia, precio);

                    // Agregar el nuevo producto al inventario
                    sistema.agregarProductoAlInventario(usuario, nuevoProducto);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Por favor, ingrese valores válidos.");
                }
                idField.setText("");
                nombreField.setText("");
                descripcionField.setText("");
                existenciaField.setText("");
                precioField.setText("");
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
