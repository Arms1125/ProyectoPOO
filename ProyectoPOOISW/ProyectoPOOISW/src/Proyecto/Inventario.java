package Proyecto;

import java.util.ArrayList;

/**
 * La clase Inventario gestiona una colección de productos.
 */
public class Inventario {
    private ArrayList<Producto> productos;  // Lista de productos en el inventario.

    /**
     * Constructor para crear un objeto de la clase Inventario.
     * Inicializa la lista de productos como una lista vacía.
     */
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    /**
     * Agrega un producto al inventario.
     *
     * @param producto El objeto Producto que se desea agregar al inventario.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Elimina un producto del inventario.
     *
     * @param producto El objeto Producto que se desea eliminar del inventario.
     */
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    /**
     * Edita un campo específico de un producto en el inventario.
     *
     * @param producto    El objeto Producto que se desea editar.
     * @param campo       El campo a editar (nombre, descripción, existencia o precio).
     * @param nuevoValor  El nuevo valor que se establecerá en el campo.
     */
    public void editarProducto(Producto producto, String campo, String nuevoValor) {
        if (producto != null) {
            switch (campo) {
                case "nombre":
                    producto.setNombre(nuevoValor);
                    break;
                case "descripcion":
                    producto.setDescripcion(nuevoValor);
                    break;
                case "existencia":
                    int nuevaExistencia = Integer.parseInt(nuevoValor);
                    producto.setExistencia(nuevaExistencia);
                    break;
                case "precio":
                    double nuevoPrecio = Double.parseDouble(nuevoValor);
                    producto.setPrecio(nuevoPrecio);
                    break;
                default:
                    System.out.println("Campo no válido.");
            }
        }
    }

    /**
     * Busca un producto en el inventario por su ID.
     *
     * @param idProducto El ID del producto que se desea buscar.
     * @return El objeto Producto si se encuentra, o null si no se encuentra.
     */
    public Producto buscarProducto(int idProducto) {
        for (Producto producto : productos) {
            if (producto.getIdProducto() == idProducto) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Lista todos los productos en el inventario.
     *
     * @return Una lista de objetos Producto en el inventario.
     */
    public ArrayList<Producto> listarProductos() {
        return productos;
    }
}
