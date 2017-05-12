package ro.axonsoft.internship172.impl;

import ro.axonsoft.internship172.api.Judet;
import ro.axonsoft.internship172.api.RoIdCardProperties;

/**
 * Created by mihai on 4/29/2017.
 */
public class RoIdCardPropertiesImpl implements RoIdCardProperties {
    private Judet judet;
    private String series;
    private int number;

    public RoIdCardPropertiesImpl(Judet judet, String series, int number){
        this.judet = judet;
        this.series = series;
        this.number = number;
    }
    @Override
    public Judet getJudet() {
        return judet;
    }

    @Override
    public String getSeries() {
        return series;
    }

    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString(){
        return "Judetul: "+ judet + " Seria: " + series + " Numarul: " + number;
    }
}
