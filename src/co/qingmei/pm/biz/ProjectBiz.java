package co.qingmei.pm.biz;

import java.util.List;

import co.qingmei.pm.dao.BugMapper;
import co.qingmei.pm.dao.EmployeeMapper;
import co.qingmei.pm.dao.TaskMapper;
import co.qingmei.pm.entity.BugExample;
import co.qingmei.pm.entity.TaskExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import co.qingmei.pm.dao.ProjectMapper;
import co.qingmei.pm.entity.Project;
import co.qingmei.pm.entity.ProjectExample;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectBiz {

	@Autowired
	private  ProjectMapper  pm;
	@Autowired
	private TaskMapper tm;
	@Autowired
	private BugMapper bm;
	@Autowired
    private EmployeeMapper em;

	public  List<Project> getProjectListWithJoinInfo(String projectName,
                                                     Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);


		List<Project> projects = this.getProjectList(projectName,pageNum,pageSize);

		//.查询附加信息
		for(Project  p:projects){
			//查询项目组人员
            p.setEmployeeList(  this.em.selectEmployeeByPid(p.getId()) );

			//查询项目的任务
			TaskExample  te = new TaskExample();
			te.createCriteria().andPidEqualTo(p.getId());
			p.setTaskList( this.tm.selectByExample(te) );


			//查询项目的bug
			BugExample  be = new BugExample();
			be.createCriteria().andPidEqualsTo(p.getId());
			p.setBugList(this.bm.selectByExample(be));

		}



		return projects;

	}
	
	
	
	public List<Project> getProjectList(String projectName, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);

		ProjectExample  pe = new ProjectExample();
		 pe.createCriteria().andNameLike(projectName);
		 
		 return this.pm.selectByExample(pe);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
    public void saveProject(Project ppp) {
		if (ppp.getId() == null){
			this.pm.insertSelective(ppp);

		}else{
			this.pm.updateByPrimaryKeySelective(ppp);
		}

    }

    public Project getProjectById(int pid) {
		return this.pm.selectByPrimaryKey(pid);
    }
}
