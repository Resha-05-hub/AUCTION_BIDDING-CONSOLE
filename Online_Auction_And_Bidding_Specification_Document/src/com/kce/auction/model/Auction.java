package com.kce.auction.model;
import java.util.ArrayList;
import java.util.List;
public class Auction {
	private String id;
	private AuctionItem item;
	private List<Bid>bids=new ArrayList<>();
	private boolean closed=false;
	public Auction(String id, AuctionItem item) {
		this.id=id;
		this.item=item;
	}
	public String getId() {
		return id;
	}
	public AuctionItem getItem() {
		return item;
	}
	public List<Bid>getBids(){
		return bids;
	}
	public boolean isClosed() {
		return closed;
	}
	public void addBid(Bid bid) {
        bids.add(bid);
    }

    public Bid getHighestBid() {
        if (bids.isEmpty()) return null;
        Bid highest = bids.get(0);
        for (Bid b : bids) {
            if (b.getAmount() > highest.getAmount()) {
                highest = b;
            }
        }
        return highest;
    }

    public void closeAuction() {
        closed = true;
    }

    @Override
    public String toString() {
        return id + " - " + item.getName() + " | Closed: " + closed
            + " | Highest Bid: " + (getHighestBid() != null ? getHighestBid() : "None");
    }
}