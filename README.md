# 🛒 Online Auction & Bidding System

## 📌 Problem Statement
The project is a **Java console application** that simulates an **Online Auction & Bidding System**.  
It is designed to manage the complete auction process including **items, sellers, bidders, bids, auctions, and settlements**.  

The main objectives are:
- To demonstrate **Object-Oriented Programming (OOP)** concepts like **Encapsulation, Aggregation, Inheritance, and Polymorphism**.  
- To enforce **auction business rules** such as:  
  - Auctions must have a **start and end window**; only bids placed during this time are valid.  
  - Each new bid must be **greater than the current highest bid**.  
  - At auction close, the **highest bid determines the winner**.  
  - Settlement occurs after **winner confirmation and payment**.  
  - Every bid is directly linked to an **auction and bidder**.  

The system is **menu-driven**, and allows users to:
- Add sellers and items  
- Create auctions with rules  
- Register bidders  
- Place and validate bids  
- Close auctions and determine winners  
- Process settlement and transfer items  

---

## How to Run (Eclipse IDE)

1. Open **Eclipse IDE**.  
2. Create a **Java Project** (e.g., `OnlineAuctionSystem`).  
3. Inside the `src` folder, create the following packages:  
   - `com.kce.auction.model`  
   - `com.kce.auction.service`  
   - `com.kce.auction.exception` (optional, for custom validations)  
   - `com.kce.auction.util` (optional, for helper classes)  
   - `com.kce.auction.main`  
4. Copy the respective **.java files** into their packages.  
5. Create a `Main.java` class inside `com.kce.auction.main` with a  
   ```java
   public static void main(String[] args)
method to run the menu-driven system.
6. Right-click the project → Run As > Java Application.
7. Use the console menu to interact with the system (Add Seller, Add Item, Create Auction, Register Bidder, Place Bid, Close Auction, Settle Payment, Display Auctions).

## OUTPUT:
<img width="1919" height="1007" alt="image" src="https://github.com/user-attachments/assets/3895514d-bd71-4b3f-bd9e-0f0aca6b95bf" />
<img width="1919" height="929" alt="image" src="https://github.com/user-attachments/assets/ea681cfd-f403-4022-8d21-18527eccd78c" />
<img width="1919" height="264" alt="image" src="https://github.com/user-attachments/assets/44dd2038-b826-4cef-ad28-186bef500022" />

## UML CLASS DIAGRAM:
<img width="650" height="983" alt="image" src="https://github.com/user-attachments/assets/cc694b34-3f66-4233-b659-420e4752105a" />

## STUDENT DETAILS:
NAME: RASMI RESHA A
ROLL NO: 717823P145


