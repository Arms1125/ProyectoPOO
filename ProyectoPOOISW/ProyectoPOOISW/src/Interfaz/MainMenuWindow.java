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
 * La clase MainMenuWindow representa la ventana del menú principal de la
 * aplicación.
 */
public class MainMenuWindow {

    private JFrame frame;  // Marco de la ventana.
    private JToolBar toolBar;  // Barra de herramientas.
    private JPanel mainPanel, usuarioPanel;  // Primer panel.

    public MainMenuWindow(SistemaGestionInventarios sistema, Usuario usuario) {
        frame = new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 600); // Tamaño ajustable
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Barra de herramientas
        toolBar = new JToolBar();
        JButton agregarProductoButton = new JButton("Agregar Producto");
        JButton buscarProductoButton = new JButton("Buscar Producto");
        JButton editarProductoButton = new JButton("Editar Producto");
        JButton eliminarProductoButton = new JButton("Eliminar Producto");
        JButton listarProductosButton = new JButton("Listar Productos");
        JButton crearUsuarioButton = new JButton("Crear Usuario");
        JButton cerrarSesionButton = new JButton("Cerrar Sesión");

        toolBar.add(agregarProductoButton);
        toolBar.add(buscarProductoButton);
        toolBar.add(editarProductoButton);
        toolBar.add(eliminarProductoButton);
        toolBar.add(listarProductosButton);

        // Panel principal
        usuarioPanel = new JPanel();
        usuarioPanel.setLayout(new BoxLayout(usuarioPanel, BoxLayout.Y_AXIS));
        usuarioPanel.setSize(300, 600);
        mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());

        //imagen usuarioPanel
        ImageIcon icon = new ImageIcon("src/img/usuario.png");
        JLabel imagen = new JLabel(icon);

        //añadir objetos al usuarioPanel
        usuarioPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        usuarioPanel.add(imagen);
        usuarioPanel.add(Box.createRigidArea(new Dimension(0, 130)));
        usuarioPanel.add(crearUsuarioButton);
        usuarioPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        usuarioPanel.add(cerrarSesionButton);

        //añadir toolbar y paneles
        frame.add(toolBar, BorderLayout.NORTH);
        frame.add(usuarioPanel, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Acciones de los botones
        agregarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarProductoWindow agregarProductoWindow = new AgregarProductoWindow(sistema, usuario);
                mainPanel.add(agregarProductoWindow, "AgregarProducto");
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "AgregarProducto");
            }
        });

        buscarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarProductoWindow buscarProductoWindow = new BuscarProductoWindow(sistema);
                mainPanel.add(buscarProductoWindow, "BuscarProducto");
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "BuscarProducto");
            }
        });

        editarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarProductoWindow editarProductoWindow = new EditarProductoWindow(sistema, usuario);
                mainPanel.add(editarProductoWindow, "EditarProducto");
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "EditarProducto");
            }
        });

        eliminarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarProductoWindow eliminarProductoWindow = new EliminarProductoWindow(sistema, usuario);
                mainPanel.add(eliminarProductoWindow, "EliminarProducto");
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "EliminarProducto");
            }
        });

        listarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Producto> productosEnInventario = sistema.listarProductosEnInventario();

                ResultadosWindow resultadosWindow = new ResultadosWindow(productosEnInventario, sistema, usuario);
                mainPanel.add(resultadosWindow.getPanel(), "ListarProducto");
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "ListarProducto");
            }
        });

        crearUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearUsuarioWindow crearUsuarioWindow = new CrearUsuarioWindow(sistema);
                mainPanel.add(crearUsuarioWindow , "CrearUsuario");
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "CrearUsuario");
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
