package fr.epita.quiz.services.data;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import fr.epita.quiz.datamodel.Question;

public abstract class GenericDAO<T> {

	private static final Logger LOGGER = LogManager.getLogger(GenericDAO.class);
	
	@Inject
	private SessionFactory sf;

	public void create(T instance) {
		Session session = getSession();
		Transaction tx = getTransaction(session);
		session.save(instance);
		tx.commit();

	}

	protected final Transaction getTransaction(Session session) {
		
		
		Transaction tx = session.getTransaction();
		if (!TransactionStatus.ACTIVE.equals(tx.getStatus())) {
			tx = session.beginTransaction();
		}
		return tx;
	}

	protected final Session getSession() {
		Session session = null;
		try {
			session = this.sf.getCurrentSession();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		if (session == null) {
			session = sf.openSession();
		}
		return session;
	}

	public void update(T instance) {
		Session session = getSession();
		Transaction tx = getTransaction(session);
		session.update(instance);
		tx.commit();
	}

	public void delete(T instance) {
		Session session = getSession();
		Transaction tx = getTransaction(session);
		session.delete(instance);
		tx.commit();
	}

	public abstract List<T> search(T criteria) ;
	public abstract Class<T> getGenericClass() ;

	public T getById(Long id) {
		return getSession().get(getGenericClass(), id);
	}

}
