/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.RcCoDAO;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.RcCo;
import ar.com.ventas.entities.Recibo;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class RcCoBO {

    private final RcCoDAO dao = new RcCoDAO();

    private static final Logger logger = Logger.getLogger("ReciboBO");

    public RcCo saveRcCo(RcCo recibo) throws Exception {
        try {
            recibo = (RcCo) dao.save(recibo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibo;
    }
    
    public void deleteRcCo(RcCo recibo) throws Exception {
        try {
            dao.delete(recibo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public RcCo getRecibosByReciboAndComprobante(Recibo re, Comprobante co) throws Exception {
        RcCo rc = null;
        try {
            rc = (RcCo) dao.getRecibosByReciboAndComprobante(re, co);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return rc;
    }
    
//    public List<Rubro> getAllRubrosActivos() throws Exception {
//        List<Rubro> rubros = null;
//        try {
//            rubros = dao.getAllRubrosActivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return rubros;
//    }

//    public List<Recibo> getRecibosEntreFechas(Date de, Date al) throws Exception {
//        List<Recibo> recibos = null;
//        try {
//            recibos = dao.getRecibosEntreFechas(de, al);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return recibos;
//    }
    
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
//    public Rubro updateRubro(Rubro rubro) throws Exception {
//        
//        try {
//            dao.update(rubro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return rubro;
//    }
}
