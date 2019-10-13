/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.CRUD;

import com.jalasoft.CRUD.model.User;
import com.jalasoft.CRUD.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.LongStream;

/**
 * CRUD application for users
 *
 * @author Raul Laredo on 10/13/2019.
 * @version v1.0
 */
@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	/**
	 * Creates new users for being used in demostration / have to be deleted in production
	 * @param repository of users
	 * @return list of users
	 */
	@Bean
	CommandLineRunner init(UserRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						User user = new User();
						user.setName("user " + i);
						user.setEmail("user" + i + "@email.com");
						user.setPhone("(111) 111-1111");
						return user;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}
}
