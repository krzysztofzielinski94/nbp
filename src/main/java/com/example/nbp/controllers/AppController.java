package com.example.nbp.controllers;

import com.example.nbp.entities.Nbp;
import com.example.nbp.services.NbpService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.simple.parser.JSONParser;

@RestController
public class AppController {

    @Autowired
    NbpService nbpService;

    @PostMapping(value = "/addValue")
    public String addValue(@RequestBody Nbp nbp){
        String convertFrom = nbp.convertFrom;
        String convertTo = nbp.convertTo;
        Double rateFrom = Double.valueOf(getNbpExchageRate(convertFrom));
        Double rateTo = Double.valueOf(getNbpExchageRate(convertTo));
        nbp = nbp.recalculate(nbp, rateTo, rateFrom);
        return nbpService.addValue(nbp);
    }

    @GetMapping(value = "/getValue/{id}")
    public String getValueBy(@PathVariable Integer id){
        return nbpService.getValue(id);
    }

    @GetMapping(value = "/getnbpdata")
    public String getNbpData(){
        String todayURL = "https://api.nbp.pl/api/exchangerates/tables/A";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(todayURL, String.class);
        return result;
    }

    @GetMapping(value = "/getNbpExchageRate/{iso3code}")
    public static String getNbpExchageRate(@PathVariable String iso3code){
        if (iso3code.equals("PLN")){
            return "1";
        }
        String todayURL = "http://api.nbp.pl/api/exchangerates/rates/a/" + iso3code + "/";
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(todayURL, String.class);
        JSONParser parser = new JSONParser();
        JSONObject json;
        try {
            json = (JSONObject) parser.parse(result);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONArray rates = ((JSONArray) json.get("rates"));
        JSONObject rate = (JSONObject)rates.get(0);
        return rate.get("mid").toString();
    }


}
