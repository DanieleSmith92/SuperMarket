package it.dstech.SuperMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.SuperMarket.model.CartaCredito;
import it.dstech.SuperMarket.model.User;
import it.dstech.SuperMarket.repository.ICartaCreditoRepository;

@Service
public class CartaCreditoService {

	@Autowired
	public ICartaCreditoRepository cartaCreditoRepository;
	
	@Autowired
	private UserService userService;
	
	public CartaCredito findOne(Long id) {
		return cartaCreditoRepository.findOne(id);
	}
	
	public Iterable<CartaCredito> findAll() {
		return cartaCreditoRepository.findAll();
	}
	
	public CartaCredito create (Long idUser , CartaCredito carta) {
		User user = userService.findOne(idUser);
		List<CartaCredito> listaCarte = user.getListaCarte();
		listaCarte.add(carta);
		user.setListaCarte(listaCarte);
		return cartaCreditoRepository.save(carta);
	}
	
	public CartaCredito update (CartaCredito carta) {
		CartaCredito cartaDb = cartaCreditoRepository.findOne(carta.getId());
		cartaDb.setDataScadenza(carta.getDataScadenza());
		cartaDb.setNumero(carta.getNumero());
		cartaDb.setCredito(carta.getCredito());
		cartaDb.setCvv(carta.getCvv());
		cartaDb.setUser(carta.getUser());
		return cartaCreditoRepository.save(cartaDb);
	}
	
	public void deleteOne(Long idCarta) {
		cartaCreditoRepository.delete(idCarta);
	}
	
}
