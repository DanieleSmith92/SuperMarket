package it.dstech.SuperMarket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.SuperMarket.model.Categoria;
import it.dstech.SuperMarket.model.Prodotto;
import it.dstech.SuperMarket.model.Storico;
import it.dstech.SuperMarket.model.User;
import it.dstech.SuperMarket.repository.IProdottoRepository;

@Service
public class ProdottoService {
	@Autowired 
	private IProdottoRepository prodottoRepository;

	@Autowired 
	private StoricoService storicoService;

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
	
	/*public  List<Prodotto> acquistoProdotti(List<Prodotto>listaAcquisti, Storico storico,Long idUser){
		List<Prodotto>listaProdotti = (List<Prodotto>) prodottoRepository.findAll();
		User user = userService.findOne(idUser);
		user.setStorico(storico);
	return 
	}
	
	 */
	




}

