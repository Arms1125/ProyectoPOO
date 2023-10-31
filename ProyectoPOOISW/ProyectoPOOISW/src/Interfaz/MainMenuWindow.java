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
import java.util.ArrayList;
import Proyecto.*;

/**
 * La clase MainMenuWindow representa la ventana del menú principal de la aplicación.
 */
public class MainMenuWindow {
    private JFrame frame;  // Marco de la ventana.

    /**
     * Constructor para crear un objeto de la clase MainMenuWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que gestiona la lógica de la aplicación.
     */
    public MainMenuWindow(SistemaGestionInventarios sistema) {
        frame = new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(6, 1));

        // Botones del menú principal
        JButton agregarProductoButton = new JButton("Agregar Producto al Inventario");
        JButton buscarProductoButton = new JButton("Buscar Producto en el Inventario");
        JButton editarProductoButton = new JButton("Editar Producto en el Inventario");
        JButton eliminarProductoButton = new JButton("Eliminar Producto del Inventario");
        JButton listarProductosButton = new JButton("Listar Productos en el Inventario");
        JButton cerrarSesionButton = new JButton("Cerrar Sesión");

        // Agregar botones al marco
        frame.add(agregarProductoButton);
        frame.add(buscarProductoButton);
        frame.add(editarProductoButton);
        frame.add(eliminarProductoButton);
        frame.add(listarProductosButton);
        frame.add(cerrarSesionButton);

        // Acciones de los botones
        agregarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarProductoWindow agregarProductoWindow = new AgregarProductoWindow(sistema);
            }
        });

        buscarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarProductoWindow buscarProductoWindow = new BuscarProductoWindow(sistema);
            }
        });

        editarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarProductoWindow editarProductoWindow = new EditarProductoWindow(sistema);
            }
        });

        eliminarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarProductoWindow eliminarProductoWindow = new EliminarProductoWindow(sistema);
            }
        });

        listarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Producto> productosEnInventario = sistema.listarProductosEnInventario();
                new ResultadosWindow(productosEnInventario);
            }
        });

        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistema.cerrarSesion();
                frame.dispose();  // Cierra la ventana actual
                new LoginWindow(sistema);  // Abre la ventana de inicio de sesión
            }
        });

        frame.setVisible(true);
    }
}
