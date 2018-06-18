package it.dstech.SuperMarket.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.SuperMarket.repository.ICartaCreditoRepository;

@Service
public class CartaCreditoService {

	@Autowired
	public ICartaCreditoRepository cartaCreditoRepository;
	
}
