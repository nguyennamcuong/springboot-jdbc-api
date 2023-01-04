package com.nbstech.spring.basic.dataacccess;

import com.nbstech.spring.basic.dataacccess.SpringDataJpa.PlayerEntity;
import com.nbstech.spring.basic.dataacccess.SpringDataJpa.PlayerRepository;
import com.nbstech.spring.basic.dataacccess.SpringDataJpa.SpringDataJPAPlayerRepository;
import com.nbstech.spring.basic.dataacccess.SpringJdbcApi.Player;
import com.nbstech.spring.basic.dataacccess.SpringJdbcApi.PlayerDAO;
import com.nbstech.spring.basic.dataacccess.SpringJdbcApi.TournamentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class SpringbootDataAccessApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlayerDAO playerDao;

	@Autowired
	TournamentDAO tournamentDAO;

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	SpringDataJPAPlayerRepository springDataPlayerRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataAccessApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		logger.info("Inserting Player 4: {}", playerDao.insertPlayer(
//				new Player(4, "Thiem", "Austria", new Date(System.currentTimeMillis()), 17 ))
//		);
//
//		logger.info("Updating Player with Id 4: {}", playerDao.updatePlayer(
//				new Player(4, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17))
//		);
//
//		logger.info("Deleting Player with Id 2: {}", playerDao.deletePlayerById(2));
//
//		logger.info("All Players Data: {}", playerDao.getAllPlayers());
//
//		logger.info("Player with Id 3: {}", playerDao.getPlayerById(3));
//
//		tournamentDAO.createTournamentTable();
//		logger.info("French Players: {}", playerDao.getPlayerByNationality("Austria"));
//		SpringDataJPA();
		SpringDataRepositoryEx();
	}
	private void SpringDataJPA() {
		// ex1
		logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
				new PlayerEntity("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));

		logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
				new PlayerEntity("Monfils", "France", Date.valueOf("1986-09-01"), 10)));

		// ex2
		logger.info("\n\n>> Player with id 2: {}\n", playerRepository.getPlayerById(2));

		// ex3
		logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
				new PlayerEntity("Thiem", "Austria",
						new Date(System.currentTimeMillis()), 17)));
		logger.info("\n\n>> Updating Player with Id 3: {}\n", playerRepository.updatePlayer(
				new PlayerEntity(3, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));
		logger.info("\n\n>> Player with id 3: {}\n", playerRepository.getPlayerById(3));

		//delete player
		playerRepository.deleteById(2);
	}

	private void SpringJdbcApi() {
		tournamentDAO.createTournamentTable();

		logger.info("French Players: {}", playerDao.getPlayerByNationality("France"));


		logger.info("Inserting Player 4: {}", playerDao.insertPlayer(
				new Player (4, "Thiem", "Austria", new Date(System.currentTimeMillis()), 17 ))
		);

		logger.info("Updating Player with Id 4: {}", playerDao.updatePlayer(
				new Player(4, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17))
		);

		logger.info("Deleting Player with Id 2: {}", playerDao.deletePlayerById(2));

		logger.info("All Players Data: {}", playerDao.getAllPlayers());

		logger.info("Player with Id 3: {}", playerDao.getPlayerById(3));

		logger.info("\n\n>> All Players Data: {}", playerRepository.getAllPlayers());
	}

	private void SpringDataRepositoryEx() {
		//Inserting rows
		logger.info("Inserting Player: {}", springDataPlayerRepository.save(new PlayerEntity("Djokovic", "Serbia",
				Date.valueOf("1987-05-22"), 81)));
		logger.info("Inserting Player: {}", springDataPlayerRepository.save(new PlayerEntity("Monfils", "France",
				Date.valueOf("1986-09-01"), 10)));
		logger.info("Inserting Player: {}", springDataPlayerRepository.save(new PlayerEntity("Thiem", "Austria",
				new Date(System.currentTimeMillis()), 17)));

		//Updating row
		logger.info("Updating Player with Id 3: {}", springDataPlayerRepository.save(new PlayerEntity(3, "Thiem", "Austria",
				Date.valueOf("1993-09-03"), 17)));

		logger.info("Player with Id 2: {}", springDataPlayerRepository.findById(2));

		logger.info("All Players Data: {}", springDataPlayerRepository.findAll());

		springDataPlayerRepository.deleteById(2);
	}

}
