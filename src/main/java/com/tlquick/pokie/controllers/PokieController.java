package com.tlquick.pokie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tlquick.pokie.models.Pokie;
import com.tlquick.pokie.repositories.PlayerRepository;
import com.tlquick.pokie.repositories.PokieRepository;

@RestController
public class PokieController {
	@Autowired
	private Pokie pokie;

	@Autowired
	PokieRepository repository;
	@Autowired
	PlayerRepository playerRepository;

	@GetMapping("/index")
	public String homePage() {
		pokie.reset();
		repository.save(pokie);
		playerRepository.save(pokie.getPlayer());
		return message();
	}

	@GetMapping("/")
	public String viewHomePage() {
		return "Welcome to Cherry Bomb";
	}

	@GetMapping("/addCredit")
	public String addCredit() {
		pokie.getPlayer().updateBalance(20);
		repository.save(pokie);
		playerRepository.save(pokie.getPlayer());
		return message();
	}
	@GetMapping("/credits/{id}") 
	  public String credits(@PathVariable int id) { 
		  pokie.getPlayer().setBet(id); 
		  repository.save(pokie);
		  playerRepository.save(pokie.getPlayer());
		  return  message();
	  }
	  @GetMapping("/lines/{id}") 
	  public String lines(@PathVariable int id) { 
		  pokie.betLines(id); 
		  repository.save(pokie);
		  playerRepository.save(pokie.getPlayer());
		  return  message();
	  }

	@GetMapping("/collect")
	public String collect() {
		pokie.getPlayer().collect();
		repository.save(pokie);
		playerRepository.save(pokie.getPlayer());
		return message();
	}

	@GetMapping("/spin")
	public String spin() {
		if (pokie.getPlayer().canBet(pokie.getBetLines())) {
			pokie.spin();
			pokie.payOut();
		}
		repository.save(pokie);
		playerRepository.save(pokie.getPlayer());
		return message();
	}

	public String message() {
		String result = "playerBalance " + pokie.getPlayer().getBalance() + "\n";
		result += "turnOver " + pokie.turnover() + "\n";
		result += "spins " + pokie.getSpins() + "\n";
		result += "lines " + pokie.getLines().getResult() + "\n";
		result += "betLines " + pokie.getBetLines() + "\n";
		result += "bet " + pokie.getPlayer().getBet() + "\n";
		result += "msg " + pokie.getMsg() + "\n";
		String[][] images = pokie.getLines().getResultImages();
		result += "images first " + images[0][0];
		return result;
	}

	@GetMapping("/stop")
	public void stop() {
		repository.save(pokie);
		playerRepository.save(pokie.getPlayer());
		System.exit(0);
	}

}
