package com.kce.auction.main;
import com.kce.auction.model.*;
import com.kce.auction.service.*;
import com.kce.auction.exception.AuctionException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AuctionService service = new AuctionService();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        System.out.println("===== Welcome to Simple Online Auction System =====");

        while (!exit) {
            System.out.println("\n1. Add Seller  2. Add Item  3. Register Bidder  4. Create Auction  5. Place Bid  6. Close Auction  7. Display Auctions  8. Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine();

            try {
                switch(choice) {
                    case "1": 
                        System.out.print("Seller name: "); 
                        System.out.println(service.addSeller(sc.nextLine())); 
                        break;

                    case "2": 
                        if(service.getSellers().isEmpty()) {
                            System.out.println("No sellers found! Add a seller first.");
                            break;
                        }
                        service.getSellers().forEach((id, s) -> System.out.println(id + ": " + s.getName()));
                        System.out.print("Seller id: "); 
                        String sid = sc.nextLine().toUpperCase();
                        System.out.print("Item name: "); 
                        String iname = sc.nextLine();
                        System.out.print("Reserve price: "); 
                        double reserve = Double.parseDouble(sc.nextLine());
                        System.out.println(service.addItem(iname, reserve, sid));
                        break;
                    case "3":
                        System.out.print("Bidder name: "); 
                        System.out.println(service.registerBidder(sc.nextLine())); 
                        break;
                    case "4":
                        if(service.getItems().isEmpty()) {
                            System.out.println("No items found! Add items first.");
                            break;
                        }
                        service.getItems().forEach((id, i) -> System.out.println(id + ": " + i.getName()));
                        System.out.print("Item id: "); 
                        String iid = sc.nextLine().toUpperCase();
                        System.out.println(service.createAuction(iid));
                        break;
                    case "5":
                        if(service.getAuctions().isEmpty()) {
                            System.out.println("No auctions found! Create an auction first.");
                            break;
                        }
                        service.getAuctions().forEach((id, a) -> System.out.println(id + ": " + a.getItem().getName()));
                        System.out.print("Auction id: "); 
                        String aid = sc.nextLine().toUpperCase();
                        if(service.getBidders().isEmpty()) {
                            System.out.println("No bidders registered! Register first.");
                            break;
                        }
                        service.getBidders().forEach((id, b) -> System.out.println(id + ": " + b.getName()));
                        System.out.print("Bidder id: "); 
                        String bidId = sc.nextLine().toUpperCase();
                        System.out.print("Amount: "); 
                        double amt = Double.parseDouble(sc.nextLine());
                        service.placeBid(aid, bidId, amt);
                        break;
                    case "6":
                        service.getAuctions().forEach((id, a) -> System.out.println(id + ": " + a.getItem().getName()));
                        System.out.print("Auction id to close: ");
                        Winner w = service.closeAuction(sc.nextLine().toUpperCase());
                        if(w != null) service.settlePayment(w);
                        break;
                    case "7": 
                        service.displayAuctions(); 
                        break;
                    case "8": 
                        exit = true; 
                        System.out.println("Exiting program... Goodbye!"); 
                        break;
                    default: 
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch(AuctionException e) {
                System.out.println("Error: " + e.getMessage());
            } catch(Exception e) {
                System.out.println("Invalid input! Please enter correct values.");
            }
        }
        sc.close();
    }
}
