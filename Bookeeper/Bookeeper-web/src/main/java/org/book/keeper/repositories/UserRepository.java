package org.book.keeper.repositories;

import org.book.keeper.entities.LoginInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<LoginInfo, Long>{
	public LoginInfo findByUserName(String username);
}
