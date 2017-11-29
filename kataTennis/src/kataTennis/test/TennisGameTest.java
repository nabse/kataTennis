package kataTennis.test;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import kataTennis.code.constants.Constants;
import kataTennis.code.implementation.Player;
import kataTennis.code.implementation.Score;
import kataTennis.code.implementation.TennisGame;

public class TennisGameTest {

	
	@Test
	public void ShouldReturnAScoreOf_15_0_0$0_0_0_WhenPlayer1WinsAPoint() 
	{
		//Arrange
		Player player1 = new Player("P1",new Score("0",0,0));
		Player player2 = new Player("P1",new Score("0",0,0));
		TennisGame tennisGame = new TennisGame();
		player1.scoresPointOn(player2, tennisGame);
		
		//When
		String currentScore = tennisGame.displayScore(player1, player2);
		
		//Assert
		assertEquals("15 0 0" + Constants.BACK_TO_LINE + "0 0 0", currentScore);
	}
	
	@Test
	public void ShouldReturnAScoreOf_40_0_0$40_0_0_WhenPlayer1WinsAPoint() 
	{
		//Arrange
		Player player1 = new Player("P1",new Score("30",0,0));
		Player player2 = new Player("P1",new Score("40",0,0));
		TennisGame tennisGame = new TennisGame();
		player1.scoresPointOn(player2, tennisGame);
		
		//When
		String currentScore = tennisGame.displayScore(player1, player2);
		
		//Assert
		assertEquals("40 0 0" + Constants.BACK_TO_LINE + "40 0 0", currentScore);		
	}
	
	@Test
	public void ShouldActivateDeuceWhenBothPlayersReachTheScore40() {
		//Arrange
		Player player1 = new Player("P1",new Score("40",0,0));
		Player player2 = new Player("P2",new Score("40",0,0));
		TennisGame tennisGame = new TennisGame();
		player1.scoresPointOn(player2, tennisGame);
		
		//When
		String currentScore = tennisGame.displayScore(player1, player2);
		
		//Assert
		assertEquals("ADV 0 0" + Constants.BACK_TO_LINE + "40 0 0", currentScore);		
	}
	
	@Test
	public void ShouldReturnAScoreOf_40_0_0$30_0_0_WhenPlayer1WinsAPoint() 
	{
		//Arrange
		Player player1 = new Player("P1",new Score("30",0,0));
		Player player2 = new Player("P1",new Score("30",0,0));
		TennisGame tennisGame = new TennisGame();
		player1.scoresPointOn(player2, tennisGame);
		
		//When
		String currentScore = tennisGame.displayScore(player1, player2);
		
		//Assert
		assertEquals("40 0 0" + Constants.BACK_TO_LINE + "30 0 0", currentScore);			
	}
	
	
	@Test
	public void ShouldReturnAScoreOf_40_1_0$30_0_0_WhenPlayer1WinsTheGame() 
	{
		//Arrange
		Player player1 = new Player("P1",new Score("40",0,0));
		Player player2 = new Player("P1",new Score("30",0,0));
		TennisGame tennisGame = new TennisGame();
		player1.scoresPointOn(player2, tennisGame);
		
		//When
		String currentScore = tennisGame.displayScore(player1, player2);
		
		//Assert
		assertEquals("40 1 0" + Constants.BACK_TO_LINE + "30 0 0", currentScore);		
	}
	
	@Test
	public void ShouldReturnAScoreOf_40_6_1$30_3_0_WhenPlayer1WinsTheGame() 
	{
		//Arrange
		Player player1 = new Player("P1",new Score("40",5,0));
		Player player2 = new Player("P1",new Score("30",3,0));
		TennisGame tennisGame = new TennisGame();
		player1.scoresPointOn(player2, tennisGame);
		
		//When
		String currentScore = tennisGame.displayScore(player1, player2);
		
		//Assert
		assertEquals("40 6 1" + Constants.BACK_TO_LINE + "30 3 0", currentScore);		
	}
	
	@Test
	public void ShouldReturnAScoreOf_40_8_2$30_6_1_WhenPlayer1WinsTheGame() 
	{
		//Arrange
		Player player1 = new Player("P1",new Score("40",7,1));
		Player player2 = new Player("P1",new Score("30",6,1));
		TennisGame tennisGame = new TennisGame();
		player1.scoresPointOn(player2, tennisGame);
		
		//When
		String currentScore = tennisGame.displayScore(player1, player2);
		
		//Assert
		assertEquals("40 8 2" + Constants.BACK_TO_LINE + "30 6 1", currentScore);		
	}
}
