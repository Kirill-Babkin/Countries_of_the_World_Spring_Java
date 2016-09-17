package tech.kilocode.flags.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.kilocode.flags.data.CountryRepository;
import tech.kilocode.flags.model.Country;

import java.util.List;

/**
 * Created by Kirill on 9/16/2016.
 */
@Controller
public class HomeController {
    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/")
    public String listAll(ModelMap modelMap){
        List<Country> countries = countryRepository.getAllCountries();
        modelMap.put("countries", countries);
        return "index";
    }
    @RequestMapping("/detail/{name}")
    public String showDetails(@PathVariable String name, ModelMap modelMap){
        Country country = countryRepository.findByName(name);
        modelMap.put("country", country);
        return "details";
    }
    @RequestMapping("/bypopulation")
    public String sortByPopulation(ModelMap modelMap){
        List<Country> countries = countryRepository.sortByPopulation();
        modelMap.put("countries", countries);
        return "index";
    }

    @RequestMapping("/byname")
    public String sortByName(ModelMap modelMap){
        List<Country> countries = countryRepository.sortByName();
        modelMap.put("countries", countries);
        return "index";
    }
}
