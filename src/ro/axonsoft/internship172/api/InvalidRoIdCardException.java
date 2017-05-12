package ro.axonsoft.internship172.api;

/**
 * Created by mihai on 4/29/2017.
 */
public class InvalidRoIdCardException extends Exception {
    public InvalidRoIdCardException(Exception ex){
        super(ex);
    }

    public InvalidRoIdCardException(String m,Exception e){super(m,e);}
    public InvalidRoIdCardException(String mes){super(mes);}
}
