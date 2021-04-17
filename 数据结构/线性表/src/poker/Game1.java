package poker;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
一副扑克牌
1.洗牌
2.给五名玩家各发两张牌,一次发牌
3.依次展示5名玩家手中的牌
 */
public class Game1 {

    public static card card;

    public static void main(String[] args) {

        //牌组
        List<card> cardList = new ArrayList<>();

        //玩家
        List<player> playerList = new ArrayList<>();
        playerList.add(new player("周润发"));
        playerList.add(new player("刘德华"));
        playerList.add(new player("周星驰"));
        playerList.add(new player("邱淑贞"));
        playerList.add(new player("今晚打老虎"));

        //初始化扑克牌
        initializeCards(cardList);

        //初始时牌库中的牌
        System.out.println("初始时牌库中的牌: ");
        System.out.println(cardList);

        //洗牌
        Collections.shuffle(cardList);
        System.out.println(cardList);

        int n = 5;//发五轮
        for (int i = 0; i < n; i++) {
            for (player player : playerList) {

                //从牌组中拿出第一张牌
                card card = cardList.remove(0);

                //把牌发到玩家手中
                player.cardList.add(card);
            }
        }

        //牌库中剩余牌
        System.out.println("发完牌后,牌库中的牌: ");
        System.out.println(cardList);

        System.out.println("抽牌前: ");
        for (player player : playerList) {
            System.out.println(player.toString() + player.cardList);
        }

        //获胜牌
        card toFindCard = new card("♥", 1);

        //周润发赌神技能发动
        System.out.println("周润发赌神技能发动: ");
        /*for (player player : playerList) {
            if (player.name.equals("周润发")) {
                if (!player.cardList.contains(toFindCard)) {
                    player.cardList.set(0,toFindCard);
                }
            }
        }*/
        power2(playerList, toFindCard);
        for (player player : playerList) {
            System.out.println(player.toString() + player.cardList);
        }

        //每名玩家随机抽取其下家的手牌
        Random random = new Random();
        for (int i = 0; i < playerList.size(); i++) {

            //每名玩家抽取其下家手牌
            player currentPlayer = playerList.get(i);
            player nextPlayer = playerList.get(i + 1 != playerList.size() ? i + 1 : 0);

            //要抽取的手牌的下标
            int toDrawIndex = random.nextInt(nextPlayer.cardList.size());

            //取牌
            card drawCard = nextPlayer.cardList.remove(toDrawIndex);

            //拿牌
            currentPlayer.cardList.add(drawCard);

        }
        System.out.println("抽牌后: ");
        for (player player : playerList) {
            System.out.println(player.toString() + player.cardList);
        }

        //周润发第二次赌神技能发动
        System.out.println("周润发第二次赌神技能发动");
        power2(playerList, toFindCard);

        for (player player : playerList) {
            System.out.println(player.toString() + player.cardList);
        }

        //开始判定
        for (player player : playerList) {
            if (player.cardList.contains(toFindCard)) {

                System.out.println(player.toString() + "获胜!!!!");
                return;

            }
        }

    }

    public static void initializeCards(List<card> cards) {
        for (String suit : new String[]{"♠", "♣", "♦", "♥"}) {

            for (int rank = 1; rank <= 13; rank++) {

                cards.add(new card(suit, rank));

            }
        }
    }

    public static void power1(List<player> playerList, card toFindCard) {
        for (player player : playerList) {
            if (player.name.equals("周润发")) {
                if (!player.cardList.contains(toFindCard)) {
                    player.cardList.set(0, toFindCard);
                }
            }
        }
    }

    public static void power2(List<player> playerList, card toFindCard) {

        for (player player : playerList) {
            if (player.name.equals("周润发")) {
                card = player.cardList.get(0);
                if (!player.cardList.contains(toFindCard)) {
                    player.cardList.set(0, toFindCard);
                }
            } else if (player.cardList.contains(toFindCard)) {
                player.cardList.set(player.cardList.indexOf(toFindCard), card);
            }
        }

    }
}
