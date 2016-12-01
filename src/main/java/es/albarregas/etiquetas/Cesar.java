package es.albarregas.etiquetas;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Cesar extends TagSupport{
    
    private String cadena;
    
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    @Override
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        this.cadena = (cadena == null || cadena.length() == 0)?"Hola Mundo JSP":cadena;
        
        return Tag.EVAL_BODY_INCLUDE;
    }
    
    @Override
    public int doEndTag() throws JspException {
        
        Writer out = pageContext.getOut();
        
            for (int i = 0; i < cadena.length(); i++) {
            try {
                out.write(cadena.charAt(i) + " = " + cadena.codePointAt(i)+"\n    ");     
            } catch (IOException ex) {
                Logger.getLogger(Cesar.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        return Tag.EVAL_PAGE;
    }
}
