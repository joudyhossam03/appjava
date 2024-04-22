/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce;

import java.util.Scanner;

/**
 *
 * @author joudi
 */
public class JavaApplication107 {

    /**
     * @param args 
     */
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the B-Commerce System!");

        System.out.println("Please enter your id");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Please enter your name");
        String name = scanner.nextLine();
        System.out.println("Please enter your address");
        String address = scanner.nextLine();
        Customer customer = new Customer(customerId, name, address);

        ElectronicProduct smartphone = new ElectronicProduct(1, "smartphone", 599.9f, "Samsung", 1);
        ClothingProduct tShirt = new ClothingProduct(2, "T-shirt", 19.99f, "Medium", "Cotton");
        BookProduct oopBook = new BookProduct(3, "OOP", 39.99f, "O’Reilly", "X Publications");

        System.out.println("How many products you want to add to your cart?");
        int nProducts = scanner.nextInt();
        Cart cart = new Cart(customer.getCustomerId(), nProducts);

        for (int i = 0; i < nProducts; i++) {
            System.out.println("Which product would you like to add? 1- Smartphone 2- I-Shirt 3- OOP");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    cart.addProduct(smartphone, i);
                    break;
                case 2:
                    cart.addProduct(tShirt, i);
                    break;
                case 3:
                    cart.addProduct(oopBook, i);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }

        float totalPrice = cart.calculatePrice();
        System.out.println("Your total is $" + totalPrice + ". Would you like to place the order? 1- Yes 2- No");
        int placeOrderChoice = scanner.nextInt();
        if (placeOrderChoice == 1) {
            cart.placeOrder();
        } else {
            System.out.println("Order placement canceled.");
        }

        scanner.close();
    }
}
  
    

