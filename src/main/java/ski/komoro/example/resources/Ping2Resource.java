package ski.komoro.example.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/nested/path")
public class Ping2Resource {
    @GET
    @Path("/ping2")
    public String get() {
        return "pong";
    }
}
