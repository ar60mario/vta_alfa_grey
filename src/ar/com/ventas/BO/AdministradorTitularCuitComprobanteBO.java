/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.AdministradorTitularCuitComprobanteDAO;
import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.AdministradorTitularCuitComprobante;
import ar.com.ventas.entities.Comprobante;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class AdministradorTitularCuitComprobanteBO {

    private final AdministradorTitularCuitComprobanteDAO dao = new AdministradorTitularCuitComprobanteDAO();

    private static final Logger logger = Logger.getLogger("AdministradorTitularCuitComprobanteBO");

    public List<AdministradorTitularCuitComprobante> getExistenFacturas(Comprobante comprobante, String cuitTitular, Administrador admin) throws Exception {
        List<AdministradorTitularCuitComprobante> facturas = null;
        try {
            facturas = dao.getExistenFacturas(comprobante, cuitTitular, admin);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return facturas;
    }

    public List<AdministradorTitularCuitComprobante> getAllPorAdministrador() throws Exception {
        List<AdministradorTitularCuitComprobante> facturas = null;
        try {
            facturas = dao.getAllPorAdministrador();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public AdministradorTitularCuitComprobante saveFactura(AdministradorTitularCuitComprobante atcc) throws Exception {
        try {
            dao.save(atcc);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return atcc;
    }
    
    public List<AdministradorTitularCuitComprobante> getAll() throws Exception {
        List<AdministradorTitularCuitComprobante> facturas = null;
        try {
            facturas = dao.getAll(AdministradorTitularCuitComprobante.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return facturas;
    }
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
//    
//    public Administrador getAdministradorById(Long id) throws Exception {
//        Administrador administrador = null;
//        try {
//            administrador = dao.getAdministradorById(id);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return administrador;
//    }
}
