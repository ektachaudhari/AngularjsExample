package com.auskeny.resources.write;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.JSONP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import com.auskeny.application.utils.JsonUtils;
import com.auskeny.hibernate.bdo.OrderDetailBDO;
import com.auskeny.hibernate.dao.CustomerDAO;
import com.auskeny.hibernate.pojo.Customer;
import com.auskeny.hibernate.pojo.OrderDetail;
import com.auskeny.hibernate.pojo.Product;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Path("/write/order")
public class OrderDetailWriteResource {
	private static final Logger logger = LoggerFactory.getLogger(OrderDetailWriteResource.class);
	OrderDetailBDO orderDetailBDO=new OrderDetailBDO();
	
	/* rest service for creating order details*/ 
	@POST
	@Path("/create")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@FormDataParam("product") String productData,@FormDataParam("quantity") int quantity,@FormDataParam("totalPrice") Double totalPrice,@FormDataParam("customerId") int customerId) {
		try {			
			System.out.println("create/order"+productData);				
			Product products=new Gson().fromJson(productData,Product.class);
			System.out.println("from product's json "+productData);
			
			CustomerDAO customerDAO=new CustomerDAO();
			Customer customer=customerDAO.findById(customerId);
			
			OrderDetail orderDetail=new OrderDetail();
			orderDetail.setProduct(products);			
			orderDetail.setCustomer(customer);
			orderDetail.setQuantity(quantity);	
			orderDetail.setTotalPrice(totalPrice);
			String jsonString=JsonUtils.getJsonFromJavaObject(orderDetail,OrderDetail.class);						
			String responseData = orderDetailBDO.create(jsonString);
			return Response.ok(responseData).build();
		} catch (Exception ex) {
			logger.trace(ex.getMessage());
			ex.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
}
