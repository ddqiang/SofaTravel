package com.example.dllo.sofatravel.main.main.order;

/**
 * Created by dllo on 16/7/25.
 */
public class ConversationBean {
    private String sendUserName;
    private String receiverUserName;
    private String text;
    private String sendAccountName;
    private String receiverAccountName;
    private int type;

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getReceiverUserName() {
        return receiverUserName;
    }

    public void setReceiverUserName(String receiverUserName) {
        this.receiverUserName = receiverUserName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSendAccountName() {
        return sendAccountName;
    }

    public void setSendAccountName(String sendAccountName) {
        this.sendAccountName = sendAccountName;
    }

    public String getReceiverAccountName() {
        return receiverAccountName;
    }

    public void setReceiverAccountName(String receiverAccountName) {
        this.receiverAccountName = receiverAccountName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
