package com.employee.workdayservice;

import com.employee.workdayservice.models.Employee;
import com.employee.workdayservice.models.HourlyEmployee;
import com.employee.workdayservice.models.ManagerEmployee;
import com.employee.workdayservice.models.SalaryEmployee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class WorkdayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkdayServiceApplication.class, args);
	}

	@Bean
	public static List<Employee> employees(){

		return Arrays.asList(
				new SalaryEmployee("1"),
				new HourlyEmployee("2"),
				new SalaryEmployee("3"),
				new HourlyEmployee("4"),
				new SalaryEmployee("5"),
				new HourlyEmployee("6"),
				new SalaryEmployee("7"),
				new HourlyEmployee("8"),
				new ManagerEmployee("9")
		);
	}

}
