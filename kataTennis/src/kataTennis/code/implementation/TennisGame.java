package kataTennis.code.implementation;

import java.util.Arrays;

import kataTennis.code.constants.Constants;

public class TennisGame {
	
	/**
	 * @param playerWinningPoint
	 * @param playerLosing
	 * Update Tennis game score
	 */
	public void scoresPoint(Player playerWinningPoint, Player playerLosing) {
		Score playerWinningPointScore = playerWinningPoint.getScore();
		Score playerLosingScore = playerLosing.getScore();
		
		if(checkPlayersScoresInCaseOfFourtyEquality(playerWinningPointScore, playerLosingScore)) {
			playerWinningPointScore.updateGameScore(Constants.ADV);
		}else if(checkPlayersScoresInCaseOfAdvantageForLosingPlayer(playerWinningPointScore, playerLosingScore)) {
			playerWinningPointScore.updateGameScore(Constants.DEUCE);
		}else if(checkPlayersScoresInCaseOfAdvantageOrFourtyForWinningPlayer(playerWinningPointScore)) {
			playerWinningPointScore.updateSetScore(playerWinningPointScore.getSetScore() + 1);
			this.manageMatchScore(playerWinningPointScore, playerLosingScore);
		} else {
			int indexLastScore = Arrays.binarySearch(Constants.GAME_SCORES, playerWinningPointScore.getGameScore());
			playerWinningPointScore.updateGameScore(String.valueOf(Constants.GAME_SCORES[indexLastScore+1]));
		}
		
		playerWinningPoint.updateScore(playerWinningPointScore);
		playerLosing.updateScore(playerLosingScore);
	}
	
	/**
	 * 
	 * @param playerWinningPointScore
	 * @param playerLosingScore
	 * @return a true if the game score of two players is 40 or not
	 */
	public boolean checkPlayersScoresInCaseOfFourtyEquality(Score playerWinningPointScore, Score playerLosingScore) {
		return Constants.FOURTY.equals(playerWinningPointScore.getGameScore()) && Constants.FOURTY.equals(playerLosingScore.getGameScore());
	}
	
	/**
	 * 
	 * @param playerWinningPointScore
	 * @param playerLosingScore
	 * @return true if the score game of player winning point is 40 and player losing is having advantage 
	 */
	public boolean checkPlayersScoresInCaseOfAdvantageForLosingPlayer(Score playerWinningPointScore, Score playerLosingScore) {
		return Constants.FOURTY.equals(playerWinningPointScore.getGameScore()) && Constants.ADV.equals(playerLosingScore.getGameScore());
	}
	
	/**
	 * 
	 * @param playerWinningPointScore
	 * @param playerLosingScore
	 * @return true if the score game of player winning point is 40 or if he is having advantage or 
	 */
	public boolean checkPlayersScoresInCaseOfAdvantageOrFourtyForWinningPlayer(Score playerWinningPointScore) {
		return Constants.ADV.equals(playerWinningPointScore.getGameScore()) || Constants.FOURTY.equals(playerWinningPointScore.getGameScore());
	}
	
	
	/**
	 * @param playerWinningPointScore
	 * @param playerLosingScore
	 * Update Match Score
	 */
	private void manageMatchScore(Score playerWinningPointScore, Score playerLosingScore) {
		if(playerWinningPointScore.getSetScore() == 6 && playerLosingScore.getSetScore() <=5){
			playerWinningPointScore.updateMatchScore(playerWinningPointScore.getMatchScore() + 1);
		}else if(playerWinningPointScore.getSetScore() >= 7 && playerWinningPointScore.getSetScore() - playerLosingScore.getSetScore() >= 2) {
			playerWinningPointScore.updateMatchScore(playerWinningPointScore.getMatchScore() + 1);
		}
	}
	/**
	 * 
	 * @param playerWinningPointScore
	 * @param playerLosingScore
	 * @return score to display
	 */
	public String displayScore(Player playerWinningPointScore, Player playerLosingScore) {
		StringBuilder score = new StringBuilder();
		
		score.append(playerWinningPointScore.getScore().getGameScore()).append(Constants.SPACE).
		append(playerWinningPointScore.getScore().getSetScore()).append(Constants.SPACE).
		append(playerWinningPointScore.getScore().getMatchScore()).
		append(Constants.BACK_TO_LINE).
		append(playerLosingScore.getScore().getGameScore()).append(Constants.SPACE).
		append(playerLosingScore.getScore().getSetScore()).append(Constants.SPACE).
		append(playerLosingScore.getScore().getMatchScore());
		
		return score.toString();
	}
}
