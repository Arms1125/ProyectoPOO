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

public class BuscarProductoWindow extends JPanel {

    private JTextField idField;

    /**
     * Constructor para crear un objeto de la clase BuscarProductoWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que
     * gestiona la lógica de la aplicación.
     */
    public BuscarProductoWindow(SistemaGestionInventarios sistema) {
        setLayout(new GridLayout(2, 2));

        JLabel idLabel = new JLabel("ID del Producto:");
        idField = new JTextField();

        JButton buscarButton = new JButton("Buscar Producto");

        JButton regresarButton = new JButton("Regresar al Menú Principal");

        add(idLabel);
        add(idField);
        //panel.add(new JLabel("")); 
        add(buscarButton);
        add(regresarButton);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    Producto productoBuscado = sistema.buscarProductoEnInventario(id);

                    if (productoBuscado != null) {
                        JOptionPane.showMessageDialog(null, "Producto encontrado:\n" + productoBuscado.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado en el inventario.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.");
                }
                idField.setText("");
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
