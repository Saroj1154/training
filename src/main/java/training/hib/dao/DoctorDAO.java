package training.hib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import training.entity.Doctor;
import training.entity.Patient;
import training.hib.util.Utility;

import java.util.HashSet;
import java.util.Set;

public class DoctorDAO {
	public static void addDoctor(Doctor doctor){
		SessionFactory sessionFactory = Utility.sessionFactoryDemo();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.save(doctor);
			tx. commit();
		}catch (Exception e){
			if(tx!= null){
				tx.rollback();
			}
			e.printStackTrace();
			e.printStackTrace();
			System.out.println("Error while saving data");
		}finally {
			if(session!= null){
				session.close();
			}
		}

	}



}
