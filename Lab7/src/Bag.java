import java.util.*;

public class Bag {
    private final List<Tile> tiles=new ArrayList<>();
    public Bag() {
        Tile t;
        for(char c='a'; c<='z'; c++) {
            for(int i=0;i<10;i++) {
                t=new Tile(c,(int)(Math.random()*1000)%10+1);
                tiles.add(t);
            }
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        int extractedindex;
        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }
            extractedindex=(int)(Math.random()*1000)%tiles.size();
            extracted.add(tiles.get(extractedindex));
            tiles.remove(extractedindex);
        }
        return extracted;
    }


}
