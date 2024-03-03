/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.CategoriaMonotributoDAO;
import ar.com.ventas.entities.CategoriaMonotributo;
import ar.com.ventas.entities.Domicilio;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class CategoriaMonotributoBO {

    private final CategoriaMonotributoDAO dao = new CategoriaMonotributoDAO();

    private static final Logger logger = Logger.getLogger("AdministradorBO");

    public List<CategoriaMonotributo> getAllCategoriasMonotributoActivos() throws Exception {
        List<CategoriaMonotributo> categorias = null;
        try {
            categorias = dao.getAllCategoriasMonotributoActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return categorias;
    }

    public List<CategoriaMonotributo> getAllCategoriasMonotributoInactivos() throws Exception {
        List<CategoriaMonotributo> categorias = null;
        try {
            categorias = dao.getAllCategoriasMonotributoInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return categorias;
    }

    public CategoriaMonotributo getCategoriaByLetraActivo(String letra) throws Exception {
        CategoriaMonotributo categoria = null;
        try {
            categoria = dao.getCategoriaByLetraActivo(letra);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return categoria;
    }

    public CategoriaMonotributo saveCategoriaMonotributo(CategoriaMonotributo categoria) throws Exception {
        try {
            dao.save(categoria);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return categoria;
    }

    public CategoriaMonotributo updateCategoriaMonotributo(CategoriaMonotributo categoria) throws Exception {
        try {
            dao.update(categoria);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return categoria;
    }

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
