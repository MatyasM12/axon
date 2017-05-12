package ro.axonsoft.internship172.impl;

import ro.axonsoft.internship172.api.Judet;
import ro.axonsoft.internship172.api.RoRegPlateProperties;

/**
 * Created by mihai on 4/29/2017.
 */
public class RoRegPlatePropertiesImpl implements RoRegPlateProperties {
    private Judet judet;
    private Short digits;
    private String letters;

    public RoRegPlatePropertiesImpl(Judet judet, Short digits, String letters){
        this.judet = judet;
        this.digits = digits;
        this.letters = letters;
    }

    public RoRegPlatePropertiesImpl(){
        this.judet = null;
        this.digits = 0;
        this.letters = "Numar Strain";
    }

    @Override
    public Judet getJudet() {
        return judet;
    }

    @Override
    public Short getDigits() {
        return digits;
    }

    @Override
    public String getLetters() {
        return letters;
    }

    @Override
    public String toString(){
        return "Judetul: " + judet + " Digits: " + digits +" Letters: "  + letters;
    }
}
