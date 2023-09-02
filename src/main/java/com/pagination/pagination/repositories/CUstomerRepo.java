package com.pagination.pagination.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pagination.pagination.enities.Customer011;

@Repository
public interface CUstomerRepo extends JpaRepository<Customer011, String> {

	Page<Customer011> findAll(Pageable pageable);
//	Page<Customer011> findByPlaceIsNullOrPlace(String Place, Pageable pageable);

//	@Query(value = "select * from customer011 a where a.place=?1", nativeQuery = true)
	List<Customer011> findByPlace(String place);
	
	@Query(value = "SELECT * FROM customer011 a WHERE (:place IS NULL OR a.place = :place)", nativeQuery = true)
    Page<Customer011> findByPlace(String place, Pageable pageable);
	
	@Query(value = "SELECT * FROM customer011 a WHERE (:place IS NULL OR a.place = :place) AND (:name IS NULL OR a.name=:name) ", nativeQuery = true)
	   
	Page<Customer011> findByPlace_Name(String place, String name,Pageable pageable);

}
