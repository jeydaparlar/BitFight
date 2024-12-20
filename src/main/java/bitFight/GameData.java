package bitFight;

public class GameData {
    private Player player;
    private Level levelReached;
    private Score score;


    public GameData(Player player, Level levelReached) {
        this.player = player;
        this.levelReached = levelReached;
        this.score = new Score(player);
    }

    public GameData(Player player, Level levelReached, Score score) {
        this(player, levelReached);
        this.score = score;
    }

    public Level getLevelReached() {
        return levelReached;
    }
    public Player getPlayer() {
        return player;
    }
    public Score getScore() {
        return score;
    }
    public void setScore(Score score) {
        this.score = score;
    }

    public boolean updateScore(Score s) {
        this.setScore(s);
        if (this.score == s) {
            return true;
        }
        return false;
    }
}
