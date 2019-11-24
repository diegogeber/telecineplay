package br.com.telecineplay.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.algolia.search.APIClient;
import com.algolia.search.ApacheAPIClientBuilder;
import com.algolia.search.Index;
import com.algolia.search.exceptions.AlgoliaException;
import br.com.telecineplay.model.Contact;

@Service
public class TestBedService {
	
	APIClient client = new ApacheAPIClientBuilder("testbed", "test").build();
		
	public void startIndexTest() {
		Index<Contact> index = client.initIndex("testbed", Contact.class);
		try {
			index.addObjects(Arrays.asList(
					  new Contact().setName("Ana").setAge(26) ,
					  new Contact().setName("Joao").setAge(26)
					));
		} catch (AlgoliaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
    @Value("${name:unknown}")
    private String name;

    public String getMessage() {
        return getMessage(name);
    }

    public String getMessage(String name) {
        return "Oi " + name;
    }

}