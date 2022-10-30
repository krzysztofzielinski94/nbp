package com.example.nbp;

import com.example.nbp.controllers.AppController;
import com.example.nbp.entities.Nbp;
import com.example.nbp.repositories.NbpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.nbp.controllers", "com.example.nbp.services"})
@EnableJpaRepositories(basePackages = "com.example.nbp.repositories")
@EntityScan(basePackages = "com.example.nbp.entities")
@EnableScheduling
public class NbpApplication  {
	@Autowired
	private NbpRepository nbpRepository;
	public static void main(String[] args) {
		SpringApplication.run(NbpApplication.class, args);
	}

	//@Scheduled(fixedDelay = 5000, initialDelay = 5000)
	@Scheduled(cron = "0 0 10 * * *")
	public void schedulerAPI(){
		for (Nbp nbp : nbpRepository.findAll()){
			String convertFrom = nbp.convertFrom;
			String convertTo = nbp.convertTo;
			Double rateFrom = Double.valueOf(AppController.getNbpExchageRate(convertFrom));
			Double rateTo = Double.valueOf(AppController.getNbpExchageRate(convertTo));
			nbp = nbp.recalculate(nbp, rateTo, rateFrom);
			nbpRepository.save(nbp);
		}
	}

}
