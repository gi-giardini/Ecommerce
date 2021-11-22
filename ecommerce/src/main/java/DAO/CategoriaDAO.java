/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamentos.Categoria;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Giovana Borges
 */
public class CategoriaDAO extends DAOGenerico<Categoria, BigDecimal>{
    public List<Categoria> getCategoria (){
        Session s = this.getSession();
        List<Categoria> categoria = new ArrayList<>();        
        
        try {
            s.beginTransaction();
            Query q = s.createQuery("from Categoria");            
            categoria = findMany(q);
            s.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            s.getTransaction().rollback();
            s.close();
        }
        
        return categoria;
    }
}
