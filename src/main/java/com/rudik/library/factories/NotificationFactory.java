package com.rudik.library.factories;

import com.rudik.library.notifications.EmailNotification;
import com.rudik.library.notifications.Notification;
import com.rudik.library.notifications.SmsNotification;

public class NotificationFactory {
    public Notification createEmailNotification(){
        return new EmailNotification();
    }

    public Notification createSmsNotification(){
        return new SmsNotification();
    }
}
