package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@RefreshScope
@SpringBootApplication
public class MSGestionOrdenConsumerApp {

	public static void main(String[] args) {
		SpringApplication.run(MSGestionOrdenConsumerApp.class, args);
	}

}
