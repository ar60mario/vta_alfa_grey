/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ComprobanteDAO extends GenericDAO {

    public List<Comprobante> getComprobantesEntrFechas(Date de, Date al) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.addOrder(Order.asc("fecha"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesEntrFechasAndRubro(Date de, Date al, Rubro ru) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.add(Restrictions.eq("rubro", ru));
        criteria.addOrder(Order.asc("fecha"));
        criteria.addOrder(Order.asc("calleNroPisoDtoCliente"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesEntreFechasAndRubroParaAsignar(Date de, Date al, Rubro ru) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.add(Restrictions.eq("rubro", ru));
        criteria.add(Restrictions.eq("cuitCliente", "00-00000000-0"));
        criteria.add(Restrictions.eq("original", true));

        criteria.addOrder(Order.asc("total"));
        criteria.addOrder(Order.asc("calleNroPisoDtoCliente"));
        criteria.addOrder(Order.asc("sucursal"));
        criteria.addOrder(Order.asc("numero"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
//        criteria.add(Restrictions.between("fecha", de, al));
        criteria.addOrder(Order.asc("fecha"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesActivosReparacion() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("tipoEmision", 4));
        criteria.add(Restrictions.neProperty("cuotasPagadas", "cantidadCuotas"));
        criteria.addOrder(Order.asc("id"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesActivosReparacion(Consorcio consorcio, Rubro rubro, Date deFecha) {
        Integer codigo = consorcio.getCodigo();
        Date now = new Date();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("codigoCliente", codigo));
        criteria.add(Restrictions.eq("rubro", rubro));
        criteria.add(Restrictions.between("fecha", deFecha, now));
        criteria.add(Restrictions.eq("tipoEmision", 4));
        criteria.addOrder(Order.desc("id"));
        return (List<Comprobante>) criteria.list();
    }

//    public List<Comprobante> getComprobantesActivosReparacion10(Consorcio consorcio, Rubro rubro, Date deFecha) {
//        Integer codigo = consorcio.getCodigo();
//        Date now = new Date();
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Comprobante.class);
//        criteria.add(Restrictions.eq("codigoCliente", codigo));
//        criteria.add(Restrictions.eq("rubro", rubro));
//        criteria.add(Restrictions.between("fecha", deFecha, now));
//        criteria.add(Restrictions.eq("tipoEmision", 4));
//        criteria.addOrder(Order.desc("id"));
//        return (List<Comprobante>) criteria.list();
//    }
//    
    public List<Comprobante> getComprobantesActivosReparacionParaRenovar() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("tipoEmision", 4));
        criteria.add(Restrictions.eq("periodoHabilitado", true));
        criteria.add(Restrictions.neProperty("cuotasPagadas", "cantidadCuotas"));
        criteria.addOrder(Order.asc("id"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesActivosReparacionParaRenovar2() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("tipoEmision", 4));
        criteria.add(Restrictions.eqOrIsNull("periodoHabilitado", false));
        criteria.add(Restrictions.eqOrIsNull("cuotaSiguienteFacturada", false));
        criteria.add(Restrictions.neProperty("cuotasPagadas", "cantidadCuotas"));
        criteria.addOrder(Order.asc("calleNroPisoDtoCliente"));
        criteria.addOrder(Order.asc("fecha"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesActivosReparacionCuotaSiguiente() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("tipoEmision", 4));
        criteria.add(Restrictions.eq("cuotaSiguienteFacturada", false));
        criteria.add(Restrictions.gt("cantidadCuotas", 1));
        criteria.add(Restrictions.neProperty("cuotasPagadas", "cantidadCuotas"));
        criteria.add(Restrictions.eqOrIsNull("periodoHabilitado", true));
        criteria.addOrder(Order.asc("id"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobEntrFechasIgualImporteIgualCuotaIgualRubro(Date de, Date al,
            Double imp, Integer cuo, Rubro ru) {
        System.out.println(de);
        System.out.println(al);
        System.out.println(imp);
        System.out.println(cuo);
//        System.exit(0);
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.add(Restrictions.eq("total", imp));
        criteria.add(Restrictions.eq("cuotasPagadas", cuo));
        criteria.add(Restrictions.eq("rubro", ru));
        criteria.add(Restrictions.eq("cuitCliente", "00-00000000-0"));
        criteria.addOrder(Order.asc("fecha"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesEntrFechasOrdenConso(Date de, Date al) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.addOrder(Order.asc("calleNroPisoDtoCliente"));
        criteria.addOrder(Order.asc("sucursal"));
        criteria.addOrder(Order.asc("numero"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesEntrFechasOrdenConsoParaAsignar(Date de, Date al) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.add(Restrictions.eq("cuitCliente", "00-00000000-0"));
        criteria.add(Restrictions.eq("original", true));
        criteria.addOrder(Order.asc("calleNroPisoDtoCliente"));
        criteria.addOrder(Order.asc("sucursal"));
        criteria.addOrder(Order.asc("numero"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesEntrFechasOrdenTitular(Date de, Date al) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.addOrder(Order.asc("razonSocialTitular"));
        criteria.addOrder(Order.asc("sucursal"));
        criteria.addOrder(Order.asc("numero"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesEntrFechasOrdenNumero(Date de, Date al) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.addOrder(Order.asc("sucursal"));
        criteria.addOrder(Order.asc("numero"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesImpagosByConsorcio(Consorcio consorcio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        Integer codigo = consorcio.getCodigo();
        criteria.add(Restrictions.eq("codigoConsorcio", codigo));
        criteria.add(Restrictions.ltProperty("pagado", "total"));
        criteria.addOrder(Order.asc("fecha"));
        return (List<Comprobante>) criteria.list();

    }

    public List<Comprobante> getComprobantesImpagos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.ltProperty("pagado", "total"));
        criteria.addOrder(Order.asc("fecha"));
        return (List<Comprobante>) criteria.list();

    }

    public List<Comprobante> getComprobantesImpagosByAdministrador(Consorcio con) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        Integer codigo = con.getCodigo();
        criteria.add(Restrictions.eq("codigoCliente", codigo));
        criteria.add(Restrictions.ltProperty("pagado", "total"));
        criteria.addOrder(Order.asc("fecha"));
        return (List<Comprobante>) criteria.list();
    }

    public Integer getImporteSiguiente() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.addOrder(Order.desc("codigo"));
        List<Comprobante> importes = (List<Comprobante>) criteria.list();
        Integer codigo;
        if (importes != null && !importes.isEmpty()) {
            codigo = 0; //importes.get(0).getCodigo() + 1;
        } else {
            codigo = 1;
        }
        return codigo;
    }

    public List<Comprobante> getAllImportesActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getAllImportesInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesEntrFechasByTitular(TitularCuit titular, Date de, Date al) {
        String cuit = titular.getCuit();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("cuitTitular", cuit));
//        criteria.add(Restrictions.eq("letra", "C"));
//        criteria.add(Restrictions.eq("original", true));
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.addOrder(Order.asc("numero"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesOriginalEntrFechasByTitular(TitularCuit titular, Date de, Date al) {
        String cuit = titular.getCuit();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("cuitTitular", cuit));
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.add(Restrictions.eqOrIsNull("original", true));
        criteria.addOrder(Order.asc("numero"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesEntreFechasByConsorcio(Consorcio consorcio, Date de, Date al) {
        Integer codigo = consorcio.getCodigo();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("codigoCliente", codigo));
        criteria.add(Restrictions.between("fecha", de, al));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesByConsorcio(Consorcio consorcio) {
        Integer codigo = consorcio.getCodigo();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("codigoCliente", codigo));
        criteria.addOrder(Order.desc("id"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesByConsorcioAndRubro(Consorcio consorcio, Rubro rubro) {
        Integer codigo = consorcio.getCodigo();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("codigoCliente", codigo));
        criteria.add(Restrictions.eq("rubro", rubro));
        criteria.add(Restrictions.eq("tipoEmision", 2));
        criteria.addOrder(Order.desc("id"));
        return (List<Comprobante>) criteria.list();
    }

    public List<Comprobante> getComprobantesEntreFechasSinPdf(Date de, Date al) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("pdfGenerado", false));
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.addOrder(Order.asc("fecha"));
        return (List<Comprobante>) criteria.list();
    }

    public Comprobante getComprobanteByNro(Integer numero, Integer tipoDoc) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Comprobante factura = null;
        int ntd = 11;
        if (tipoDoc == 2) {
            ntd = 13;
        }
        factura = (Comprobante) session.createCriteria(Comprobante.class)
                .add(Restrictions.eq("numero", numero))
                .add(Restrictions.eq("tipoDoc", ntd))
                //.addOrder(Order.asc("numero"))
                .uniqueResult();
//        System.out.println(factura);
        return factura;
    }

    public List<Comprobante> getAllComprobantesByNro(Integer numero) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        List<Comprobante> facturas = null;
        facturas = (List<Comprobante>) session.createCriteria(Comprobante.class)
                .add(Restrictions.eq("numero", numero))
                .list();
        return facturas;
    }

    public List<Comprobante> getAllComprobantesAsignadosPorIdOriginal(Long id) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        List<Comprobante> facturas = null;
        facturas = (List<Comprobante>) session.createCriteria(Comprobante.class)
                .add(Restrictions.or(
                        Restrictions.eq("id_original", id),
                         Restrictions.eq("id", id))
                )
                        .list();
        return facturas;
    }

    public Comprobante getComprByNroSucAndTipo(Integer numero, Integer suc, Integer tipo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Comprobante factura = null;
        factura = (Comprobante) session.createCriteria(Comprobante.class)
                .add(Restrictions.eq("numero", numero))
                .add(Restrictions.eq("sucursal", suc))
                .add(Restrictions.eq("codigoComprobante", tipo))
                .add(Restrictions.eq("original", true))
                //.addOrder(Order.asc("numero"))
                .uniqueResult();
//        System.out.println(factura);
        return factura;
    }

//    public List<Administrador> getAllAdministradoresInactivos() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Administrador.class);
//        criteria.add(Restrictions.eq("activo", false));
//        criteria.addOrder(Order.asc("razonSocial"));
//        return (List<Administrador>) criteria.list();
//    }
//
//    public Integer getCodigoSiguiente() {
//        Integer codigo = 0;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Administrador.class);
//        criteria.addOrder(Order.desc("codigo"));
//        List<Administrador> administradores = (List<Administrador>) criteria.list();
//        if (administradores != null && !administradores.isEmpty()) {
//            Administrador admin = administradores.get(0);
//            codigo = admin.getCodigo();
//        }
//        return codigo;
//    }
    public List<Comprobante> getComprobanteByNroAndTitular(Integer numero, String cuitTitular, Long idAdmin) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("numero", numero));
        criteria.add(Restrictions.eq("cuitTitular", cuitTitular));
        criteria.add(Restrictions.eq("codigoComprobante", 11));
        criteria.add(Restrictions.eq("id_administrador", idAdmin));
        List<Comprobante> facturas = null;
        facturas = (List<Comprobante>) criteria.list();
        return facturas;
    }
}
