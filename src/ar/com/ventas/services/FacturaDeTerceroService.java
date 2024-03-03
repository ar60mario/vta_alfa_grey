package ar.com.ventas.services;

import ar.com.ventas.BO.FacturaDeTerceroBO;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.FacturaDeTercero;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FacturaDeTerceroService {

    public FacturaDeTercero saveFacturaDeTercero(FacturaDeTercero factura) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            factura = new FacturaDeTerceroBO().saveFacturaDeTercero(factura);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return factura;
    }
    
    public FacturaDeTercero updateFacturaDeTercero(FacturaDeTercero factura) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            factura = new FacturaDeTerceroBO().updateFacturaDeTercero(factura);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return factura;
    }

    public List<FacturaDeTercero> getAllFacturasDeTerceroEntregadas() throws Exception {
        List<FacturaDeTercero> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            facturas = new FacturaDeTerceroBO().getAllFacturasDeTerceroEntregadas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public List<FacturaDeTercero> getAllFacturasDeTerceroNoEntregadas() throws Exception {
        List<FacturaDeTercero> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            facturas = new FacturaDeTerceroBO().getAllFacturasDeTerceroNoEntregadas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public List<FacturaDeTercero> getAllFacturasDeTerceroNoEntregadasByConsorcio(Consorcio consorcio) throws Exception {
        List<FacturaDeTercero> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            facturas = new FacturaDeTerceroBO().getAllFacturasDeTerceroNoEntregadasByConsorcio(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public List<FacturaDeTercero> getAllFacturasDeTerceroNoCobradasByConsorcio(Consorcio consorcio) throws Exception {
        List<FacturaDeTercero> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            facturas = new FacturaDeTerceroBO().getAllFacturasDeTerceroNoCobradasByConsorcio(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
}
