package ro.axonsoft.internship172.api;

/**
 * Created by mihai on 4/29/2017.
 */

/**
 * parser-ul de numere de inmatriculare
 */
public interface RoRegPlateParser {
    RoRegPlateProperties parseRegistrationPlate(String registrationPlate) throws InvalidRoRegPlateException;
}
