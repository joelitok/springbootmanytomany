package com.relation.relationmanytomany;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.relation.relationmanytomany.entities.Role;
import com.relation.relationmanytomany.entities.User;
import com.relation.relationmanytomany.services.UserService;

@SpringBootApplication
public class RelationmanytomanyApplication implements CommandLineRunner{
    @Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(RelationmanytomanyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	User user = new User();
	user.setUsername("user1");
	user.setPassword("123456");
	userService.addNewUser(user);

	User user1 = new User();
	user1.setUsername("admin");
	user1.setPassword("123456");
	userService.addNewUser(user1);

	Stream.of("STUDENT","ADMIN","USER").forEach(role->{
		Role role1 = new Role();
		role1.setRoleName(role);
		userService.addNewRole(role1);
	});
	
userService.addRoleToUser("user1", "STUDENT");
userService.addRoleToUser("user1", "USER");
userService.addRoleToUser("admin", "USER");
userService.addRoleToUser("admin", "ADMIN");

try {
	 User userAuth = userService.authenticate("user1", "123456");
	 System.out.println(userAuth.getUserId());
	 System.out.println(userAuth.getUsername());
	
	 userAuth.getRoles().forEach(r->{
		System.out.println("Role=>"+r.getRoleName());
	 });
} catch (Exception e) {
	e.printStackTrace();
}
		
	}

}
