/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.HijoDAO;
import ar.com.ventas.entities.Hijo;
import ar.com.ventas.entities.Persona;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class HijoBO {

    private final HijoDAO dao = new HijoDAO();

    private static final Logger logger = Logger.getLogger("HijoBO");

    public List<Hijo> getAllHijosActivos() throws Exception {
        List<Hijo> hijos = null;
        try {
            hijos = dao.getAllHijosActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return hijos;
    }
    
    public List<Hijo> getAllHijosActivosByPersona(Persona persona) throws Exception {
        List<Hijo> hijos = null;
        try {
            hijos = dao.getAllHijosActivosByPersona(persona);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return hijos;
    }
    
    public List<Hijo> getAllHijosInactivosByPersona(Persona persona) throws Exception {
        List<Hijo> hijos = null;
        try {
            hijos = dao.getAllHijosInactivosByPersona(persona);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return hijos;
    }
    
    public List<Hijo> getAllHijosInactivos() throws Exception {
        List<Hijo> hijos = null;
        try {
            hijos = dao.getAllHijosInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return hijos;
    }

    public Hijo saveHijo(Hijo hijo) throws Exception {
        try {
            dao.save(hijo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return hijo;
    }
    
    public Hijo updateHijo(Hijo hijo) throws Exception {
        try {
            dao.update(hijo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return hijo;
    }

}
