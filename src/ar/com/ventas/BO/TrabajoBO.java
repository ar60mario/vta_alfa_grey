/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.TrabajoDAO;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.RenglonTrabajo;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Servicio;
import ar.com.ventas.entities.Trabajo;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.substring;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class TrabajoBO {

    private final TrabajoDAO dao = new TrabajoDAO();
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
    private final DecimalFormat sdd = new DecimalFormat("00");
    private final DecimalFormat sdy = new DecimalFormat("0000");

    private static final Logger logger = Logger.getLogger("TrabajoBO");

    public List<Trabajo> getAllTrabajosActivos() throws Exception {
        List<Trabajo> trabajos = null;
        try {
            trabajos = dao.getAllTrabajosActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public List<Trabajo> getAllTrabajosActivosNoFacturados() throws Exception {
        List<Trabajo> trabajos = null;
        try {
            trabajos = dao.getAllTrabajosActivosNoFacturados();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public List<Trabajo> getTrabajosByCertificadosPendientes() throws Exception {
        List<Trabajo> trabajos = null;
        List<Trabajo> trabs = new ArrayList<>();
        try {
            trabajos = dao.getTrabajosByCertificadosPendientes();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        for (Trabajo t : trabajos) {
            RenglonTrabajo rt = null;
            rt = new RenglonTrabajoBO().getLaboratorioRecibidoByTrabajoActivo(t);
            if (rt != null) {
                trabs.add(t);
            }
        }
        return trabs;
    }

    public List<Trabajo> getTrabajosByCertificadosEmitido(Consorcio consorcio) throws Exception {
        List<Trabajo> trabajos = null;
        try {
            trabajos = dao.getTrabajosByCertificadosEmitido(consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }

        return trabajos;
    }

    public List<Trabajo> getTrabajosParaCertificados() throws Exception {
        List<Trabajo> trabajos = null;
        try {
            trabajos = dao.getTrabajosParaCertificados();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajos;
    }

    public List<Trabajo> getTrabajosByRubroActivos(Rubro rubro) throws Exception {
        List<Trabajo> trabajos = null;
        try {
            trabajos = dao.getTrabajosByRubroActivos(rubro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajos;
    }

    public Trabajo getTrabajoByConsorcioAndServicio(Consorcio consorcio, Servicio servicio) throws Exception {
        Trabajo trabajo = null;
        try {
            trabajo = dao.getTrabajoByConsorcioAndServicio(consorcio, servicio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajo;
    }

    public List<Trabajo> getTrabajosByConsorcioAndServicio(Consorcio consorcio, Servicio servicio) throws Exception {
        List<Trabajo> trabajos = null;
        try {
            trabajos = dao.getTrabajosByConsorcioAndServicio(consorcio, servicio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajos;
    }

    public List<Trabajo> getTrabajosByConsorcioActivos(Consorcio consorcio) throws Exception {
        List<Trabajo> trabajos = null;
        try {
            trabajos = dao.getTrabajosByConsorcioActivos(consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajos;
    }

    public List<Trabajo> getTrabajosByServicioActivos(Servicio servicio) throws Exception {
        List<Trabajo> trabajos = null;
        try {
            trabajos = dao.getTrabajosByServicioActivos(servicio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajos;
    }

    public List<Trabajo> getTrabajosByRubroParaRenovarActivos(Rubro rubro, Date fecha) throws Exception {
        List<Trabajo> trabajos = null;
        List<Trabajo> trabajos2 = new ArrayList<>();
        try {
            trabajos = dao.getTrabajosByRubroParaRenovarActivos(rubro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        if (trabajos != null && !trabajos.isEmpty()) {
            for (Trabajo t : trabajos) {
                Servicio serv = t.getServicio();
                Integer periodicidad = serv.getPeriodicidad();
                int tiempo = periodicidad *30;
                Calendar cal = Calendar.getInstance();
                cal.setTime(t.getFecha());
                cal.add(Calendar.DATE, tiempo);
                Date nf = cal.getTime();
                if (nf.before(fecha)){
                    trabajos2.add(t);
                }
            }
        }

        return trabajos2;
    }

    public List<Trabajo> getTrabajosByServicioActivosTerminados(Servicio servicio) throws Exception {
        List<Trabajo> trabajos = null;
        try {
            trabajos = dao.getTrabajosByServicioActivosTerminados(servicio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajos;
    }

    public List<Trabajo> getAllTrabajosInactivos() throws Exception {
        List<Trabajo> trabajos = null;
        try {
            trabajos = dao.getAllTrabajosInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajos;
    }

    public Trabajo saveTrabajo(Trabajo trabajo) throws Exception {
        try {
            dao.save(trabajo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajo;
    }

    public void saveTrabajoCompleto(Trabajo trabajo, List<RenglonTrabajo> renglones) throws Exception {
        Trabajo srv = null;
        try {
            srv = (Trabajo) dao.save(trabajo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        for (RenglonTrabajo rs : renglones) {
            rs.setTrabajo(srv);
            new RenglonTrabajoBO().saveRenglonTrabajo(rs);
        }
        return;
    }

    public void updateTrabajoCompleto(Trabajo trabajo, List<RenglonTrabajo> renglones) throws Exception {
        Trabajo srv = null;
        try {
            srv = (Trabajo) dao.update(trabajo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        for (RenglonTrabajo rs : renglones) {
            rs.setTrabajo(srv);
            new RenglonTrabajoBO().updateRenglonTrabajo(rs);
        }
        return;
    }

    public void saveTrabajoAndRenglones(Trabajo trabajo, List<RenglonTrabajo> renglones) throws Exception {

        try {
            dao.save(trabajo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return;
    }

    public Trabajo updateTrabajo(Trabajo trabajo) throws Exception {
        try {
            dao.update(trabajo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajo;
    }

    public void deleteTrabajo(Trabajo trabajo) throws Exception {
        try {
            dao.delete(trabajo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public List<Trabajo> getTrabajosActivosByPeriodo(Date fecha1, Date fecha2) throws Exception {
        List<Trabajo> trabajos = null;
        try {
            trabajos = dao.getTrabajosActivosByPeriodo(fecha1, fecha2);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return trabajos;
    }
}
