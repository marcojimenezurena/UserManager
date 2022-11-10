/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.gestionusuarios;

import java.util.ArrayList;

/**
 *
 * @author mjimen19
 */
public class User {
    private String name;
    private String password;
    private String email;
    private String answerToSecurityQuestion;
    private int numQuestion;
    private ArrayList<Message> messages = new ArrayList<Message>();

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        numQuestion = -1;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAnswerToSecurityQuestion() {
        return answerToSecurityQuestion;
    }

    public void setAnswerToSecurityQuestion(String answerToSecurityQuestion, int numQuestion) {
        this.answerToSecurityQuestion = answerToSecurityQuestion;
        this.numQuestion = numQuestion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
    
    public void addMessage(Message msg){
        messages.add(msg);
    }

    public int getNumQuestion() {
        return numQuestion;
    }
    
    
}
