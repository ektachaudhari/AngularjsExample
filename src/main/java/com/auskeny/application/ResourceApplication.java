package com.auskeny.application;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

@ApplicationPath("/rest")
public class ResourceApplication extends Application{
	
	/*public  ResourceApplication(){
		System.out.println("in ResourceApplication");
		packages("com.auskeny.resources.write","com.auskeny.resources.read");
		register(MultiPartFeature.class);
	}*/
	
	
	@Override
	public Set<Class<?>> getClasses(){
		System.out.println("in Application");
		Set<Class<?>> resources = new java.util.HashSet<>();
		
		resources.add(com.auskeny.resources.write.CustomerWriteResource.class);
		resources.add(com.auskeny.resources.read.CustomerReadResource.class);
		resources.add(com.auskeny.resources.write.ProductWriteResource.class);
		resources.add(com.auskeny.resources.read.ProductReadResource.class);
		resources.add(com.auskeny.resources.write.OrderDetailWriteResource.class);
		resources.add(MultiPartFeature.class);
				
		return resources;
		
	}
}
