/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.IvaVentasDAO;
import ar.com.ventas.entities.Consorcio;
//import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.ComprobanteRenglones;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class IvaVentasBO {

    private final IvaVentasDAO dao = new IvaVentasDAO();

    private static final Logger logger = Logger.getLogger("IvaVentasBO");

//    public List<IvaVentas> getAllImportesActivos() throws Exception {
//        List<IvaVentas> importes = null;
//        try {
//            importes = dao.getAllImportesActivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return importes;
//    }

//    public List<ComprobanteRenglones> getAllRenglonesByFactura(IvaVentas iv) throws Exception {
//        List<ComprobanteRenglones> iv1 = null;
//        try {
//            iv1 = dao.getAllRenglonesByFactura(iv);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return iv1;
//    }

//    public List<IvaVentas> getFacturasEntreFechas(Date de, Date al) throws Exception {
//        List<IvaVentas> facturas = null;
//        try {
//            facturas = dao.getFacturasEntreFechas(de, al);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return facturas;
//    }

//    public List<IvaVentas> getFacturasEntreFechasByTitular(Date de, Date al, String cuitTitular) throws Exception {
//        List<IvaVentas> facturas = null;
//        try {
//            facturas = dao.getFacturasEntreFechasByTitular(de, al, cuitTitular);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return facturas;
//    }
//    
//    public List<IvaVentas> getFacturasByConsorcioEntreFechas(Consorcio co, Date de, Date al) throws Exception {
//        List<IvaVentas> facturas = null;
//        try {
//            facturas = dao.getFacturasByConsorcioEntreFechas(co, de, al);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return facturas;
//    }
//    
//    public List<IvaVentas> getFacturasByConsorcioEntreFechasConDeuda(Consorcio co, Date de, Date al) throws Exception {
//        List<IvaVentas> facturas = null;
//        List<IvaVentas> fc = new ArrayList<>();
//        try {
//            facturas = dao.getFacturasByConsorcioEntreFechas(co, de, al);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        if(facturas != null && !facturas.isEmpty()){
//            for(IvaVentas i:facturas){
//                Date ff = i.getFecha();
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(ff);
//                int cuotas = i.getCantidadCuotas();
//                int cuotasPagadas = i.getCuotasPagadas();
//                if(cuotas > cuotasPagadas){
//                    System.out.println(cal.getTime());
//                    System.out.println(cuotasPagadas);
//                }
//            }
//        }
//        return facturas;
//    }

//    public Integer getImporteSiguiente() throws Exception {
//        Integer codigo = 0;
//        try {
//            codigo = dao.getImporteSiguiente();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return codigo;
//    }

//    public List<IvaVentas> getAllImportesInactivos() throws Exception {
//        List<IvaVentas> importes = null;
//        try {
//            importes = dao.getAllImportesInactivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return importes;
//    }
//
//    public IvaVentas saveImporte(IvaVentas importe) throws Exception {
//        try {
//            dao.save(importe);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return importe;
//    }
//
//    public IvaVentas saveFacturaCompleta(IvaVentas iv, List<ComprobanteRenglones> ivr) throws Exception {
//        if (ivr != null) {
//            iv = (IvaVentas) dao.save(iv);
//            IvaVentasDAO ivD = new IvaVentasDAO();
//            for (ComprobanteRenglones ir : ivr) {
//                ir.setIvaVentas(iv);
//                ivD.save(ir);
//            }
//        } else {
//            try {
//                iv = (IvaVentas) dao.save(iv);
//            } catch (HibernateException ex) {
//                throw new Exception(ex);
//            }
//        }
//        return iv;
//    }
//
//    public IvaVentas updateIvaVentas(IvaVentas iv) throws Exception {
//        try {
//            dao.update(iv);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return iv;
//    }

}
