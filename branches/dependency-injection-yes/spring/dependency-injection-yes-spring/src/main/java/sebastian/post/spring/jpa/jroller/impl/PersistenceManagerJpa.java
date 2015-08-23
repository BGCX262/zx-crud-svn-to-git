package sebastian.post.spring.jpa.jroller.impl;

import java.util.List;

import javax.persistence.EntityManager;

import model.BaseModel;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import sebastian.post.spring.jpa.jroller.PersistenceManager;

public class PersistenceManagerJpa extends JpaDaoSupport  implements PersistenceManager {

	
	public <T> T find(Class<? extends BaseModel> entityClass, Long id) {
		throw new UnsupportedOperationException("max deve ancora implementare questo metodo !");
	}

	public <T> T merge(T entity) {
		throw new UnsupportedOperationException("max deve ancora implementare questo metodo !");
	}

	public void remove(BaseModel entity) {
		throw new UnsupportedOperationException("max deve ancora implementare questo metodo !");
	}

	public void save(BaseModel entity) {
		this.getJpaTemplate().persist(entity);
	}

	public <T> List<T> findAll(Class<? extends BaseModel> entityClass) {
		 return getJpaTemplate().find("from " + entityClass.getName());
	}


}
