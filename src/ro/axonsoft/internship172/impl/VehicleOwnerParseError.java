package ro.axonsoft.internship172.impl;

import java.io.Serializable;

/**
 * Created by mihai on 4/30/2017.
 */

/**
 * clasa care va cuprinde erorile din fisierul de intrare
 */
public class VehicleOwnerParseError implements Serializable{
    private Integer line;
    private Integer type;

    public VehicleOwnerParseError(Integer line, Integer type){
        this.line = line;
        this.type = type;
    }

    public void addError(Integer line, Integer type){
        this.line = line;
        this.type = type;
    }
    @Override
    public String toString(){
        return "line:" + line + " type: " + type;
    }
}
