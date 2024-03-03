/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.ImporteDAO;
import ar.com.ventas.entities.Importe;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ImporteBO {

    private final ImporteDAO dao = new ImporteDAO();

    private static final Logger logger = Logger.getLogger("ImporteBO");

    public List<Importe> getAllImportesActivos() throws Exception {
        List<Importe> importes = null;
        try {
            importes = dao.getAllImportesActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return importes;
    }
    
    public Integer getImporteSiguiente() throws Exception {
        Integer codigo = 0;
        try {
            codigo = dao.getImporteSiguiente();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return codigo;
    }
    
    public List<Importe> getAllImportesInactivos() throws Exception {
        List<Importe> importes = null;
        try {
            importes = dao.getAllImportesInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return importes;
    }

    public Importe saveImporte(Importe importe) throws Exception {
        try {
            dao.save(importe);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return importe;
    }
    
    public Importe updateImporte(Importe importe) throws Exception {
        try {
            dao.update(importe);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return importe;
    }

}
