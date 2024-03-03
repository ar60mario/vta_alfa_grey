/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.TextoPeriodoReparacionDAO;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.TextoPeriodoReparacion;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class TextoPeriodoReparacionBO {

    TextoPeriodoReparacionDAO dao = new TextoPeriodoReparacionDAO();

    public TextoPeriodoReparacion getTextoPeriodoByConsorcioAndRubro(Consorcio co, Rubro ru) throws Exception {
        try {
            return dao.getTextoPeriodoByConsorcioAndRubro(co, ru);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

//    public List<Abono> getAbonoByConsorcioAndRubro(Consorcio co, Rubro ru) throws Exception {
//        try {
//            return dao.getAbonoByConsorcioAndRubro(co, ru);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAbonosByRubroAndCuota(Rubro rubro, Integer cuota) throws Exception {
//        try {
//            return dao.getAbonosByRubroAndCuota(rubro, cuota);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAllAbonosActivosOrdenadoByRubro(Rubro rubro) throws Exception {
//        try {
//            return dao.getAllAbonosActivosOrdenadoByRubro(rubro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAllAbonosInactivosOrdenadoByRubro(Rubro rubro) throws Exception {
//        try {
//            return dao.getAllAbonosInactivosOrdenadoByRubro(rubro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAbonosActivosPendientesOrdenadoByRubro(Rubro rubro) throws Exception {
//        List<Abono> abonos = null;
//        List<Abono> abonos2 = new ArrayList<>();
//        try {
//            abonos = dao.getAbonosActivosPendientesOrdenadoByRubro(rubro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        if (abonos != null && !abonos.isEmpty()) {
//            for (Abono a : abonos) {
//                Date fecha = a.getFechaInicio();
//                int di = a.getCuotas() - a.getCuotaFacturada();
//                if (di > 0) {
////                    if (UtilAbonos.getEstaEnFrecuencia(fecha)) {
//                    abonos2.add(a);
////                    }
////                    System.out.println("x");
//                } else {
////                    System.out.println("T");
//                    if (UtilAbonos.getEstaEnFrecuencia(fecha)) {
//                        
//                    }
//                    Date f2 = new Date();
//                    Date f3 = a.getFechaPeriodo();
//                    int lapso = UtilAbonos.getDiferenciaEntreFechas(f2, f3);
//                    int freq = a.getFrecuencia();
//                    int df = lapso - freq;
//                    if (df < 1) {
//                        abonos2.add(a);
//                    }
////                    System.out.println(f2);
////                    System.out.println(f3);
////                    System.out.println(lapso);
////                    System.out.println(freq);
////                    System.out.println(df);
////                    System.out.println("Y");
//                }
////                System.out.println(a.getConsorcio().getDomicilio().getCalle());
////                System.out.println(a.getConsorcio().getDomicilio().getNumero());
////                System.out.println(a.getCuotas());
////                System.out.println(a.getCuotaFacturada());
////                System.out.println(di);
////                System.out.println("_");
//            }
////            JOptionPane.showMessageDialog(null, "WWW");
//        }
//        return abonos2;
//    }
//
//    public List<Abono> getAbonosActivosPendientesOrdenadoByRubro4(Rubro rubro) throws Exception {
//        List<Abono> abonos = null;
////        List<Abono> abonos2 = new ArrayList<>();
//        try {
//            abonos = dao.getAbonosActivosPendientesOrdenadoByRubro(rubro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//
//    public List<Abono> getAbonosActivosOrdenadosVencidosByRubro(Rubro rubro) throws Exception {
//        try {
//            return dao.getAbonosActivosOrdenadosVencidosByRubro(rubro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAbonosActivosNoFacturados() throws Exception {
//        try {
//            return dao.getAbonosActivosNoFacturados();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public Abono getUltimoAbonoByConsorcioAndRubro(Consorcio co, Rubro rubro) throws Exception {
//        List<Abono> abonos;
//        try {
//            abonos = dao.getUltimoAbonoByConsorcioAndRubro(co, rubro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        if (abonos != null && !abonos.isEmpty()) {
//            Abono ab = abonos.get(0);
//            return ab;
//        } else {
//            return null;
//        }
//    }
//
//    public List<Abono> getAbonosActivosFinalizadosByRubro(Rubro rubro) throws Exception {
//        List<Abono> abonos = null;
//        try {
//            abonos = dao.getAbonosActivosFinalizadosByRubro(rubro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        if (abonos != null && !abonos.isEmpty()) {
//            for (Abono ab : abonos) {
//                Consorcio coNuevo = ab.getConsorcio();
//                Integer codigo = coNuevo.getCodigo();
//                ConsorcioMaster cm = null;
//                cm = new ConsorcioMasterBO().getConsorcioMasterByRubroAndConsorcio(rubro, coNuevo);
//
//            }
//        }
//        return abonos;
//    }
//
//    public List<Abono> getAllAbonosActivosOrdenadoByRubroAndAdministrador(Rubro rubro, Administrador admin) throws Exception {
//        try {
//            return dao.getAllAbonosActivosOrdenadoByRubroAndAdministrador(rubro, admin);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAllAbonosInactivosOrdenadoByRubroAndAdministrador(Rubro rubro, Administrador admin) throws Exception {
//        try {
//            return dao.getAllAbonosInactivosOrdenadoByRubroAndAdministrador(rubro, admin);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAllAbonosActivosOrdenadoByRubroPendientesFacturar(Rubro rubro, Administrador admin) throws Exception {
//        try {
//            return dao.getAllAbonosActivosOrdenadoByRubroPendientesFacturar(rubro, admin);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAllAbonosActivos() throws Exception {
//        try {
//            return dao.getAllAbonosActivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAbonosActivosByRubroAndFiltroConsorcio(String filtro, Rubro rubro) throws Exception {
//        try {
//            return dao.getAbonosActivosByRubroAndFiltroConsorcio(filtro, rubro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public Abono getAbonoById(Long id) throws Exception {
//        try {
//            return dao.getAbonoById(id);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public void saveAbono(Abono abono) throws Exception {
//        try {
//            dao.save(abono);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public void updateAbono(Abono abono) throws Exception {
//        try {
//            dao.update(abono);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
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
//
//    public List<Abono> getAbonosActivosVencidosByFecha(Date fechaConsulta) throws Exception {
//        List<Abono> abono2 = new ArrayList<>();
//        List<Abono> abonos = null;
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMM");
//        Calendar cal = Calendar.getInstance();
//        String periodo1 = sdf2.format(fechaConsulta);
//        String periodo2;
//        cal.setTime(fechaConsulta);
//        cal.set(Calendar.DAY_OF_MONTH, 1);
//        int p1 = Integer.valueOf(periodo1);
//
//        try {
//            abonos = dao.getAbonosActivosVencidosByFecha();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        if (abonos != null && !abonos.isEmpty()) {
//            for (Abono ab : abonos) {
//                periodo2 = sdf2.format(ab.getFechaPeriodo());
//                int p2 = Integer.valueOf(periodo2);
//                if (p2 < p1) {
//                    abono2.add(ab);
//                }
//            }
//        }
//        return abono2;
//    }
//
//    public void updateListaAbonosHabilitados(List<Abono> abonos) throws Exception {
//        if (abonos != null && !abonos.isEmpty()) {
//            for (Abono a : abonos) {
//                a.setPendiente(true);
//                dao.update(a);
//            }
//        }
//    }
}
