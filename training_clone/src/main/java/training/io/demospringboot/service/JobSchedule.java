package training.io.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import training.io.demospringboot.repository.CustomerRepo;

// co the add them @service hoac @component
@Component
public class JobSchedule {
	@Autowired
	CustomerRepo customerRepo;
	
	@Scheduled(fixedDelay = 5000)
	public void hello() {
		int size = customerRepo.findAll().size();
		System.out.println("hello" + size);
	}
}
