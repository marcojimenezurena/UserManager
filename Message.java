/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.gestionusuarios;

/**
 *
 * @author mjimen19
 */
public class Message {
    
    private String text;
    private User sender;

    public Message(String text, User sender) {
        this.text = text;
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public User getSender() {
        return sender;
    }
    
    
}
