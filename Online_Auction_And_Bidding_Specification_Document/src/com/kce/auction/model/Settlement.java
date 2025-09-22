package com.kce.auction.model;

public class Settlement {
	private Winner winner;
	private boolean paid=false;
	public Settlement(Winner winner) {
		this.winner=winner;
	}
	@Override
	public String toString() {
		return winner.toString()+"|Paid:"+paid;
	}

}
