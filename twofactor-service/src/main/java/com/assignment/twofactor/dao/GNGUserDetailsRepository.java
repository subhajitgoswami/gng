package com.assignment.twofactor.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GNGUserDetailsRepository extends JpaRepository<GNGUserDetails, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update USERS set two_fa_code = :twofaCode " + "WHERE id = :id", nativeQuery = true)
	void updateTwofaProperties(@Param("id") String userName, @Param("twofaCode") String twofaCode);
}
