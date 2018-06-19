package it.dstech.SuperMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.SuperMarket.model.Prodotto;
import it.dstech.SuperMarket.repository.IProdottoRepository;

@Service
public class ProdottoService {
	@Autowired 
	private IProdottoRepository prodottoRepository;

	@Autowired 
	private StoricoService storicoService;

	public Prodotto findOne(Long id) {
		return prodottoRepository.findOne(id);
	}
	public Iterable<Prodotto> findAll() {
		return prodottoRepository.findAll();
	}
	
}
