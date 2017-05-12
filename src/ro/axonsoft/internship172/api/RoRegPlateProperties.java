package ro.axonsoft.internship172.api;

/**
 * Created by mihai on 4/29/2017.
 */

/**
 * interfata pentru proprietatile numarelor de inmatriculare
 */
public interface RoRegPlateProperties {
    /**
     *
     * @return judetul in care este inmatriculata masina
     */
    Judet getJudet();

    /**
     *
     * @return cifrele numarului de inmatriculare
     */
    Short getDigits();

    /**
     *
     * @return literele numarului de inmatriculare
     */
    String getLetters();
}
