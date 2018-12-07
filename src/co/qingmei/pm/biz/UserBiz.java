package co.qingmei.pm.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import co.qingmei.pm.dao.EmployeeMapper;
import co.qingmei.pm.entity.Employee;
import co.qingmei.pm.entity.EmployeeExample;


@Component
public class UserBiz {

	@Autowired
	private  EmployeeMapper em;
	
	public Employee login(String uName, String pwd) {
		
		EmployeeExample  ee = new EmployeeExample();
		ee.createCriteria().andLoginnameEqualTo(uName).andPwdEqualTo(pwd);
		
		List<Employee> us= this.em.selectByExample(ee);
		
		return  us.size()>0?us.get(0):null;
	}

	public List<Employee> getUserList(String userName, Integer pageNum, Integer pageSize) {
		
		PageHelper.startPage(pageNum,pageSize);
		
		EmployeeExample  ee = new EmployeeExample();
		ee.createCriteria().andNameLike(userName);
		
		return   this.em.selectByExample(ee);
		
		
	}

	@Transactional(propagation= Propagation.REQUIRED )
	public void saveUser(Employee uuu) {
		if (uuu.getId() ==null)
			this.em.insertSelective(uuu);
		else
		    this.em.updateByPrimaryKeySelective(uuu);
		
	}

	public Employee getUserById(int id) {
		// TODO Auto-generated method stub
		return  this.em.selectByPrimaryKey(id);
	}
	
	@Transactional(propagation= Propagation.REQUIRED )
	public void deleteUser(int userId) {
		this.em.deleteByPrimaryKey(userId); 
		
	}

}
