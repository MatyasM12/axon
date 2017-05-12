package ro.axonsoft.internship172;

import ro.axonsoft.internship172.api.*;
import ro.axonsoft.internship172.impl.RoIdCardParserImpl;
import ro.axonsoft.internship172.impl.RoIdCardSeriesJudMapperImpl;
import ro.axonsoft.internship172.impl.RoRegPlateParserImpl;
import ro.axonsoft.internship172.impl.VehicleOwnersProcessorImpl;

import java.io.*;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by mihai on 4/29/2017.
 */

/**
 * Datele se citesc din fisierul date.csv
 * se trimit sub forma unui stream si se prelucreaza in clasa VehicleOwnersProcessor
 * se serielizeaza si se scriu in fisierul out.txt
 * de asemenea datele se afiseaza si pe ecran
 */
public class StartApp {

    public static void main(String[] args) throws IOException, InvalidRoIdCardException, InvalidRoIdCardSeriesException, InvalidRoRegPlateException, ParseException {
        String key = "ro.axonsoft.internship.jcis.url";
        System.setProperty(key, "file:///C:/judet.yml");
        InputStream is = null;
        ObjectOutputStream out = null;
        try{
            is = new FileInputStream("date.csv");
        }catch(Exception e){
            e.printStackTrace();
        }

        Date date = new Date(); //current date, can be changed
        VehicleOwnersProcessor myP = new VehicleOwnersProcessorImpl(new RoIdCardParserImpl(), new RoRegPlateParserImpl(new RoIdCardSeriesJudMapperImpl()), date);

        try {

            FileOutputStream out2 = new FileOutputStream("out.txt");
            out = new ObjectOutputStream(out2);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        myP.process(is, out);
        is.close();
        //oout.close();
    }
}
