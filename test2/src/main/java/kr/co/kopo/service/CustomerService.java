package kr.co.kopo.service;

import java.util.List;

import kr.co.kopo.model.Customer;

public interface CustomerService {

	List<Customer> list();

	void add(Customer item);

	Customer item(Long custId);

	void update(Customer customer);

	void delete(Long custId);

}
