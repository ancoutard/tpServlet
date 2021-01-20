/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp1_servlet_jsp;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 *
 * @author ViJAN
 */
public class CartListener implements HttpSessionAttributeListener {
    
    @Override
    public void attributeAdded(HttpSessionBindingEvent event){
        event.getSession().getServletContext().log("PRODUIT AJOUTE");
    }
    
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event){
        event.getSession().getServletContext().log("PRODUIT RETIRE");
    }
    
    @Override
    public void attributeReplaced(HttpSessionBindingEvent event){
        event.getSession().getServletContext().log("PRODUIT AJOUTE");
    }
}
