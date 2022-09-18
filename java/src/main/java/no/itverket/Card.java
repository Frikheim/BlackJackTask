package no.itverket;

class Card {
    Suit suit;
    int rank;

    Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getRankString() {
        String rankString;
        if(rank == 1) {
            rankString = "A";
        } else if (rank == 11) {
            rankString = "j";
        } else if (rank == 12) {
            rankString = "Q";
        }
        else if (rank == 13) {
        rankString = "K";
        }
        else {
            rankString = String.valueOf(rank);
        }
        return rankString;
    }
}
