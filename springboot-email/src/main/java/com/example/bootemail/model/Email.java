package com.example.bootemail.model;

/**
 * @author wh
 * @description 邮箱实体类
 * @date 2019/4/24
 */
public class Email {
    //发送者邮箱
    private String senderEmail ;
    //接收者邮箱
    private String receiverEmail;
    //标题
    private String title;
    //主题内容
    private String content;
    //附件路径
    private String filePath;

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Email(String senderEmail, String receiverEmail, String title, String content , String filePath) {
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
        this.title = title;
        this.content = content;
        this.filePath = filePath;
    }

    public Email() {
    }

    @Override
    public String toString() {
        return "Email{" +
                "senderEmail='" + senderEmail + '\'' +
                ", receiverEmail='" + receiverEmail + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getFilePath() {

        return filePath;
    }


}
