package dao;

import modelo.Producto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

public class ProductoDAO {

    private SessionFactory factory = HibernateUtil.getSessionFactory();

    // GUARDAR
    public void guardar(Producto p) {
        Session s = factory.getCurrentSession();
        s.beginTransaction();
        s.save(p);
        s.getTransaction().commit();
    }

    // lISTA
    public List<Producto> listar() {
        Session s = factory.getCurrentSession();
        s.beginTransaction();
        List<Producto> lista = s.createQuery("from Producto", Producto.class).getResultList();
        s.getTransaction().commit();
        return lista;
    }

    // ACTUALIZAR
    public void actualizar(Producto p) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.update(p);

        session.getTransaction().commit();
    }

    // ELIMINAR
    public void eliminar(int id) {
        Session s = factory.getCurrentSession();
        s.beginTransaction();
        Producto p = s.get(Producto.class, id);
        if (p != null) {
            s.delete(p);
        }
        s.getTransaction().commit();
    }
    
    //BUSCAR ID
    public Producto buscarPorId(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Producto p = session.get(Producto.class, id);

        session.getTransaction().commit();
        return p;
    }
}