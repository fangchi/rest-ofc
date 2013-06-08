package com.fc.resource;

import java.util.HashMap;

import org.restlet.Application;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class SaveImgResource extends ServerResource {
	
	@Post("text")
	public String saveImg() {
		System.out.println(getContext().getAttributes());
		return null;
		
	}
}
