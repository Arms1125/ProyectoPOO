/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

/**
 *
 * @author arman
 */
import Proyecto.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CargarArchivo {
    public static ArrayList<Usuario> cargarUsuarios(String archivoUsuarios) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoUsuarios))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] usuarioData = line.split(",");
                if (usuarioData.length == 4) {
                    int idUsuario = Integer.parseInt(usuarioData[0]);
                    String nombreUsuario = usuarioData[1];
                    String contraseña = usuarioData[2];
                    String rol = usuarioData[3];
                    Usuario usuario = new Usuario(idUsuario, nombreUsuario, contraseña, rol);
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public static ArrayList<Producto> cargarProductos(String archivoProductos) {
        ArrayList<Producto> productos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoProductos))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productoData = line.split(",");
                if (productoData.length == 5) {
                    int idProducto = Integer.parseInt(productoData[0]);
                    String nombre = productoData[1];
                    String descripcion = productoData[2];
                    int existencia = Integer.parseInt(productoData[3]);
                    double precio = Double.parseDouble(productoData[4]);
                    Producto producto = new Producto(idProducto, nombre, descripcion, existencia, precio);
                    productos.add(producto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
