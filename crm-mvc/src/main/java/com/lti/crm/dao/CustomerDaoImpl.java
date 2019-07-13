package com.lti.crm.dao;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.crm.model.Customer;
@Repository
public class CustomerDaoImpl implements CustomerDAO {
 
@Autowired
private SessionFactory sessionFactory;
public void saveCustomer(Customer theCustomer) {
Session currentSession= sessionFactory.getCurrentSession();
  currentSession.saveOrUpdate(theCustomer);
 }

public Customer getCustomer(int theId) {
 Session currentSession=sessionFactory.getCurrentSession();
 Customer theCustomer=currentSession.get(Customer.class, theId);
 return theCustomer;
}

public List<Customer> getCustomers() {
 Session session=sessionFactory.getCurrentSession();
 CriteriaBuilder cb=session.getCriteriaBuilder();
 CriteriaQuery<Customer> cq=cb.createQuery(Customer.class);
 Root<Customer> root=cq.from(Customer.class);
 cq.select(root);
 Query query=session.createQuery(cq);
 return query.getResultList();
}

}
