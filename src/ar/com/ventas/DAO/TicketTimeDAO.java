/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.TicketTime;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class TicketTimeDAO extends GenericDAO {

    public TicketTime getTicketByTitular(TitularCuit titular) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(TicketTime.class);
        criteria.add(Restrictions.eq("titular", titular));
        return (TicketTime) criteria.uniqueResult();
    }
    /*
    
    
    public List<Cliente> getAllClientes() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("inactivo",false));
        criteria.addOrder(Order.asc("razonSocial"));
        //Criteria criteria1 = criteria.createCriteria("direccion");
        //criteria.addOrder(Order.asc("direccion"));
        criteria.addOrder(Order.asc("codigoMauro"));
        List<Cliente> clientes = (List<Cliente>) criteria.list();
        return clientes;
    }
     */
}
