package com.forezp;

import com.forezp.message.Receiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@SpringBootApplication
public class SpringbootRedisApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootRedisApplication.class);

	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
											MessageListenerAdapter listenerAdapter) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	@Bean
	Receiver receiver(CountDownLatch latch) {
		return new Receiver(latch);
	}

	@Bean
	CountDownLatch latch() {
		return new CountDownLatch(1);
	}

	@Bean
	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}

	public static void main(String[] args) throws Exception{
		ApplicationContext ctx =  SpringApplication.run(SpringbootRedisApplication.class, args);

		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
		CountDownLatch latch = ctx.getBean(CountDownLatch.class);

		LOGGER.info("Sending message...");
		template.convertAndSend("chat", "Hello from Redis!");

		latch.await();

		System.exit(0);
	}


	/**
	 * 2017-04-20 17:25:15.536  INFO 39148 --- [           main] com.forezp.SpringbootRedisApplication    : Sending message...
	 *  2017-04-20 17:25:15.544  INFO 39148 --- [    container-2] com.forezp.message.Receiver              : Received <Hello from Redis!>
	 */
}
