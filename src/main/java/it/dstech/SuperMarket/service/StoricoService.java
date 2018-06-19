package it.dstech.SuperMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.SuperMarket.model.Storico;
import it.dstech.SuperMarket.model.User;
import it.dstech.SuperMarket.repository.IStoricoRepository;

@Service
public class StoricoService {
	
	@Autowired
	private IStoricoRepository storicoRepository;
	
	@Autowired
	private UserService userService;
 
	public Storico storicoPerUser(Long idUser) {
		User user = userService.findOne(idUser);
		Storico storicoUser = user.getStorico();
		return storicoUser;
	}
	
}
