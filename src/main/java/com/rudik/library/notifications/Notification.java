package com.rudik.library.notifications;

public interface Notification {
    void send(String recipient, String message);
}
