package Proyecto;

/**
 * La clase Usuario representa a un usuario en el sistema.
 */
public class Usuario {
    private int idUsuario;         // Identificador único del usuario.
    private String nombreUsuario;  // Nombre de usuario.
    private String contraseña;     // Contraseña del usuario.
    private String rol;            //Rol de usuario
    
    /**
     * Constructor para crear un objeto de la clase Usuario.
     *
     * @param idUsuario      Identificador único del usuario.
     * @param nombreUsuario  Nombre de usuario.
     * @param contraseña     Contraseña del usuario.
     * @param rol            Rol del usuario.
     */
    
    public Usuario(int idUsuario, String nombreUsuario, String contraseña, String rol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }
    
    /**
     * Obtiene el identificador único del usuario.
     *
     * @return El identificador único del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param idUsuario El nuevo identificador único del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param nombreUsuario El nuevo nombre de usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contraseña La nueva contraseña del usuario.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
        /**
     * Obtiene el rol del usuario.
     *
     * @return El rol del usuario.
     */
    public String getRol() {
        return rol;
    }

    /**
     * Establece el rol del usuario.
     *
     * @param rol El nuevo rol del usuario del usuario.
     */
    public void setRol (String rol) {
        this.rol = rol;
    }
    
}

