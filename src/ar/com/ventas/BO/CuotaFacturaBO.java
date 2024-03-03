/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.CuotaFacturaDAO;
import ar.com.ventas.entities.CuotaFactura;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class CuotaFacturaBO {

    private final CuotaFacturaDAO dao = new CuotaFacturaDAO();

    private static final Logger logger = Logger.getLogger("AdministradorBO");

//    public List<CuotaFactura> getAllAdministradoresActivos() throws Exception {
//        List<CuotaFactura> administradores = null;
//        try {
//            administradores = dao.getAllAdministradoresActivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return administradores;
//    }
//    
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
//    
    public CuotaFactura saveCuotaFactura(CuotaFactura cuota) throws Exception {
        try {
            dao.save(cuota);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cuota;
    }
//    
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
//
//    public List<Administrador> getAllAdministradoresActivosByFiltro(String filtro) throws Exception {
//        List<Administrador> administradores = null;
//        try {
//            administradores = dao.getAllAdministradoresActivosByFiltro(filtro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return administradores;
//    }
}
