package emailparsing;

import java.util.ArrayList;
import java.util.List;

public class EmailParser {
    public List<String> parseIncomingEmails(String[] emails) {
        List<String> parsedEmails = new ArrayList<>();
        for (String email : emails) {
            String parsedEmail = parseEmail(email);
            parsedEmails.add(parsedEmail);
        }
        return parsedEmails;
    }

    private String parseEmail(String email) {
        return "Parsed email: " + email;
    }
}
