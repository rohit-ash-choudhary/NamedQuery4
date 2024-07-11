package com.sp.main.NamedQuery2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.sp.entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       EntityManagerFactory emf= Persistence.createEntityManagerFactory("main-persistence");
       EntityManager em=emf.createEntityManager();
       
       try {
    	   
    	TypedQuery<Employee> query1 = em.createNamedQuery("Allemployeedetails", Employee.class);
       	List<Employee> std_list1 = query1.getResultList();
       	for(Employee std1 : std_list1)
       	{
       		System.out.println("Id : "+std1.getEmployee_id());
       		System.out.println("Name  :"+std1.getEmployee_firstname());
       	
       		System.out.println("-----------------------------");
       	}
       	//-------------------------------//
       	TypedQuery<Employee> query = em.createNamedQuery("AllemployeedetailsID", Employee.class);
       	query.setParameter("emp_id",0);
       	Employee emp=query.getSingleResult();
       	System.out.println("Emp name "+ emp.getEmployee_firstname() + "emp lasst name"+ emp.getEmployee_lastname());
       		
       			
       			
       			
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
    }
}
