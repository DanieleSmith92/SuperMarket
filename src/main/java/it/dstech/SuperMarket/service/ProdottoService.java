package it.dstech.SuperMarket.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.SuperMarket.model.CartaCredito;
import it.dstech.SuperMarket.model.Categoria;
import it.dstech.SuperMarket.model.Prodotto;
import it.dstech.SuperMarket.model.Storico;
import it.dstech.SuperMarket.model.User;
import it.dstech.SuperMarket.repository.IProdottoRepository;
import it.dstech.SuperMarket.repository.IUserRepository;

@Service
public class ProdottoService {
	@Autowired 
	private IProdottoRepository prodottoRepository;
	@Autowired
	private IUserRepository userRepository;
	@Autowired 
	private StoricoService storicoService;
	@Autowired
	private CartaCreditoService cartaCreditoService;

	@Autowired 
	private UserService userService;

	public  Iterable<Prodotto> save (Iterable<Prodotto>listaProdotti){
		return prodottoRepository.save(listaProdotti);	
	}




	public Prodotto findOne(Long id) {
		return prodottoRepository.findOne(id);
	}
	public Iterable<Prodotto> findAll() {
		return prodottoRepository.findAll();
	}
	public List<Prodotto>prodottiDisponibili(){
		List<Prodotto>listaProdottiDisponibili = new ArrayList<>();
		List<Prodotto>listaProdotti =(List<Prodotto>) prodottoRepository.findAll();
		for(Prodotto prodotto: listaProdotti) {
			if(prodotto.getQuantitaDisponibile() > 0 ) {
				listaProdottiDisponibili.add(prodotto);

			}
		}
		return listaProdottiDisponibili;

	}

	public List<Prodotto>listaProdottiCategoria (Categoria categoria){
		List<Prodotto>listaProdotti = (List<Prodotto>) prodottoRepository.findAll();
		List<Prodotto>listaProdottiCateg =new ArrayList<>();
		for(Prodotto prodotto:listaProdotti) {
			if(prodotto.getCategoria().equals(categoria)) {
				listaProdottiCateg.add(prodotto);

			}
		}
		return listaProdottiCateg;
	}

	public  User acquistoProdotti(List<Prodotto>listaAcquisti, Storico storico,Long idUser, Long idCarta , List<String> nomeProdotto, int quantitaDaComprare){
		List<Prodotto>listaProdotti = (List<Prodotto>) prodottoRepository.findAll();
		User user = userService.findOne(idUser);
		CartaCredito cartaUtente = cartaCreditoService.findOne(idCarta);
		List<Prodotto> listaOffertaRandom = listaRandom();
		List<Prodotto> listaOfferta = offertaDataScandenza();
		for (Prodotto prodotto : listaProdotti) {
			if (prodotto.getNome().equals(nomeProdotto.contains(prodotto.getNome()))) {
				if(prodotto.getQuantitaDisponibile() > quantitaDaComprare && cartaUtente.getCredito() >= prodotto.getPrezzoIvato()) {
					listaAcquisti.add(prodotto);
					if(listaOffertaRandom.contains(prodotto) && listaOfferta.contains(prodotto)) {
						Double nuovoCredito = cartaUtente.getCredito()-prodotto.getPrezzoIvato();
						cartaUtente.setCredito(nuovoCredito);
					}
				}
			}
			prodotto.setQuantitaDisponibile(prodotto.getQuantitaDisponibile()-quantitaDaComprare);
		}
		storico.setListaProdottiAcqustati(listaAcquisti);
		user.setStorico(storico);
		return userRepository.save(user);
	}


	public List<Prodotto> offertaDataScandenza() {
		List<Prodotto> listaProdotti  = (List<Prodotto>) prodottoRepository.findAll();
		List<Prodotto> listaProdottiOfferta = new ArrayList<>();
		for(Prodotto prodotto : listaProdotti) {
			if(prodotto.getDataDiScadenza().isBefore(LocalDate.now().minusDays(3))) {
				prodotto.setPrezzoIvato(prodotto.getPrezzoIvato() - (prodotto.getPrezzoIvato()*0.4));
				listaProdottiOfferta.add(prodotto);
			}
		}
		
		return listaProdottiOfferta;
	}
	
	public List<Prodotto> listaRandom (){
		
		Double percentualeSconto = 0.1;
		Random randomGetLista = new Random();
		List<Prodotto> listaProdotti  = (List<Prodotto>) prodottoRepository.findAll();
		List<Prodotto> listaRandom = new ArrayList<>();
		
		for(Integer i = 0 ; i < 5 ; i++) {
			int prodottoLista = randomGetLista.nextInt(listaProdotti.size());
			Prodotto prodottoInOfferta = listaProdotti.get(prodottoLista);
			listaRandom.add(prodottoInOfferta);
		}
		
		for(Prodotto prodotto : listaRandom) {
			prodotto.setPrezzoIvato(prodotto.getPrezzoIvato() - (prodotto.getPrezzoIvato()*percentualeSconto));
		}
		
		return listaRandom;
	}




}

