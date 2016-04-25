package com.suryabhan.resources;

import com.suryabhan.core.TestDabsejdbi;
import com.suryabhan.db.TestdbjdbiDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by suryabhan on 22/04/16.
 */

@Path("/hello-world")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class SayHelloResource
{
    private final TestdbjdbiDAO enterDataDAO;

    public SayHelloResource(TestdbjdbiDAO enterDataDAO) {
        this.enterDataDAO = enterDataDAO;
    }


    @GET
    @UnitOfWork
    public List<TestDabsejdbi> SayHello()
    {
        return enterDataDAO.getAll();
    }

    @GET
    @UnitOfWork
    @Path("/{id}")
    public TestDabsejdbi getbyid(@PathParam("id") Integer id)
    {
        return enterDataDAO.getbyid(id);
    }


    @POST
    @UnitOfWork
    public int insetdata(TestDabsejdbi db)
    {
        return enterDataDAO.insert(db);
    }

    @PUT
    @UnitOfWork
    @Path("/{id}")
    public int updatedata(@PathParam("id") Integer id, @Valid TestDabsejdbi db)
    {
        db.setId(id);
        return enterDataDAO.update(db);
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    public int deletedata(@PathParam("id") Integer id)
    {
        return enterDataDAO.deletebyid(id);
    }





}
