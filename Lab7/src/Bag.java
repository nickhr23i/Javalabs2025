import java.util.*;

public class Bag {
    private final List<Tile> tiles=new ArrayList<>();
    public Bag() {
        Tile t;
        int points;
        for(char c='a'; c<='z'; c++) {
            points=(int)(Math.random()*1000)%10+1;
            for(int i=0;i<10;i++) {
                t=new Tile(c,points);
                getTiles().add(t);
            }
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        int extractedindex;
        for (int i = 0; i < howMany; i++) {
            if (getTiles().isEmpty()) {
                break;
            }
            extractedindex=(int)(Math.random()*1000)% getTiles().size();
            extracted.add(getTiles().get(extractedindex));
            getTiles().remove(extractedindex);
        }
        return extracted;
    }

    public synchronized void discardTiles(List<Tile> discarded) {
        getTiles().addAll(discarded);
    }


    public List<Tile> getTiles() {
        return tiles;
    }
}
