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

public class BuscarProductoWindow {

    private JPanel panel;
    private JTextField idField;

    /**
     * Constructor para crear un objeto de la clase BuscarProductoWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que
     * gestiona la lógica de la aplicación.
     */
    public BuscarProductoWindow(SistemaGestionInventarios sistema) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel idLabel = new JLabel("ID del Producto:");
        idField = new JTextField();

        JButton buscarButton = new JButton("Buscar Producto");

        JButton regresarButton = new JButton("Regresar al Menú Principal");

        panel.add(idLabel);
        panel.add(idField);
        //panel.add(new JLabel("")); 
        panel.add(buscarButton);
        panel.add(regresarButton);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    Producto productoBuscado = sistema.buscarProductoEnInventario(id);

                    if (productoBuscado != null) {
                        JOptionPane.showMessageDialog(panel, "Producto encontrado:\n" + productoBuscado.toString());
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

    public JPanel getPanel() {
        return panel;
    }
    
    public JFrame getFrame() {
        JFrame frame = new JFrame("Buscar Producto");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        return frame;
    }
}
