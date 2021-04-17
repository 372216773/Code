package poker;

import java.util.ArrayList;
import java.util.List;

public class player {

    public String name;

    public player(String name) {
        this.name = name;
    }

    List<card> cardList = new ArrayList<>();

    @Override
    public String toString() {
        return "player:" + name ;
    }
}
