package ro.axonsoft.internship172.impl;

import ro.axonsoft.internship172.api.RoIdCardProperties;
import ro.axonsoft.internship172.api.RoRegPlateProperties;
import ro.axonsoft.internship172.api.VehicleOwnerRecord;

import java.util.Date;

/**
 * Created by mihai on 4/29/2017.
 */
public class VehicleOwnerRecordImpl implements VehicleOwnerRecord {
    private RoIdCardProperties idProperties;
    private RoRegPlateProperties regProperties;
    Date cardIssueDate;

    public VehicleOwnerRecordImpl(RoIdCardProperties idProperties, RoRegPlateProperties regProperties, Date cardIssueDate){
        this.idProperties = idProperties;
        this.regProperties = regProperties;
        this.cardIssueDate = cardIssueDate;
    }

    @Override
    public RoIdCardProperties getIdCard() {
        return idProperties;
    }

    @Override
    public RoRegPlateProperties getRegPlate() {
        return regProperties;
    }

    @Override
    public Date getIdCardIssueDate() {
        return cardIssueDate;
    }
}
