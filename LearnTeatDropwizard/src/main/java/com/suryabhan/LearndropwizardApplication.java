package com.suryabhan;

import com.suryabhan.core.TestDatabase;
import com.suryabhan.db.TestDataDAO;
import com.suryabhan.resources.SayHelloResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
        // TODO: application initialization
        bootstrap.addBundle(hibernateBundle);
    }

    /**
     * Hibernate bundle.
     */
    private final HibernateBundle<LearndropwizardConfiguration> hibernateBundle
            = new HibernateBundle<LearndropwizardConfiguration>(
            TestDatabase.class
    ) {

        @Override
        public DataSourceFactory getDataSourceFactory(
                LearndropwizardConfiguration configuration
        ) {
            return configuration.getDatabase();
        }

    };

    @Override
    public void run(final LearndropwizardConfiguration configuration,
                    final Environment environment) {


        //Create Employee DAO.
        final TestDataDAO testDataDAO
                = new TestDataDAO(hibernateBundle.getSessionFactory());
        //endregion

        environment.jersey().register(new SayHelloResource(testDataDAO));
    }

}
