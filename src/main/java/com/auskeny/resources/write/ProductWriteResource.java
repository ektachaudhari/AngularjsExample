package com.auskeny.resources.write;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.auskeny.hibernate.bdo.ProductBDO;

@Path("/write/product")
public class ProductWriteResource {
private static final Logger logger = LoggerFactory.getLogger(CustomerWriteResource.class);
	
	ProductBDO productBDO=new ProductBDO();

	/* rest service for creating product details */
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(String jsonString) {
		try {
			System.out.println("create/product");
			String responseData = productBDO.create(jsonString);
			return Response.ok(responseData).build();
		} catch (Exception ex) {
			logger.trace(ex.getMessage());
			ex.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
	
	/* rest service for updating product details */
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(String jsonString) {
		try {
			System.out.println("IN update method:: " + jsonString);
			String responseData = productBDO.update(jsonString);
			System.out.println("after  update method:: " + jsonString);
			return Response.ok(responseData).build();
		} catch (Exception ex) {
			ex.printStackTrace();	
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}

	}
}
