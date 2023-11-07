/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

/**
 *
 * @author arman
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Proyecto.*;
import java.util.ArrayList;

public class GuardarArchivo {
    public static void guardarUsuarios(String archivoUsuarios, ArrayList<Usuario> usuarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoUsuarios))) {
            for (Usuario usuario : usuarios) {
                writer.write(usuario.getIdUsuario() + "," + usuario.getNombreUsuario() + "," + usuario.getContraseña() + "," + usuario.getRol());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarProductos(String archivoProductos, ArrayList<Producto> productos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoProductos))) {
            for (Producto producto : productos) {
                writer.write(
                    producto.getIdProducto() + "," +
                    producto.getNombre() + "," +
                    producto.getDescripcion() + "," +
                    producto.getExistencia() + "," +
                    producto.getPrecio()
                );
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
