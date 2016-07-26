package com.auskeny.resources.write;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auskeny.hibernate.bdo.CustomerBDO;

@Path("/write/customer")
public class CustomerWriteResource {
	private static final Logger logger = LoggerFactory.getLogger(CustomerWriteResource.class);
	
	CustomerBDO customerBDO = new CustomerBDO();

	/* rest service for creating customer details */
	@POST
	@Path("/create")
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(String jsonString) {
		try {
			System.out.println("create");
			String responseData = customerBDO.create(jsonString);
			return Response.ok(responseData).build();
		} catch (Exception ex) {
			logger.trace(ex.getMessage());
			ex.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}

	/* rest service for updating customer details */
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(String jsonString) {
		try {
			System.out.println("IN update method:: " + jsonString);
			String responseData = customerBDO.update(jsonString);
			System.out.println("after  update method:: " + jsonString);
			return Response.ok(responseData).build();
		} catch (Exception ex) {
			ex.printStackTrace();	
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}

	}

	/* rest service for deleting customer details using*/ 
	@GET
	@Path("/remove/{entityIdPk}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("entityIdPk") int customerIdPk) {
		try {
			System.out.println("in  rest delete");
			//customerBDO.delete(custId);
			customerBDO.delete(customerIdPk);
			return Response.status(200).build();
		} catch (Exception ex) {
			ex.printStackTrace();			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}

}
