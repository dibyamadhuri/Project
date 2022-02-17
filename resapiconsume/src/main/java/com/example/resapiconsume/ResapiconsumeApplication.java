package com.example.resapiconsume;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.example.resapiconsume.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ResapiconsumeApplication {

	public static void main(String[] args) throws URISyntaxException, JsonProcessingException {
		//SpringApplication.run(ResapiconsumeApplication.class, args);

		RestTemplate restTemplate = new RestTemplate();

	/* 	String resonse = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", String.class);
		System.out.println(resonse); */

	/* 	List list = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", List.class);
		list.forEach(post -> {
			System.out.println(post);
			System.out.println("");
		}); */
/* 
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(
															"http://jsonplaceholder.typicode.com/posts", 
															String.class);
		responseEntity.getBody();
		responseEntity.getHeaders();
		 */
		
		/*  Post post = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts/1", Post.class);
		 System.out.println(post.getBody()); */

		/*  ResponseEntity<Post> postEntity = restTemplate.getForEntity(
			 											"http://jsonplaceholder.typicode.com/posts/1", 
														 Post.class);
		 System.out.println(postEntity.getBody().getBody()); */		
		/*  
		RequestEntity requestEntity=new RequestEntity<>(HttpMethod.GET, 
		 												new URI("http://jsonplaceholder.typicode.com/posts/1"));
		ResponseEntity<Post> postEntity = restTemplate.exchange(requestEntity, Post.class);
		Post post=postEntity.getBody();
		System.out.println(post.getUserId()); */

		Post postObject = new Post(500, 700, "sunset", "a beautiful sunset in Mumbai");
		ObjectMapper objectMapper =new ObjectMapper();
		String inputJSON= objectMapper.writeValueAsString(postObject);
		HttpEntity<String> entity = new HttpEntity<String>(inputJSON);
		ResponseEntity<Object> response = restTemplate.
											exchange("http://jsonplaceholder.typicode.com/posts",
														HttpMethod.POST,entity,Object.class);
		System.out.println(response.getStatusCode());
	}

}
