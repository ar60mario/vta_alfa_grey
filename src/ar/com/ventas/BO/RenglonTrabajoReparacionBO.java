/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.RenglonTrabajoDAO;
import ar.com.ventas.entities.Persona;
import ar.com.ventas.entities.RenglonTrabajo;
import ar.com.ventas.entities.RenglonTrabajoReparacion;
import ar.com.ventas.entities.Trabajo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class RenglonTrabajoReparacionBO {

    private final RenglonTrabajoDAO dao = new RenglonTrabajoDAO();

    private static final Logger logger = Logger.getLogger("RenglonTrabajoBO");

    public List<RenglonTrabajo> getAllRenglonTrabajoActivos() throws Exception {
        List<RenglonTrabajo> renglones = null;
        try {
            renglones = dao.getAllRenglonTrabajoActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglones;
    }

    public List<RenglonTrabajo> getEmpleados() throws Exception {
        List<RenglonTrabajo> renglones = null;
        try {
            renglones = dao.getEmpleados();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglones;
    }

    public List<RenglonTrabajo> getAllRenglonesByTrabajoActivos(List<Trabajo> trabajos) throws Exception {
        List<RenglonTrabajo> renglones = new ArrayList<>();
        List<RenglonTrabajo> renglonTemp = null;
        for (Trabajo trabajo : trabajos) {
            try {
                renglonTemp = dao.getAllRenglonesByTrabajoActivo(trabajo);
            } catch (HibernateException ex) {
                renglones = null;
                throw new Exception(ex);
            }
            for (RenglonTrabajo rt : renglonTemp) {
                renglones.add(rt);
            }
        }
        return renglones;
    }

    public List<RenglonTrabajo> getAllRenglonTrabajoInactivos() throws Exception {
        List<RenglonTrabajo> renglones = null;
        try {
            renglones = dao.getAllRenglonTrabajoInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglones;
    }

    public RenglonTrabajoReparacion saveRenglonTrabajoReparacion(RenglonTrabajoReparacion renglon) throws Exception {
        try {
            dao.save(renglon);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglon;
    }

    public RenglonTrabajo updateRenglonTrabajo(RenglonTrabajo renglon) throws Exception {
        try {
            dao.update(renglon);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglon;
    }

    public void deleteRenglonTrabajo(RenglonTrabajo renglon) throws Exception {
        try {
            dao.delete(renglon);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public List<RenglonTrabajo> getRenglonesByTrabajoActivo(Trabajo trabajo) throws Exception {
        List<RenglonTrabajo> renglones = new ArrayList<>();
        try {
            renglones = dao.getAllRenglonesByTrabajoActivo(trabajo);
        } catch (HibernateException ex) {
            renglones = null;
            throw new Exception(ex);
        }
        return renglones;
    }

    public String getCaracteristicasByTrabajo(Trabajo trabajo) throws Exception {
        String caract = "";
        try {
            caract = dao.getCaracteristicasByTrabajo(trabajo);
        } catch (HibernateException ex) {
            caract = "";
            throw new Exception(ex);
        }
        return caract;
    }

    public String getPendientesByTrabajo(Trabajo trabajo) throws Exception {
        String pendientes;
        try {
            pendientes = dao.getPendientesByTrabajo(trabajo);
        } catch (HibernateException ex) {
            pendientes = "";
            throw new Exception(ex);
        }
        return pendientes;
    }

    public RenglonTrabajo getRenglonLaboratorioByTrabajoActivo(Trabajo trabajo) throws Exception {
        RenglonTrabajo renglones = null;
        try {
            renglones = dao.getRenglonLaboratorioByTrabajoActivo(trabajo);
        } catch (HibernateException ex) {
            renglones = null;
            throw new Exception(ex);
        }
        return renglones;
    }

    public RenglonTrabajo getRenglonFechaByTrabajoActivo(Trabajo trabajo) throws Exception {
        RenglonTrabajo renglones = null;
        try {
            renglones = dao.getRenglonFechaByTrabajoActivo(trabajo);
        } catch (HibernateException ex) {
            renglones = null;
            throw new Exception(ex);
        }
        return renglones;
    }

    public RenglonTrabajo getLaboratorioRecibidoByTrabajoActivo(Trabajo trabajo) throws Exception {
        RenglonTrabajo renglon = null;
        try {
            renglon = dao.getLaboratorioRecibidoByTrabajoActivo(trabajo);
        } catch (HibernateException ex) {
            renglon = null;
            throw new Exception(ex);
        }
        return renglon;
    }

    public List<Persona> getEmpleadosByTrabajo(Trabajo trabajo) throws Exception {
        List<RenglonTrabajo> renglones;
        List<Persona> personas = new ArrayList<>();
        try {
            renglones = dao.getRenglonesByTrabajo(trabajo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        if (renglones != null && !renglones.isEmpty()) {
            for (RenglonTrabajo r : renglones) {
                String dato = r.getContenido();
                if (dato.length() != 0) {
                    Long ide = Long.valueOf(dato);
                    Persona persona = null;
                    persona = new PersonaBO().getPersonaById(ide);
                    personas.add(persona);
                }
            }
        }
        return personas;
    }
}
