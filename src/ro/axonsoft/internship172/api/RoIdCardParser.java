package ro.axonsoft.internship172.api;

import com.esotericsoftware.yamlbeans.YamlException;

/**
 * Created by mihai on 4/29/2017.
 */

/**
 *  Parserul pentru cartile de identitate
 */
public interface RoIdCardParser {
    /** Parseaza un string dat ca si parametru care reprezinta seria si numarul unei carti de identitate
     *
     * @param idCard - string
     * @return RoIdCardProperties - proprietatile definite de un obiect cu atribute seria, judetul si numarul cartii de identitate
     * @throws InvalidRoIdCardException in cazul in care cartea de identitate este invalida
     * @throws YamlException in cazul in care apare o exceptie la parsarea fisierului yaml
     * @throws InvalidRoIdCardSeriesException in cazul in care seria buletinului nu corespunde nici unui judet din Romania
     */
    RoIdCardProperties parseIdCard(String idCard) throws InvalidRoIdCardException, YamlException, InvalidRoIdCardSeriesException;
}
