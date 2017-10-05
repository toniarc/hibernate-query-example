package br.com.interage.integration.persistence;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;

import br.com.interage.business.model.Employee;
import br.gov.pa.prodepa.persistence.AbstractDaoCrud;

public class EmployeeDao extends AbstractDaoCrud<Employee> {

	public List<Employee> search(Employee bean, Integer first, Integer maxResults) {
		/*
		 * Session session = (Session) getEntityManager().getDelegate(); Criteria
		 * criteria = session.createCriteria(Employee.class);
		 * //criteria.createCriteria("", arg1); //criteria.setResultTransformer(new
		 * AliasToBeanResultTransformer(SomeDTO.class));
		 * 
		 * Example example = Example.create(bean).enableLike(); criteria.add(example);
		 * List<Employee> result = criteria.list();
		 */

		//Query emps = buscarPorTodosOsCamposComMapeamentoDefault();
		//List<Employee> resultList = emps.getResultList();
		
		Query emps = buscarUsandoSqlResulSetMappings();
		List<Object[]> list = emps.getResultList();
		
		return null;
	}

	private Query buscarUsandoSqlResulSetMappings() {
		StringBuilder hql = new StringBuilder();
		hql.append(" select e.emp_no as id, e.first_name, e.last_name, e.PHONE_EXT, ");
		hql.append(" e.HIRE_DATE, e.SALARY, e.FULL_NAME, ");
		hql.append(" e.dept_no, e.JOB_CODE, e.JOB_COUNTRY, e.JOB_GRADE");
		hql.append(" from employee e ");
		
		Query emps = getEntityManager().createNativeQuery(hql.toString(), "EmployeeMapping");
		return emps;
	}

	/**
	 * Busca pelos nomes padrao das colunas, porem so funciona se a clausula select
	 *  conter todos os campos mapeados na entidade
	 */
	private Query buscarPorTodosOsCamposComMapeamentoDefault() {
		StringBuilder hql = new StringBuilder();
		hql.append(" select e.emp_no, e.dept_no, e.first_name, e.last_name, e.PHONE_EXT, ");
		hql.append(" e.HIRE_DATE, e.SALARY, e.FULL_NAME, e.JOB_CODE, e.JOB_COUNTRY, e.JOB_GRADE ");
		hql.append(" from employee e ");
		
		Query emps = getEntityManager().createNativeQuery(hql.toString(), Employee.class);
		return emps;
	}

	public Integer count(Employee bean) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.rowCount());
		Example example = Example.create(bean).enableLike();
		criteria.add(example);
		Object uniqueResult = criteria.uniqueResult();
		return ((Long) uniqueResult).intValue();
	}

}
