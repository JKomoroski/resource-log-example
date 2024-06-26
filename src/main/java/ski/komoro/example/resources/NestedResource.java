package ski.komoro.example.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/nested")
public class NestedResource {
    @GET
    @Path("/path")
    public String get() {
        return "Captain Kirk";
    }
}
