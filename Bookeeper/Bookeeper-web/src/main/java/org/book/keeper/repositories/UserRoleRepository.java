package org.book.keeper.repositories;

import java.util.List;

import org.book.keeper.entities.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long>{
	
	@Query("select a.role from UserRole a, LoginInfo b where b.userName=?1 and a.userId=b.userId")
	public List<String> findRoleByUserName(String username);
}
