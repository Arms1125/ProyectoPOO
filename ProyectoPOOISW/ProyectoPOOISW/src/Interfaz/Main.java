/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Interfaz;

/**
 *
 * @author arman
 */
import Proyecto.*;

/**
 * La clase Main contiene el método principal que inicia la aplicación.
 */
public class Main {

    /**
     * El método principal de la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        SistemaGestionInventarios sistema = new SistemaGestionInventarios();

        // Crear usuarios de ejemplo
        Usuario usuario1 = new Usuario(1, "usuario1", "contraseña1");
        Usuario usuario2 = new Usuario(2, "usuario2", "contraseña2");

        // Agregar los usuarios al sistema
        sistema.agregarUsuario(usuario1);
        sistema.agregarUsuario(usuario2);

        // Iniciar la ventana de inicio de sesión
        LoginWindow ini = new LoginWindow(sistema);
    }
}
