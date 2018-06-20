package it.dstech.SuperMarket.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.SuperMarket.model.Prodotto;
import it.dstech.SuperMarket.model.User;
import it.dstech.SuperMarket.service.ProdottoService;

@RestController 
@RequestMapping("/prodotto")
public class ProdottoCtrl {

	@Autowired 
	private ProdottoService prodottoService;

	@RequestMapping(method = RequestMethod.POST, value = "/saveProdotti")
	public  Iterable<Prodotto> save (@RequestBody Iterable<Prodotto>listaProdotti){
		return prodottoService.save(listaProdotti);	
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne")
	public Prodotto findOne(@RequestParam ("id") Long id) throws Exception {
		return prodottoService.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findAll")
	public Iterable<Prodotto> findAll() {
		return prodottoService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/acquistoProdotti")
	public  User acquistoProdotti( @RequestBody List<Long> listaIdAcquisti, Long idCarta) throws Exception{
		return prodottoService.acquistoProdotti(listaIdAcquisti, idCarta);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/offertaDataScandenza")
	public List<Prodotto> offertaDataScandenza() {
		return prodottoService.offertaDataScandenza();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listaRandom")
	public List<Prodotto> listaRandom (){
		return prodottoService.listaRandom();
	}
}
