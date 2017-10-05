package br.com.interage.quickstart.integration.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;

import com.github.fluent.hibernate.transformer.FluentHibernateResultTransformer;

import br.com.interage.business.dto.EmployeeDto;
import br.com.interage.business.model.Department;
import br.com.interage.business.model.Employee;

public class EmployeeDaoTest {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultTestPU");
		EntityManager em = emf.createEntityManager();

		Session session = (Session) em.getDelegate();
		
		//searchWithNativeQuery(session);
		
		//searchWithCriteria(session);
		
		//searchWithSqlResulSetMappings(em);
		//searchWithJPACriteria(em);
		
		searchWithHql(session);
		
		em.close();
		emf.close();
	}

	private static void searchWithJPACriteria(EntityManager em) {
		Employee e = new Employee();
		e.setFirstName("Kevin");
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class); //Tipo que sera retornado na consulta
		Root<Employee> employee = query.from(Employee.class);
		
		//Join<Employee, Department> department = employee.join("department", JoinType.INNER);
		
		TypedQuery<Employee> tq = em.createQuery(query);
		List<Employee> resultList = tq.getResultList();
		
		for (Employee emp : resultList) {
			System.out.println(emp);
		}
	}
	
	private static void searchWithSqlResulSetMappings(EntityManager em) {
		
		Employee emp = new  Employee();
		
		StringBuilder hql = new StringBuilder();
		hql.append(" select e.emp_no, e.first_name as FIRST_NA2_4_0_, e.last_name, e.PHONE_EXT, ");
		hql.append(" e.HIRE_DATE, e.SALARY, e.FULL_NAME, e.dept_no as DEPT_NO8_4_0_ ");
		//hql.append(" e.dept_no, e.JOB_CODE, e.JOB_COUNTRY, e.JOB_GRADE");
		hql.append(" from employee e ");
		hql.append(" where 1=1 ");
		
		if(emp.getFirstName() != null) {
			hql.append(" and e.firstName = :fn");
		}
		
		Query emps = em.createNativeQuery(hql.toString(), "EmployeeMapping");
		
		if(emp.getFirstName() != null) {
			emps.setParameter("fn", "kevin");
		}
		
		List<Employee> resultList = emps.getResultList();
		
	}

	private static void searchWithCriteria(Session session) {
		
		Department d = new Department("130");
		Example departExample = Example.create(d);
		
		Employee e = new Employee();
		e.setFirstName("Kevin");
		//e.setDepartment(new Department("130"));
		Example empExample = Example.create(e);
		
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.createCriteria("department", "d");
		criteria.setProjection(
				Projections.projectionList()
					.add(Projections.property("empNo"), "empNo")
					.add(Projections.property("firstName"), "firstName")
					.add(Projections.property("fullName"), "fullName")
					.add(Projections.property("d.deptNo"), "department.deptNo")
					);
		criteria.add(empExample);
		criteria.setResultTransformer(new FluentHibernateResultTransformer(Employee.class));
		
		List<Employee> result2 = criteria.list();
		
		for (Employee emp : result2) {
			System.out.println(emp + ", deptNo=" + emp.getDepartment().getDeptNo());
		}
	}

	private static void searchWithNativeQuery(Session session) {
		StringBuilder hql = new StringBuilder();
		hql.append(" select e.emp_no as empNo, e.first_name as firstName, e.last_name as lastName, d.dept_no as deptNo, d. ");
		hql.append(" from employee e inner join department d on d.dept_no = e.dept_no ");
		
		SQLQuery sqlQuery = session.createSQLQuery(hql.toString());
		sqlQuery.setResultTransformer(new FluentHibernateResultTransformer(EmployeeDto.class));
		List<EmployeeDto> result1 = sqlQuery.list();
		
		for (EmployeeDto emp : result1) {
			System.out.println(emp);
		}
	}
	
	private static void searchWithHql(Session session) {
		StringBuilder hql = new StringBuilder("select e.empNo as empNo, e.firstName as firstName from Employee e join e.department d");
		org.hibernate.Query q = session.createQuery(hql.toString());
		q.setResultTransformer(new FluentHibernateResultTransformer(Employee.class));
		List<Employee> list = q.list();
		
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}
}
