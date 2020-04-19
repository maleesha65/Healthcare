package com.healthcare.project.hospitalApiProject;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/Hospital")
public class HospitalResource {

	HospitalRepository hr =new HospitalRepository();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hospital> getAllHospital() {
		
		return hr.getAllHospital();
		
		/*Hospital h1 = new Hospital();
		h1.setH_id("h1");
		h1.setH_name("Hemas");
		h1.setH_address("Kandy road Colomboo");
		h1.setH_phone("0112349804");
		h1.setH_email("hemas@gmail.com");

		Hospital h2 = new Hospital();
		h2.setH_id("h2");
		h2.setH_name("Appalo");
		h2.setH_address("Colomboo road Kurunegala");
		h2.setH_phone("0374569808");
		h2.setH_email("appalo@gmail.com");
		
		Hospital h3 = new Hospital();
		h3.setH_id("h3");
		h3.setH_name("Lanka");
		h3.setH_address("Kandy road Colomboo");
		h3.setH_phone("0112254678");
		h3.setH_email("lanka@gmail.com");
		
		Hospital.add(h1);
		Hospital.add(h2);
		Hospital.add(h3);*/
		
		
        
        
        
        }
	
	@POST
    @Path("/Hospital")
    @Consumes(MediaType.APPLICATION_JSON)
	public Hospital createHospital(Hospital h1) {
		
		return hr.createHospital(h1);
	}
    
	@PUT
    @Path("/Hospital")
    @Consumes(MediaType.APPLICATION_JSON)
	public Hospital updateHospital(Hospital h1) {
		
		return hr.updateHospital(h1);
		
		
		
	}
    
	@DELETE
	@Path("/Hospital")
	public Hospital deleteHospital(Hospital h1) {
		
		return hr.deleteHospital(h1);
	}
	
}
