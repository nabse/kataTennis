package kataTennis.code.implementation;

public class Player {

	private String name;
	private Score score;

	public Player(String name,Score score) {
		this.score = score;
		this.name = name;
	}

	public Score getScore() {
		return score;
	}

	public void updateScore(Score score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void updateName(String name) {
		this.name = name;
	}

	public void scoresPointOn(Player player, TennisGame tennisGame) {
		tennisGame.scoresPoint(this, player);
	}	
}
