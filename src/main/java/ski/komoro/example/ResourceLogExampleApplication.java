package ski.komoro.example;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import ski.komoro.example.resources.NestedResource;
import ski.komoro.example.resources.Ping2Resource;
import ski.komoro.example.resources.PingResource;

public class ResourceLogExampleApplication extends Application<ResourceLogExampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ResourceLogExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "ResourceLogExample";
    }

    @Override
    public void initialize(final Bootstrap<ResourceLogExampleConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ResourceLogExampleConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(NestedResource.class);
        environment.jersey().register(PingResource.class);
        environment.jersey().register(Ping2Resource.class);
    }

}
