package com.github.eciuca.dropwizard.helloworld.app;

import be.fluid_it.µs.bundle.dropwizard.µService;
import be.fluid_it.µs.bundle.dropwizard.µsBundle;
import be.fluid_it.µs.bundle.dropwizard.µsEnvironment;
import com.github.eciuca.dropwizard.helloworld.config.HelloWorldConfiguration;
import com.github.eciuca.dropwizard.helloworld.modules.HelloWorldModule;
import com.github.eciuca.dropwizard.helloworld.rest.HelloWorldResource;

public class HelloWorldService extends µService<HelloWorldConfiguration> {
    static {
        µService.µServiceClass = HelloWorldService.class;
        µService.relativePathToYmlInIDE = "hello-world-config.yml";
    }

    public Class configurationClass() {
        return HelloWorldConfiguration.class;
    }

    protected void run(HelloWorldConfiguration configuration, µsEnvironment µsEnvironment) throws Exception {
        µsEnvironment.jersey().register(HelloWorldResource.class);
    }

    @Override
    public void initialize(µsBundle.Builder µsBundleBuilder) {
        µsBundleBuilder
                .addModule(new HelloWorldModule());
    }
}
