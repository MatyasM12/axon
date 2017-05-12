package ro.axonsoft.internship172.impl;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import ro.axonsoft.internship172.api.InvalidRoIdCardSeriesException;
import ro.axonsoft.internship172.api.Judet;
import ro.axonsoft.internship172.api.RoIdCardSeriesJudMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mihai on 4/29/2017.
 */
public class RoIdCardSeriesJudMapperImpl implements RoIdCardSeriesJudMapper{
    @Override
    public Judet mapIdCardToJudet(String idCardSeries) throws InvalidRoIdCardSeriesException, YamlException {
        String serie = idCardSeries.substring(0,2).toUpperCase();
        YamlReader reader = null;
        try {
            URL u = new URL(System.getProperty("ro.axonsoft.internship.jcis.url") );
            reader = new YamlReader(new FileReader(new File(u.getFile() )));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Object object = reader.read();
        Map map = (Map)object;
        String judet = (String)getKeyFromValue(map,serie);
        if(judet != null)
            return Judet.valueOf(judet);
        else
            throw new InvalidRoIdCardSeriesException("Serie invalida!");
    }

    /**
     *Verifica daca valoarea data value este prezenta in Map-ul hm si returneaza judetul careia ii este asociat
     * @param hm - Map, value - Object
     * @return null daca judetul nu exista in Map, judetul in cazul in care exista
     */
    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            Object oo = hm.get(o);
            List myList = (ArrayList) oo;
            if (myList.contains(value))
                return o;
        }
        return null;
    }
}
