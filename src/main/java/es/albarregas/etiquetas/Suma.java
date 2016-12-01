/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.etiquetas;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Suma extends TagSupport{
    
    private int numero1;
    private int numero2;


    
    @Override
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        
        try {
            
            out.write("Suma = "+(numero1+numero2));
        } catch (IOException ex) {
            Logger.getLogger(Suma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tag.EVAL_BODY_INCLUDE;
    }
    
        @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    /**
     * @param numero1 the numero1 to set
     */
    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    /**
     * @param numero2 the numero2 to set
     */
    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }
    
    
}
