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
 * La clase ResultadosPanel representa un panel que muestra los resultados en una tabla.
 */
public class ResultadosWindow {
    private JPanel panel;  // Panel principal.
    private SistemaGestionInventarios sistema;
    private Usuario usuario;

    /**
     * Constructor para crear un objeto de la clase ResultadosPanel.
     *
     * @param productos Una lista de objetos Producto que se mostrarán en la tabla.
     * @param sistema   Un objeto de la clase SistemaGestionInventarios que gestiona la lógica de la aplicación.
     * @param usuario   Un objeto de la clase usuario que gestiona el rol del usuario.
     */
    public ResultadosWindow(ArrayList<Producto> productos, SistemaGestionInventarios sistema, Usuario usuario) {
        this.sistema = sistema;
        this.usuario = usuario;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

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

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(volverButton, BorderLayout.SOUTH);

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ocultar el panel de resultados y mostrar el menú principal
                panel.setVisible(false);            }
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
