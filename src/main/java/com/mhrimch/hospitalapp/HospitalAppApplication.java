package com.mhrimch.hospitalapp;

import com.mhrimch.hospitalapp.entities.Patient;
import com.mhrimch.hospitalapp.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class HospitalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalAppApplication.class, args);}
	@Bean
	public CommandLineRunner start(PatientRepository patientRepository){
		/*return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {

			}
		};*/
		return args -> {
			Patient p1 = new Patient();
			p1.setFirstName("Imran");
			p1.setLastName("Hrimch");
			p1.setBirthday(LocalDate.of(2021, 8,24));
			p1.setScore(0);
			p1.set_Ill(false);
			patientRepository.save(p1);
			Patient p2 = new Patient(null, "Hodayfa", "Hrimch", LocalDate.of(2021,8,24), 0, false);
			patientRepository.save(p2);
			Patient P3 = Patient.builder().firstName("mohammed").lastName("hrimch").birthday(LocalDate.of(1980, 12,21)).score(0).is_Ill(false).build();
            patientRepository.save(Patient.builder().firstName("mohammed").lastName("hrimch").birthday(LocalDate.of(1980, 12,21)).score(0).is_Ill(false).build());

			List<Patient> patientList = patientRepository.findAll();

			patientList.forEach(patient -> {
				System.out.println(patient.toString());
			});


		};
	}

}
