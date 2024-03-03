/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.PrecioDAO;
import ar.com.ventas.entities.Precio;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class PrecioBO {

    private final PrecioDAO dao = new PrecioDAO();

    private static final Logger logger = Logger.getLogger("ConsorcioBO");

    public List<Precio> getAllPreciosActivos() throws Exception {
        List<Precio> precios = null;
        try {
            precios = dao.getAllPreciosActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return precios;
    }
    
    public List<Precio> getAllPreciosInactivos() throws Exception {
        List<Precio> precios = null;
        try {
            precios = dao.getAllPreciosInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return precios;
    }

    public Precio savePrecio(Precio precio) throws Exception {
        try {
            dao.save(precio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return precio;
    }
    
    public Precio updatePrecio(Precio precio) throws Exception {
        try {
            dao.update(precio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return precio;
    }

}
