package no.itverket;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        final Deck deck = new Deck();
        final Hand playerHand = new Hand();
        final Hand dealerHand = new Hand();
        int playerTotal = 0;
        int dealerTotal;

        final Card dealerCard = deck.cards.remove();
        dealerHand.addCard(dealerCard);
        dealerTotal = dealerHand.getTotal();
        System.out.printf("Dealer drew %s %s. Dealer has %s. Your turn%n", dealerCard.suit, dealerCard.getRankString(), dealerTotal);
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Stand, Hit");
            final String read = scanner.nextLine();

            if (read.equals("Hit")) {
                final Card card = deck.cards.remove();
                playerHand.addCard(card);
                playerTotal = playerHand.getTotal();
                if(playerTotal > 21) {
                    System.out.printf("Hit with %s %s. Total is %s.%n", card.suit, card.getRankString(), playerTotal);
                    break;
                }
                if(playerTotal == 21) {
                    System.out.printf("Hit with %s %s. Total is %s. Blackjack!%n", card.suit, card.getRankString(), playerTotal);
                    break;
                }
                System.out.printf("Hit with %s %s. Total is %s%n", card.suit, card.getRankString(), playerTotal);
            } else if (read.equals("Stand")) {
                break;
            }
        }
        while (true) {
            if(playerTotal > 21) {
                break;
            }
            System.out.println("Dealer's turn");
            final Card card = deck.cards.remove();
            dealerHand.addCard(card);
            dealerTotal = dealerHand.getTotal();
            if(dealerTotal > 21) {
                System.out.printf("Dealer drew  %s %s. Dealer has %s. The game is over%n", card.suit, card.getRankString(), dealerTotal);
                break;
            }
            if(dealerTotal == 21) {
                System.out.printf("Dealer drew  %s %s. Dealer has %s. Blackjack!%n", card.suit, card.getRankString(), dealerTotal);
                break;
            }
            System.out.printf("Dealer drew  %s %s. Dealer has %s.%n", card.suit, card.getRankString(), dealerTotal);
            if(dealerTotal > 16) {
                System.out.println("Dealer stands, game is over");
                break;
            }
        }
        if(dealerTotal > playerTotal ) {
            if(dealerTotal > 21) {
                System.out.printf("You won the game! The dealer got %s, which is over 21%n", dealerTotal);
            }
            System.out.println("You lost the game!");
        }
        else if (playerTotal > 21) {
            System.out.println("You lost the game!");
        }
        else if(dealerTotal == playerTotal) {
            System.out.printf("It is a draw! You both got %s.%n", playerTotal);
        }
        else {
            System.out.println("You won the game!");
        }
    }
}
