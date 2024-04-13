package oauth;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.auth.oauth2.UserCredentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.AccessTokenProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class GoogleOAuth {
    public void setupGoogleOAuth() {
        try {
            FileInputStream credentialsStream = new FileInputStream("path/to/your/credentials.json");

            GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream);

            credentials.refreshIfExpired();

            AccessToken accessToken = credentials.getAccessToken();
            System.out.println("Access Token: " + accessToken.getTokenValue());

            if (credentials instanceof ServiceAccountCredentials) {
                ServiceAccountCredentials serviceAccountCredentials = (ServiceAccountCredentials) credentials;
                System.out.println("Service Account Email: " + serviceAccountCredentials.getClientEmail());
            }

            if (credentials instanceof UserCredentials) {
                UserCredentials userCredentials = (UserCredentials) credentials;
                System.out.println("User Email: " + userCredentials.getClientId());
            }

            List<String> scopes = credentials.getScopes();
            System.out.println("Scopes: " + scopes);

            System.out.println("Google OAuth setup complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
