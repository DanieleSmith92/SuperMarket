package it.dstech.SuperMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.dstech.SuperMarket.model.User;
import it.dstech.SuperMarket.repository.IUserRepository;

@Service
public class UserService {


	@Autowired
	private IUserRepository dao;

	public User create (User user) {
		return dao.save(user);
	}
	public Iterable<User> createList (Iterable<User> listaUser){
		return dao.save(listaUser);
	}
	public Iterable<User> findAll() {
		return dao.findAll();
	}
	public User findOne(Long id) {
		return dao.findOne(id);
	}
	public void deleteAll() {
		dao.deleteAll();
	}
	public void deleteOne(Long id) {
		dao.delete(id);
	}
	public User update (User userInput) {
		User userDb = findOne(userInput.getId());
		userDb.setUsername(userInput.getUsername());
		userDb.setPassword(userInput.getPassword());
		return dao.save(userDb);
	}
	public User findByUsername (String username) {
		return dao.findByUsername(username);

	}
}