package poker;

import java.util.*;

/*
抓鬼:去掉一张牌
五人依次抓牌,直到把所有的牌都抓光.抓牌期间,一旦出现两张牌点数相同,就可以扔掉

正式游戏:
一回合:
每个人抽取下家的一张随即手牌
    如果谁的手牌被抽完了,则谁退出游戏
直到只剩一个人,就算抓到鬼了
 */
public class Game2 {

    public static void main(String[] args) {


        List<card> cardList = new ArrayList<>();

        List<player> playerList = new ArrayList<>();
        playerList.add(new player("周润发"));
        playerList.add(new player("刘德华"));
        playerList.add(new player("周星驰"));
        playerList.add(new player("邱淑贞"));
        playerList.add(new player("今晚打老虎"));

        //初始化扑克牌
        initializeCards(cardList);

        System.out.println("初始时扑克牌组: ");
        System.out.println(cardList);

        //洗牌
        System.out.println("洗牌: ");
        Collections.shuffle(cardList);
        System.out.println(cardList);

        //发牌
        //popCard(5,playerList,cardList);

        //看牌
        //System.out.println("看牌: ");
        //displayCards(playerList);

        //抽牌
        popCards(playerList, cardList);

        //将手中无牌的人排除
        Iterator<player> iterator = playerList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().cardList.isEmpty()) {
                iterator.next();
            }
        }

        Random random = new Random();
        //游戏开始
        while (true) {
            for (int i = 0; i < playerList.size(); i++) {
                player currentPlayer = playerList.get(i);


            }
        }

    }

    public static void initializeCards(List<card> cardList) {

        for (String suit : new String[]{"♥", "♦", "♣", "♠"}) {
            for (int rank = 1; rank < 14; rank++) {
                cardList.add(new card(suit, rank));
            }
        }

    }

    public static void displayCards(List<player> playerList) {

        for (player player : playerList) {
            System.out.println(player.name + ": " + player.cardList);
        }

    }

    public static void popCards(List<player> playerList, List<card> cardList) {

        //先从牌库中把牌抽完
        while (true) {

            for (player player : playerList) {

                if (cardList.isEmpty()) {
                    return;
                }

                card card = cardList.remove(0);

                if (player.cardList.contains(card)) {

                    Iterator<card> iterator = player.cardList.iterator();

                    while (iterator.hasNext()) {
                        if (iterator.next().equals(card)) {
                            iterator.remove();
                        }
                    }
                } else {
                    player.cardList.add(card);
                }
            }
        }
    }
}
