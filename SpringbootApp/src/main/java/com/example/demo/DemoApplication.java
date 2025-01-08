package com.example.demo;

import com.example.demo.model.Company;
import com.example.demo.model.Employee;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication(
		exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class }
)

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//@Bean
	ApplicationRunner process2(CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
		return args -> {
			//List<Employee>  list = employeeRepository.findByCompanyNameIsLike("EPAM%");
			List<Employee>  list = employeeRepository.findByName("Ankit610");
			System.out.println(list);

			//N+1 problem solved using EntityGraph
//			List<Company> ll = companyRepository.findAll();
//			System.out.println(ll);

			//PAging and sorting
			Pageable pageable = PageRequest.of(0,20);
			Page<Company> ll2 = companyRepository.findAll(pageable);
			System.out.println(ll2);
			System.out.println(ll2.getContent());

			Pageable pageable3 = PageRequest.of(1,20);
			Page<Company> ll3 = companyRepository.findAll(pageable3);
			System.out.println(ll3);
			System.out.println(ll3.getContent());


//			SessionFactory sessionFactory = null;
//			Session session = sessionFactory.openSession();
//			session.load(new Object());

			//	DriverManagerDataSource  // - default DS by spring
			//OneToMany
		};
	}


	@Bean
	ApplicationRunner process(CompanyRepository companyRepository, EmployeeRepository employeeRepository){
		return args -> {
			for (int i = 0; i < 1; i++) {
				Random random = new Random();
				int no = random.nextInt(1000);
				Company company = new Company();
				company.setName("Wipro "+no);

				"".equals("");
//				Employee employee1 = new Employee();
//				employee1.setName("Ankit"+no);
//				employee1.setCompany(company);
//				Employee employee2 = new Employee();
//				employee2.setName("Sonu"+no);
//				employee2.setCompany(company);

				//company.setEmployees(Arrays.asList(employee1, employee2));

				companyRepository.save(company);
//				employeeRepository.save(employee1);
//				employeeRepository.save(employee2);

				System.out.println("Hello World");
			}

		};
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
