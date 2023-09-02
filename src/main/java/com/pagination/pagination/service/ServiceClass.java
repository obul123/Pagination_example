package com.pagination.pagination.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pagination.pagination.enities.Customer011;
import com.pagination.pagination.repositories.CUstomerRepo;

@Service
public class ServiceClass {
	
	@Autowired
	CUstomerRepo cUstomerRepo;

	public Customer011 createCustomer(@Valid Customer011 customer) {
		return cUstomerRepo.save(customer);
	}

	public List<Customer011> getAllCustomers() {
		// TODO Auto-generated method stub
		return cUstomerRepo.findAll();
	}

	public Page<Customer011> getAllCustomersWithPagination(String place ,String name ,  int pageNum, int pageSize) {
		System.out.println(place+"page num "+pageNum+" page size "+pageSize+" list "+cUstomerRepo.findAll());
//		return cUstomerRepo.findAll(PageRequest.of(pageNum, pageSize));
//		boolean isEmpty = products.isEmpty();
//		System.out.println("WSsf "+isEmpty+" products are "+products.getContent());
//		return products;
//		return null;
		return cUstomerRepo.findByPlace_Name(place,name, PageRequest.of(pageNum, pageSize));
	}

	public List<Customer011> fetchCustomerByPlace(String place) {
		return cUstomerRepo.findByPlace(place);
		
	}

}
