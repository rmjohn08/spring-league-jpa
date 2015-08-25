package net.rmj.league.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.sun.istack.internal.logging.Logger;

import net.rmj.league.dao.LeagueDAO;
import net.rmj.league.entity.League;

public class LeagueLauncher {

	private static final Logger logger = Logger.getLogger(LeagueLauncher.class);
	
	public static void main(String[] args) {
		// 
		 //Create Spring application context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
         
        //Get service from context. (service's dependency (ProductDAO) is autowired in ProductService)
        LeagueDAO dao = ctx.getBean(LeagueDAO.class);
         
		try {
			League league = new League();
			league.setLeagueName("Soccer Fall 2015");
			
			League winter = new League();
			league.setLeagueName("Soccer winter 2016");
			
			League spring = new League();
			league.setLeagueName("Soccer spring 2016");
				
			logger.info("persisting leagues...");
			dao.persistLeague(league);
			//dao.persistLeague(winter);
			//dao.persistLeague(spring);		
			//dao.flush();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
			
		LeagueDAO dao2 = ctx.getBean(LeagueDAO.class);
		List<League> list = dao2.getLeagues();
		for (League l : list) {
			System.out.println("League -" + l.getId() + " " + l.getLeagueName());
		}
		
		League l = dao2.getLeagueById(new Long(1));
		
		if (l!=null) {
			logger.info("Found " + l.getLeagueName());
		} else {
			logger.info("No league found ");
			
		}
		ctx.close();	
	}

}
