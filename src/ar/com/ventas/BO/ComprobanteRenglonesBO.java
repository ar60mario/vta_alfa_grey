/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.ComprobanteRenglonesDAO;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteRenglones;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ComprobanteRenglonesBO {

    private final ComprobanteRenglonesDAO dao = new ComprobanteRenglonesDAO();

    private static final Logger logger = Logger.getLogger("ComprobanteRenglonesBO");

    public List<ComprobanteRenglones> getRenglonesPorComprobante(Comprobante comprobante) throws Exception {
        List<ComprobanteRenglones> comprobantes = null;
        try {
            comprobantes = dao.getRenglonesPorComprobante(comprobante);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
//    public Integer getImporteSiguiente() throws Exception {
//        Integer codigo = 0;
//        try {
//            codigo = dao.getImporteSiguiente();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return codigo;
//    }
//    
//    public List<Comprobante> getComprobantesEntreFechasSinPdf(Date de, Date al) throws Exception {
//        List<Comprobante> comprobantes = null;
//        try {
//            comprobantes = dao.getComprobantesEntreFechasSinPdf(de, al);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return comprobantes;
//    }
//    
//    public List<Comprobante> getComprobantesEntrFechasByTitular(TitularCuit titular, Date de, Date al) throws Exception {
//        List<Comprobante> comprobantes = null;
//        try {
//            comprobantes = dao.getComprobantesEntrFechasByTitular(titular, de, al);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return comprobantes;
//    }
//    
//    public List<Comprobante> getComprobantesEntreFechasByConsorcio(Consorcio consorcio, Date de, Date al) throws Exception {
//        List<Comprobante> comprobantes = null;
//        try {
//            comprobantes = dao.getComprobantesEntreFechasByConsorcio(consorcio, de, al);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return comprobantes;
//    }
//    
//    public List<Comprobante> getAllImportesActivos() throws Exception {
//        List<Comprobante> importes = null;
//        try {
//            importes = dao.getAllImportesActivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return importes;
//    }
//    
//    public List<Comprobante> getAllImportesInactivos() throws Exception {
//        List<Comprobante> importes = null;
//        try {
//            importes = dao.getAllImportesInactivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return importes;
//    }
//    public List<Administrador> getAllAdministradoresInactivos() throws Exception {
//        List<Administrador> administradores = null;
//        try {
//            administradores = dao.getAllAdministradoresInactivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return administradores;
//    }
//    
//    public Integer getCodigoSiguiente() throws Exception {
//        Integer codigo;
//        try {
//            codigo = dao.getCodigoSiguiente();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return codigo;
//    }
    public ComprobanteRenglones saveRenglon(ComprobanteRenglones renglon) throws Exception {
        try {
            renglon = (ComprobanteRenglones) dao.save(renglon);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglon;
    }
    
    public ComprobanteRenglones updateRenglon(ComprobanteRenglones renglon) throws Exception {
        try {
            renglon = (ComprobanteRenglones) dao.update(renglon);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglon;
    }
    
    public void deleteRenglon(ComprobanteRenglones renglon) throws Exception {
        try {
            dao.delete(renglon);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public void borrarRenglones(List<ComprobanteRenglones> renglones) throws Exception {
        for(ComprobanteRenglones cr:renglones){
            deleteRenglon(cr);
        }
    }

//    public Administrador updateAdministrador(Administrador administrador) throws Exception {
//        DomicilioBO domicilioBO = new DomicilioBO();
//        Domicilio domicilio = administrador.getDomicilio();
//        domicilio = domicilioBO.updateDomicilio(domicilio);
//        administrador.setDomicilio(domicilio);
//        try {
//            dao.update(administrador);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return administrador;
//    }
}
