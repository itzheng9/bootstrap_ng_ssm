package co.qingmei.pm.actions;

import co.qingmei.pm.biz.ProjectBiz;
import co.qingmei.pm.biz.TaskBiz;
import co.qingmei.pm.entity.Project;
import co.qingmei.pm.entity.Task;
import co.qingmei.pm.utils.WebUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class TaskAction  {




	@Autowired
	private TaskBiz tb;

	@RequestMapping("getTaskById.action")
	public  void  getTaskById(int   tid ,HttpServletResponse resp){
		Task  ppp= this.tb.getTaskById(tid);


		WebUtils.writeData2Page( ppp ,resp );
	}

	@RequestMapping("saveTask.action")
	public void saveTask(@RequestBody  Task ppp,HttpServletResponse resp ){

		//TODO cong从sesion取登录用户id填入下面
		//ppp.setCreateuid();

		this.tb.saveTask(ppp);

		WebUtils.writeData2Page( new Object() ,resp );


	}


	@RequestMapping("taskList.action")
	public void  getTaskList(String taskName,
			@RequestParam (value="pageNum",defaultValue="1")Integer pageNum,
			@RequestParam (value="pageSize",defaultValue="10")Integer pageSize,

			HttpServletResponse resp) {
		 
		
        List<Task> ps= this.tb.getTaskList(taskName,pageNum,pageSize);
		 
		
		PageInfo  pi =  new PageInfo (ps);
		 
		WebUtils.writeData2Page( pi ,resp );
	}


	@RequestMapping("deleteTaskById.action")
	public  void deleteTaskById(int   tId,HttpServletResponse resp){
		this.tb.deleteTaskById(tId);

		WebUtils.writeData2Page( 1 ,resp );
	}
}

