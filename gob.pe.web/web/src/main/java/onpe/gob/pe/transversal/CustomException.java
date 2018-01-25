/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onpe.gob.pe.transversal;

/**
 *
 * @author MHuamani
 */
public class CustomException extends Exception{
    private boolean internalMessage;
    private Object[] parameters;
    
    public CustomException(String message,Object... parameters){     
        super(message);
        this.parameters=parameters;
    }
    
    public CustomException(String message){
        super(message);
    }

    public boolean isInternalMessage() {
        return internalMessage;
    }

    public void setInternalMessage(boolean internalMessage) {
        this.internalMessage = internalMessage;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
