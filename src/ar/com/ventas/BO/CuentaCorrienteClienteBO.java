/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.CuentaCorrienteClienteDAO;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class CuentaCorrienteClienteBO {

    private final CuentaCorrienteClienteDAO dao = new CuentaCorrienteClienteDAO();

    private static final Logger logger = Logger.getLogger("CuentaCorrienteClienteBO");

//    public List<Administrador> getAllAdministradoresActivos() throws Exception {
//        List<Administrador> administradores = null;
//        try {
//            administradores = dao.getAllAdministradoresActivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return administradores;
//    }
    public List<CuentaCorrienteCliente> getCuentaCorrienteClienteByCliente(Consorcio consorcio) throws Exception {
        List<CuentaCorrienteCliente> cuentaCorrienteCliente = null;
        try {
            cuentaCorrienteCliente = dao.getCuentaCorrienteClienteByCliente(consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cuentaCorrienteCliente;
    }

    public List<CuentaCorrienteCliente> getCuentaCorrienteClienteByClienteEntreFechas(Consorcio consorcio, Date de, Date al) throws Exception {
        List<CuentaCorrienteCliente> cuentaCorrienteCliente = null;
        try {
            cuentaCorrienteCliente = dao.getCuentaCorrienteClienteByClienteEntreFechas(consorcio, de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cuentaCorrienteCliente;
    }

    public List<CuentaCorrienteCliente> getCuentaCorrienteClienteByClienteEntreFechas2(Consorcio consorcio, Date de, Date al) throws Exception {
        List<CuentaCorrienteCliente> cuentaCorrienteCliente = null;
        try {
            cuentaCorrienteCliente = dao.getCuentaCorrienteClienteByClienteEntreFechas2(consorcio, de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cuentaCorrienteCliente;
    }
    
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
    public CuentaCorrienteCliente saveCuentaCorrienteCliente(CuentaCorrienteCliente cuenta) throws Exception {
        try {
            dao.save(cuenta);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cuenta;
    }
    
    public CuentaCorrienteCliente updateCuentaCorrienteCliente(CuentaCorrienteCliente cuenta) throws Exception {
        try {
            dao.update(cuenta);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cuenta;
    }
    
    public void deleteCuentaCorrienteCliente(CuentaCorrienteCliente cuenta) throws Exception {
        try {
            dao.delete(cuenta);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public List<CuentaCorrienteCliente> getCtaCteDeVariosClientesEntreFechas(Consorcio consorcio, Date de, Date al) throws Exception {
        List<CuentaCorrienteCliente> cuentaCorrienteCliente = null;
        try {
            cuentaCorrienteCliente = dao.getCuentaCorrienteClienteByClienteEntreFechas(consorcio, de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cuentaCorrienteCliente;
    }
}
