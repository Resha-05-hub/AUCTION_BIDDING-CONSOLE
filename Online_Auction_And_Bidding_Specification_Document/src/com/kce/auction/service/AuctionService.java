package com.kce.auction.service;
import com.kce.auction.model.*;
import com.kce.auction.exception.AuctionException;
import java.util.*;
public class AuctionService {
    private Map<String, Seller> sellers = new HashMap<>();
    private Map<String, AuctionItem> items = new HashMap<>();
    private Map<String, Bidder> bidders = new HashMap<>();
    private Map<String, Auction> auctions = new HashMap<>();
    private int sellerCount=1,itemCount=1,bidderCount=1,auctionCount=1;
    public Seller addSeller(String name){ 
    	Seller s=new Seller("S"+sellerCount++,name); 
    	sellers.put(s.getId(),s); return s; }
    public AuctionItem addItem(String name,double reserve,String sid)throws AuctionException{
        Seller s=sellers.get(sid.toUpperCase()); 
        if(s==null) throw new AuctionException("Seller not found");
        AuctionItem i=new AuctionItem("I"+itemCount++,name,reserve,s); 
        items.put(i.getId(),i); return i;
    }
    public Bidder registerBidder(String name){ 
    	Bidder b=new Bidder("B"+bidderCount++,name); 
    bidders.put(b.getId(),b); return b; 
    }
    public Auction createAuction(String iid)throws AuctionException{
        AuctionItem it=items.get(iid.toUpperCase()); 
        if(it==null) throw new AuctionException("Item not found");
        Auction a=new Auction("A"+auctionCount++,it); 
        auctions.put(a.getId(),a); return a;
    }
    public void placeBid(String aid,String bidId,double amt)throws AuctionException{
        Auction a=auctions.get(aid.toUpperCase()); 
        if(a==null) throw new AuctionException("Auction not found");
        if(a.isClosed()) throw new AuctionException("Auction closed");
        Bidder b=bidders.get(bidId.toUpperCase()); 
        if(b==null) throw new AuctionException("Bidder not found");
        double min=a.getHighestBid()==null?a.getItem().getReservePrice():a.getHighestBid().getAmount();
        if(amt<=min) throw new AuctionException("Bid must be higher than current highest");
        a.addBid(new Bid(b,amt));
        System.out.println(b.getName()+" placed $" + amt);
        System.out.println("Highest: $" + a.getHighestBid().getAmount()+" by "+a.getHighestBid().getBidder().getName());
    }
    public Winner closeAuction(String aid)throws AuctionException{
        Auction a=auctions.get(aid.toUpperCase()); 
        if(a==null) throw new AuctionException("Auction not found");
        a.closeAuction(); 
        Bid h=a.getHighestBid();
        if(h==null){ 
        	System.out.println("No bids on "+a.getItem().getName()); 
        	return null; 
        	}
        System.out.println("Closed "+a.getItem().getName()+" | Winner: "+h.getBidder().getName()+" $" + h.getAmount());
        return new Winner(a,h);
    }
    public void settlePayment(Winner w){
        if(w==null) return;
        System.out.println("----- Settlement -----");
        System.out.println("Item: "+w.getAuction().getItem().getName());
        System.out.println("Winner: "+w.getBid().getBidder().getName()+" | Paid: $"+w.getBid().getAmount());
        System.out.println("Item transferred ");
    }
    public void displayAuctions(){ 
    	if(auctions.isEmpty()) System.out.println("No auctions"); 
    	else auctions.values().forEach(System.out::println); 
    	}
    public Map<String,Seller> getSellers(){
    	return sellers;
    	}
    public Map<String,AuctionItem> getItems(){
    	return items;
    	}
    public Map<String,Bidder> getBidders(){
    	return bidders;
    	}
    public Map<String,Auction> getAuctions(){
    	return auctions;
    	}
}
