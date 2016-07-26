package com.auskeny.resources.read;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.auskeny.hibernate.bdo.CustomerBDO;

@Path("/read/customer")
public class CustomerReadResource {
	private static final Logger logger = LoggerFactory.getLogger(CustomerReadResource.class);
	
	/* rest service for listing  employee details */
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		try {
			System.out.println("read/customer");
			String responseData = new CustomerBDO().list();
			System.out.println(responseData);
			return Response.ok(responseData).build();			
		} catch (Exception ex) {
			ex.printStackTrace();
			logger. trace(ex.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}

	}
}
