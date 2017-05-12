package ro.axonsoft.internship172.api;

import java.util.Date;

/**
 * Created by mihai on 4/29/2017.
 */

/**
 * interfata pentru datele care cuprind cartea de identitate, numarul de inmatriculare a masinii
 * si data la care a fost eliberat buletinul
 */
public interface VehicleOwnerRecord {
    /**
     *
     * @return cartea de identitate sub forma unui obiect de tipul RoIdCardProperties
     * care cuprinde judet, serie si numar
     */
    RoIdCardProperties getIdCard();

    /**
     *
     * @return numarul de inmatriculare a masinii sub forma unui obiect de tipul RoRegPlateProperties
     * care cuprinde judet, numarul si literele din numarul de inmatriculare
     */
    RoRegPlateProperties getRegPlate();

    /**
     *
     * @return data de emitere a cartii de identitate
     */
    Date getIdCardIssueDate();
}
