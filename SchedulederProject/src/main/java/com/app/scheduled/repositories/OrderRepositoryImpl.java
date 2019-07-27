package com.app.scheduled.repositories;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.scheduled.entities.OrderEntity;


@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public OrderEntity addProduct(OrderEntity product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(product);
		return product;
	}

	@Override
	public OrderEntity getSingleProduct(long id) {
		// TODO Auto-generated method stub
		return (OrderEntity) sessionFactory.getCurrentSession().get(OrderEntity.class, id);

	}

	@Override
	public Map<String, Object> getAllProduct() {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(OrderEntity.class).addOrder(Order.desc("id"));
		criteria.setMaxResults(1);
		Map<String, Object> data = new HashMap<>();
		data.put("data", criteria.list());

		return data;
	}

	@Override
	public OrderEntity getOrderByStatus() {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(OrderEntity.class);
		
		criteria.add(Restrictions.eq("proStatus", "False"));
		criteria.addOrder(Order.asc("id"));
		
		if(criteria.list().size()>0)
		{
			return (OrderEntity) criteria.list().get(0);
		}
		
		 return null;
	}

	@Override
	public OrderEntity updateOrder(OrderEntity orderEntity) {
		sessionFactory.getCurrentSession();
		return null;
	}

}
