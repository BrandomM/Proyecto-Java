package com.simecad.simecad.service;

public interface EmailService {

    void sendSimpleMessageToOne(String to, String subject, String text);

    void sendSimpleMessageToMany(String[] to, String subject, String text);

    void sendMessageWithAttachmentToOne(
            String to, String subject, String text, String pathToAttachment, String filename);

    void sendMessageWithAttachmentToMany(
            String[] to, String subject, String text, String pathToAttachment, String filename);
}
