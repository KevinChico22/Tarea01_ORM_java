package app;

import dao.ProductoDAO;
import dao.clienteDAO;
import modelo.Producto;
import modelo.Cliente;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();

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