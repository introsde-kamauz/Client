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
import java.util.Random;

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
		
		Requester sender = new Requester(service, MediaType.APPLICATION_JSON);
		String result = "";
		RequestedFormat printer = new RequestedFormat();
		
		Response res = sender.get("/user");
		res.bufferEntity();
		List<Person> abc = res.readEntity(new GenericType<List<Person>>() {});
		
		Integer sizeBefore = abc.size();
	
		JSONObject j = new JSONObject();
		j.put("name", "Michela");
		res = sender.post("/user", j.toJSONString());
		res.bufferEntity();
		res = sender.get("/user");
		res.bufferEntity();
		abc = res.readEntity(new GenericType<List<Person>>() {});
		
		if (abc.size() == sizeBefore+1) {
			System.out.print("USER ADDED SUCCESSFULLY");
		} else {
			System.out.print("ERROR WHILE ADDING NEW USER");
		}
		System.out.println("Number of users: "+abc.size());
		
		System.out.println("\n");
		
		j = new JSONObject();
		j.put("name", "Metallica");
		res = sender.post("/user/1/artist", j.toJSONString());
		res.bufferEntity();
		j = new JSONObject();
		j.put("name", "Black Stone Cherry");
		res = sender.post("/user/1/artist", j.toJSONString());
		res.bufferEntity();
		result = res.readEntity(String.class);
		j = new JSONObject();
		j.put("name", "Avenged Sevenfold");
		res = sender.post("/user/1/artist", j.toJSONString());
		res.bufferEntity();
		result = res.readEntity(String.class);
		
		res = sender.get("/user/1/artist");
		res.bufferEntity();
		result = res.readEntity(String.class);
		if (result.indexOf("Black Stone Cherry") != -1 && result.indexOf("Avenged Sevenfold") != -1) {
			System.out.println("PREFERENCES ADDED SUCCESSFULLY");
		} else {
			System.out.println("ERROR WHEN ADDING PREFERENCES");
		}
		System.out.println(result);
		System.out.println();
		
		res = sender.delete("/user/1/artist/Black Stone Cherry");
		res = sender.delete("/user/1/artist/Avenged Sevenfold");
		res.bufferEntity();
		result = res.readEntity(String.class);
		
		res = sender.get("/user/1/artist");
		res.bufferEntity();
		result = res.readEntity(String.class);
		
		if (result.indexOf("Black Stone Cherry") == -1 && result.indexOf("Avenged Sevenfold") == -1) {
			System.out.println("PREFERENCES REMOVED SUCCESSFULLY");
		} else {
			System.out.println("ERROR WHILE REMOVING PREFERENCES");
		}
		
		System.out.println(result+"\n");
		
		res = sender.get("/user/1/artist/recom");
		res.bufferEntity();
		String artsStrig = res.readEntity(String.class);
		List<Artist> listArt = res.readEntity(new GenericType<List<Artist>>() {});
		if (artsStrig != "[]") {
			System.out.println("ARTISTS RECOMMENDED SUCCESSFULLY");
		} else {
			System.out.println("ERROR WHILE RECOMMEND ARTISTS");
		}
		System.out.println(artsStrig);
		System.out.println("\n");
		String stArts = res.readEntity(String.class);
		
		System.out.println("get recommended events");
		
		List<Event> ee = new ArrayList<Event>();
		try {
			res = sender.get("/user/1/event/Rovereto");
			System.out.println("Response code: "+res.getStatus());
			res.bufferEntity();
			String eeString = res.readEntity(String.class);
			System.out.println("4) "+ee);
			System.out.println("\n");
		} catch(Exception e) {
			System.out.println("Request takes much time to be executed, so Heroku dropped it by setting a request timeout");
		}
		
		// {id}/evaluateArtistRecommendation/{artistName}/{artistId}/{rate}
		Random generator = new Random();
		if(listArt.size()>0) {
			JSONObject param = new JSONObject();
	
			int random = generator.nextInt(listArt.size());
			param.put("aid", listArt.get(random).getId());
			param.put("artistName", listArt.get(random).getName());
			param.put("userId", "1");
			param.put("rate", String.format("%s", generator.nextInt(10)));
			
			res = sender.post("/user/1/evaluate", param.toJSONString());
			res.bufferEntity();
			result = res.readEntity(String.class);
			
			res = sender.get("/user/1/evaluate");
			res.bufferEntity();
			//List<Evaluation> eval = res.readEntity(new GenericType<List<Evaluation>>() {});
			String eval = res.readEntity(String.class);
			if (eval.indexOf(listArt.get(random).getName().replace("\"","")) != -1) {
				System.out.println("EVALUATION ADDED SUCCESSFULLY");
			} else {
				System.out.println("ERROR WHILE ADDING NEW EVALUATION");
			}
			System.out.println(eval);
			System.out.println("\n");
		}
		
		res = sender.get("/motivation");
		res.bufferEntity();
		result = res.readEntity(String.class);
		if (result != "" ) {
			System.out.println("RANDOM QUOTE GENERATED SUCCESSFULLY");
		} else {
			System.out.println("ERROR WHILE GENERATING THE QUOTE");
		}
		System.out.println("5) "+result);
		System.out.println("\n");
		
		System.out.println("GET USER ARTISTS");
		res = sender.get("/user/1/artist");
		res.bufferEntity();
		result = res.readEntity(String.class);
		System.out.println(result);
		
	}
	
}
