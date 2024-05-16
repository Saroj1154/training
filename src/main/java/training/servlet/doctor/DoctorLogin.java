package training.servlet.doctor;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import training.entity.Doctor;
import training.hib.util.Utility;

@WebServlet("/drLogin")
public class DoctorLogin extends HttpServlet {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("DoPost");
		// Create Session Factory
		SessionFactory sessionFactory = Utility.sessionFactoryDemo();
		session = sessionFactory.openSession();

		transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Doctor> criteriaQuery = criteriaBuilder.createQuery(Doctor.class);
		Root<Doctor> doctorRoot = criteriaQuery.from(Doctor.class);

		criteriaQuery.select(doctorRoot).distinct(true).where(
				criteriaBuilder.equal(doctorRoot.get("doctorName"), req.getParameter("doctorName")),
				criteriaBuilder.equal(doctorRoot.get("doctorAddress"), req.getParameter("doctorAddress")));
		// fetch the hospital data
		Query query = (Query) session.createQuery(criteriaQuery);
		Doctor doctor=  (Doctor) ( query).getSingleResult();
		
		if(doctor!= null) {
			HttpSession httpSession = req.getSession(); // creating session
			httpSession.setAttribute("doctorObj", doctor); // setting value of doctor obj in session
			session.close();
			resp.sendRedirect("doctorWelcomePage.jsp");
		}
		
		

	}
}
