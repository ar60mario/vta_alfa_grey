package ar.com.ventas.services;

import ar.com.ventas.BO.ComprobanteBO;
import ar.com.ventas.BO.ComprobanteNumerosInicialesBO;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteNumerosIniciales;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ComprobanteNumerosInicialesService {

    public ComprobanteNumerosIniciales saveImporte(ComprobanteNumerosIniciales ivni) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivni = new ComprobanteNumerosInicialesBO().saveImporte(ivni);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivni;
    }
    
    public ComprobanteNumerosIniciales updateImporte(ComprobanteNumerosIniciales ivni) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivni = new ComprobanteNumerosInicialesBO().updateImporte(ivni);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivni;
    }

    public List<Comprobante> getAllImportesActivos() throws Exception {
        List<Comprobante> importes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            importes = new ComprobanteBO().getAllImportesActivos();
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
            codigo = new ComprobanteBO().getImporteSiguiente();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return codigo;
    }
    
    public ComprobanteNumerosIniciales getNumeroInicialByTitular(TitularCuit tc) throws Exception {
        ComprobanteNumerosIniciales importe = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            importe = new ComprobanteNumerosInicialesBO().getNumeroInicialByTitular(tc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return importe;
    }
    
    public List<Comprobante> getAllImportesInactivos() throws Exception {
        List<Comprobante> importes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            importes = new ComprobanteBO().getAllImportesInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return importes;
    }
}
