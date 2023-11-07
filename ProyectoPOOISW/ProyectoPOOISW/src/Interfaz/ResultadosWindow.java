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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Proyecto.*;
import java.awt.event.*;


/**
 * La clase ResultadosWindow representa una ventana que muestra los resultados en una tabla.
 */
public class ResultadosWindow {
    private JFrame frame;  // Marco de la ventana.

    /**
     * Constructor para crear un objeto de la clase ResultadosWindow.
     *
     * @param productos Una lista de objetos Producto que se mostrarán en la tabla.
     */
    public ResultadosWindow(ArrayList<Producto> productos,SistemaGestionInventarios sistema,Usuario usuario) {
        frame = new JFrame("Resultados");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear un DefaultTableModel con las columnas deseadas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Existencia");
        model.addColumn("Precio");

        // Llenar la tabla con los productos
        for (Producto producto : productos) {
            model.addRow(new Object[]{
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getExistencia(),
                producto.getPrecio()
            });
        }

        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        
        JButton volverButton = new JButton("Volver al Menú Principal");

        frame.add(scrollPane);
        frame.add(volverButton);
        frame.setLayout(new FlowLayout());

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana de resultados
                new MainMenuWindow(sistema,usuario); // Abre la ventana del menú principal
            }
        });
        
        frame.pack();
        frame.setVisible(true);
    }
}