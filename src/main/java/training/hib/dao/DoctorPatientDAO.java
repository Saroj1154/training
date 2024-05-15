package training.hib.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import training.entity.Doctor;
import training.entity.Patient;
import training.hib.util.Utility;

public class DoctorPatientDAO {
	public static void insertData() {
		SessionFactory sessionFactory = Utility.sessionFactoryDemo();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Set<Doctor> doctorSet = new HashSet();

		Doctor doctor = new Doctor();
		doctor.setDoctorName("Santosh");
		doctor.setDoctorAddress("Haltom");

		Set<Patient> patientSet = new HashSet();

		Patient patient = new Patient();
		patient.setPatientName("Amar");
		patient.setPatientEmail("Amar@gmail.com");
		patient.setPatientAddress("Pune");
		patientSet.add(patient);

		patient.setDoctors(doctorSet);

		doctor.setPatients(patientSet);
		try {

			tx = session.beginTransaction();
			session.persist(patient);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void addPatient(Patient patient) {
		SessionFactory sessionFactory = Utility.sessionFactoryDemo();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(patient);
		tx.commit();
	}
	
	public static Set<Patient> getPatientListByDoctor(Doctor doctor){
		SessionFactory sessionFactory = Utility.sessionFactoryDemo();
		Session session = sessionFactory.openSession();
		doctor= session.load(Doctor.class, doctor.getDoctorId());
		System.out.println(doctor.getPatients());
		return doctor.getPatients();
	}

}
