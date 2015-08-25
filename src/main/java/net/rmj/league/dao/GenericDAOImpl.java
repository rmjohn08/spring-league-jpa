package net.rmj.league.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
@Repository
@Transactional
public class GenericDAOImpl implements GenericDAO {

	private static EntityManagerFactory emf; //= Persistence.createEntityManagerFactory("JpaPersistenceUnit");
	
	@PersistenceContext //(unitName="JpaPersistenceUnit")
	private EntityManager em;
	
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
		/*
		if (em==null) 
			em = emf.createEntityManager();
		
		return em;
		*/
	}
	
	public void closeEntityManager() {
		emf.close();
	}
	
    public void flush() {
        getEntityManager().flush();
    }
	
	public <T> T find(Class<T> clazz, Object id) {
		return getEntityManager().find(clazz, id);
	}

	public void insert(Object obj) {
		getEntityManager().persist(obj);
	}

	public void delete(Object o) {
		getEntityManager().remove(o);
	}

	// it does an insert or update
	public void save(Object o) {
		getEntityManager().merge(o);		
	}

	public <T> List<T> findAll(Class<T> clazz) {
		EntityManager em = getEntityManager();
		CriteriaQuery<T> criteria = em.getCriteriaBuilder().createQuery(clazz);
		criteria.select(criteria.from(clazz));
		List<T> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}

	public <T> List<T> findAllOrderBy(Class<T> clazz, String colName) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T, PropType> List<T> findWherePropertIn(Class<T> clazz,
			String propName, List<PropType> valueList) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
