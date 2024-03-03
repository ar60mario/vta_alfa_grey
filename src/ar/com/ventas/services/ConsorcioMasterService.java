package ar.com.ventas.services;

import ar.com.ventas.BO.ConsorcioMasterBO;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.ConsorcioMaster;
import ar.com.ventas.entities.Rubro;

import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConsorcioMasterService {

//    public Domicilio getClienteByCodigo(String codigo) throws Exception{
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        Cliente cliente = null;
//        try {
//            cliente = new ClienteBO().getClienteByCodigo(codigo);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return cliente;
//    }
//    
//    public void deleteCliente(Cliente cliente) throws Exception{
//       Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//       Transaction tx = session.beginTransaction();
//       try{
//          new ClienteBO().deleteCliente(cliente);
//          tx.commit();
//       }
//       catch(Exception ex){
//           tx.rollback();
//           throw new Exception (ex);
//       }
//    }
//
//    public Consorcio saveConsorcio(Consorcio consorcio) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            consorcio = new ConsorcioBO().saveConsorcio(consorcio);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return consorcio;
//    }
//    
//    public Integer asignarPagoToConsorcio(Consorcio consorcio, Recibo recibo)  throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        ReciboBO rb = new ReciboBO();
//        CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
//        CuentaCorrienteClienteBO ccBo = new CuentaCorrienteClienteBO();
//        ccc.setComprobante(null);
//        ccc.setFecha(recibo.getFecha());
//        ccc.setDebe(0.0);
//        ccc.setHaber(recibo.getImporte());
//        ccc.setSaldo(consorcio.getSaldo());
//        int value = 1;
//        ccc.setTipoComprobante(4);
//        try {
//            consorcio = new ConsorcioBO().updateConsorcio(consorcio);
//            ccc.setConsorcio(consorcio);
//            recibo = rb.saveRecibo(recibo);
//            ccc.setRecibo(recibo);
//            ccBo.saveCuentaCorrienteCliente(ccc);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            value = 2;
//            throw new Exception(ex);
//        }
//        return value;
//    }
//    
//    public Consorcio updateConsorcio(Consorcio consorcio) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            consorcio = new ConsorcioBO().updateConsorcio(consorcio);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return consorcio;
//    }
//    
//    public Consorcio getConsorcioById(Long idC) throws Exception {
//        Consorcio consorcio = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            consorcio = new ConsorcioBO().getConsorcioById(idC);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return consorcio;
//    }
//    
//    public Consorcio getConsorcioByCodigo(Integer codigo) throws Exception {
//        Consorcio consorcio = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            consorcio = new ConsorcioBO().getConsorcioByCodigo(codigo);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return consorcio;
//    }
//    
    public List<ConsorcioMaster> getAllConsorciosActivos() throws Exception {
        List<ConsorcioMaster> consorcios = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            consorcios = new ConsorcioMasterBO().getAllConsorciosMasterActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return consorcios;
    }

    public void deleteConsorcioActivoMaster(ConsorcioMaster co) throws Exception {
//        ConsorcioMaster consorcio = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ConsorcioMasterBO().deleteConsorcioActivoMaster(co);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public ConsorcioMaster getConsorcioActivoMaster(Consorcio co, Rubro ru, Consorcio coNuevo) throws Exception {
        ConsorcioMaster consorcio = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            consorcio = new ConsorcioMasterBO().getConsorcioActivoMaster(co, ru, coNuevo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return consorcio;
    }
    
    public ConsorcioMaster getConsorcioMasterParaElim(Consorcio co, Rubro ru) throws Exception {
        ConsorcioMaster consorcio = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            consorcio = new ConsorcioMasterBO().getConsorcioMasterParaElim(co, ru);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return consorcio;
    }
    
    public List<ConsorcioMaster> getConsorciosByRubro(Rubro ru, int ord) throws Exception {
        List<ConsorcioMaster> consorcio = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            consorcio = new ConsorcioMasterBO().getConsorciosByRubro(ru, ord);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return consorcio;
    }
    
    public ConsorcioMaster getConsorcioMasterByRubroAndConsorcio(Rubro ru, Consorcio coNuevo) throws Exception {
        ConsorcioMaster consorcio = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        System.out.println(ru);
        System.out.println(coNuevo);
        try {
            consorcio = new ConsorcioMasterBO().getConsorcioMasterByRubroAndConsorcio(ru, coNuevo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return consorcio;
    }

    public void saveConsorcioMaster(ConsorcioMaster consorcio) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ConsorcioMasterBO().saveConsorcioMaster(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public void updateConsorcioMaster(ConsorcioMaster consorcio) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ConsorcioMasterBO().updateConsorcioMaster(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

//    public List<Consorcio> getAllConsorciosActivosByAdministrador(Administrador administrador) throws Exception {
//        List<Consorcio> consorcios = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            consorcios = new ConsorcioBO().getAllConsorciosActivosByAdministrador(administrador);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public List<Consorcio> getAllConsorciosInactivosByAdministrador(Administrador administrador) throws Exception {
//        List<Consorcio> consorcios = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            consorcios = new ConsorcioBO().getAllConsorciosInactivosByAdministrador(administrador);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public List<Consorcio> getAllConsorciosActivosByFiltro(String filtro) throws Exception {
//        List<Consorcio> consorcios = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            consorcios = new ConsorcioBO().getAllConsorciosActivosByFiltro(filtro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public List<Consorcio> getAllConsorciosActivosByNumero(String numero) throws Exception {
//        List<Consorcio> consorcios = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            consorcios = new ConsorcioBO().getAllConsorciosActivosByNumero(numero);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public List<Consorcio> getAllConsorciosInactivos() throws Exception {
//        List<Consorcio> consorcios = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            consorcios = new ConsorcioBO().getAllConsorciosInactivos();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public List<Consorcio> getAllConsorciosInactivosByFiltro(String filtro) throws Exception {
//        List<Consorcio> consorcios = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            consorcios = new ConsorcioBO().getAllConsorciosInactivosByFiltro(filtro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//    
//    public List<Consorcio> getAllConsorciosInactivosByNumero(String numero) throws Exception {
//        List<Consorcio> consorcios = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            consorcios = new ConsorcioBO().getAllConsorciosInactivosByNumero(numero);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return consorcios;
//    }
//
//    public Integer getCodigoSiguiente() throws Exception {
//        Integer codigo;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            codigo = new ConsorcioBO().getCodigoSiguiente();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return codigo;
//    }
//    public List<Cliente> getAllClientesActivos() throws Exception {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            clientes = new ClienteBO().getAllClientesActivos();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//
//    
//    public List<Cliente> getClienteByPagina(int paginaActual) throws Exception{
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            clientes = new ClienteBO().getClienteByPagina(paginaActual);
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    
//    public int getClientesCount() throws Exception{
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        int count = 0;
//        try{
//            count = new ClienteBO().getClientesCount();
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return count;
//    }
//    
//    public List<Cliente> getClienteOrdenado() throws Exception{
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            clientes = new ClienteBO().getClientesOrdenado();
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    
//    public List<Cliente> getClientesByFiltro(String filtro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Cliente> clientes = null;
//        try{
//            clientes = new ClienteBO().getClientesByFiltro(filtro);
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    
//    public List<Cliente> getClientesByFiltroNumerico(String filtro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Cliente> clientes = null;
//        try{
//            clientes = new ClienteBO().getClientesByFiltroNumerico(filtro);
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    //getClientesInactivosByFiltroOrdenado
//    public List<Cliente> getClientesInactivosByFiltroOrdenado(String filtro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Cliente> clientes = null;
//        try{
//            clientes = new ClienteBO().getClientesInactivosByFiltroOrdenado(filtro);
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    
//    public void saveListaClientes(List<Cliente> listaClientes) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new ClienteBO().saveListaClientes(listaClientes);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//    
//    public List<Cliente> getClienteOrdenadoPorNumero() throws Exception{
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            clientes = new ClienteBO().getClientesOrdenadoPorNumero();
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    
//    public List<Cliente> getClienteDeudores() throws Exception{
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            clientes = new ClienteBO().getClientesDeudores();
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    
//    public List<Cliente> getAllClienteConSaldo() throws Exception{
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            clientes = new ClienteBO().getAllClientesConSaldo();
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    
//    public List<Cliente> getByVendedor(Vendedor vendedor) throws Exception{
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Cliente> clientes = null;
//        try {
//            clientes = new ClienteBO().getByVendedor(vendedor);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
}
