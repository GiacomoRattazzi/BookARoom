/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookaroom.v1.views;

import bookaroom.v1.controllers.UserController;
import bookaroom.v1.controllers.LoginController;
import bookaroom.v1.controllers.RoomController;
import bookaroom.v1.exceptions.AlreadyExistsException;
import bookaroom.v1.exceptions.DoesNotExistException;
import bookaroom.v1.exceptions.InvalidCreditCardException;
import java.util.Scanner;


/**
 *
 * @author giaco
 */
public class main {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to the BookARoom hotel website!");
        homePage();
    }
        private static void homePage() {
        String choice, username, password, firstName, lastName, email, ccexpirationdate, cccode, ccnumber;
        //String ver;
        
        do {
            System.out.println("Enter:"
                    + "\n[q] to quit the application"
                    + "\n[1] to login"
                    + "\n[2] to create a user account"
                    + "\n[3] to see rooms in the hotel");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter your username:");
                    username = sc.nextLine();
                    System.out.println("Enter your password:");
                    password = sc.nextLine();
                    LoginController.setUsername(username);
                    LoginController.setPassword(password);
                    LoginController.userLogsIn();
                    if (LoginController.getUserLoggedIn() != null) {
                        userHomePage();
                    }
                    break;
                case "2":
                    System.out.println("Enter a username:");
                    username = sc.nextLine();
                    System.out.println("Enter a first name:");
                    firstName = sc.nextLine();
                    System.out.println("Enter a last name:");
                    lastName = sc.nextLine();
                    System.out.println("Enter an email:");
                    email = sc.nextLine();
                    System.out.println("Enter a password:");
                    password = sc.nextLine();
                    System.out.println("PAYMENT INFORMATION");
                    //CCnumber:
                    ccnumber = "";
                    String code1 = "";
                    boolean numCorrect = false;
                    while(!numCorrect){

                            System.out.println("Enter a credit card number (16-digit number):"); 
                            code1 = sc.nextLine();
                            if (code1.length()!=16) {
                                System.out.println("The credit card number should a 16-digit number, yours is a "+code1.length()+"-digit number. Please enter it again");
                                
                            }
                            else if (code1.length()==16)
                                numCorrect =true;
                                ccnumber = code1;
                      }    
                    //CCcode:
                    cccode = "";
                    String code2 = "";
                    boolean codeCorrect = false;
                    while(!codeCorrect){
                        
                        System.out.println("Enter a verification code (3-digit number):");
                        code2 = sc.nextLine();
                        if (code2.length()!=3) {
                            System.out.println("The credit card number should a 3-digit number, yours is a "+code2.length()+"-digit number. Please enter it again");

                        }
                        else if (code2.length()==3)
                            codeCorrect =true;
                            cccode = code2;
                      }
                    
                    System.out.println("Enter an expiration date (month/year):");
                    ccexpirationdate = sc.nextLine();
                    UserController.setUsername(username);
                    UserController.setFirstName(firstName);
                    UserController.setLastName(lastName);
                    UserController.setEmail(email);
                    UserController.setPassword(password);
                    UserController.setCCnumber(ccnumber);
                    UserController.setCCcode(cccode);
                    UserController.setCCexpirationDate(ccexpirationdate);
                    UserController.createAUser();
                    break;
                case "3":
                    System.out.println(RoomController.getRooms());
                    break;
                case "q":
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Choice = " + choice + " does not exist.");
                    break;
            }
        } while (!choice.equals("q"));
        }
    public static void userHomePage() {
        String choice, subChoice, roomName;

        do {
            System.out.println("Enter:"
                    + "\n[q] to log out"
                    + "\n[1] to see rooms in the Hotel and adding one to Booking"
                    + "\n[2] to remove a room from Booking"
                    + "\n[3] to see Room in Booking and confirm it"
                    + "\n[4] to show user information");
                    //TODO if we finished the rest, do restaurants preferences
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println(RoomController.getRooms());
                    do {
                        System.out.println("Enter: "
                                + "\n[q] to go back"
                                + "\n[1] to add room from the hotel to Booking");
                        subChoice = sc.nextLine();
                        switch (subChoice) {
                            case "1":
                                System.out.println("Enter the name of the room:");
                                roomName = sc.nextLine();
                                RoomController.setRoomName(roomName);
                                RoomController.addRoomToBooking();
                                System.out.println("You have book "+ roomName +".");
                                break;  
                            case "q":
                                break;
                            default:
                                System.out.println("Choice = " + subChoice + " does not exist.");
                                break;
                        }
                    } while (!subChoice.equals("q"));
                    break;
                case "2":
                    System.out.println("Here are the products in Booking, write the name of the room you want to remove.");
                    System.out.println(LoginController.getUserLoggedIn().getBooking().toString());
                    System.out.println("Room name:");
                    roomName = sc.nextLine();
                    RoomController.setRoomName(roomName);
                    RoomController.removeRoomFromBooking();
                    break;
                case "3":
                    System.out.println("Here are the room(s) that you have booked.");
                    System.out.println(LoginController.getUserLoggedIn().getBooking().toString());
                    System.out.println("Room name:");
                    roomName = sc.nextLine();
                    UserController.completeBooking();
                    RoomController.setRoomName(roomName);
                    RoomController.removeRoomFromBooking();
                    //TODO: exception invalidcreditcard
                    break;
                case "4":
                    System.out.println(LoginController.getUserLoggedIn().toString());
                    break;
                case "q":
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Choice = " + choice + " does not exist.");
                    break;
            }
        } while (!choice.equals("q"));
        LoginController.userLogsout();
    }
}






