package org.example;

import oauth.GoogleOAuth;
import oauth.OutlookOAuth;
import emailinteraction.EmailSender;
import emailparsing.EmailParser;
import emailparsing.EmailLabeler;
import automatedresponse.AutomatedResponseGenerator;

public class Main {
    public static void main(String[] args) {
        GoogleOAuth googleOAuth = new GoogleOAuth();
        googleOAuth.setupGoogleOAuth();

        OutlookOAuth outlookOAuth = new OutlookOAuth();
        outlookOAuth.setupOutlookOAuth();

        EmailSender emailSender = new EmailSender("your-email@example.com", "your-password");
        emailSender.sendEmail("recipient@example.com", "Test Email", "This is a test email.");

        EmailParser emailParser = new EmailParser();
        emailParser.parseIncomingEmails(args);

        EmailLabeler emailLabeler = new EmailLabeler();
        emailLabeler.labelEmails(args);

        AutomatedResponseGenerator responseGenerator = new AutomatedResponseGenerator();
        String emailContent = "This is a sample email content.";
        String automatedResponse = responseGenerator.generateAutomatedResponse(emailContent);
        System.out.println("Automated Response: " + automatedResponse);
    }
}
