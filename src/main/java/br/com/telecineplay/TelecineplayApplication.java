package br.com.telecineplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.telecineplay.service.TestBedService;
import br.com.telecineplay.service.YoutubeSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class TelecineplayApplication implements CommandLineRunner {
	
	@Autowired
    private TestBedService testBedService;
	
	@Autowired
	private YoutubeSearchService youtubeSearchService;

	public static void main(String[] args) {
		SpringApplication.run(TelecineplayApplication.class, args);
		
	}
	
	@Override
    public void run(String... args) throws Exception {
		
        if (args.length > 0) {
        	System.out.println(testBedService.getMessage(args[0].toString()));
        } else {
        	System.out.println(testBedService.getMessage());
        }
        
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        //testBedService.startIndexTest();
        youtubeSearchService.searchVideosYoutube();
        System.out.println("###### FIM #####");

    }
}
