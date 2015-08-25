package net.rmj.league.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import net.rmj.league.entity.League;

@Component
public class LeagueDAO extends GenericDAOImpl {

	public void close() {
		this.closeEntityManager();
	}

	public void persistLeague(League league) {
		/* EntityManager em = createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(league);
		tx.commit();
		em.close();
		*/
		insert(league);
	}
	
	@SuppressWarnings("unchecked")
	public List<League> getLeagues() {
		/*
		EntityManager em = createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Query qry = em.createQuery("select l from League l");
		List<League> leagues = qry.getResultList();
				
		tx.commit();
		em.close();
		return leagues;
		*/
		return findAll(League.class);
		
	}
	
	public League getLeagueById(Long id) {
		return this.find(League.class, id);
		
	}
	
}
