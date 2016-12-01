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

public class Factorial extends TagSupport{
    
    private int numero;
    private int factorial;

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        factorial=1;
        try {
            while ( numero!=0) {
            factorial=factorial*numero;
            numero--;
            }
            out.write("Factorial = "+factorial);
        } catch (IOException ex) {
            Logger.getLogger(Factorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tag.EVAL_BODY_INCLUDE;
    }
    
}
