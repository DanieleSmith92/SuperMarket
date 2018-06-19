package it.dstech.SuperMarket.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.SuperMarket.model.CartaCredito;
import it.dstech.SuperMarket.service.CartaCreditoService;

@RestController
@RequestMapping ("/cartaCredito")
public class CartaCreditoCtrl {

	@Autowired
	CartaCreditoService serviceCartaCredito;
	
	public CartaCredito findOne(@PathVariable("id")Long id) {
		return serviceCartaCredito.findOne(id);
	}
	
	
}
