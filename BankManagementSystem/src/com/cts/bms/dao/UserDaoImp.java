package com.cts.bms.dao;

import java.util.Calendar;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.cts.bms.entity.Initial_Balance;
//import com.cts.bms.entity.Location;
import com.cts.bms.utils.Login;
//import com.cts.bms.entity.User;
//import com.cts.bms.pojos.RegistrationDetails;
import com.cts.bms.entity.User;
import com.cts.bms.utils.RegistrationDetails;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	// @Autowired
	// private RegistrationDetails details;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.bms.dao.UserDao#add(com.cts.bms.entity.User)
	 */
	@Override
	public void add(User user) {
		Session ses = sessionFactory.getCurrentSession();
		ses.save(user);
		//ses.beginTransaction().commit();

	}

	// /* (non-Javadoc)
	// * @see com.cts.bms.dao.UserDao#listUsers()
	// */
	// @Override
	// public List<User> listUsers() {
	// @SuppressWarnings("unchecked")
	// TypedQuery<User> query =
	// sessionFactory.getCurrentSession().createQuery("from User");
	// return query.getResultList();
	// }
	//
	// /* (non-Javadoc)
	// * @see com.cts.bms.dao.UserDao#validateUser(com.cts.bms.entity.Login)
	// */
	@Override
	public boolean validateUser(Login login) {
		// TODO Auto-generated method stub
		boolean flag = false;

		Session ses = sessionFactory.getCurrentSession();

		Query qry = ses.createQuery("from User where username=:username and password=:password");

		qry.setParameter("username", login.getUsername());

		qry.setParameter("password", login.getPassword());
		System.out.println("validate user " + login.getPassword() + " " + login.getUsername());
		List<Login> users = qry.getResultList();

		if (users.size() != 0) {
			flag = true;
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.bms.dao.UserDao#registerUser(com.cts.bms.entity.User)
	 */
	@Override
	public RegistrationDetails registerUser(User user) {
		// TODO Auto-generated method stub

		RegistrationDetails details = new RegistrationDetails();

	//	if (!findByUserName(user.getUsername())) {

			Session ses = sessionFactory.getCurrentSession();

			String reg_id = generateRegistrationId();

			user.setCust_id(reg_id);

			System.out.println(user.getCountry());

			String account_no = generateAccountNumber();

			user.setAcc_no(account_no);

			add(user);

			details.setAccountNumber(account_no);

			details.setCustomerId(reg_id);

	//	}

		return details;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.bms.dao.UserDao#findByUserName(java.lang.String)
	 */
	@Override
	public boolean findByUserName(String username) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Session ses = sessionFactory.getCurrentSession();
		Query query = ses.createQuery("from User where username = :username");
		query.setParameter("username", username);
		List result = query.getResultList();
		if (result.size() == 0) {
			flag = true;
		}
		return flag;
	}

	private String generateRegistrationId() {

		String s = "R-";

		Session ses = sessionFactory.getCurrentSession();

		long registration_number = (long) ses.createQuery("select Count(*)from User ").uniqueResult();

		s += String.format("%03d", ++registration_number);
		;

		return s;
	}

	private String generateAccountNumber() {

		long prefix = 501002103;

		String pre = Long.toString(prefix);

		Session ses = sessionFactory.getCurrentSession();

		long count = (long) ses.createQuery("select count(*) from User").uniqueResult();

		String suffix = String.format("%07d", count);

		return prefix + suffix;

	}

	// /* (non-Javadoc)
	// * @see com.cts.bms.dao.UserDao#findByUserName(java.lang.String)
	// */
	// @Override
	// public boolean findByUserName(String username) {
	// // TODO Auto-generated method stub
	// boolean flag = false;
	// Session ses = sessionFactory.getCurrentSession();
	// Query query = ses.createQuery("from User where username = :username");
	// query.setParameter("username", username);
	// List result = query.getResultList();
	// if(result.size()==0){
	// flag = true;
	// }
	// return flag;
	// }
	//
	// /* (non-Javadoc)
	// * @see com.cts.bms.dao.UserDao#findCountryId(com.cts.bms.entity.User)
	// */
	// @Override
	// public List<String> findCountryId(User user) {
	// Session ses = sessionFactory.getCurrentSession();
	// Query query = ses.createQuery("select loc_id from location where country
	// = :country and state = :state");
	// query.setParameter("country", user.getLocation().getCountry());
	// query.setParameter("state", user.getLocation().getState());
	// List<String> countryId = query.getResultList();
	// System.out.println("Country Id for " +user.getLocation().getCountry()+ "
	// and" +user.getLocation().getState()+ "is" +countryId);
	// return countryId;
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.cts.bms.dao.UserDao#findInitialDepositAmount(com.cts.bms.entity.User)
	// */
	// @Override
	// public long findInitialDepositAmount(User user) {
	//
	// Session ses = sessionFactory.getCurrentSession();
	// if(user.getAcc_type().equals("Saving")){
	// //initial saving amount
	//
	// long q1 = (long) ses.createQuery(" select initial_saving from
	// initial_balance where country =:country")
	// .setParameter("country", user.getLocation().getCountry()).uniqueResult();
	//
	// // List l2 = q2.getResultList();
	// return q1;
	//
	//
	// }
	// else {
	// long q2 = (long) ses.createQuery(" select initial_salary from
	// initial_balance where country =:country")
	// .setParameter("country", user.getLocation().getCountry()).uniqueResult();
	//
	// //initial salary amount
	//
	// return q2;
	// }
	//
	//
	//
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see com.cts.bms.dao.UserDao#findIFSCCode(com.cts.bms.entity.User)
	// */
	// @Override
	// public List<String> findIFSCCode(User user) {
	// // TODO Auto-generated method stub
	// Session ses = sessionFactory.getCurrentSession();
	// Query query = ses.createQuery("select IFSC from branch where branch_name
	// =:branch_name");
	// query.setParameter("branch_name", user.getBranch_name());
	// List<String> li = query.getResultList();
	//
	//
	// if(li.size() != 0){
	// return li;
	// }
	// else {
	// return null;
	// }
	// }
	//
	// /* (non-Javadoc)
	// * @see com.cts.bms.dao.UserDao#isPanExists(java.lang.String)
	// */
	// @Override
	// public String isPanExists(String pan_no) {
	// // TODO Auto-generated method stub
	// Session ses = sessionFactory.getCurrentSession();
	// Query query = ses.createQuery("select pan_no from customer_details");
	// List<String> li = query.getResultList();
	//
	// if(li.contains(pan_no)){
	// String s = "Customer with PAN number" +pan_no+ "exists in the system";
	// return s;
	//
	// }else {
	// String s = "Customer with PAN number" +pan_no+ "accepted";
	// return s;
	// }
	// }
	//
	// /* (non-Javadoc)
	// * @see com.cts.bms.dao.UserDao#getStates(java.lang.String)
	// */
	// @Override
	// public List<String> getStates(String country) {
	// // TODO Auto-generated method stub
	// Session ses = sessionFactory.getCurrentSession();
	// Query query = ses.createQuery("select state from location where country
	// =; country");
	// query.setParameter("country", country);
	// List<String> li = query.getResultList();
	// return li;
	// }
	//
	//
	// /* (non-Javadoc)
	// * @see com.cts.bms.dao.UserDao#getAge(java.util.Date)
	// */
	// @Override
	// public int getAge(Date dob) {
	// // TODO Auto-generated method stub
	//
	// Calendar now = Calendar.getInstance();
	// Calendar cal = Calendar.getInstance();
	// cal.setTime(dob);
	// if(cal.after(now)){
	// int year1 = now.get(Calendar.YEAR);
	// int year2 = cal.get(Calendar.YEAR);
	// int age = year1 - year2;
	// int month1 = now.get(Calendar.MONTH);
	// int month2 = cal.get(Calendar.MONTH);
	// if (month2 > month1) {
	// age--;
	// }
	// else if (month1 == month2) {
	// int day1 = now.get(Calendar.DAY_OF_MONTH);
	// int day2 = cal.get(Calendar.DAY_OF_MONTH);
	// if (day2 > day1) {
	// age--;
	// }
	// }
	// getAgeStatus(age);
	// return age;
	// }
	// else {
	// System.out.println("Date of birth is invalid");
	// return 0;
	// }
	// }
	//
	// /* (non-Javadoc)
	// * @see com.cts.bms.dao.UserDao#getAgeStatus(int)
	// */
	// @Override
	// public String getAgeStatus(int age) {
	// // TODO Auto-generated method stub
	// String citizenStatus;
	// if(age<18){
	// citizenStatus = "Minor";
	//
	// }
	// else if(age >18 && age<=60){
	// citizenStatus = "Normal";
	//
	// }
	// else {
	// citizenStatus = "Senior";
	//
	// }
	//
	// return citizenStatus;
	//
	// }
	//
	//
	//
	// /* (non-Javadoc)
	// * @see com.cts.bms.dao.UserDao#getInterestRate(int)
	// */
	// @Override
	// public int getInterestRate(String status) {
	// // TODO Auto-generated method stub
	// int interestRate;
	//
	// Session ses = sessionFactory.getCurrentSession();
	//
	// interestRate= (int)ses.createQuery("select int_rate from citizen_status
	// where status:status").setParameter("status", status).uniqueResult();
	//
	// return interestRate;
	//
	// }
	//
	//
	// private String generateRegistrationId() {
	//
	// String s="R-";
	//
	// Session ses = sessionFactory.getCurrentSession();
	//
	// int registration_number = (int) ses.createQuery("select Count(*)from User
	// ").uniqueResult();
	//
	// s+=String.format("%03d", ++registration_number);;
	//
	// return s;
	// }
	//
	//
	// private String generateAccountNumber() {
	//
	// long prefix = 501002103;
	//
	// String pre=Long.toString(prefix);
	//
	// Session ses = sessionFactory.getCurrentSession();
	//
	// long count =(long) ses.createQuery("select count(*) from
	// account_details").uniqueResult();
	//
	// String suffix = String.format("%07d", count);
	//
	//
	// return prefix+suffix;
	//
	// }

}
