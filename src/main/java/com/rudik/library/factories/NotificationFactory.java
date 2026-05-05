package com.rudik.library.factories;

import com.rudik.library.notifications.EmailNotification;
import com.rudik.library.notifications.Notification;
import com.rudik.library.notifications.SmsNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {
    private final EmailNotification emailNotification;
    private final SmsNotification smsNotification;

    @Autowired
    public NotificationFactory(EmailNotification emailNotification, SmsNotification smsNotification){
        this.emailNotification = emailNotification;
        this.smsNotification = smsNotification;
    }

    public Notification createSmsNotification(){
        return smsNotification;
    }

    public Notification createEmailNotification(){
        return emailNotification;
    }
}
