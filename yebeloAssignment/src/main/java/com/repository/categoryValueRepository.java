package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.categoryValue;

@Repository
public interface categoryValueRepository extends JpaRepository<categoryValue, Long> {
	
	@Query(value = "SELECT COALESCE(MAX(value), 0) FROM Number WHERE categoryCode = :categoryCode", nativeQuery = true)
    categoryValue findMaxValueByCategoryCode(String categoryCode);

    @Query(value = "SELECT value FROM CategoryValue WHERE categoryCode = :categoryCode")
    Integer findValueByCategoryCode(String categoryCode);

    @Modifying
    @Query(value = "UPDATE CategoryValue SET value = :newValue WHERE categoryCode = :categoryCode AND value = :oldValue")
    int updateValueByCategoryCodeAndValue(int newValue, String categoryCode, int oldValue);

	
}