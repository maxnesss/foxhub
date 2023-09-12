package com.gfa.foxbook.foxbook.services;


import com.gfa.foxbook.foxbook.models.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl {
    private final JavaMailSender mailSender;

    public void send(String to, String subject, String text) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("gfafoxbook@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);

        mailSender.send(message);
    }
  
    public String generateWelcomeEmail(String firstName){
        return "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0\"><title>Welcome to FoxHub</title></head><body><div style=\"max-width:600px;margin:0 auto;padding:20px;background-color:#ffffff;box-shadow:0px 0px 10px 0px rgba(0,0,0,0.1);\"><h1 style=\"color:#4CAF50;text-align:left;\">Welcome to FoxHub</h1><h3 style=\"color:#333333;\">Hi! Thank you for registering, "+firstName+"</h3><p style=\"color:#666666;\">We wish to welcome you to your new favorite site! We're excited to have you join our community. Feel free to explore, connect with others, and share your thoughts. If you have any questions, don't hesitate to reach out.</p><p style=\"margin-top:20px;font-size:12px;color:#aaaaaa;text-align:center;\">You received this email because you just signed up for a new account. If it wasn't you, please let us know.</p><div style=\"display:flex;align-items:center;justify-content:center;\"><img src=\"https://uploads-ssl.webflow.com/5a8e9877a63d300001a1b0bc/64831b7b4d0859996e81ed15_corporate%20logo%20c.png\" alt=\"img of fox\"></div></div></body></html>";
    }
  
    public String generateVerificationEmail(String token) {
        return "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0\"><title>Email Verification for FoxHub</title></head><body><div style=\"max-width:600px;margin:0 auto;padding:20px;background-color:#ffffff;box-shadow:0px 0px 10px 0px rgba(0,0,0,0.1);\"><h1 style=\"color:#4CAF50;text-align:left;\">Email Verification for FoxHub</h1><p style=\"color:#666666;\">Thank you for registering with FoxHub. Please verify your email by clicking on the link below:</p><p style=\"color:#666666;\"><a href=\"http://foxhub.gfapp.eu/api/v1/auth/verify-email/" + token + "\" style=\"color: #4CAF50;\">Verify Email</a></p><p style=\"margin-top:20px;font-size:12px;color:#aaaaaa;text-align:center;\">If you did not register for an account with FoxHub, please ignore this email.</p></div></body></html>";
    }

    // Check how the list of users is displayed after logic is implemented
    public String generateOrderToGFAEmail(List<User> selectedUsers, String headhunterName) {
        return "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>FoxHub - New Order Notification</title></head><body><div style=\"max-width: 600px; margin: 0 auto; padding: 20px; background-color: #ffffff; box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);\"><h1 style=\"color: #4CAF50; text-align: left;\">FoxHub - New Order Notification</h1><h3 style=\"color: #333333;\">Hello Team,</h3><p style=\"color: #666666;\">A new order has been placed on FoxHub.</p><table style=\"border-collapse: collapse; width: 100%; margin-top: 20px;\"><tbody>\" + selectedUsers + \"</tbody></table><p style=\"color: #666666; margin-top: 20px;\">Total amount: <strong>\" + selectedUsers.length + \"</strong></p><p style=\"color: #666666;\">This order was created by: <strong>\" + headhunterName + \"</strong>.</p><p style=\"color: #666666;\">Please process the order accordingly and provide any necessary updates to the customer.</p></div></body></html>\n";
    }

    public String generateOrderToHeadhunterEmail() {
        return "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>FoxHub - Order Confirmation</title></head><body><div style=\"max-width: 600px; margin: 0 auto; padding: 20px; background-color: #ffffff; box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);\"><h1 style=\"color: #4CAF50; text-align: left;\">FoxHub - Order Confirmation</h1><h3 style=\"color: #333333;\">Hello,</h3><p style=\"color: #666666;\">Thank you for choosing FoxHub! We are excited to confirm your order.</p><p style=\"color: #666666;\">Your order is being processed, and you will receive further updates through email.</p><p style=\"margin-top: 20px; font-size: 12px; color: #aaaaaa; text-align: center;\">If you did not place this order, please contact us immediately if you have any questions.</p></div></body></html>";
    }
}
