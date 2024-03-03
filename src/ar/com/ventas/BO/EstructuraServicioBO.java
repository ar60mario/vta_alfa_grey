/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.EstructuraServicioDAO;
import ar.com.ventas.entities.Estructura;
import ar.com.ventas.entities.EstructuraServicio;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class EstructuraServicioBO {

    private final EstructuraServicioDAO dao = new EstructuraServicioDAO();

    private static final Logger logger = Logger.getLogger("EstructuraServicioBO");

    public List<EstructuraServicio> getAllEstructuraServicioActivos() throws Exception {
        List<EstructuraServicio> estructuras = null;
        try {
            estructuras = dao.getAllEstructuraServicioActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return estructuras;
    }
    
    public EstructuraServicio getEstructuraServicioActivoById(Long id) throws Exception {
        EstructuraServicio estructura = null;
        try {
            estructura = dao.getEstructuraServicioActivoById(id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return estructura;
    }
    
    public List<EstructuraServicio> getAllEstructuraServicioByEstructuraActivos(Estructura estructura) throws Exception {
        List<EstructuraServicio> estructuras = null;
        try {
            estructuras = dao.getAllEstructuraServicioByEstructuraActivos(estructura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return estructuras;
    }
    
    public List<EstructuraServicio> getAllEstructuraServicioInactivos() throws Exception {
        List<EstructuraServicio> estructuras = null;
        try {
            estructuras = dao.getAllEstructuraServicioInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return estructuras;
    }
    
    public EstructuraServicio saveEstructuraServicio(EstructuraServicio estructura) throws Exception {
        try {
            dao.save(estructura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return estructura;
    }
    
    public void deleteEstructuraServicio(EstructuraServicio estructura) throws Exception {
        try {
            dao.delete(estructura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return;
    }
    
    public EstructuraServicio updateEstructuraServicio(EstructuraServicio estructura) throws Exception {
        
        try {
            dao.update(estructura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return estructura;
    }
}
