package it.dstech.SuperMarket.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.SuperMarket.service.ProdottoService;
import it.dstech.SuperMarket.service.StoricoService;

@RestController 
@RequestMapping("/prodotto")
public class ProdottoCtrl {

	@Autowired 
	private ProdottoService prodottoService;
	@Autowired 
	private StoricoService storicoService;
	
	
}
