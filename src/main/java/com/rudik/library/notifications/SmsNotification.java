package com.rudik.library.notifications;

import org.springframework.stereotype.Component;

@Component
public class SmsNotification implements Notification{
    @Override
    public void send(String recipientPhone, String message){
        System.out.println("Sms to " + recipientPhone + " : " + message);
    }
}
