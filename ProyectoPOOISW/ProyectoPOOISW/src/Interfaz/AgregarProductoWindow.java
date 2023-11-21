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

public class AgregarProductoWindow extends JPanel {

    private JTextField idField;  
    private JTextField nombreField;
    private JTextField descripcionField;
    private JTextField existenciaField;
    private JTextField precioField;

    /**
     * Constructor para crear un objeto de la clase AgregarProductoWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que gestiona la lógica de la aplicación.
     * @param usuario Un objeto de la clase usuario que gestiona el rol del usuario.
     */
    public AgregarProductoWindow(SistemaGestionInventarios sistema, Usuario usuario) {
        setLayout(new GridLayout(7, 2));

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

        add(idLabel);
        add(idField);
        //panel.add(new JLabel("")); 
        add(nombreLabel);
        add(nombreField);
        //panel.add(new JLabel("")); 
        add(descripcionLabel);
        add(descripcionField);
        //panel.add(new JLabel("")); 
        add(existenciaLabel);
        add(existenciaField);
        //panel.add(new JLabel("")); 
        add(precioLabel);
        add(precioField);
        //panel.add(new JLabel("")); 
        add(agregarButton);
        add(regresarButton);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String nombre = nombreField.getText();
                    String descripcion = descripcionField.getText();
                    int existencia = Integer.parseInt(existenciaField.getText());
                    double precio = Double.parseDouble(precioField.getText());

                    Producto nuevoProducto = new Producto(id, nombre, descripcion, existencia, precio);
                    sistema.agregarProductoAlInventario(usuario, nuevoProducto);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos.");
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
                // Realizar acciones adicionales si es necesario
                // ...
                setVisible(false); // Ocultar el panel actual
            }
        });
    }

}
