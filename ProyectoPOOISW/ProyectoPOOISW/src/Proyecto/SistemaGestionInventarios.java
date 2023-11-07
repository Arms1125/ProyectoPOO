package Proyecto;

import java.util.ArrayList;
import javax.swing.*;

/**
 * La clase SistemaGestionInventarios gestiona usuarios y productos en un
 * sistema de inventario.
 */
public class SistemaGestionInventarios {

    private JDialog dialog;
    private ArrayList<Usuario> usuarios;  // Lista de usuarios registrados en el sistema.
    private Inventario inventario;        // Instancia de la clase Inventario para gestionar productos.
    public Usuario usuarioLogueado;      // Usuario que ha iniciado sesión en el sistema.

    /**
     * Constructor para crear un objeto de la clase SistemaGestionInventarios.
     * Inicializa la lista de usuarios, la instancia de Inventario y establece
     * el usuario logueado como nulo.
     */
    public SistemaGestionInventarios() {
        dialog = new JDialog();
        this.usuarios = new ArrayList<>();
        this.inventario = new Inventario();
        this.usuarioLogueado = null;
    }

    /**
     * Agrega un usuario al sistema.
     *
     * @param usuario El objeto Usuario que se desea agregar.
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Inicia sesión de un usuario en el sistema.
     *
     * @param nombreUsuario Nombre de usuario del usuario que intenta iniciar
     * sesión.
     * @param contraseña Contraseña del usuario que intenta iniciar sesión.
     * @return true si la sesión se inicia con éxito, false si el nombre de
     * usuario o la contraseña son incorrectos.
     */
    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                usuarioLogueado = usuario;
                return true; // Sesión iniciada con éxito
            }
        }
        return false; // Usuario o contraseña incorrectos
    }

    /**
     * Cierra la sesión del usuario actual.
     */
    public void cerrarSesion() {
        usuarioLogueado = null;
    }

    /**
     * Agrega un producto al inventario, si hay un usuario logueado.
     *
     * @param producto El objeto Producto que se desea agregar al inventario.
     */
    public void agregarProductoAlInventario(Usuario usuario, Producto producto) {
        if (usuario.getRol().equals("Administrador") || usuario.getRol().equals("Gestor de Inventario")) {
            // Permite agregar productos al inventario
            if (inventario.agregarProducto(producto)) {
                JOptionPane.showMessageDialog(dialog, "Producto agregado al inventario con éxito.");
                dialog.dispose(); // Cierra la ventana de diálogo
            } else {
                JOptionPane.showMessageDialog(dialog, "No se pudo agregar el producto. La ID ya está en uso.");
            }
        } else {
            JOptionPane.showMessageDialog(dialog, "No tiene permiso para realizar esta accion");// No tiene permisos para agregar productos 
            dialog.dispose(); // Cierra la ventana de diálogo
        }
    }

    /**
     * Busca un producto en el inventario por su ID, si hay un usuario logueado.
     *
     * @param idProducto El ID del producto que se desea buscar.
     * @return El objeto Producto si se encuentra, o null si no se encuentra o
     * no hay sesión iniciada.
     */
    public Producto buscarProductoEnInventario(int idProducto) {
        if (usuarioLogueado != null) {
            return inventario.buscarProducto(idProducto);
        }
        return null;
    }

    /**
     * Elimina un producto del inventario, si hay un usuario logueado.
     *
     * @param producto El objeto Producto que se desea eliminar del inventario.
     */
    public void eliminarProducto(Usuario usuario, Producto producto) {
        if (usuario != null && (usuario.getRol().equals("Administrador") || usuario.getRol().equals("Gestor de Inventario"))) {
            inventario.eliminarProducto(producto);
            JOptionPane.showMessageDialog(dialog, "Producto eliminado con éxito.");
            dialog.dispose(); // Cierra la ventana de diálogo
        } else {
            JOptionPane.showMessageDialog(dialog, "No tiene permiso para realizar esta accion");// El usuario no tiene permisos para eliminar productos
            dialog.dispose(); // Cierra la ventana de diálogo
        }
    }

    /**
     * Lista los productos en el inventario, si hay un usuario logueado.
     *
     * @return Una lista de objetos Producto si hay sesión iniciada, o una lista
     * vacía si no hay sesión.
     */
    public ArrayList<Producto> listarProductosEnInventario() {
        if (usuarioLogueado != null) {
            return inventario.listarProductos();
        }
        return new ArrayList<>(); // Si no hay sesión iniciada o usuario logueado, devuelve una lista vacía.
    }

    /**
     * Edita un producto del inventario, si hay un usuario logueado.
     *
     * @param producto El objeto Producto que se desea editar del inventario.
     */
    public void editarProducto(Usuario usuario, Producto producto, String campo, String nuevoValor) {
        if (usuario != null && (usuario.getRol().equals("Administrador") || usuario.getRol().equals("Gestor de Inventario"))) {
            inventario.editarProducto(producto, campo, nuevoValor);
            JOptionPane.showMessageDialog(dialog, "Producto editado con éxito.");
            dialog.dispose();
        } else {
            JOptionPane.showMessageDialog(dialog, "No tiene permiso para realizar esta accion");// El usuario no tiene permisos para editar productos
            dialog.dispose(); // Cierra la ventana de diálogo
        }
    }

    /**
     * Establece la lista de usuarios en el sistema.
     *
     * @param usuarios La nueva lista de usuarios.
     */
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Obtiene la instancia de Inventario asociada al sistema.
     *
     * @return La instancia de Inventario.
     */
    public Inventario getInventario() {
        return inventario;
    }
}
