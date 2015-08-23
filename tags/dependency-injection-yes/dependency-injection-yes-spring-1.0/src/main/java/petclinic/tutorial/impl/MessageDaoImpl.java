package petclinic.tutorial.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.hello.Message;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import petclinic.tutorial.MessageDao;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Message msg) {
		// Consider returning the persistent object here, for exposing
		// a newly assigned id using any persistence provider...
		this.em.persist(msg);
	}

}
