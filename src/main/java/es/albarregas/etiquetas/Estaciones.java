/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.etiquetas;

import java.io.IOException;
import java.io.Writer;
import static java.lang.System.out;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.Tag;

public class Estaciones extends TagSupport implements DynamicAttributes{
    
    private String mes;
    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        
        switch(String.valueOf(value).toLowerCase()){
            case "primavera":
                this.mes = "prim";
                break;
            case "verano":
                this.mes = "ver";
                break;
            case "otono":
                this.mes = "oto";
                break;
            case "invierno":
                this.mes = "inv";
                break;
            default:
                this.mes = "inv";       
        }   
    }
    @Override
    public int doStartTag(){
        Writer out = pageContext.getOut();
        try {
            out.write("<div class=\""+this.mes+"\">");
        } catch (IOException ex) {
            Logger.getLogger(Estaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tag.EVAL_BODY_INCLUDE;
    }
    
    @Override
    public int doEndTag() {
        Writer out = pageContext.getOut();
        try {
            out.write("</div>");
        } catch (IOException ex) {
            Logger.getLogger(Estaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tag.EVAL_PAGE;
    }


    
}
