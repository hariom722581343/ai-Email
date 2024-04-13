package oauth;

import com.microsoft.aad.msal4j.*;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class OutlookOAuth {
    private static final String CLIENT_ID = "your-client-id";
    private static final String TENANT_ID = "your-tenant-id";
    private static final String CLIENT_SECRET = "your-client-secret";
    private static final Set<String> SCOPES = Collections.singleton("https://outlook.office.com/mail.read");

    public void setupOutlookOAuth() {
        try {
            ConfidentialClientApplication app = ConfidentialClientApplication.builder(
                            CLIENT_ID,
                            ClientCredentialFactory.createFromSecret(CLIENT_SECRET))
                    .authority("https://login.microsoftonline.com/" + TENANT_ID)
                    .build();

            UsernamePasswordParameters parameters = UsernamePasswordParameters.builder(
                            Collections.singleton("your-username"),
                            "your-password".toCharArray())
                    .build();

            IAuthenticationResult result = app.acquireToken(parameters).get();
            String accessToken = result.accessToken();
            System.out.println("Access token: " + accessToken);
        } catch (InterruptedException | MalformedURLException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
