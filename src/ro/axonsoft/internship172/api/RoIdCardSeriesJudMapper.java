package ro.axonsoft.internship172.api;

import com.esotericsoftware.yamlbeans.YamlException;

/**
 * Created by mihai on 4/29/2017.
 */

/**
 * mapper-ul care asociaza unei serii data sub forma unui string, un judet din Romania
 */
public interface RoIdCardSeriesJudMapper {
    /**
     *
     * @param idCardSeries - seria cartii de identitate data sub forma unui string
     * @return Judetul asociat seriei
     * @throws InvalidRoIdCardSeriesException in cazul in care seria nu corespunde niciunui judet din Romania
     * @throws YamlException in cazul in care apar probleme in parsarea fisierului YAML
     */
    Judet mapIdCardToJudet(String idCardSeries) throws InvalidRoIdCardSeriesException, YamlException;
}
