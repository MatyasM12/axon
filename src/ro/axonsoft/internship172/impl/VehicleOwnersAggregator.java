package ro.axonsoft.internship172.impl;

import ro.axonsoft.internship172.api.Judet;
import ro.axonsoft.internship172.api.RoRegPlateProperties;
import ro.axonsoft.internship172.api.VehicleOwnerRecord;

import java.io.Serializable;
import java.util.*;

/**
 * Created by mihai on 4/29/2017.
 */
public class VehicleOwnersAggregator implements Serializable {
    private Date referenceDate;
    private int nrPar = 0, nrImpar = 0, passedRegChangeDueDate=0;
    float oddToEvenRatio;
    private Map<Judet, Integer> unregCarsCountByJud = new HashMap<>();
    private List<VehicleOwnerParseError> errors = new ArrayList<>();
    public VehicleOwnersAggregator(Date referenceDate){
        this.nrImpar = 0;
        this.nrPar = 0;
        this.referenceDate = referenceDate;
        this.passedRegChangeDueDate = 0;
        for(Judet e : Judet.values())
            unregCarsCountByJud.put(e, 0);
    }

    public VehicleOwnersAggregator aggregate(VehicleOwnerRecord record){
        RoRegPlateProperties regPlateProps = record.getRegPlate();
        Short digits = record.getRegPlate().getDigits();
        Judet judetOwner = record.getIdCard().getJudet();
        Judet judetCar = record.getRegPlate().getJudet();
        Date idCardIssueDate = record.getIdCardIssueDate();
        int diffInDays = (int)( (referenceDate.getTime() - idCardIssueDate.getTime())
                / (1000 * 60 * 60 * 24) );
        if(judetOwner != judetCar && judetCar != null && judetOwner != null && diffInDays > 30)
            passedRegChangeDueDate += 1;
        if(digits == 0){
            if(regPlateProps.getLetters().equals("Numar Strain"))
                unregCarsCountByJud.put(record.getIdCard().getJudet(), unregCarsCountByJud.get(record.getIdCard().getJudet())+1);
        }
        else if(digits % 2 == 0)
            nrPar += 1;
            else
                nrImpar += 1;
        if(nrPar > 0)
            oddToEvenRatio = Math.round(((float)nrImpar*100/nrPar));
        return new VehicleOwnersAggregator(referenceDate);
    }
    public void addError(VehicleOwnerParseError err){
        errors.add(err);
    }
    @Override
    public String toString(){
        return "Par: " + nrPar + " Impar: " + nrImpar + "\n" +
                "Raport Impar/Par: " + oddToEvenRatio + "\n" + "passedRegChangeDueDate : " + passedRegChangeDueDate +" \nunregCarsCountByJud: \n"+ unregCarsCountByJud + "\nErrors: " + errors;

    }

}
