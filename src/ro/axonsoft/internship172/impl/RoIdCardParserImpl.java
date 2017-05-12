package ro.axonsoft.internship172.impl;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import ro.axonsoft.internship172.api.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mihai on 4/29/2017.
 */

/**
 * clasa care implementeaza interfata RoIdCardParser
 */
public class RoIdCardParserImpl implements RoIdCardParser {

    @Override
    public RoIdCardProperties parseIdCard(String idCard) throws YamlException, InvalidRoIdCardSeriesException, InvalidRoIdCardException {
        String formattedString = idCard.replaceAll("\\s+", "");
        if(formattedString.length() == 8) {
            String serie = formattedString.substring(0, 2).toUpperCase();
            RoIdCardSeriesJudMapper m = new RoIdCardSeriesJudMapperImpl();
            Judet judet = m.mapIdCardToJudet(formattedString);
            int number = Integer.parseInt(formattedString.substring(2,8));
            String s = "asf";
            if(judet != null)
                return new RoIdCardPropertiesImpl(judet, serie, number);
        }
        else{
            throw new InvalidRoIdCardException("Invalid ID card!");
        }
        return null;
    }

}
