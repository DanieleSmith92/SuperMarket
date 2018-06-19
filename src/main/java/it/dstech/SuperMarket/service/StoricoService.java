package it.dstech.SuperMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
 
	public Storico storicoPerUser() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUsername(auth.getName());
		
		Storico storicoUser = user.getStorico();
		return storicoUser;
	}
	
}
