/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.ReciboDAO;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
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
public class ReciboBO {

    private final ReciboDAO dao = new ReciboDAO();

    private static final Logger logger = Logger.getLogger("ReciboBO");

    public Recibo saveRecibo(Recibo recibo) throws Exception {
        try {
            recibo = (Recibo) dao.save(recibo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibo;
    }
    
    public void deleteRecibo(Recibo recibo) throws Exception {
        try {
            dao.delete(recibo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public void eliminarReciboCompleto(Recibo re, Consorcio co, RcCo rcCo, 
            CuentaCorrienteCliente cc, Comprobante cmp) throws Exception {
        try {
            new ConsorcioBO().updateConsorcio(co);
            new RcCoBO().deleteRcCo(rcCo);
            new CuentaCorrienteClienteBO().deleteCuentaCorrienteCliente(cc);
            new ReciboBO().deleteRecibo(re);
            new ComprobanteBO().updateComprobante(cmp);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
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

    public List<Recibo> getRecibosEntreFechas(Date de, Date al) throws Exception {
        List<Recibo> recibos = null;
        try {
            recibos = dao.getRecibosEntreFechas(de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibos;
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
