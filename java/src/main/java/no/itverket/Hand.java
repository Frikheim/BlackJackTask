package no.itverket;

import java.util.ArrayList;
import java.util.List;

public class Hand {
     List<Card> hand;

    public int getTotal() {
        return total;
    }

    private int total;

     Hand() {
       hand  = new ArrayList<>();
       total = 0;
     }

     void addCard(Card card) {
         hand.add(card);
         if(card.rank == 1) {
             if(total + 11 > 21) {
                 total += card.rank;
             }
             else {
                 total += 11;
             }
         }
         else {
             total += card.rank;
         }
     }
}
