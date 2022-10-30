package com.example.nbp.services;

import com.example.nbp.entities.Nbp;
import com.example.nbp.repositories.NbpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class NbpServiceImpl implements NbpService {

    @Autowired
    NbpRepository nbpRepository;

    @Override
    public String addValue(Nbp nbp){
        Nbp savedObject = nbpRepository.save(nbp);
        Map<String, Integer> rMap = new HashMap<>();
        nbpRepository.saveAndFlush(savedObject);
        Integer id = savedObject.getId(savedObject);
        System.out.println("Added Value");
        return "{\"id\":" + id + "}";
    }

    @Override
    public String getValue(Integer id){
        DecimalFormat df = new DecimalFormat("0.00");
        return "{\"value\":" + df.format(nbpRepository.findById(id).get().convertedValue) +
                ", " + "\"currency\":" + "\"" + nbpRepository.findById(id).get().convertTo + "\"" + "}";
    }
}
