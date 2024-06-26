package ski.komoro.example.core;

import static org.junit.jupiter.api.Assertions.*;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ski.komoro.example.ResourceLogExampleApplication;
import ski.komoro.example.ResourceLogExampleConfiguration;

@ExtendWith(DropwizardExtensionsSupport.class)
class ResourceLogExampleTest {

    private static final DropwizardAppExtension<ResourceLogExampleConfiguration> EXT = new DropwizardAppExtension<>(
            ResourceLogExampleApplication.class,
            ResourceHelpers.resourceFilePath("test-config.yml")
    );

    @Test
    void testResources() {
        Client client = EXT.client();
        Response path = client.target(
                        String.format("http://127.0.0.1:%d/nested/path", EXT.getLocalPort()))
                .request()
                .get();

        Response ping = client.target(
                        String.format("http://127.0.0.1:%d/nested/path/ping", EXT.getLocalPort()))
                .request()
                .get();

        Response ping2 = client.target(
                        String.format("http://127.0.0.1:%d/nested/path/ping2", EXT.getLocalPort()))
                .request()
                .get();


        assertAll(
                () -> assertEquals(200, path.getStatus()),
                () -> assertEquals(200, ping.getStatus()),
                () -> assertEquals(200, ping2.getStatus())
        );



    }
}
