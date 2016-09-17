package tech.kilocode.flags.model;

import java.util.List;

/**
 * Created by Kirill on 9/16/2016.
 */
public class Country implements Comparable {
    private String name;
    private String capital;
    private int population;
    List<String> languages;

    public Country(String name, String capital, int population, List<String> languages) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        return capital != null ? capital.equals(country.capital) : country.capital == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        Country country = (Country) o;
        if(population < country.getPopulation()) return - 1;
        if(population > country.getPopulation()) return 1;
        return 0;
    }
}
