/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamentos.Cliente;
import java.math.BigDecimal;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author Giovana Borges
 */
public class LoginDAO extends DAOGenerico<Cliente, BigDecimal>{
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
    
     public Cliente findSenha(String senha, String email){
        Session s = this.getSession();
        Cliente cliente = null;
        
        try{
            s.beginTransaction();              
            Query q = s.createQuery("from Cliente where senha = :senha and email = :email");//chave(com "") e valor recebido(com :)
            q.setString("senha", senha);
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
}
