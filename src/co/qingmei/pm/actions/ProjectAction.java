package co.qingmei.pm.actions;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.qingmei.pm.biz.ProjectBiz;
import co.qingmei.pm.entity.Project;
import co.qingmei.pm.utils.WebUtils;

import com.github.pagehelper.PageInfo;

@Controller
public class ProjectAction  {





	public void  ProjectAction(int i){
		if (i==10)
			return;

		//1*1 =1
		//1*2=2 2*2=4
		//1*3=3 2*3=6 3*3=9
		for(int a=1;a<=i;a++)
            System.out.print( a+"*"+i+"="+a*i +"  ");

		System.out.println();
		ProjectAction(i+1);

	}


	public  static  void main(String [] sss){
		ProjectAction  pa = new ProjectAction();
		pa.ProjectAction(1);
	}

	
	@Autowired
	private ProjectBiz pb;


	@RequestMapping("getProjectListWithJoinInfo.action")
	public void  getProjectListWithJoinInfo(String projectName,
											@RequestParam (value="pageNum",defaultValue="1")Integer pageNum,
											@RequestParam (value="pageSize",defaultValue="10")Integer pageSize,

											HttpServletResponse resp){


		List<Project>  ppp =this.pb.getProjectListWithJoinInfo(projectName,pageNum,pageSize);


		PageInfo  pi =  new PageInfo(ppp);


		WebUtils.writeData2Page( pi ,resp );

	}

	@RequestMapping("getProjectById.action")
	public  void  getProjectById(int   pid ,HttpServletResponse resp){
		Project  ppp= this.pb.getProjectById(pid);


		WebUtils.writeData2Page( ppp ,resp );
	}

	@RequestMapping("saveProject.action")
	public void saveProject(@RequestBody  Project ppp,HttpServletResponse resp ){

		this.pb.saveProject(ppp);

		WebUtils.writeData2Page( new Object() ,resp );


	}


	@RequestMapping("projectList.action")
	public void  getProjectList(String projectName,
			@RequestParam (value="pageNum",defaultValue="1")Integer pageNum,
			@RequestParam (value="pageSize",defaultValue="10")Integer pageSize,

			HttpServletResponse resp) {
		 
		
        List<Project> ps= this.pb.getProjectList(projectName,pageNum,pageSize);
		 
		
		PageInfo  pi =  new PageInfo(ps);
		 
		WebUtils.writeData2Page( pi ,resp );
	}
}

