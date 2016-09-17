package tech.kilocode.flags.data;

import org.springframework.stereotype.Component;
import tech.kilocode.flags.model.Country;

import java.util.*;

/**
 * Created by Kirill on 9/16/2016.
 */
@Component
public class CountryRepository {
    private static List<Country> countries = Arrays.asList(
            new Country("Kenya", "Nairobi", 44_350_000, Arrays.asList(" Swahili",  "English")),
            new Country("Ecuador", "Quito", 15_740_000, Arrays.asList("Spanish")),
            new Country("France", "Paris", 66_030_000, Arrays.asList("French")),
            new Country("India", "New Delhi", 1_252_000_000, Arrays.asList("Hindi", "English")),
            new Country("Italy", "Rome", 59_830_000, Arrays.asList("Italian"))

    );

    public List<Country> getAllCountries(){
        return new ArrayList<>(countries);
    }

    public Country findByName (String name){
        return countries.stream()
                .filter(country -> country.getName()
                        .equalsIgnoreCase(name)).
                        findFirst().
                        orElse(null);
    }

    public List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        Collections.sort(sortedByPopulation);
        Collections.reverse(sortedByPopulation);
        return sortedByPopulation;
    }

    public List<Country> sortByName(){
        List<Country> sortedByName = new ArrayList<>(countries);
        Collections.sort(sortedByName, (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return sortedByName;
    }


}
