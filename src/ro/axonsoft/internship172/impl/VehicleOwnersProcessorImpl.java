package ro.axonsoft.internship172.impl;

import ro.axonsoft.internship172.api.*;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mihai on 4/29/2017.
 */
public class VehicleOwnersProcessorImpl implements VehicleOwnersProcessor {
    Date referenceDate;
    RoIdCardParser idCardParser;
    RoRegPlateParser regPlateParser;
    public VehicleOwnersProcessorImpl(RoIdCardParser idCardParser, RoRegPlateParser regPlateParser, Date referenceDate){
        this.idCardParser = new RoIdCardParserImpl();
        this.regPlateParser = new RoRegPlateParserImpl(new RoIdCardSeriesJudMapperImpl());
        this.referenceDate = referenceDate;
    }

    @Override
    public void process(InputStream ciCarRegNbInputStream, ObjectOutputStream processResultOutputStream) throws IOException, InvalidRoIdCardException, InvalidRoIdCardSeriesException, InvalidRoRegPlateException, ParseException {
        VehicleOwnersAggregator myAgg = new VehicleOwnersAggregator(referenceDate);
        BufferedReader reader = new BufferedReader(new InputStreamReader(ciCarRegNbInputStream));
        StringBuilder out = new StringBuilder();
        String line;
        int lineNumber = 0;
        while ((line = reader.readLine()) != null) {
            out.append(line);   // add everything to StringBuilder
            lineNumber += 1;
            if((line.split(";")).length >= 3) {
                String idCard = line.split(";")[0];
                Date date1 = isDateValid(line.split(";")[1]);
                if(date1 == null){
                    myAgg.addError(new VehicleOwnerParseError(lineNumber,2));
                }
                else {
                    String regPlate = line.split(";")[2];
                    try{
                          VehicleOwnerRecord myRecord = new VehicleOwnerRecordImpl(idCardParser.parseIdCard(idCard), regPlateParser.parseRegistrationPlate(regPlate), date1);
                          myAgg.aggregate(myRecord);
                    }catch(InvalidRoIdCardException ex){
                        myAgg.addError(new VehicleOwnerParseError(lineNumber, 1));
                    }catch(InvalidRoIdCardSeriesException ex){
                        myAgg.addError(new VehicleOwnerParseError(lineNumber, 1));
                    }
                }
            }
            else{
                myAgg.addError(new VehicleOwnerParseError(lineNumber,0));
            }

        }
        System.out.println(myAgg);

        try {
            processResultOutputStream.writeObject(myAgg);
            processResultOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /** Functie care verifica daca Data este valida
     * @param date - data de verificat sub forma de string
     * @return data - sub forma de java.util.Date daca este valida, null daca nu este valida
     */
    public static Date isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            Date validDate = df.parse(date);
            return validDate;
        } catch (ParseException e) {
            return null;
        }
    }
}
