package ar.com.ventas.services;

import ar.com.ventas.BO.PrecioBO;
import ar.com.ventas.entities.Precio;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PrecioService {

    public Precio savePrecio(Precio precio) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            precio = new PrecioBO().savePrecio(precio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return precio;
    }
    
    public Precio updatePrecio(Precio precio) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            precio = new PrecioBO().updatePrecio(precio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return precio;
    }

    public List<Precio> getAllPreciosActivos() throws Exception {
        List<Precio> precios = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            precios = new PrecioBO().getAllPreciosActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return precios;
    }
    
    public List<Precio> getAllPreciosInactivos() throws Exception {
        List<Precio> precios = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            precios = new PrecioBO().getAllPreciosInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return precios;
    }
}
