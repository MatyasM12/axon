package ro.axonsoft.internship172.api;

/**
 * Created by mihai on 4/29/2017.
 */
public class InvalidRoIdCardSeriesException extends Exception {

    public InvalidRoIdCardSeriesException(Exception ex){
        super(ex);
    }

    public InvalidRoIdCardSeriesException(String m,Exception e){super(m,e);}
    public InvalidRoIdCardSeriesException(String mes){super(mes);}
}
