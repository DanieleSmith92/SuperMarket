package it.dstech.SuperMarket.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.SuperMarket.model.User;

public interface IUserRepository extends CrudRepository<User, Long>{ 
	
  
}
