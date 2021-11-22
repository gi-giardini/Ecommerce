/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamentos.Cliente;
import Mapeamentos.HibernateUtil;
import java.math.BigDecimal;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Giovana Borges
 */
public class CadastroClienteDAO extends DAOGenerico<Cliente, BigDecimal> {
    public boolean salvar(Cliente cliente){
        Session s = this.getSession();
        try{
            cliente.setIsAdmin(false);
            s.beginTransaction();
            this.save(cliente);
            
            s.getTransaction().commit();
            
            return true;
        }catch(HibernateException e){
            s.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean deletar(Cliente cliente){
        Session s = HibernateUtil.getSession();
        
        try{
            s.beginTransaction();
            this.delete(cliente);
            
            s.getTransaction().commit();
            
            return true;
        }catch(HibernateException e){
            s.getTransaction().rollback();
            return false;
        }
    }
    
    public Cliente getClienteByCpf(String cpf){
        Session s = this.getSession();
        Cliente cliente = null;
        
        try{
            s.beginTransaction();              
            Query q = s.createQuery("from Cliente where cpf = :cpf");//chave(com "") e valor recebido(com :)
            q.setString("cpf", cpf);
            cliente = findOne(q);
            s.close();
        }catch (HibernateException e){
            e.printStackTrace();
            s.getTransaction().rollback();
            s.close();
        }
        
        return cliente;
    }
    
    public Cliente getClienteByEmail(String email){
        Session s = this.getSession();
        Cliente cliente = null;
        
        try{
            s.beginTransaction();              
            Query q = s.createQuery("from Cliente where email = :email");//chave(com "") e valor recebido(com :)
            q.setString("email", email);
            cliente = findOne(q);
            s.close();
        }catch (HibernateException e){
            e.printStackTrace();
            s.getTransaction().rollback();
            s.close();
        }
        
        return cliente;
    }
    
    public Cliente getClienteBySenha(String senha){
        Session s = this.getSession();
        Cliente cliente = null;
        
        try{
            s.beginTransaction();              
            Query q = s.createQuery("from Cliente where senha = :senha");//chave(com "") e valor recebido(com :)
            q.setString("senha", senha);
            cliente = findOne(q);
            s.close();
        }catch (HibernateException e){
            e.printStackTrace();
            s.getTransaction().rollback();
            s.close();
        }
        
        return cliente;
    }
}


