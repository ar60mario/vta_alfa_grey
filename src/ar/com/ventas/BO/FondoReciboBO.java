/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.FondoReciboDAO;
import ar.com.ventas.entities.FondoRecibo;
import ar.com.ventas.entities.TitularCuit;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class FondoReciboBO {

    private final FondoReciboDAO dao = new FondoReciboDAO();

    private static final Logger logger = Logger.getLogger("ConsorcioBO");

    public List<FondoRecibo> getAllFondoRecibosActivos() throws Exception {
        List<FondoRecibo> fondos = null;
        try {
            fondos = dao.getAllFondoRecibosActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fondos;
    }

    public List<FondoRecibo> getAllFondoRecibosInactivos() throws Exception {
        List<FondoRecibo> fondos = null;
        try {
            fondos = dao.getAllFondoRecibosInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fondos;
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

    public FondoRecibo saveFondoRecibo(FondoRecibo fondo) throws Exception {
        FondoRecibo fdo;
        try {
            fdo = (FondoRecibo) dao.save(fondo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fdo;
    }
    
    public FondoRecibo updateFondoRecibo(FondoRecibo fondo) throws Exception {
        FondoRecibo fdo;
        try {
            fdo = (FondoRecibo) dao.update(fondo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fdo;
    }
    
    public FondoRecibo getFondoReciboByTitular2(TitularCuit titu) throws Exception {
        FondoRecibo fdo = null;
        try {
            fdo = (FondoRecibo) dao.getFondoReciboByTitular2(titu);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fdo;
    }
    
//    public List<Consorcio> getConsorciosActivosMaster() throws Exception {
//        List<Consorcio> consorcios = null;
//        try {
//            consorcios = dao.getConsorciosActivosMaster();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public List<Consorcio> getAllConsorciosActivosByAdministrador(Administrador administrador) throws Exception {
//        List<Consorcio> consorcios = null;
//        try {
//            consorcios = dao.getAllConsorciosActivosByAdministrador(administrador);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public List<Consorcio> getAllConsorciosInactivosByAdministrador(Administrador administrador) throws Exception {
//        List<Consorcio> consorcios = null;
//        try {
//            consorcios = dao.getAllConsorciosInactivosByAdministrador(administrador);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public Consorcio getConsorcioById(Long idC) throws Exception {
//        Consorcio consorcio = null;
//        try {
//            consorcio = dao.getConsorcioById(idC);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return consorcio;
//    }
//    
//    public Consorcio getConsorcioByCodigo(Integer codigo) throws Exception {
//        Consorcio consorcio = null;
//        try {
//            consorcio = dao.getConsorcioByCodigo(codigo);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return consorcio;
//    }
//    
//    public List<Consorcio> getAllConsorciosActivosByFiltro(String filtro) throws Exception {
//        List<Consorcio> consorcios = null;
//        try {
//            consorcios = dao.getAllConsorciosActivosByFiltro(filtro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public List<Consorcio> getAllConsorciosActivosByNumero(String numero) throws Exception {
//        List<Consorcio> consorcios = null;
//        try {
//            consorcios = dao.getAllConsorciosActivosByNumero(numero);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public List<Consorcio> getAllConsorciosInactivos() throws Exception {
//        List<Consorcio> consorcios = null;
//        try {
//            consorcios = dao.getAllConsorciosInactivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public List<Consorcio> getAllConsorciosInactivosByFiltro(String filtro) throws Exception {
//        List<Consorcio> consorcios = null;
//        try {
//            consorcios = dao.getAllConsorciosInactivosByFiltro(filtro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public List<Consorcio> getAllConsorciosInactivosByNumero(String numero) throws Exception {
//        List<Consorcio> consorcios = null;
//        try {
//            consorcios = dao.getAllConsorciosInactivosByNumero(numero);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    
////    public List<Cliente> getAllClientesActivos() throws Exception {
////        List<Cliente> listClientes = null;
////        try {
////            listClientes = dao.getAllClientesActivos();
////        } catch (HibernateException ex) {
////            throw new Exception(ex);
////        }
////        return listClientes;
////    }
////

//    
//    public Consorcio updateConsorcio(Consorcio consorcio) throws Exception {
//        DomicilioBO domicilioBO = new DomicilioBO();
//        Domicilio domicilio = consorcio.getDomicilio();
//        domicilio = domicilioBO.updateDomicilio(domicilio);
//        consorcio.setDomicilio(domicilio);
//        try {
//            dao.update(consorcio);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return consorcio;
//    }
//
//    public void updateCliente(Cliente cliente) throws Exception {
//
//        // Primero guardo la dirección del administrador.
////        DomicilioBO domicilioBO = new DomicilioBO();        
////        Domicilio domicilioCliente = cliente.getDomicilio();
////        domicilioCliente = domicilioBO.updateDomicilio(domicilioCliente);
////        cliente.setDomicilio(domicilioCliente);
//        try {
//            cliente = (Cliente) dao.update(cliente);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//
//    }
//
//    public List<Cliente> getClienteByPagina(int paginaActual) throws Exception {
//
//        List<Cliente> listadoClientes = null;
//        int start = 0;
//        if (paginaActual > 1) {
//            start = ((paginaActual - 1) * Constantes.MAX_RESULTS) + 1;
//        }
//
//        try {
//            listadoClientes = dao.getAll(Cliente.class, start);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//
//        return listadoClientes;
//
//    }
//
//    public int getClientesCount() throws Exception {
//
//        int cantidad = 0;
//
//        try {
//            cantidad = dao.getCount(Cliente.class);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//
//        return cantidad;
//
//    }
//
//    public void deleteCliente(Cliente cliente) throws Exception {
//
//        try {
//            dao.delete(cliente);
//
//        } catch (HibernateException ex) {
//
//            throw new Exception(ex);
//        }
//    }
//
//    public Cliente getClienteByCodigo(String codigo) throws Exception {
//        Cliente cliente = null;
//        try {
//            cliente = dao.getByCodigo(codigo);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return cliente;
//    }
//
//    public List<Cliente> getClientesOrdenado() throws Exception {
//
//        List<Cliente> listadoClientes = null;
//        try {
//            listadoClientes = dao.getAllClientesOrdenado();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listadoClientes;
//
//    }
//    
//    public List<Cliente> getClientesByFiltro(String filtro) throws Exception {
//        List<Cliente> clientes = null;
//        try {
//            clientes = dao.getClientesByFiltro(filtro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
////getClientesInactivosByFiltroOrdenado
//    public List<Cliente> getClientesInactivosByFiltroOrdenado(String f) throws Exception {
//        List<Cliente> clientes = null;
//        try {
//            clientes = dao.getClientesInactivosByFiltroOrdenado(f);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    
//    public List<Cliente> getClientesByFiltroNumerico(String f) throws Exception {
//        List<Cliente> clientes = null;
//        try {
//            clientes = dao.getClientesByFiltroNumerico(f);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    
//    public void saveListaClientes(List<Cliente> listaClientes) throws Exception {
//        DomicilioBO db = new DomicilioBO();
//
//        if (listaClientes != null && !listaClientes.isEmpty()) {
//            for (Cliente cliente : listaClientes) {
//                Domicilio domicilio = cliente.getDomicilio();
//                try {
//                    domicilio = db.saveDomicilio(domicilio);
//                    cliente.setDomicilio(domicilio);
//                    dao.save(cliente);
//                } catch (HibernateException ex) {
//                    throw new Exception("Ha ocurrido un problema intentando guardar el Cliente.\nPor favor intente nuevamente mas tarde.");
//                }
//            }
//        }
//    }
//
//    public List<Cliente> getClientesOrdenadoPorNumero() throws Exception {
//
//        List<Cliente> listadoClientes = null;
//        try {
//            listadoClientes = dao.getAllClientesOrdenadoPorNumero();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listadoClientes;
//
//    }
//
//    public List<Cliente> getClientesDeudores() throws Exception {
//        List<Cliente> clientes = null;
//        try {
//            clientes = dao.getClientesDeudores();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//
//    public List<Cliente> getAllClientesConSaldo() throws Exception {
//        List<Cliente> clientes = null;
//        try {
//            clientes = dao.getAllClientesConSaldo();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//
//    public List<Cliente> getByVendedor(Vendedor vendedor) throws Exception {
//        List<Cliente> listClientes = null;
//        try {
//            listClientes = dao.getByVendedor(vendedor);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listClientes;
//    }
}
