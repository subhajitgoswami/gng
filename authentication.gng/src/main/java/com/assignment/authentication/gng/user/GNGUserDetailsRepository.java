package com.assignment.authentication.gng.user;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GNGUserDetailsRepository  extends JpaRepository<GNGUserDetails, Long> {
	
	
	
	@Query(value = "SELECT * FROM USERS " + 
			"WHERE name = :username", 
			  nativeQuery = true)
	GNGUserDetails getUser(@Param("username") String userName);

	@Query(value = "SELECT DISTINCT P.PERMISSION_NAME FROM PERMISSION P \r\n" + 
			"INNER JOIN role_permission r_p ON P.ID=r_p.PERMISSION_ID\r\n" + 
			"INNER JOIN ROLE R ON R.ID=r_p.ROLE_ID \r\n" + 
			"INNER JOIN role_users r_u ON r_u.ROLE_ID=R.ID\r\n" + 
			"INNER JOIN USERS U ON U.ID=r_u.USER_ID\r\n" + 
			"WHERE U.name = :username", 
			  nativeQuery = true)
	List<String> getPermissionList(@Param("username") String username);
}
