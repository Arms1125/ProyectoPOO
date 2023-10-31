package Proyecto;


/**
 * La clase Producto representa un artículo en el inventario.
 */

public class Producto {
    private int idProducto;        // Identificador único del producto.
    private String nombre;         // Nombre del producto.
    private String descripcion;    // Descripción del producto.
    private int existencia;        // Cantidad en existencia del producto.
    private double precio;         // Precio del producto.

    /**
     * Constructor para crear un objeto de la clase Producto.
     *
     * @param idProducto    Identificador único del producto.
     * @param nombre        Nombre del producto.
     * @param descripcion   Descripción del producto.
     * @param existencia    Cantidad en existencia del producto.
     * @param precio        Precio del producto.
     */
    public Producto(int idProducto, String nombre, String descripcion, int existencia, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.existencia = existencia;
        this.precio = precio;
    }

    /**
     * Obtiene el identificador único del producto.
     *
     * @return El identificador único del producto.
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el identificador único del producto.
     *
     * @param idProducto El nuevo identificador único del producto.
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return La descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     *
     * @param descripcion La nueva descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la cantidad en existencia del producto.
     *
     * @return La cantidad en existencia del producto.
     */
    public int getExistencia() {
        return existencia;
    }

    /**
     * Establece la cantidad en existencia del producto.
     *
     * @param existencia La nueva cantidad en existencia del producto.
     */
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Actualiza la cantidad en existencia del producto sumando la cantidad especificada.
     *
     * @param cantidad Cantidad a agregar a la existencia del producto.
     */
    public void actualizarExistencia(int cantidad) {
        this.existencia += cantidad;
    }

    /**
     * Devuelve una representación en formato de cadena del producto.
     *
     * @return Una cadena que muestra el ID, nombre, descripción, existencia y precio del producto.
     */
    @Override
    public String toString() {
        return "ID: " + idProducto + ", Nombre: " + nombre + ", Descripción: " + descripcion + ", Existencia: " + existencia + ", Precio: " + precio;
    }
}
