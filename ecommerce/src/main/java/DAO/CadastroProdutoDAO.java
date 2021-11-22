/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamentos.HibernateUtil;
import Mapeamentos.Produto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

/**
 *
 * @author Giovana Borges
 */
public class CadastroProdutoDAO extends DAOGenerico<Produto, BigDecimal>{
    public boolean salvar(Produto produto, Date f){
        Session s = this.getSession();
        try{
            s.beginTransaction();
            produto.setModificacao(f);
            this.save(produto);
            
            s.getTransaction().commit();
            
            return true;
        }catch(HibernateException e){
            s.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean editar(Produto produto, Date f, int cod){
        Session s = this.getSession();
        try{
            s.beginTransaction();
            produto.setCod(cod);
            produto.setModificacao(f);
            this.save(produto);
            
            s.getTransaction().commit();
            
            return true;
        }catch(HibernateException e){
            s.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean deletar(Produto produto){
        Session s = HibernateUtil.getSession();
        
        try{
            s.beginTransaction();
            this.delete(produto);
            
            s.getTransaction().commit();
            
            return true;
        }catch(HibernateException e){
            s.getTransaction().rollback();
            return false;
        }
    }
    
    public List<Produto> getProdutosRecentes() {
        Session s = this.getSession();
        List<Produto> recentes = null;

        try {
            s.beginTransaction();
            Query q = s.createQuery("from Produto order by modificacao desc, cod asc");
            q.setMaxResults(6);
            recentes = findMany(q);
            s.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            s.getTransaction().rollback();
            s.close();
        }

        return recentes;
    }
    
    public List<Produto> getByCategoria(int idCategoria) {
        Session s = this.getSession();
        List<Produto> pCategoria = new ArrayList<>();
        
        System.out.println("Id da categoria: "+idCategoria);
        try {
            s.beginTransaction();
            Query q = s.createQuery("from Produto where categoria = :idCategoria");
            q.setInteger("idCategoria", idCategoria);
            pCategoria = findMany(q);
            s.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            s.getTransaction().rollback();
            s.close();
        }
        
        return pCategoria;
    }
    
    public List<Produto> getAll (){
        Session s = this.getSession();
        List<Produto> all = new ArrayList<>();        
        
        try {
            s.beginTransaction();
            Query q = s.createQuery("from Produto");            
            all = findMany(q);
            s.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            s.getTransaction().rollback();
            s.close();
        }
        
        return all;
    }
   
    public Produto getProdutoById(int cod){
        Session s = this.getSession();
        Produto p = new Produto();
        
        try {
            s.beginTransaction();
            Query q = s.createQuery("from Produto where cod = :cod");
            q.setInteger("cod", cod);
            p = findOne(q);
            s.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            s.getTransaction().rollback();
            s.close();
        }
        
        return p;
    }
}