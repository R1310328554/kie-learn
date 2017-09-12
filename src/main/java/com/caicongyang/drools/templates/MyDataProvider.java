package com.caicongyang.drools.templates;  
  
import java.util.Iterator;  
import java.util.List;  
  
import org.drools.template.DataProvider;  
  
/** 
 * @author caicongyang1 
 * @version id: Message, v 0.1 16/9/29 обнГ3:06 caicongyang1 Exp $$ 
 */  
public class MyDataProvider implements DataProvider {  
  
    private Iterator<String[]> iterator;  
  
    public MyDataProvider(List<String[]> rows) {  
        this.iterator = rows.iterator();  
    }  
  
    public boolean hasNext() {  
        return iterator.hasNext();  
    }  
  
    public String[] next() {  
        return iterator.next();  
    }  
}  