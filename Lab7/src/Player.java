import java.util.*;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running = true;
    private int points = 0;
    private List<Tile> tiles = new ArrayList<>();
    private List<Tile> used = new ArrayList<>();

    public Player(String name, Game game) {
        this.setName(name);
        this.game = game;
        tiles = game.getBag().extractTiles(7);
    }

    private boolean createWord(String word, List<Tile> available) {
        if (available.isEmpty()) return false;
        for (Tile t : available) {
            word += t.toString();
            used.add(t);
            points += t.getPoints();
            if (game.getDictionary().isWord(word)&&((word.length()>=2)||available.size()<=2)) {
                game.getBoard().addWord(this, word);
                return true;
            }
            else {
                List<Tile> next = new ArrayList<>(available);
                next.remove(t);
                if(createWord(word, next)==true) return true;
            }
            word=word.substring(0,word.length()-1);
            used.remove(t);
            points -= t.getPoints();
        }
        return false;
    }

    private boolean submitWord() {
        used.clear();
        if(createWord("",tiles)==true) {
            tiles.removeAll(used);
            List<Tile> extracted = game.getBag().extractTiles(7 - tiles.size());
            tiles.addAll(extracted);
        }
        else{
            game.getBag().discardTiles(tiles);
            tiles.clear();
            tiles=game.getBag().extractTiles(7);
        }
        if (tiles.isEmpty()) {
            return false;
        }
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public void run() {
        while (isRunning()) {
            setRunning(submitWord());
        }
        System.out.println(name + " " + points);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}