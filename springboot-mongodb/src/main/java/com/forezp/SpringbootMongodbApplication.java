package com.forezp;

import com.forezp.dao.CustomerRepository;
import com.forezp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * 启动mongodb
 * C:\Program Files\MongoDB\Server\3.4\bin
 * mongod.exe --dbpath E:\mongdb\data\db
 */
@SpringBootApplication
public class SpringbootMongodbApplication  implements CommandLineRunner {


	@Autowired
	private CustomerRepository repository;

	static {
		//for localhost testing only
		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
				new javax.net.ssl.HostnameVerifier(){

					public boolean verify(String hostname,
										  javax.net.ssl.SSLSession sslSession) {
						if (hostname.equals("192.168.8.104")) {
							return true;
						}
						return false;
					}
				});
	}



	public static void main(String[] args) {
		System.setProperty("javax.net.ssl.trustStore", "/etc/ssl/nx.keystore");

		System.setProperty("javax.net.ssl.trustStorePassword", "1234567890");
		SpringApplication.run(SpringbootMongodbApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}

	/**
	 * Customers found with findAll():
	 -------------------------------
	 Customer[id=58f880f589ffb696b8a6077e, firstName='Alice', lastName='Smith']
	 Customer[id=58f880f589ffb696b8a6077f, firstName='Bob', lastName='Smith']

	 Customer found with findByFirstName('Alice'):
	 --------------------------------
	 Customer[id=58f880f589ffb696b8a6077e, firstName='Alice', lastName='Smith']
	 Customers found with findByLastName('Smith'):
	 --------------------------------
	 Customer[id=58f880f589ffb696b8a6077e, firstName='Alice', lastName='Smith']
	 Customer[id=58f880f589ffb696b8a6077f, firstName='Bob', lastName='Smith']
	 */
}
