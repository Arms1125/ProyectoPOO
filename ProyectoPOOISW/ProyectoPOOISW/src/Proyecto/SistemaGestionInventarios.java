package Proyecto;

import java.util.ArrayList;

/**
 * La clase SistemaGestionInventarios gestiona usuarios y productos en un sistema de inventario.
 */
public class SistemaGestionInventarios {
    private ArrayList<Usuario> usuarios;  // Lista de usuarios registrados en el sistema.
    private Inventario inventario;        // Instancia de la clase Inventario para gestionar productos.
    private Usuario usuarioLogueado;      // Usuario que ha iniciado sesión en el sistema.

    /**
     * Constructor para crear un objeto de la clase SistemaGestionInventarios.
     * Inicializa la lista de usuarios, la instancia de Inventario y establece el usuario logueado como nulo.
     */
    public SistemaGestionInventarios() {
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
     * @param nombreUsuario Nombre de usuario del usuario que intenta iniciar sesión.
     * @param contraseña    Contraseña del usuario que intenta iniciar sesión.
     * @return true si la sesión se inicia con éxito, false si el nombre de usuario o la contraseña son incorrectos.
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
    public void agregarProductoAlInventario(Producto producto) {
        if (usuarioLogueado != null) {
            inventario.agregarProducto(producto);
        }
    }

    /**
     * Busca un producto en el inventario por su ID, si hay un usuario logueado.
     *
     * @param idProducto El ID del producto que se desea buscar.
     * @return El objeto Producto si se encuentra, o null si no se encuentra o no hay sesión iniciada.
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
    public void eliminarProductoDelInventario(Producto producto) {
        if (usuarioLogueado != null) {
            inventario.eliminarProducto(producto);
        }
    }

    /**
     * Lista los productos en el inventario, si hay un usuario logueado.
     *
     * @return Una lista de objetos Producto si hay sesión iniciada, o una lista vacía si no hay sesión.
     */
    public ArrayList<Producto> listarProductosEnInventario() {
        if (usuarioLogueado != null) {
            return inventario.listarProductos();
        }
        return new ArrayList<>(); // Si no hay sesión iniciada o usuario logueado, devuelve una lista vacía.
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
