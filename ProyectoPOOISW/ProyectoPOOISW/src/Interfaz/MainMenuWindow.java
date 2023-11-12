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
                mainPanel.add(agregarProductoWindow.getPanel(), "AgregarProducto");
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "AgregarProducto");
            }
        });

        buscarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarProductoWindow buscarProductoWindow = new BuscarProductoWindow(sistema);
                mainPanel.add(buscarProductoWindow.getPanel(), "BuscarProducto");
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "BuscarProducto");
            }
        });

        editarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarProductoWindow editarProductoWindow = new EditarProductoWindow(sistema, usuario);
                mainPanel.add(editarProductoWindow.getPanel(), "EditarProducto");
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "EditarProducto");
            }
        });

        eliminarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarProductoWindow eliminarProductoWindow = new EliminarProductoWindow(sistema, usuario);
                mainPanel.add(eliminarProductoWindow.getPanel(), "EliminarProducto");
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
                mainPanel.add(crearUsuarioWindow.getPanel(), "CrearUsuario");
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

    /**
     * Constructor para crear un objeto de la clase MainMenuWindow.
     *
     * @param sistema Un objeto de la clase SistemaGestionInventarios que
     * gestiona la lógica de la aplicación.
     * @param usuario Un objeto de la clase usuario que gestiona el rol del
     * usuario.
     */
    /*public MainMenuWindow(SistemaGestionInventarios sistema, Usuario usuario) {
        frame = new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Crear la barra de herramientas
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBounds(0, 0, 800, 50);

        // Crear los botones de la barra de herramientas
        JButton agregarProductoButton = new JButton("Agregar Producto");
        JButton buscarProductoButton = new JButton("Buscar Producto");
        JButton editarProductoButton = new JButton("Editar Producto");
        JButton eliminarProductoButton = new JButton("Eliminar Producto");
        JButton listarProductosButton = new JButton("Listar Productos");
        JButton crearUsuarioButton = new JButton("Crear Usuario");
        JButton cerrarSesionButton = new JButton("Cerrar Sesion");

        // Agregar botones a la barra de herramientas
        toolBar.add(agregarProductoButton);
        toolBar.add(buscarProductoButton);
        toolBar.add(editarProductoButton);
        toolBar.add(eliminarProductoButton);
        toolBar.add(listarProductosButton);

        // Crear los dos paneles
        panel1 = new JPanel();
        panel1.setSize(700, 500);
        panel2 = new JPanel();
        panel2.setSize(100, 500);

        // Agregar Botones al JPanel2
        panel2.add(crearUsuarioButton);
        panel2.add(cerrarSesionButton);

        // Agregar la barra de herramientas y los paneles al marco
        frame.add(toolBar, BorderLayout.NORTH);
        frame.add(panel2);
        frame.add(panel1);

        // Acciones de los botones de la barra de herramientas
        agregarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarProductoWindow agregarProductoWindow = new AgregarProductoWindow(sistema, usuario);
                // Mostrar el panel en el que deseas agregar la ventana
                panel1.removeAll();
                panel1.add(agregarProductoWindow);
                frame.revalidate();
            }
        });

        buscarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarProductoWindow buscarProductoWindow = new BuscarProductoWindow(sistema);
                // Mostrar el panel en el que deseas agregar la ventana
                panel1.removeAll();
                panel1.add(buscarProductoWindow);
                frame.revalidate();
            }
        });

        editarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarProductoWindow editarProductoWindow = new EditarProductoWindow(sistema, usuario);
                frame.dispose(); // Cierra la ventana menu
            }
        });

        eliminarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarProductoWindow eliminarProductoWindow = new EliminarProductoWindow(sistema, usuario);
                frame.dispose(); // Cierra la ventana menu
            }
        });

        listarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Producto> productosEnInventario = sistema.listarProductosEnInventario();
                new ResultadosWindow(productosEnInventario, sistema, usuario);
                frame.dispose(); // Cierra la ventana menu
            }
        });

        crearUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario != null && (usuario.getRol().equals("Administrador") || usuario.getRol().equals("Gestor de Usuarios"))) {
                    new CrearUsuarioWindow(sistema);
                    frame.dispose(); // Cierra la ventana menu
                } else {
                    JOptionPane.showMessageDialog(frame, "No tiene permisos para crear usuarios.");
                }
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
    }*/
}
