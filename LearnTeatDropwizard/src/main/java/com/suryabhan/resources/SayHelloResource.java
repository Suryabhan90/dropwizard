package com.suryabhan.resources;

import com.suryabhan.core.TestDatabase;
import com.suryabhan.db.TestDataDAO;
import io.dropwizard.hibernate.UnitOfWork;
import org.hibernate.HibernateException;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by suryabhan on 22/04/16.
 */

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class SayHelloResource
{
    private final TestDataDAO enterDataDAO;

    public SayHelloResource(TestDataDAO enterDataDAO) {
        this.enterDataDAO = enterDataDAO;
    }


    @GET
    @UnitOfWork
    public List<TestDatabase> SayHello()
    {
        return enterDataDAO.findAll();
    }

    @POST
    @UnitOfWork
    public int insetdata(TestDatabase db)
    {
        return enterDataDAO.EnterDate(db);
    }




}
