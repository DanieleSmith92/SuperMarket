package it.dstech.SuperMarket.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import it.dstech.SuperMarket.model.Storico;

import it.dstech.SuperMarket.service.StoricoService;

@RestController
@RequestMapping ("/storico")
public class StoricoCtrl {

	
	@Autowired
	private StoricoService storicoService;
	@RequestMapping (method=RequestMethod.GET,value="/storicoPerUser")
	public Storico storicoPerUser() {
		return storicoService.storicoPerUser();
	}
	
	
	
	
}
