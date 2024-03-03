/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.AdministradorDAO;
import ar.com.ventas.DAO.ConfiguracionDAO;
import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Domicilio;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ConfiguracionBO {

    private final ConfiguracionDAO dao = new ConfiguracionDAO();

    private static final Logger logger = Logger.getLogger("ConfiguracionBO");

    public Configuracion getConfiguracion(Long id) throws Exception {
        Configuracion configuracion = null;
        try {
            configuracion = dao.getConfiguracion(id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return configuracion;
    }
    
//    public List<Administrador> getAllAdministradoresActivos() throws Exception {
//        List<Administrador> administradores = null;
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
    public Configuracion saveConfiguracion(Configuracion configuracion) throws Exception {
        try {
            dao.save(configuracion);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return configuracion;
    }
    
    public Configuracion updateConfiguracion(Configuracion configuracion) throws Exception {
        try {
            dao.update(configuracion);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return configuracion;
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

}
