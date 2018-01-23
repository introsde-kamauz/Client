package projectclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.glassfish.jersey.client.ClientConfig;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonProcessingException;

import model.*;
import lib.*;

public class ClientClass {
	public static void main(String[] args) throws JsonProcessingException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget service = client.target("http://processcentricservice.herokuapp.com");
		
		Requester postman2 = new Requester(service, MediaType.APPLICATION_JSON);
		String result = "";
		RequestedFormat printer = new RequestedFormat();
	
		System.out.println("adding new user");
		Response res = postman2.post("/Giorgio Michelotti/register", MediaType.APPLICATION_JSON);
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		String r2 = res.readEntity(String.class);
		
		System.out.println("0) "+r2+"\n\n");
		
		System.out.println("gettin all users");
		res = postman2.get("/users");
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		List<Person> abc = res.readEntity(new GenericType<List<Person>>() {});
		
		System.out.println("2) "+abc.size());
		System.out.println("\n");
		
		
		System.out.println("add artist preference");
		res = postman2.post("/2/addArtist/Iron%20Maiden", MediaType.APPLICATION_JSON);
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		result = res.readEntity(String.class);
		System.out.println("2) "+result);
		System.out.println("\n");
		
		System.out.println("get user artists");
		res = postman2.get("2/getUserArtists");
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		List<Artist> arts = res.readEntity(new GenericType<List<Artist>>() {});
		System.out.println("3) "+arts.size());
		System.out.println("\n");
		
		System.out.println("get recommended artists");
		res = postman2.get("2/recommArtists");
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		String artsStrig = res.readEntity(String.class);
		System.out.println("3) "+artsStrig);
		System.out.println("\n");
		String stArts = res.readEntity(String.class);
		System.out.println(stArts);
		
		System.out.println("get recommended events");
		
		List<Event> ee = new ArrayList<Event>();
		try {
			res = postman2.get("2/recommEvents/Rovereto");
			System.out.println("Response code: "+res.getStatus());
			res.bufferEntity();
			String eeString = res.readEntity(String.class);
			System.out.println("4) "+ee);
			System.out.println("\n");
		} catch(Exception e) {
			System.out.println("Request takes much time to be executed, so Heroku dropped it by setting a request timeout");
		}
		
		// {id}/evaluateArtistRecommendation/{artistName}/{artistId}/{rate}
		if(arts.size()>0) {
			System.out.println("evaluate artist recommendation");
			res = postman2.post("2/evaluateArtistRecommendation/"+arts.get(0).getName()+"/"+arts.get(0).getId()+"/5", MediaType.APPLICATION_JSON);
			System.out.println("Response code: "+res.getStatus());
			res.bufferEntity();
			result = res.readEntity(String.class);
			System.out.println("5) "+result);
			System.out.println("\n");
			
			System.out.println("get user evaluations");
			res = postman2.get("1/getEvaluations");
			System.out.println("Response code: "+res.getStatus());
			res.bufferEntity();
			//List<Evaluation> eval = res.readEntity(new GenericType<List<Evaluation>>() {});
			String eval = res.readEntity(String.class);
			System.out.println("6) "+eval);
			System.out.println("\n");
		}
		
		System.out.println("get random motivational quote");
		res = postman2.get("/getMotivation");
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		result = res.readEntity(String.class);
		System.out.println("5) "+result);
		System.out.println("\n");
		
		System.out.println("get user artists");
		res = postman2.get("1/getUserArtists");
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		result = res.readEntity(String.class);
		System.out.println("6) "+result);
		
	}
	
}

/*
 * package projectclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.glassfish.jersey.client.ClientConfig;
import org.json.simple.JSONObject;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonProcessingException;

import model.*;
import lib.*;

public class ClientClass {
	public static void main(String[] args) throws JsonProcessingException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget service = client.target("http://processcentricservice.herokuapp.com");
		
		Requester postman2 = new Requester(service, MediaType.APPLICATION_JSON);
		String result = "";
		RequestedFormat printer = new RequestedFormat();
	
		System.out.println("adding new user");
		Response res = postman2.post("/register", "Giorgio Michelotti");
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		String r2 = res.readEntity(String.class);
		
		System.out.println("0) "+r2+"\n\n");
		
		System.out.println("gettin all users");
		res = postman2.get("/users");
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		List<Person> abc = res.readEntity(new GenericType<List<Person>>() {});
		
		System.out.println("2) "+abc.size());
		System.out.println("\n");
		
		
		System.out.println("add artist preference");
		JSONObject param = new JSONObject();
		param.put("id", 1);
		param.put("name", "Iron%20Maiden");
		
		res = postman2.post("/addArtist", param.toJSONString());
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		result = res.readEntity(String.class);
		System.out.println("2) "+result);
		System.out.println("\n");
		
		param = new JSONObject();
		param.put("id", 1);
		param.put("name", "Metallica");
		System.out.println("add artist preference");
		res = postman2.post("/1/addArtist/Metallica", param.toJSONString());
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		result = res.readEntity(String.class);
		System.out.println("2) "+result);
		System.out.println("\n");
		
		System.out.println("get user artists");
		res = postman2.get("1/getUserArtists");
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		List<Artist> arts = res.readEntity(new GenericType<List<Artist>>() {});
		System.out.println("3) "+arts.size());
		System.out.println("\n");
		
		System.out.println("get recommended artists");
		res = postman2.get("1/recommArtists");
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		arts = res.readEntity(new GenericType<List<Artist>>() {});
		System.out.println("3) "+arts.size());
		System.out.println("\n");
		
		System.out.println("get recommended events");
		
		List<Event> ee = new ArrayList<Event>();
		try {
			res = postman2.get("1/recommEvents/Rovereto");
			System.out.println("Response code: "+res.getStatus());
			res.bufferEntity();
			ee = res.readEntity(new GenericType<List<Event>>() {});
			System.out.println("4) "+ee.size());
			System.out.println("\n");
		} catch(Exception e) {
			System.out.println("Request takes much time to be executed, so Heroku dropped it by setting a request timeout\n\n");
		}
		
		// {id}/evaluateArtistRecommendation/{artistName}/{artistId}/{rate}
		if(arts.size()>0) {
			System.out.println("evaluate artist recommendation");
			param = new JSONObject();
			Evaluation e = new Evaluation();
			e.setArtistId(arts.get(0).getId());
			e.setArtistName(arts.get(0).getName());
			e.setUserId("1");
			e.setRate(7);
			param.put("e", e);
			res = postman2.post("/evaluateArtistRecommendation", param.toJSONString());
			System.out.println("Response code: "+res.getStatus());
			res.bufferEntity();
			result = res.readEntity(String.class);
			System.out.println("5) "+result);
			System.out.println("\n");
			
			System.out.println("get user evaluations");
			res = postman2.get("1/getEvaluations");
			System.out.println("Response code: "+res.getStatus());
			res.bufferEntity();
			//List<Evaluation> eval = res.readEntity(new GenericType<List<Evaluation>>() {});
			String eval = res.readEntity(String.class);
			System.out.println("6) "+eval);
			System.out.println("\n");
		}
		
		System.out.println("get random motivational quote");
		res = postman2.get("/getMotivation");
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		result = res.readEntity(String.class);
		System.out.println("5) "+result);
		System.out.println("\n");
		
		System.out.println("get user artists");
		res = postman2.get("1/getUserArtists");
		System.out.println("Response code: "+res.getStatus());
		res.bufferEntity();
		result = res.readEntity(String.class);
		System.out.println("6) "+result);
		
	}
	
}
*/
