/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.ComprobanteDAO;
import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.TitularCuit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ComprobanteBO {

    private final ComprobanteDAO dao = new ComprobanteDAO();

    private static final Logger logger = Logger.getLogger("ComprobanteBO");

    public List<Comprobante> getComprobantesEntrFechas(Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesEntrFechas(de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesEntrFechasAndRubro(Date de, Date al, Rubro ru) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesEntrFechasAndRubro(de, al, ru);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesEntreFechasAndRubroParaAsignar(Date de, Date al, Rubro ru) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesEntreFechasAndRubroParaAsignar(de, al, ru);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesActivos() throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesActivosReparacion() throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesActivosReparacion();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesActivosReparacion(Consorcio consorcio, Rubro rubro, Date deFecha) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesActivosReparacion(consorcio, rubro, deFecha);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesActivosReparacionParaRenovar() throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesActivosReparacionParaRenovar();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesActivosReparacionCuotaSiguiente() throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesActivosReparacionCuotaSiguiente();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesActivosReparacionParaRenovar2() throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesActivosReparacionParaRenovar2();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobEntrFechasIgualImporteIgualCuotaIgualRubro(Date de, Date al,
            Double imp, Integer cuo, Rubro ru) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobEntrFechasIgualImporteIgualCuotaIgualRubro(de, al, imp, cuo, ru);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesEntrFechasOrdenConso(Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesEntrFechasOrdenConso(de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesEntrFechasOrdenConsoParaAsignar(Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesEntrFechasOrdenConsoParaAsignar(de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesEntrFechasOrdenTitular(Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesEntrFechasOrdenTitular(de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesEntrFechasOrdenNumero(Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesEntrFechasOrdenNumero(de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesImpagos() throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesImpagos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesImpagosByConsorcio(Consorcio consorcio) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesImpagosByConsorcio(consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobanteByNroAndTitular(Integer numero, String cuitTitular, Long idAdmin) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobanteByNroAndTitular(numero, cuitTitular, idAdmin);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

//    public List<Comprobante> getComprobantesImpagosByAdministrador(Administrador adm) throws Exception {
//        List<Comprobante> comprobantes = null;
//        List<Consorcio> consorcios = null;
//        List<Comprobante> comprob = new ArrayList<>();
//        Boolean tiene = false;
//        try {
//            consorcios = new ConsorcioBO().getAllConsorciosActivosByAdministrador(adm);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        if (consorcios != null && !consorcios.isEmpty()) {
//            for (Consorcio con : consorcios) {
//                comprobantes = dao.getComprobantesImpagosByAdministrador(con);
//                if (comprobantes != null && !comprobantes.isEmpty()) {
//                    for (Comprobante com : comprobantes) {
//                        comprob.add(com);
//                    }
//                    tiene = true;
//                }
//            }
//        }
//        if (tiene) {
//            return comprob;
//        } else {
//            return null;
//        }
//    }
    public Integer getImporteSiguiente() throws Exception {
        Integer codigo = 0;
        try {
            codigo = dao.getImporteSiguiente();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return codigo;
    }

    public List<Comprobante> getComprobantesEntreFechasSinPdf(Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesEntreFechasSinPdf(de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesEntrFechasByTitular(TitularCuit titular, Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesEntrFechasByTitular(titular, de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesOriginalEntrFechasByTitular(TitularCuit titular, Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesOriginalEntrFechasByTitular(titular, de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesEntreFechasByConsorcio(Consorcio consorcio, Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesEntreFechasByConsorcio(consorcio, de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;

    }

    public Comprobante getUltimoComprobanteByConsorcio(Consorcio consorcio) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesByConsorcio(consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        if (comprobantes.isEmpty()) {
            return null;
        } else {
            return comprobantes.get(0);
        }
    }

    public Comprobante getUltimoComprobanteByConsorcioAndRubro(Consorcio consorcio, Rubro rubro) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesByConsorcioAndRubro(consorcio, rubro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        if (comprobantes.isEmpty()) {
            return null;
        } else {
            return comprobantes.get(0);
        }
    }

    public Comprobante getComprobantesByConsorcioAndRubro(Consorcio consorcio, Rubro rubro) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getComprobantesByConsorcioAndRubro(consorcio, rubro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        if (comprobantes.isEmpty()) {
            return null;
        } else {
            return comprobantes.get(0);
        }
    }

    public List<Comprobante> getAllImportesActivos() throws Exception {
        List<Comprobante> importes = null;
        try {
            importes = dao.getAllImportesActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return importes;
    }

    public List<Comprobante> getAllImportesInactivos() throws Exception {
        List<Comprobante> importes = null;
        try {
            importes = dao.getAllImportesInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return importes;
    }

    public Comprobante getComprobanteById(Long id) throws Exception {
        Comprobante comp = null;

        try {
            comp = (Comprobante) dao.getById(Comprobante.class,
                    id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comp;
    }

//    public List<Administrador> getAllAdministradoresInactivos() throws Exception {
//        List<Administrador> administradores = null;
//        try {
//            administradores = dao.getAllAdministradoresInactivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return administradores;
//    }
//    
//    public Integer getCodigoSiguiente() throws Exception {
//        Integer codigo;
//        try {
//            codigo = dao.getCodigoSiguiente();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return codigo;
//    }
    public Comprobante saveComprobante(Comprobante comprobante) throws Exception {
        try {
            comprobante = (Comprobante) dao.save(comprobante);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobante;
    }

    public void deleteComprobante(Comprobante comprobante) throws Exception {
        try {
            dao.delete(comprobante);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public Comprobante updateComprobante(Comprobante comprobante) throws Exception {
        try {
            comprobante = (Comprobante) dao.update(comprobante);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobante;
    }

    public void updateListaComprobantes(List<Comprobante> comprobantes) throws Exception {
        for (Comprobante c : comprobantes) {
            try {
                dao.update(c);
            } catch (HibernateException ex) {
                throw new Exception(ex);
            }
        }
    }

    public Comprobante getComprobanteByNro(Integer numero, Integer tipoDoc) throws Exception {
        Comprobante factura = null;
        try {
            factura = (Comprobante) dao.getComprobanteByNro(numero, tipoDoc);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return factura;
    }

    public List<Comprobante> getAllComprobantesByNro(Integer numero) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getAllComprobantesByNro(numero);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getAllComprobantesAsignadosPorIdOriginal(Long numero) throws Exception {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = dao.getAllComprobantesAsignadosPorIdOriginal(numero);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public Comprobante getComprByNroSucAndTipo(Integer numero, Integer suc, Integer tipo) throws Exception {
        Comprobante factura = null;
        try {
            factura = (Comprobante) dao.getComprByNroSucAndTipo(numero, suc, tipo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return factura;
    }

//    public Administrador updateAdministrador(Administrador administrador) throws Exception {
//        DomicilioBO domicilioBO = new DomicilioBO();
//        Domicilio domicilio = administrador.getDomicilio();
//        domicilio = domicilioBO.updateDomicilio(domicilio);
//        administrador.setDomicilio(domicilio);
//        try {
//            dao.update(administrador);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return administrador;
//    }
}
