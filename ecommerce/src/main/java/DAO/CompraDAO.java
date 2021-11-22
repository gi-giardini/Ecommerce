/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamentos.Cliente;
import Mapeamentos.Compra;
import Mapeamentos.Produto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Giovana Borges
 */
public class CompraDAO extends DAOGenerico<Compra, BigDecimal>{
    public boolean salvar(Compra compra, Date f, int quant, double valor, Cliente cliente, Produto produto){
        Session s = this.getSession();
        try{
            compra.setData(f);
            compra.setQuantCompra(quant);
            compra.setValorTotal(valor);
            compra.setCliente(cliente);            
            compra.setProduto(produto);
                    
            s.beginTransaction();
            this.save(compra);
            
            s.getTransaction().commit();
            
            return true;
        }catch(HibernateException e){
            s.getTransaction().rollback();
            return false;
        }
    }
    
    public List<Compra> getProdutoCompradoById(int cod){
        Session s = this.getSession();
        List<Compra> c = new ArrayList<>();
        
        try {
            s.beginTransaction();
            Query q = s.createQuery("from Compra where produto = :cod");
            q.setInteger("cod", cod);
            c = findMany(q);
            s.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            s.getTransaction().rollback();
            s.close();
        }
        
        return c;
    }
    
    public List<Compra> getHistorico(String cpf) {
        Session s = this.getSession();
        List<Compra> historico = new ArrayList<>();
        
        System.out.println("O cpf do cliente é: "+cpf);
        try {
            s.beginTransaction();
            Query q = s.createQuery("from Compra where cliente = :cpf");
            q.setString("cpf", cpf);
            historico = findMany(q);
            s.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            s.getTransaction().rollback();
            s.close();
        }
        
        return historico;
    }
}