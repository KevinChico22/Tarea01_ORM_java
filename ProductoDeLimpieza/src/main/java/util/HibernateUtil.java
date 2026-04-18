package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import modelo.Producto;

public class HibernateUtil {

    private static final SessionFactory factory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Producto.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("Error: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}