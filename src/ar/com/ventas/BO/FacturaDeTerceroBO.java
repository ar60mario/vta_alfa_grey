/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.FacturaDeTerceroDAO;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.FacturaDeTercero;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class FacturaDeTerceroBO {

    private final FacturaDeTerceroDAO dao = new FacturaDeTerceroDAO();

    private static final Logger logger = Logger.getLogger("FacturaDeTerceroBO");

    public List<FacturaDeTercero> getAllFacturasDeTerceroEntregadas() throws Exception {
        List<FacturaDeTercero> facturas = null;
        try {
            facturas = dao.getAllFacturasDeTerceroEntregadas();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public List<FacturaDeTercero> getAllFacturasDeTerceroNoEntregadas() throws Exception {
        List<FacturaDeTercero> facturas = null;
        try {
            facturas = dao.getAllFacturasDeTerceroNoEntregadas();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public List<FacturaDeTercero> getAllFacturasDeTerceroNoEntregadasByConsorcio(Consorcio consorcio) throws Exception {
        List<FacturaDeTercero> facturas = null;
        try {
            facturas = dao.getAllFacturasDeTerceroNoEntregadasByConsorcio(consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public List<FacturaDeTercero> getAllFacturasDeTerceroNoCobradasByConsorcio(Consorcio consorcio) throws Exception {
        List<FacturaDeTercero> facturas = null;
        try {
            facturas = dao.getAllFacturasDeTerceroNoCobradasByConsorcio(consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public FacturaDeTercero saveFacturaDeTercero(FacturaDeTercero factura) throws Exception {
        try {
            dao.save(factura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return factura;
    }
    
    public FacturaDeTercero updateFacturaDeTercero(FacturaDeTercero factura) throws Exception {
        try {
            dao.update(factura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return factura;
    }
}
