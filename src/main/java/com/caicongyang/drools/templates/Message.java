package com.caicongyang.drools.templates;  
  
import java.io.Serializable;  
  
/**
 */  
public class Message implements Serializable {  
  
    private static final long serialVersionUID = -3168739008574463191L;  
  
    public static final int HELLO = 0;  
    public static final int GOODBYE = 1;  
  
    private String message;  
  
    private int status;  
  
    public String getMessage() {  
        return this.message;  
    }  
  
    public void setMessage(String message) {  
        this.message = message;  
    }  
  
    public int getStatus() {  
        return this.status;  
    }  
  
    public void setStatus(int status) {  
        this.status = status;  
    }  
  
}  