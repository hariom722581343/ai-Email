package automatedresponse;

import java.util.Random;

public class AutomatedResponseGenerator {
    public String generateAutomatedResponse(String emailContent) {
        if (containsKeyword(emailContent, "interested")) {
            return suggestDemoCall();
        } else if (containsKeyword(emailContent, "query")) {
            return provideInformation();
        } else {
            return defaultResponse();
        }
    }

    private boolean containsKeyword(String emailContent, String keyword) {
        return emailContent.toLowerCase().contains(keyword.toLowerCase());
    }

    private String suggestDemoCall() {
        Random random = new Random();
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);

        return "Thank you for your email. We see that you are interested in our product. " +
                "Would you like to schedule a demo call? " +
                "We suggest a time of " + String.format("%02d", hour) + ":" + String.format("%02d", minute) + ".";
    }

    private String provideInformation() {
        return "Thank you for reaching out. Here is the information you requested.";
    }

    private String defaultResponse() {
        return "Thank you for your email. We will get back to you shortly.";
    }
}
