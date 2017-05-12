package ro.axonsoft.internship172.impl;

import ro.axonsoft.internship172.api.*;

/**
 * Created by mihai on 4/29/2017.
 */
public class RoRegPlateParserImpl implements RoRegPlateParser{
    private Judet judet;
    private Short number;
    private String letters;
    public RoRegPlateParserImpl(RoIdCardSeriesJudMapper idCardSeriesJudMapper){
        judet = null;
        number = 0;
        letters = null;
    }

    @Override
    public RoRegPlateProperties parseRegistrationPlate(String registrationPlate) throws InvalidRoRegPlateException {
        String formattedString = (registrationPlate.replaceAll("\\s+", "")).toUpperCase();
        if(formattedString.length() == 6){
            try {
                judet = Judet.valueOf(formattedString.substring(0, 1));
                number = Short.parseShort(formattedString.substring(1, 3));
                letters = formattedString.substring(3, 6);
            }catch(Exception ex){
                return new RoRegPlatePropertiesImpl();
            }
        }
        else if(formattedString.length() == 7){
            if(formattedString.charAt(0) == 'B' && Character.isDigit(formattedString.charAt(1))){
                try{
                    judet = Judet.valueOf(formattedString.substring(0,1));
                    number = Short.parseShort(formattedString.substring(1,4));
                    letters = formattedString.substring(4,7);
                }catch(Exception ex){
                    return new RoRegPlatePropertiesImpl();
                }

            }
            else{
                try {
                    judet = Judet.valueOf(formattedString.substring(0, 2));
                    number = Short.parseShort(formattedString.substring(2, 4));
                    letters = formattedString.substring(4, 7);
                }catch(Exception ex){
                    return new RoRegPlatePropertiesImpl();
                }
            }
        }
        else if(formattedString.length() == 8){
            try {
                judet = Judet.valueOf(formattedString.substring(0, 2));
                number = Short.parseShort(formattedString.substring(2, 5));
                letters = formattedString.substring(5, 8);
            }catch(Exception ex){
                return new RoRegPlatePropertiesImpl();
            }
        }
        else
            return new RoRegPlatePropertiesImpl();

        return new RoRegPlatePropertiesImpl(judet, number, letters);
    }
    @Override
    public String toString(){
        return judet + " " + number + " " + letters;
    }
}
