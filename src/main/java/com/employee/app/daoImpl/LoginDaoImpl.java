package com.employee.app.daoImpl;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.app.dao.LoginDao;
import com.employee.app.entity.Registration;

@SuppressWarnings({ "deprecation" })
@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Registration login(Registration registration) {
		Session session = null;
		Registration user = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Registration.class);
			criteria.add(Restrictions.eq("email", registration.getEmailId()));
			criteria.add(Restrictions.eq("password", registration.getPassword()));
			user = (Registration) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String registerNewUser(Registration registration) {
		Session session = null;
		String isRegistered = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(registration);
			transaction.commit();
			isRegistered = "User is Registered!";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isRegistered;
	}

}
