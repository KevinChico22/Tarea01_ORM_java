package dao;

import modelo.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class clienteDAO {

    private SessionFactory factory = HibernateUtil.getSessionFactory();

    public void guardar(Cliente cliente) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
    }
}