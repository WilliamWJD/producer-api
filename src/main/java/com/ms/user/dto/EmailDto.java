package com.ms.user.dto;

import java.util.UUID;

public class EmailDto {
    private UUID userId;
    private String emailTo;
    private String subjetc;
    private String text;

    public EmailDto(){
    }

    public EmailDto(UUID userId, String emailTo, String subjetc, String text) {
        this.userId = userId;
        this.emailTo = emailTo;
        this.subjetc = subjetc;
        this.text = text;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubjetc() {
        return subjetc;
    }

    public void setSubjetc(String subjetc) {
        this.subjetc = subjetc;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "EmailDto{" +
                "userId=" + userId +
                ", emailTo='" + emailTo + '\'' +
                ", subjetc='" + subjetc + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
