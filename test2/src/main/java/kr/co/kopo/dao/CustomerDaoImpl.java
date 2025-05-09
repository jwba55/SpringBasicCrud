package kr.co.kopo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kopo.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Customer> list() {
		// TODO Auto-generated method stub
		return sql.selectList("users.list");
	}

	@Override
	public void add(Customer item) {
		// TODO Auto-generated method stub
		sql.insert("users.add", item);
	}

	@Override
	public Customer item(Long custId) {
		// TODO Auto-generated method stub
		return sql.selectOne("users.item", custId);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		sql.update("users.update", customer);
	}

	@Override
	public void delete(Long custId) {
		// TODO Auto-generated method stub
		sql.delete("users.delete", custId);
	}

}
