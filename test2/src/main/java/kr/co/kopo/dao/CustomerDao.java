package kr.co.kopo.dao;

import java.util.List;

import kr.co.kopo.model.Customer;

public interface CustomerDao {

	List<Customer> list();

	void add(Customer item);

	Customer item(Long custId);

	void update(Customer customer);

	void delete(Long custId);

}
