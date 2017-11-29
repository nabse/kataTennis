package kataTennis.code.implementation;

public class Score {
	
	private String gameScore;
	private int setScore;
	private int matchScore;
	
	public Score(String gameScore, int setScore, int setsWon) {
		this.gameScore = gameScore;
		this.setScore = setScore;
		this.matchScore = setsWon;
	}
	public String getGameScore() {
		return gameScore;
	}
	public void updateGameScore(String gameScore) {
		this.gameScore = gameScore;
	}
	public int getSetScore() {
		return setScore;
	}
	public void updateSetScore(int setScore) {
		this.setScore = setScore;
	}
	public int getMatchScore() {
		return matchScore;
	}
	public void updateMatchScore(int matchScore) {
		this.matchScore = matchScore;
	}
}
