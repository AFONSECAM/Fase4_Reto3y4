package com.reto2.reto2;


import com.reto2.reto2.Interface.OrdersCrudRepository;
import com.reto2.reto2.Interface.ProductoCrudRepository;
import com.reto2.reto2.Interface.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Reto2Application implements CommandLineRunner {
	@Autowired
	private UserCrudRepository userCrudRepository;
	@Autowired
	private ProductoCrudRepository productoCrudRepository;
	@Autowired
	private OrdersCrudRepository ordersCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(Reto2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userCrudRepository.deleteAll();
		productoCrudRepository.deleteAll();
		ordersCrudRepository.deleteAll();
	}
}
