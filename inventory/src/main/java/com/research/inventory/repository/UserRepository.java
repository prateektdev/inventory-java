package com.research.inventory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.research.inventory.model.User;

/**

* The is the JPA Repository for the User Entity .
* We define the necessary methods which We will be implementing in the User Service

* @version 1.0

* @author Prateek T

*/
@Repository
public interface UserRepository  extends CrudRepository<User, Long>{

	public User findByUsername(String username) ; 
}
