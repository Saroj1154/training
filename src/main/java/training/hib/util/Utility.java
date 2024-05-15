package training.hib.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import training.entity.Doctor;
import training.entity.Patient;



public class Utility {

	 public static SessionFactory sessionFactoryDemo() {
	        Configuration configuration = new Configuration();
	        Properties properties=new Properties();
		 properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		 properties.put(Environment.URL, "jdbc:mysql://localhost:3306/Spring5May2024");
		 properties.put(Environment.USER, "root");
		 properties.put(Environment.PASS, "Saroj@1154");
		 properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		 properties.put(Environment.HBM2DDL_AUTO, "update");
		 properties.put(Environment.SHOW_SQL, "true");
	        configuration.setProperties(properties);
	        configuration.addAnnotatedClass(Doctor.class);
	        configuration.addAnnotatedClass(Patient.class);
	        return configuration.buildSessionFactory();
	    }
}
