package com.auskeny.resources.read;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.auskeny.hibernate.bdo.ProductBDO;

@Path("/read/product")
public class ProductReadResource {
	private static final Logger logger = LoggerFactory.getLogger(CustomerReadResource.class);
	
	/* rest service for listing  product details */
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		try {
			System.out.println("read/product");
			String responseData = new ProductBDO().list();
			System.out.println(responseData);
			return Response.ok(responseData).build();			
		} catch (Exception ex) {
			ex.printStackTrace();
			logger. trace(ex.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}

	}
	
	/* rest service for deleting customer details using*/ 
	@GET
	@Path("/remove/{entityIdPk}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("entityIdPk") int productIdPk) {
		try {
			System.out.println("in  rest delete");			
			new ProductBDO().delete(productIdPk);
			return Response.status(200).build();
		} catch (Exception ex) {
			ex.printStackTrace();			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
}
