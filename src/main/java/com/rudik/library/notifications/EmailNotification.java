package com.rudik.library.notifications;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements Notification{
    @Override
    public void send(String recipientEmail, String message){
        System.out.println("Email to " + recipientEmail + " : " + message);
    }
}
