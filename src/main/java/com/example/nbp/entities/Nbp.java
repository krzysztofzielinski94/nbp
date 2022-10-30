package com.example.nbp.entities;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Table(name="nbp", schema="public")
public class Nbp {
    public Nbp(){}
    public Nbp(Double baseValue, String convertFrom, String convertTo, Double convertedValue){
        this.baseValue = baseValue;
        this.convertFrom = convertFrom;
        this.convertTo = convertTo;
        this.convertedValue = convertedValue;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public Double baseValue;
    public String convertFrom;
    public String convertTo;
    //public String convertedValue;
    public Double convertedValue;
    public int getId(Nbp savedObject) {
        return savedObject.id;
    }

    public Nbp recalculate(Nbp nbp, Double rateTo, Double rateFrom) {
        Double baseValue = nbp.baseValue;
        String convertFrom = nbp.convertFrom;
        String convertTo = nbp.convertTo;

        nbp.convertedValue = ( baseValue / rateTo) * rateFrom;
        return nbp;
    }
}
