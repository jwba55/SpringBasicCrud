package kr.co.kopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kopo.dao.CustomerDao;
import kr.co.kopo.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public List<Customer> list() {
		// TODO Auto-generated method stub
		return customerDao.list();
	}

	@Override
	public void add(Customer item) {
		// TODO Auto-generated method stub
		customerDao.add(item);
	}

	@Override
	public Customer item(Long custId) {
		// TODO Auto-generated method stub
		return customerDao.item(custId);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}

	@Override
	public void delete(Long custId) {
		// TODO Auto-generated method stub
		customerDao.delete(custId);
	}

}
