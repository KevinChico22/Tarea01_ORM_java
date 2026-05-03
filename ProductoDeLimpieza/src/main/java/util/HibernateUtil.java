package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Producto;
import modelo.Marca;
import modelo.Cliente;
import modelo.Empresa;

public class HibernateUtil {

    private static final SessionFactory factory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Producto.class)
                    .addAnnotatedClass(Marca.class) //
                    .addAnnotatedClass(Cliente.class)
                    .addAnnotatedClass(Empresa.class)
                    .buildSessionFactory();
            
        } catch (Throwable ex) {
        	  System.out.println("ERROR AL CREAR SESSION FACTORY");
              throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}