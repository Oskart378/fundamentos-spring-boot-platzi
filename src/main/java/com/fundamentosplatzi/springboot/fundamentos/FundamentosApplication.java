package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.*;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.UserRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private OperationUser operationUser;
	private UserPojo userPojo;
	private UserRepository userRepository;

	private MyBeanWithProperties myBeanWithProperties;

	@Autowired
	public FundamentosApplication(@Qualifier("componentToImplement") ComponentDependency componentDependency,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								  OperationUser operationUser, MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,  UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.operationUser = operationUser;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDb();
	}

	private void saveUsersInDb(){
		User user1 = new User("Jon", "jon@domain.com", LocalDate.of(2021, 03, 21));
		User user2 = new User("Julie", "Julie@domain.com", LocalDate.of(2021, 07, 22));
		User user3 = new User("user3", "user3@domain.com", LocalDate.of(2021, 11, 14));
		User user4 = new User("user4", "user4@domain.com", LocalDate.of(2021, 6, 1));
		User user5 = new User("user5", "user5@domain.com", LocalDate.of(2021, 5, 25));
		User user6 = new User("user6", "user6@domain.com", LocalDate.of(2021, 1, 11));
		User user7 = new User("user7", "user7@domain.com", LocalDate.of(2021, 2, 12));

		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7);
		list.stream().forEach(userRepository::save);
	}

	public void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		operationUser.printEveryOperation(20 , 5);
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());

		try{
			int value = 10 / 0;
			LOGGER.debug("Mi valor es " + value);
		}

		catch(Exception ex) {
			LOGGER.error("Esto es un error " + ex.getMessage());
		}
	}
}
