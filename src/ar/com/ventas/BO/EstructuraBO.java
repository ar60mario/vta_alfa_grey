/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.EstructuraDAO;
import ar.com.ventas.entities.Estructura;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class EstructuraBO {

    private final EstructuraDAO dao = new EstructuraDAO();

    private static final Logger logger = Logger.getLogger("EstructuraBO");

    public List<Estructura> getAllEstructurasActivas() throws Exception {
        List<Estructura> estructuras = null;
        try {
            estructuras = dao.getAllEstructurasActivas();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return estructuras;
    }

    public List<Estructura> getAllEstructurasInactivas() throws Exception {
        List<Estructura> estructuras = null;
        try {
            estructuras = dao.getAllEstructurasInactivas();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return estructuras;
    }

    public Estructura saveEstructura(Estructura estructura) throws Exception {

        try {
            dao.save(estructura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return estructura;
    }

    public Estructura updateEstructura(Estructura estructura) throws Exception {

        try {
            dao.update(estructura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return estructura;
    }
}
