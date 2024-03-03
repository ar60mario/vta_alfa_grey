/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.RenglonAbonoDAO;
import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.RenglonAbono;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class RenglonAbonoBO {
    RenglonAbonoDAO dao = new RenglonAbonoDAO();
    public List<RenglonAbono> getAllRenglonAbonos() throws Exception{
        try {
            return dao.getAllRenglonAbonos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public RenglonAbono saveRenglonAbono(RenglonAbono abono) throws Exception {
        RenglonAbono ra = null;
        try {
            ra = (RenglonAbono) dao.save(abono);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ra;
    }
    
    public void updateRenglonAbono(RenglonAbono abono) throws Exception {
        try {
            dao.update(abono);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public List<RenglonAbono> getRenglonAbonosByAbono(Abono abono) throws Exception{
        try {
            return dao.getRenglonAbonosByAbono(abono);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public void deleteRenglonAbono(RenglonAbono abono) throws Exception {
        try {
            dao.delete(abono);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
}
