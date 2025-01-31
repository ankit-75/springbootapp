package assignment.assignment2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Player player = new MusicPlayer(Arrays.asList("Track1", "Track2", "Track3"));
        player.playOrPause();
        player.playOrPause();
        player.playOrPause();


        player.stop();
        player.stop();


        player.next();
        player.next();
        player.next();
        player.next();

        player.repeatOnOrOff();
        player.next();
        player.next();
        player.next();

        player.repeatOnOrOff();
        player.next();
        player.next();

        player.previous();
        player.previous();
        player.previous();

        player.repeatOnOrOff();
        player.previous();
        player.previous();
        player.previous();
        player.previous();

    }
}
