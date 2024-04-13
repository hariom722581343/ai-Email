package emailparsing;

import java.util.HashMap;
import java.util.Map;

public class EmailLabeler {
    public Map<String, String> labelEmails(String[] emails) {
        Map<String, String> labeledEmails = new HashMap<>();
        for (String email : emails) {
            String label = generateLabel(email);
            labeledEmails.put(email, label);
        }
        return labeledEmails;
    }

    private String generateLabel(String email) {
        if (email.contains("urgent")) {
            return "Urgent";
        } else if (email.contains("important")) {
            return "Important";
        } else {
            return "General";
        }
    }
}
