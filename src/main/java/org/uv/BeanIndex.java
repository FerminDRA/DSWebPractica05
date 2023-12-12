/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package org.uv;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author fermin
 */
@Named(value = "beanIndex")
@SessionScoped
public class BeanIndex implements Serializable {

    //private Usuario user= new Usuario();
    private Venta venta= new Venta();
    private Date date7;

    public BeanIndex() {
    }
    
//    public Usuario getUser() {
//        return user;
//    }
//
//    public void setUser(Usuario user) {
//        this.user = user;
//    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
    
    public void Guardar() throws SQLException{
        Session session= HibernateUtil.getSession();
        Transaction tr= session.beginTransaction();
        Venta v=new Venta();
        java.util.Date fecha=new java.util.Date();
        v.setFecha(new Date(fecha.getTime()));
        Cliente c= new Cliente();
        c.setIdCliente(1);
        v.setCli(c);
        v.setTotal(new BigDecimal(20));
        session.save(v);
        //session.save(this.user);
        addMessage(FacesMessage.SEVERITY_INFO, "Atencion", "Se conecto");
        tr.commit();
        session.close();
    }
    
    public void addRow(){
        VentaDetalle d1=new VentaDetalle();
        d1.setIdProducto(0);
        d1.setDescripcion("Jabon");
        d1.setPrecio(new BigDecimal("10.2"));
        d1.setCantidad(10);
        venta.getVentaDetalles().add(d1);
        FacesMessage msg = new FacesMessage("New Product added", String.valueOf(d1.getIdProducto()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void Mostrar() throws SQLException{
//        Session session= HibernateUtil.getSession();
//        Transaction tr= session.beginTransaction();
//        
//        int idCli=Integer.parseInt(user.getUsuario());
//        Cliente cliente=session.get(Cliente.class, idCli);
//        if(cliente!=null){
//            List<Venta> ventasCliente=cliente.getVentas();
//            addMessage(FacesMessage.SEVERITY_INFO, "Atencion", "Cliente: No.V:"+ventasCliente.size());
//        }
//        else{
//            addMessage(FacesMessage.SEVERITY_INFO, "Atencion", "No existe");
//        }
//        //session.save(this.user);
//        tr.commit();
//        session.close();
    }
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
}



