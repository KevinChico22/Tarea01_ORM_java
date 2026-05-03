package dao;

import modelo.Marca;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

public class MarcaDAO {

    private SessionFactory factory = HibernateUtil.getSessionFactory();

    // GUARDAR
    public void guardar(Marca m) {
        Session s = factory.getCurrentSession();
        s.beginTransaction();
        s.save(m);
        s.getTransaction().commit();
    }

    // LISTAR (JPQL)
    public List<Marca> listar() {
        Session s = factory.getCurrentSession();
        s.beginTransaction();

        List<Marca> lista = s.createQuery("from Marca", Marca.class).getResultList();

        s.getTransaction().commit();
        return lista;
    }

    // BUSCAR POR ID
    public Marca buscarPorId(int id) {
        Session s = factory.getCurrentSession();
        s.beginTransaction();

        Marca m = s.get(Marca.class, id);

        s.getTransaction().commit();
        return m;
    }

    // ACTUALIZAR
    public void actualizar(Marca m) {
        Session s = factory.getCurrentSession();
        s.beginTransaction();

        s.update(m);

        s.getTransaction().commit();
    }

    // BUSCAR POR NOMBRE (JPQL con parámetro)
    public List<Marca> buscarPorNombre(String nombre) {
        Session s = factory.getCurrentSession();
        s.beginTransaction();

        List<Marca> lista = s.createQuery(
                "SELECT m FROM Marca m WHERE m.nombre = :nombre", Marca.class)
                .setParameter("nombre", nombre)
                .getResultList();

        s.getTransaction().commit();
        return lista;
    }

    // CONTAR (JPQL)
    public Long contarMarcas() {
        Session s = factory.getCurrentSession();
        s.beginTransaction();

        Long total = s.createQuery(
                "SELECT COUNT(m) FROM Marca m", Long.class)
                .getSingleResult();

        s.getTransaction().commit();
        return total;
    }
}