/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.TitularCuitDAO;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Persona;
import ar.com.ventas.entities.TitularCuit;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class TitularCuitBO {

    private final TitularCuitDAO dao = new TitularCuitDAO();

    private static final Logger logger = Logger.getLogger("AdministradorBO");

    public List<TitularCuit> getAllTitularesDeCuitActivos() throws Exception {
        List<TitularCuit> titulares = null;
        try {
            titulares = dao.getAllTitularesDeCuitActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return titulares;
    }
    
    public List<TitularCuit> getAllTitularesDeCuitInactivos() throws Exception {
        List<TitularCuit> titulares = null;
        try {
            titulares = dao.getAllTitularesDeCuitInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return titulares;
    }

    public TitularCuit saveTitularCuit(TitularCuit titular) throws Exception {
        DomicilioBO domicilioBO = new DomicilioBO();
        Domicilio domicilio = titular.getDomicilio();
        domicilio = domicilioBO.saveDomicilio(domicilio);
        titular.setDomicilio(domicilio);
        try {
            dao.save(titular);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return titular;
    }
    
    public TitularCuit updateTitularCuit(TitularCuit titular) throws Exception {
        DomicilioBO domicilioBO = new DomicilioBO();
        Domicilio domicilio = titular.getDomicilio();
        domicilio = domicilioBO.updateDomicilio(domicilio);
        titular.setDomicilio(domicilio);
        try {
            dao.update(titular);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return titular;
    }
    
    public TitularCuit getTitularDeCuitActivoByPersona(Persona persona) throws Exception {
        TitularCuit tc = null;
        try {
            tc = dao.getTitularDeCuitActivoByPersona(persona);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return tc;
    }
    
    public List<TitularCuit> getTitularDeCuitActivoByFiltro(String filtro) throws Exception {
        List<TitularCuit> tc = null;
        try {
            tc = dao.getTitularDeCuitActivoByFiltro(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return tc;
    }
    
    public TitularCuit getTitularActivoByCuit(String cuit) throws Exception {
        TitularCuit tc = null;
        try {
            tc = dao.getTitularActivoByCuit(cuit);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return tc;
    }
    
    public TitularCuit getTitularByCuit(String cuit) throws Exception {
        TitularCuit tc = null;
        try {
            tc = dao.getTitularByCuit(cuit);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return tc;
    }
}
