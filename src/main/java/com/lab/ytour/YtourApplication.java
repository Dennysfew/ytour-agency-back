package com.lab.ytour;

import com.lab.ytour.tour.Tour;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication

public class YtourApplication {

	public static void main(String[] args) {
		SpringApplication.run(YtourApplication.class, args);
	}


}
