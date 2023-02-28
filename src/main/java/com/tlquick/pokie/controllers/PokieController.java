package com.tlquick.pokie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView homePage() {
		pokie.reset();
		repository.save(pokie);
		playerRepository.save(pokie.getPlayer());
		return getModelAndView();
	}

	@GetMapping("/")
	public ModelAndView viewHomePage() {
		return getModelAndView();
	}

	@GetMapping("/addCredit")
	public ModelAndView addCredit() {
		pokie.getPlayer().updateBalance(20);
		repository.save(pokie);
		playerRepository.save(pokie.getPlayer());
		return getModelAndView();
	}
	@GetMapping("/credits/{id}") 
	  public ModelAndView credits(@PathVariable int id) { 
		  pokie.getPlayer().setBet(id); 
		  repository.save(pokie);
		  playerRepository.save(pokie.getPlayer());
		  return  getModelAndView();
	  }
	  @GetMapping("/lines/{id}") 
	  public ModelAndView lines(@PathVariable int id) { 
		  pokie.betLines(id); 
		  repository.save(pokie);
		  playerRepository.save(pokie.getPlayer());
		  return  getModelAndView();
	  }

	@GetMapping("/collect")
	public ModelAndView collect() {
		pokie.getPlayer().collect();
		repository.save(pokie);
		playerRepository.save(pokie.getPlayer());
		return getModelAndView();
	}

	@GetMapping("/spin")
	public ModelAndView spin() {
		if (pokie.getPlayer().canBet(pokie.getBetLines())) {
			pokie.spin();
			pokie.payOut();
		}
		repository.save(pokie);
		playerRepository.save(pokie.getPlayer());
		return getModelAndView();
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
	public ModelAndView getModelAndView()
	  {
		  ModelAndView mav = new ModelAndView("index");
		  mav.addObject("playerBalance", pokie.getPlayer().getBalance()); 
		  mav.addObject("turnOver", pokie.turnover());
		  mav.addObject("payOuts", pokie.payouts());
		  mav.addObject("spins", pokie.getSpins());
		  mav.addObject("betLines", pokie.getBetLines());
		  mav.addObject("bet", pokie.getPlayer().getBet());
		  mav.addObject("msg", pokie.getMsg());
		  mav.addObject("images", pokie.getLines().getResultImages());
		  return  mav; 
	  }

	@GetMapping("/stop")
	public void stop() {
		repository.save(pokie);
		playerRepository.save(pokie.getPlayer());
		System.exit(0);
	}

}
