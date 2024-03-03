package ar.com.ventas.services;

import ar.com.ventas.BO.ImporteBO;
import ar.com.ventas.entities.Importe;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ImporteService {

    public Importe saveImporte(Importe importe) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            importe = new ImporteBO().saveImporte(importe);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return importe;
    }
    
    public Importe updateImporte(Importe importe) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            importe = new ImporteBO().updateImporte(importe);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return importe;
    }

    public List<Importe> getAllImportesActivos() throws Exception {
        List<Importe> importes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            importes = new ImporteBO().getAllImportesActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return importes;
    }
    
    public Integer getImporteSiguiente() throws Exception {
        Integer codigo = 0;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            codigo = new ImporteBO().getImporteSiguiente();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return codigo;
    }
    
    public List<Importe> getAllImportesInactivos() throws Exception {
        List<Importe> importes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            importes = new ImporteBO().getAllImportesInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return importes;
    }
}
