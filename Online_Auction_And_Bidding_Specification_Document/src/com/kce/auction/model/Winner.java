package com.kce.auction.model;

public class Winner {
    private Auction auction;
    private Bid bid;

    public Winner(Auction auction, Bid bid) {
        this.auction = auction;
        this.bid = bid;
    }

    public Auction getAuction() { return auction; }
    public Bid getBid() { return bid; }

    @Override
    public String toString() {
        if (bid == null) return "No winner for auction: " + auction.getItem().getName();
        return "Winner: " + bid.getBidder().getName() 
            + " | Item: " + auction.getItem().getName() 
            + " | Amount: $" + bid.getAmount();
    }
}
