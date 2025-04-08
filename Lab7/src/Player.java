import java.util.*;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running=true;
    public Player(String name,Game game) { this.setName(name); this.game=game; }
    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        String word="";
        for(Tile t : extracted) {
            word+=t.toString();
        }
        game.getBoard().addWord(this, word);
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public void run() {
        while(running) {
            running=submitWord();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}