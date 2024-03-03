/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.ServicioDAO;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Servicio;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ServicioBO {

    private final ServicioDAO dao = new ServicioDAO();

    private static final Logger logger = Logger.getLogger("ServicioBO");

    public List<Servicio> getAllServiciosActivos() throws Exception {
        List<Servicio> servicios = null;
        try {
            servicios = dao.getAllServiciosActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return servicios;
    }
    
    public List<Servicio> getAllServiciosActivosSinTrabajo() throws Exception {
        List<Servicio> servicios = null;
        try {
            servicios = dao.getAllServiciosActivosSinTrabajo();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return servicios;
    }
    
    public Servicio getServicioActivoByRubroAndConsorcio(Rubro rubro, Consorcio consorcio) throws Exception {
        Servicio servicio = null;
        try {
            servicio = dao.getServicioActivoByRubroAndConsorcio(rubro, consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return servicio;
    }
    
    public List<Servicio> getServiciosActivoByRubro(Rubro rubro) throws Exception {
        List<Servicio> servicios = null;
        try {
            servicios = dao.getServiciosActivoByRubro(rubro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return servicios;
    }
    
    public List<Servicio> getAllServiciosActivosByConsorcio(Consorcio consorcio) throws Exception {
        List<Servicio> servicios = null;
        try {
            servicios = dao.getAllServiciosActivosByConsorcio(consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return servicios;
    }
    
    public List<Servicio> getAllServiciosInactivosByRubroAndConsorcio(Rubro rubro, Consorcio consorcio) throws Exception {
        List<Servicio> servicios = null;
        try {
            servicios = dao.getAllServiciosInactivosByRubroAndConsorcio(rubro, consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return servicios;
    }
    
    public List<Servicio> getAllServiciosInactivos() throws Exception {
        List<Servicio> servicios = null;
        try {
            servicios = dao.getAllServiciosInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return servicios;
    }
    
    public Servicio saveServicio(Servicio servicio) throws Exception {
        try {
            dao.save(servicio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return servicio;
    }
    
    public Servicio updateServicio(Servicio servicio) throws Exception {
        try {
            dao.update(servicio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return servicio;
    }

}
