package app;

import dao.ProductoDAO;
import dao.clienteDAO;
import modelo.Producto;
import modelo.Cliente;

import java.util.List;
import java.util.Scanner;

import modelo.Marca;
import dao.MarcaDAO;

public class MainApp {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();
        MarcaDAO marcaDAO = new MarcaDAO();
        
        ///marca 
        Marca m = new Marca("Fabuloso");
        System.out.println("Marca creada en memoria (TRANSIENT)");
        
    ///Marca-persistent
        marcaDAO.guardar(m);
        System.out.println("Marca guardada en BD (PERSISTENT)");
        System.out.println("ID generado: " + m.getId());
        
        /// DETACHED recuperar desde BD
        Marca m2 = marcaDAO.buscarPorId(m.getId());

        System.out.println("Marca en estado DETACHED:");
        System.out.println(m2.getNombre());
        
        
        
        ///modificacion
        m2.setNombre("Fabuloso Premium");
        marcaDAO.actualizar(m2);
        
        System.out.println("    JPQL ");

     // LISTAR
     System.out.println("LISTA DE MARCAS:");
     for (Marca marca : marcaDAO.listar()) {
         System.out.println(marca.getId() + " - " + marca.getNombre());
     }

     // BUSCAR POR NOMBRE
     System.out.println("\nBUSCAR MARCA Fabuloso:");
     for (Marca marca : marcaDAO.buscarPorNombre("Fabuloso")) {
         System.out.println(marca.getNombre());
     }

     // CONTAR
     System.out.println("\nTOTAL DE MARCAS: " + marcaDAO.contarMarcas());

        System.out.println("Marca actualizada desde DETACHED");
        
       //CREAR 5 PRODUCTOS 
        dao.guardar(new Producto("Detergente", 3.5));
        dao.guardar(new Producto("Cloro", 2.0));
        dao.guardar(new Producto("Jabón", 1.5));
        dao.guardar(new Producto("Desinfectante", 4.0));
        dao.guardar(new Producto("Suavizante", 5.0));

        System.out.println(" -Productos creados");

    //lISTA
        System.out.println("     LISTA DE PRODUCTOS:     ");
        for (Producto p : dao.listar()) {
            System.out.println(p.getId() + " - " + p.getNombre() + " $" + p.getPrecio());
        }

        //BUSCAR POR ID
        Producto p = dao.buscarPorId(1);
        p.setPrecio(4.0);
        dao.actualizar(p);

        System.out.println(" -Producto actualizado- ");

        //ELIMINAR
        dao.eliminar(2);

        System.out.println(" :::Producto eliminado:::");

    
        System.out.println(" :) LISTA FINAL:");
        for (Producto prod : dao.listar()) {
            System.out.println(prod.getId() + " - " + prod.getNombre() + " $" + prod.getPrecio());
        }
        
        
    }
}