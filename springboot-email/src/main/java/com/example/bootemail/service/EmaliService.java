package com.example.bootemail.service;

import com.example.bootemail.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author wh
 * @description 邮箱服务
 * @date 2019/4/24
 */
@Service
public class EmaliService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    JavaMailSenderImpl javaMailSenderImpl;

    /**
     * 发送普通邮件
     * @param email
     */
    public void send(Email email){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(email.getSenderEmail());
        simpleMailMessage.setTo(email.getReceiverEmail());
        simpleMailMessage.setSubject(email.getTitle());
        simpleMailMessage.setText(email.getContent());
        javaMailSender.send(simpleMailMessage);
    }

    /**
     * 发送带附件的邮件
     */
    public void sendAccessory(Email email){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(email.getSenderEmail());
            mimeMessageHelper.setTo(email.getReceiverEmail());
            mimeMessageHelper.setSubject(email.getTitle());
            mimeMessageHelper.setText(email.getContent(),true);
            FileSystemResource systemResource = new FileSystemResource(new File(email.getFilePath()));
            String fileName=email.getFilePath().substring(email.getFilePath().lastIndexOf(File.separator));
            mimeMessageHelper.addAttachment(fileName,systemResource);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 群发普通邮件
     * @param email
     */
    public void sendGroupEmail(Email email){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(email.getSenderEmail());
        String emailAddress[] = {"1065036424@qq.com","925346457@qq.com","928041057@qq.com"};
        simpleMailMessage.setTo(emailAddress);
        simpleMailMessage.setSubject(email.getTitle());
        simpleMailMessage.setText(email.getContent());
        javaMailSender.send(simpleMailMessage);
    }
}
