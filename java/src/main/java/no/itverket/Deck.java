package no.itverket;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

class Deck {
    Queue<Card> cards;

    Deck() {
        cards = new ArrayDeque<>();
        ArrayList<Card> cardList = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int i = 1; i < 14; i++) {
                cardList.add(new Card(suit, i));
            }
        }
        Random random = new Random();
        while(!cardList.isEmpty()) {
            int index = random.nextInt(cardList.size());
            cards.offer(cardList.get(index));
            cardList.remove(index);
        }
    }
}
