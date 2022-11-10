/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.curso.gestionusuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author mjimen19
 */
public class GestionUsuarios {

    private static final HashMap users = new HashMap();
    private static User userLogged;
    private static ArrayList<String> questions = new ArrayList();
    
    public static void main(String[] args) {
        questions.add("What is your favourite food?");
        
        System.out.println("Welcome to the useless program of login into the void");
        
        
        Scanner sc = new Scanner(System.in);
        String command;
        do{
            System.out.println("Enter a command");
            System.out.println("1 -> Register new user");
            System.out.println("2 -> Log in");
            System.out.println("exit -> End the program");
            System.out.println("-----------------------------------------");
            command = sc.nextLine();
            
            switch(command){
                case "1" -> commandRegister(sc);
                case "2" -> commandLogin(sc);
            }
            
        }while(!command.equals("exit"));
    }
    
    //
    // MAIN MENU COMMANDS
    //
    
    private static void commandRegister(Scanner sc){
        System.out.println("Enter the name of the new user:");
        String name = sc.nextLine();
        System.out.println("Enter a password:");
        String password = sc.nextLine();
        System.out.println("Enter the email:");
        String email = sc.nextLine();
        
        if(users.containsKey(name)){
            System.out.println("That username already exists");
            System.out.println("-------------------------------");
        }else{
            users.put(name, new User(name,password,email));
        }
    }
    
    private static void commandLogin(Scanner sc){
        System.out.println("Enter the username:");
        String name = sc.nextLine();
        if(!users.containsKey(name)){
            System.out.println("This username doesn't exists");
            System.out.println("------------------------------------------");
        }else{
            System.out.println("Enter the password:");
            String password = sc.nextLine();
            User user = (User) users.get(name);
            if(user.getPassword().equals(password)){
                userLogged = user;
                commandLoggedUser(sc);
            }else{
                System.out.println("The password is incorrect");
                if(user.getNumQuestion() != -1){
                    System.out.println("If you want to change the password, answer the security question");
                    System.out.println("Else enter 'exit' to go back to the menu");
                    System.out.println(questions.get(user.getNumQuestion()));
                    String answer = sc.nextLine();
                    if(!"exit".equals(answer)){
                        if(answer.equals(user.getAnswerToSecurityQuestion())){
                            System.out.println("Correct. Now enter the new password");
                            String pass = sc.nextLine();
                            user.setPassword(pass);
                        }
                    }
                    System.out.println("-----------------------------------------");
                }
            }
        }
    }
    
    private static void commandLoggedUser(Scanner sc){
        
        String command;
        do{
            System.out.println("-------------------------------------------");
            System.out.println("You are logged as user " + userLogged.getName());
            System.out.println("Enter a command:");
            System.out.println("1 -> Set a security question");
            System.out.println("2 -> Modify email");
            System.out.println("3 -> Change password");
            System.out.println("4 -> Send a message");
            System.out.println("5 -> See your inbox");
            System.out.println("0 -> Log out");
            System.out.println("-----------------------------------------");
            command = sc.nextLine();
            
            switch(command){
                case "1" -> commandSetSecurityQuestion(sc);
                case "2" -> commandModifyEmail(sc);
                case "3" -> commandChangePassword(sc);
                case "4" -> commandSendMessage(sc);
                case "5" -> commandSeeInbox();
            }
            
        }while(!command.equals("0"));
    }
    
    
    //
    //  LOGGED USER COMMANDS
    //
    
    private static void commandSetSecurityQuestion(Scanner sc){
        System.out.println("Select a security question:");
        
        
        
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(i + " -> " + questions.get(i));
        }
        
        int chosenQuestion = 0;
        do{
            try{
                chosenQuestion = sc.nextInt();
            }catch(Exception e){
                System.out.println("Enter a valid question number");
            }
        }while(chosenQuestion < 0 || chosenQuestion >= questions.size());
        
        System.out.print("Enter your answer to the question: ");
        System.out.println(questions.get(chosenQuestion));
        
        sc.nextLine();  //To clear the previous nextInt
        String answer = sc.nextLine();
        userLogged.setAnswerToSecurityQuestion(answer,chosenQuestion);
        
    }
    
    private static void commandModifyEmail(Scanner sc){
        System.out.println("--------------------------------");
        System.out.println("Your current email is " + userLogged.getEmail());
        System.out.println("Enter the new email:");
        
        String email = sc.nextLine();
        
        userLogged.setEmail(email);
        
        System.out.println("You changed your email succesfully");
    }
    
    private static void commandChangePassword(Scanner sc){
        System.out.println("--------------------------------");
        System.out.println("Your current password is " + userLogged.getPassword());
        System.out.println("Enter the new password:");
        
        String pass = sc.nextLine();
        
        userLogged.setPassword(pass);
        
        System.out.println("You changed your password succesfully");
    }
    
    private static void commandSendMessage(Scanner sc){
        System.out.println("Enter the name of the destination from the list:");
        System.out.println("---------------------------------------");
        for(Object name : users.keySet()){
            System.out.println(name);
        }
        System.out.println("---------------------------------------");
        
        String name = sc.nextLine();
        
        System.out.println("Enter the message you want to send:");
        String msg = sc.nextLine();
        if(users.containsKey(name)){
            User destination = (User) users.get(name);
            destination.addMessage(msg);
            System.out.println("The message was sent succesfully");
        }else{
            System.out.println("The destination doesn't exists");
        }
        
    }
    
    private static void commandSeeInbox(){
        System.out.println("List of your received messages");
        System.out.println("------------------------------------");
        ArrayList<String> msg = userLogged.getMessages();
        for(String s : msg){
            System.out.println(s);
            System.out.println("********************************");
        }
        System.out.println("------------------------------------");
    }
}
