package it.dstech.SuperMarket.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(auth.getName());
		
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
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(auth.getName());
		
		List<Prodotto>listaProdotti = (List<Prodotto>) prodottoRepository.findAll();
		List<Prodotto>listaProdottiCateg =new ArrayList<>();
		for(Prodotto prodotto:listaProdotti) {
			if(prodotto.getCategoria().equals(categoria)) {
				listaProdottiCateg.add(prodotto);

			}
		}
		return listaProdottiCateg;
	}

	public  User acquistoProdotti( List<Long> listaIdAcquisti, Long idCarta){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(auth.getName());
		
		Integer quantitaDaComprare = 1;
		List<Prodotto>listaProdotti = (List<Prodotto>) prodottoRepository.findAll();
		CartaCredito cartaUtente = cartaCreditoService.findOne(idCarta);
		List<Prodotto> listaOffertaRandom = listaRandom();
		List<Prodotto> listaOfferta = offertaDataScandenza();
		for (Prodotto prodotto : listaProdotti) {
			if (prodotto.getId().equals(listaIdAcquisti.contains(prodotto.getId()))) {
				if(prodotto.getQuantitaDisponibile() >= quantitaDaComprare && cartaUtente.getCredito() >= prodotto.getPrezzoIvato()) {
					if(listaOffertaRandom.contains(prodotto) && listaOfferta.contains(prodotto)) {
						Double nuovoCredito = cartaUtente.getCredito()-prodotto.getPrezzoIvato();
						cartaUtente.setCredito(nuovoCredito);
					}
				}
			}
			prodotto.setQuantitaDisponibile(prodotto.getQuantitaDisponibile()-quantitaDaComprare);
		}
		
		Storico storico = new Storico();
		List<Prodotto> listaProdottiAcquistati = new ArrayList<>();
		for (Long idAcquistato  : listaIdAcquisti) {
			Prodotto prodotto = prodottoRepository.findOne(idAcquistato);
			listaProdottiAcquistati.add(prodotto);
		}
		storico.setListaProdottiAcqustati(listaProdottiAcquistati);
		List<Storico> listaStorici = new ArrayList<>();
		listaStorici.add(storico);
		user.setListaStorici(listaStorici);
		return userRepository.save(user);
	}
	

	public List<Prodotto> offertaDataScandenza() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(auth.getName());
		
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
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(auth.getName());
		
		
		Random randomGetLista = new Random();
		List<Prodotto> listaProdotti  = (List<Prodotto>) prodottoRepository.findAll();
		List<Prodotto> listaRandom = new ArrayList<>();
		
		for(Integer i = 0 ; i < 5 ; i++) {
			int prodottoLista = randomGetLista.nextInt(listaProdotti.size());
			Prodotto prodottoInOfferta = listaProdotti.get(prodottoLista);
			listaRandom.add(prodottoInOfferta);
		}
		
		for(Prodotto prodotto : listaRandom) {
			prodotto.setPrezzoIvato(prodotto.getPrezzoIvato() - (prodotto.getPrezzoIvato()*prodotto.getOfferta()));
		}
		
		return listaRandom;
	}


}

