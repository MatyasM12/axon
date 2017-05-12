package ro.axonsoft.internship172.api;

/**
 * Created by mihai on 4/29/2017.
 */
public class InvalidRoRegPlateException extends Exception {

    public InvalidRoRegPlateException(Exception ex){
        super(ex);
    }

    public InvalidRoRegPlateException(String m,Exception e){super(m,e);}
    public InvalidRoRegPlateException(String mes){super(mes);}
}
