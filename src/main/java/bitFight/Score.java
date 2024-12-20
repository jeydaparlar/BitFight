package bitFight;

import java.util.ArrayList;

public class Score {
    private Player player;
    private int value;
    private static ArrayList<Score> scoreTab = new ArrayList<>();

    public Score(Player player) {
        this.player = player;
        this.value = player.getLevel();
        scoreTab.add(this);
    }

    public Score(Player player, int value) {
        this(player);
        this.value = value;
    }

    public Player getPlayer() {
        return player;
    }

    public static ArrayList<Score> getScoreTab() {
        return scoreTab;
    }

    public int getValue() {
        return value;
    }

    public boolean add(Score s) {
        scoreTab.add(s);
        if (scoreTab.contains(s)) return true;
        return false;
    }

    public boolean isHighest() {
        for (Score i : scoreTab) {
            if (i.value > this.value) {
                return false;
            }
        }
        return true;
    }

    public static Score getHighest() {
        for (Score i : scoreTab) {
            if (i.isHighest()) {
                return i;
            }
        }
        return null;
    }

    public static String getBestPlayerName() {
        return Score.getHighest().getPlayer().getName();
    }
}
