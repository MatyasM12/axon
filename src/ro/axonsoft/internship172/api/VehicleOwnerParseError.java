package ro.axonsoft.internship172.api;

/**
 * Created by mihai on 4/29/2017.
 */
/**
 * Eroare la o linie din datele de intrare proprietari autovehicule.
 *
 */
public interface VehicleOwnerParseError {
    /**
     * Numărul liniei la care a apărut eroarea.
     */
    Integer getLine();
    /**
     * 0 - invalid line, 1 - invalid CI, 2 - invalid date
     */
    Integer getType();
}
