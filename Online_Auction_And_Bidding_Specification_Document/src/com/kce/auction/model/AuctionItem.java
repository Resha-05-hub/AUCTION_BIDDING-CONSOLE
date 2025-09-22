package com.kce.auction.model;

public class AuctionItem {
	private String id;
	private String name;
	private double reservePrice;
	private Seller seller;
	public AuctionItem(String id, String name, double reservePrice, Seller seller) {
		this.id=id;
		this.name=name;
		this.reservePrice=reservePrice;
		this.seller=seller;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getReservePrice() {
		return reservePrice;
	}
	public Seller getSeller() {
		return seller;
	}
	@Override
	public String toString() {
		return id + " - " + name + " | Reserve: $" + reservePrice + " | Seller: " + seller.getName();
	}

}
