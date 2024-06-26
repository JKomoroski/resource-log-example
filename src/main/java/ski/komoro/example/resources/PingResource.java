package ski.komoro.example.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/nested/path/ping")
public class PingResource {
    @GET
    public String get() {
        return "pong";
    }
}
