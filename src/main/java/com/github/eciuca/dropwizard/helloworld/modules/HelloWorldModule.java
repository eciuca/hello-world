package com.github.eciuca.dropwizard.helloworld.modules;

import be.fluid_it.µs.bundle.guice.ApplicationModule;
import com.github.eciuca.dropwizard.helloworld.config.HelloWorldConfiguration;
import com.google.inject.Binder;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class HelloWorldModule implements ApplicationModule {
    public void configure(Binder binder) {

    }

    @Provides
    @Named("defaultName")
    public String providesName(HelloWorldConfiguration configuration) {
        return configuration.getDefaultName();
    }
}
