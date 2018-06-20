package it.dstech.SuperMarket.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(method=RequestMethod.GET, value="/findOne")
	public CartaCredito findOne(@PathVariable("id")Long id) throws Exception {
		return serviceCartaCredito.findOne(id);
	}
	@RequestMapping(method=RequestMethod.GET, value="/findAll")
	public Iterable<CartaCredito> findAll(){
		return serviceCartaCredito.findAll();
	}
	@RequestMapping(method=RequestMethod.POST, value="/create")
	public CartaCredito create(@RequestBody CartaCredito carta) {
			return serviceCartaCredito.create(carta);
	}
	@RequestMapping(method=RequestMethod.POST, value="/update")
	public CartaCredito update(@RequestBody CartaCredito carta) throws Exception {
		return serviceCartaCredito.update(carta);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteOne")
	public void deleteOne(@RequestParam("idCarta") Long idCarta) {
		serviceCartaCredito.deleteOne(idCarta);
	}
}
