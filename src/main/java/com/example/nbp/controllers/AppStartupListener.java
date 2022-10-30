package com.example.nbp.controllers;

import com.example.nbp.entities.Nbp;
import com.example.nbp.repositories.NbpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AppStartupListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private NbpRepository nbpRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        for (Nbp nbp : nbpRepository.findAll()){
            String convertFrom = nbp.convertFrom;
            String convertTo = nbp.convertTo;
            Double rateFrom = Double.valueOf(AppController.getNbpExchageRate(convertFrom));
            Double rateTo = Double.valueOf(AppController.getNbpExchageRate(convertTo));
            nbp = nbp.recalculate(nbp, rateTo, rateFrom);
            nbpRepository.save(nbp);
        }
        System.out.println("onApplicationEvent");
    }
}
