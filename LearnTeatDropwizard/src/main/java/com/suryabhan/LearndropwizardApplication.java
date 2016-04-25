package com.suryabhan;

import com.suryabhan.db.TestdbjdbiDAO;
import com.suryabhan.resources.SayHelloResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class LearndropwizardApplication extends Application<LearndropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LearndropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "Learndropwizard";
    }

    @Override
    public void initialize(final Bootstrap<LearndropwizardConfiguration> bootstrap) {

    }


    @Override
    public void run(final LearndropwizardConfiguration configuration,
                    final Environment environment) {



        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment,configuration.getDatabase() , "postgresql");

        final TestdbjdbiDAO testDataDAO = jdbi.onDemand(TestdbjdbiDAO.class);

        environment.jersey().register(new SayHelloResource(testDataDAO));
    }

}
