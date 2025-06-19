package com.ces3.examen.examen_final;

import com.ces3.examen.examen_final.modelo.Teacher;
import com.ces3.examen.examen_final.repositorio.TeacherRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamenFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenFinalApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(TeacherRepository repo) {
		return args -> {
			Teacher t1 = new Teacher("Laura", "Gómez", "Matemáticas", 3000.0, "laura@correo.com");
			Teacher t2 = new Teacher("Carlos", "Ruiz", "Física", 3200.0, "carlos@correo.com");
			Teacher t3 = new Teacher("Ana", "Martínez", "Química", 3100.0, "ana@correo.com");

			repo.save(t1);
			repo.save(t2);
			repo.save(t3);

			for (Teacher t : repo.findAll()) {
				System.out.println(t.toString() + " - Salario anual: $" + t.calcularSalarioAnual());
			}
		};
	}

}
