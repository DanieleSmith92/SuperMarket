package it.dstech.SuperMarket.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.SuperMarket.model.CartaCredito;
import it.dstech.SuperMarket.service.CartaCreditoService;


@RestController
@RequestMapping ("/cartaCredito")
public class CartaCreditoCtrl {

	@Autowired
	CartaCreditoService serviceCartaCredito;

	public CartaCredito findOne(@PathVariable("id")Long id) throws Exception {
		return serviceCartaCredito.findOne(id);
	}
	@RequestMapping(method=RequestMethod.GET, value="/findAll")
	public Iterable<CartaCredito> findAll(){
		return serviceCartaCredito.findAll();
	}
	@RequestMapping(method=RequestMethod.POST, value="/create")
	public CartaCredito create(@RequestParam("carta") CartaCredito carta) {
			return serviceCartaCredito.create(carta);
	}
	@RequestMapping(method=RequestMethod.POST, value="/update")
	public CartaCredito update(@RequestParam("carta")CartaCredito carta) throws Exception {
		return serviceCartaCredito.update(carta);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteOne")
	public void deleteOne(Long idCarta) {
		serviceCartaCredito.deleteOne(idCarta);
	}
}
