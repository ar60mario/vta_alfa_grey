/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.PersonaDAO;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Persona;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class PersonaBO {

    private final PersonaDAO dao = new PersonaDAO();

    private static final Logger logger = Logger.getLogger("PersonaBO");

    public List<Persona> getAllPersonasActivas() throws Exception {
        List<Persona> personas = null;
        try {
            personas = dao.getAllPersonasActivas();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return personas;
    }
    
    public List<Persona> getTitularesActivos() throws Exception {
        List<Persona> personas = null;
        try {
            personas = dao.getTitularesActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return personas;
    }
    
    public List<Persona> getEmpleadosActivos() throws Exception {
        List<Persona> personas = null;
        try {
            personas = dao.getEmpleadosActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return personas;
    }
    
    public List<Persona> getPersonasActivasByFiltro(String filtro) throws Exception {
        List<Persona> personas = null;
        try {
            personas = dao.getPersonasActivasByFiltro(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return personas;
    }
    
    public String getPersonaActivaById(Long id) throws Exception {
        String persona = null;
        try {
            persona = dao.getPersonaActivaById(id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return persona;
    }
    
    public Persona getPersonaById(Long id) throws Exception {
        Persona persona = null;
        try {
            persona = dao.getPersonaById(id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return persona;
    }
    
    public List<Persona> getAllPersonasInactivas() throws Exception {
        List<Persona> personas = null;
        try {
            personas = dao.getAllPersonasInactivas();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return personas;
    }
    
    public Integer getCodigoSiguiente() throws Exception {
        Integer codigo;
        try {
            codigo = dao.getCodigoSiguiente();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return codigo;
    }
    
    public Persona savePersona(Persona persona) throws Exception {
        DomicilioBO domicilioBO = new DomicilioBO();
        Domicilio domicilio = persona.getDomicilio();
        domicilio = domicilioBO.saveDomicilio(domicilio);
        persona.setDomicilio(domicilio);
        try {
            dao.save(persona);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return persona;
    }
    
    public Persona updatePersona(Persona persona) throws Exception {
        DomicilioBO domicilioBO = new DomicilioBO();
        Domicilio domicilio = persona.getDomicilio();
        domicilio = domicilioBO.updateDomicilio(domicilio);
        persona.setDomicilio(domicilio);
        try {
            dao.update(persona);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return persona;
    }

}
