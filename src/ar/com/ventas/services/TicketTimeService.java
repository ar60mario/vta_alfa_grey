/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.BO.TicketTimeBO;
import ar.com.ventas.entities.TicketTime;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class TicketTimeService {
    
    public TicketTime updateTicket(TicketTime ticket) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new TicketTimeBO().updateTicket(ticket);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ticket;
    }
    
    public TicketTime saveTicket(TicketTime ticket) throws Exception {
        TicketTime tt = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            tt = new TicketTimeBO().saveTicket(ticket);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return tt;
    }
    
    public TicketTime getTicketById(Long id) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        TicketTime ticket = null;
        try {
            ticket = new TicketTimeBO().getTicketById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ticket;
    }
   
    public TicketTime getTicketByTitular(TitularCuit titular) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        TicketTime ticket = null;
        try {
            ticket = new TicketTimeBO().getTicketByTitular(titular);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ticket;
    }
    
}
