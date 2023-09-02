package com.pagination.pagination.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagination.pagination.enities.Customer011;
import com.pagination.pagination.enities.customeResponseForPagination;
import com.pagination.pagination.service.ServiceClass;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class RestControllerClass {

	@Autowired
	ServiceClass serviceClass;

	@RequestMapping(method = RequestMethod.POST, value = "/customer/createCustomer")
	public ResponseEntity createCustomer(@Valid @RequestBody Customer011 customer) {
		Customer011 cust = serviceClass.createCustomer(customer);
		if (cust != null)
			return new ResponseEntity(cust, HttpStatus.CREATED);
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/customer/fetchAllCustomers")
	public List<Customer011> getALLCustomers() {
		return serviceClass.getAllCustomers();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/customer/fetchAllCustomers1")
	public customeResponseForPagination<Customer011> getALLCustomerswithPagination(
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") @Parameter(description = "pls provide pageNum") int pageNum,
			@RequestParam(required = false, defaultValue = "22") @Parameter(description = "pls provide pageSize") int pageSize,
			@RequestParam(required = false) @Parameter(description = "place chahiye toh , bhejo idhar") String place,
			@RequestParam(value="name" , required=false) String Name) {

		customeResponseForPagination<Customer011> customeResponseForPagination = new customeResponseForPagination<>();
		Page<Customer011> page = serviceClass.getAllCustomersWithPagination(place,Name, pageNum - 1, pageSize);
		customeResponseForPagination.setTotalNoOfRecords((int) page.getTotalElements());
		customeResponseForPagination.setNoOfPages(page.getTotalPages());
		int sum = pageNum * pageSize;
		if (sum < page.getTotalElements()) {
			customeResponseForPagination.setHasNext("Y");
		} else {
			customeResponseForPagination.setHasNext("N");
		}
		customeResponseForPagination.setPageNum(pageNum);
		customeResponseForPagination.setPageSize(pageSize);
		customeResponseForPagination.setList(page.getContent());
		System.out.println("contents are : " + page.getContent());
		// return new ResponseEntity(customeResponseForPagination, HttpStatus.OK);
		return customeResponseForPagination;
	}

	@RequestMapping(method = RequestMethod.GET , value="/customer/fetchAllCustomersByPlace")
	public List<Customer011> getAllCusomersByPlace(
			@RequestParam(required = false) @Parameter(description = "pls provide placename") String place) {
		List<Customer011> customer011s = serviceClass.fetchCustomerByPlace(place);
		if (customer011s == null)
			return null;
		else
			return customer011s;
	}

}
