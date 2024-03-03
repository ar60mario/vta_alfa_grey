/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.ComprobanteDAO;
import ar.com.ventas.DAO.ComprobanteNumerosInicialesDAO;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteNumerosIniciales;
import ar.com.ventas.entities.TitularCuit;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ComprobanteNumerosInicialesBO {

    private final ComprobanteNumerosInicialesDAO dao = new ComprobanteNumerosInicialesDAO();

    private static final Logger logger = Logger.getLogger("IvaVentasBO");

    public List<Comprobante> getAllImportesActivos() throws Exception {
        List<Comprobante> importes = null;
        try {
            importes = dao.getAllImportesActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return importes;
    }
    
    public ComprobanteNumerosIniciales getNumeroInicialByTitular(TitularCuit tc) throws Exception {
        ComprobanteNumerosIniciales importe = null;
        try {
            importe = dao.getNumeroInicialByTitular(tc);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return importe;
    }
    
    public Integer getImporteSiguiente() throws Exception {
        Integer codigo = 0;
        try {
            codigo = dao.getImporteSiguiente();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return codigo;
    }
    
    public List<Comprobante> getAllImportesInactivos() throws Exception {
        List<Comprobante> importes = null;
        try {
            importes = dao.getAllImportesInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return importes;
    }

    public ComprobanteNumerosIniciales saveImporte(ComprobanteNumerosIniciales ivni) throws Exception {
        try {
            ivni = (ComprobanteNumerosIniciales) dao.save(ivni);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivni;
    }
    
    public ComprobanteNumerosIniciales updateImporte(ComprobanteNumerosIniciales ivni) throws Exception {
        try {
            ivni = (ComprobanteNumerosIniciales) dao.update(ivni);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivni;
    }

}
