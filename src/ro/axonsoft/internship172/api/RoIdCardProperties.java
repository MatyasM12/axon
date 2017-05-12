package ro.axonsoft.internship172.api;

/**
 * Created by mihai on 4/29/2017.
 */

/**
 * interfata pentru proprietatile cardului de identitate
 */
public interface RoIdCardProperties {
    /**
     *
     * @return judetul pe baza seriei cartii de identitate
     */
    Judet getJudet();

    /**
     *
     * @return seria cartii de identitate
     */
    String getSeries();

    /**
     *
     * @return numarul cartii de identitate
     */
    Integer getNumber();
}
