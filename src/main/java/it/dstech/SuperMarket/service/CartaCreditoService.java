package it.dstech.SuperMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	public CartaCredito findOne(Long id) throws Exception {
		return cartaCreditoRepository.findById(id).orElseThrow(()-> new Exception());
	}
	
	public Iterable<CartaCredito> findAll() {
		return cartaCreditoRepository.findAll();
	}
	
	public CartaCredito create (CartaCredito carta) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUsername(auth.getName());
		
		List<CartaCredito> listaCarte = user.getListaCarte();
		listaCarte.add(carta);
		carta.setUser(user);
		user.setListaCarte(listaCarte);
		return cartaCreditoRepository.save(carta);
	}
	
	public CartaCredito update (CartaCredito carta) throws Exception {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUsername(auth.getName());
		
		
		CartaCredito cartaDb = findOne(carta.getId());
		cartaDb.setDataScadenza(carta.getDataScadenza());
		cartaDb.setNumero(carta.getNumero());
		cartaDb.setCredito(carta.getCredito());
		cartaDb.setCvv(carta.getCvv());
		cartaDb.setUser(carta.getUser());
		return cartaCreditoRepository.save(cartaDb);
	}
	
	public void deleteOne(Long idCarta) {
		cartaCreditoRepository.deleteById(idCarta);
	}
	
	
}
