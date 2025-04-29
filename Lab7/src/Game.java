import java.util.*;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary("dictionary.txt");
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void play() {
        Timekeeper tk = new Timekeeper();
        tk.setDaemon(true);
        tk.start();
        for (Player player : players) {
            new Thread(player).start();
        }
        boolean ok = true;
        while (ok) {
            if (bag.getTiles().size() == 0 || tk.isInterrupted() == true) {
                for (Player player : players) {
                    player.setRunning(false);

                }
                ok = false;
            }
        }

    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1", game));
        game.addPlayer(new Player("Player 2", game));
        game.addPlayer(new Player("Player 3", game));
        game.play();
    }

    public Dictionary getDictionary() {
        return dictionary;
    }
}