package com.kce.auction.model;

public class Bidder {
	private String id;
	private String name;
	public Bidder(String id, String name) {
		this.id=id;
		this.name=name;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return id+"-"+name;
	}

}
