package org.ahmadiyya.halqa.software.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ahmadiyya.halqa.software.model.Receipt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReceiptDaoImpl implements ReceiptDao {

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;

	// private SessionFactory sessionFactory;
	//
	// public SessionFactory getSessionFactory() {
	// return sessionFactory;
	// }

	// @Autowired
	// public void setSessionFactory(SessionFactory sessionFactory) {
	//
	// this.sessionFactory = sessionFactory;
	// }

	@Override
	public void addReceipt(Receipt p) {
		entityManager.persist(p);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Receipt> listReceipt() {

		List<Receipt> personsList = entityManager.createQuery("from Receipt")
				.getResultList();

		return personsList;
	}

	@Override
	public Receipt getPersonById(long id) {

		Receipt p = (Receipt) entityManager.find(Receipt.class, new Long(id));

		return p;
	}

}
