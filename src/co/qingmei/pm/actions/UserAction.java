package co.qingmei.pm.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import co.qingmei.pm.biz.UserBiz;
import co.qingmei.pm.entity.Employee;
import co.qingmei.pm.utils.WebUtils;
import net.sf.json.JSONObject;

@Controller
public class UserAction {

	/*public static void main(String[] args) {
		Employee  uuu = new Employee  ();
		uuu.setId(123);
		uuu.setEmail("sdfsdfsf");
		uuu.setLoginname("admin");
		
		System.out.println( JSONObject.fromObject(uuu).toString() );
		
	}
	*/
	@Autowired
	private  UserBiz  ub;
	
	@RequestMapping("ajaxGetJsonData.action")
	public void test( HttpServletResponse resp) {
		 Employee  emp = new Employee();
		 emp.setId(1111111);
		 emp.setEmail("abc@sdfsf.com");
		 emp.setLoginname("root");
		 emp.setName("IT_zheng");
		 emp.setPwd("123");
		 
		 

		WebUtils.writeData2Page( emp ,resp );
	}

	@RequestMapping("getUserById.action")
	public void getUserById(int id,HttpServletResponse resp) {
		Employee u = this.ub.getUserById(id);

		WebUtils.writeData2Page( u ,resp );
	}

	@RequestMapping("userList.action")
	public  void  getUserList(
			String userName,
			@RequestParam (value="pageNum",defaultValue="1")Integer pageNum,
			@RequestParam (value="pageSize",defaultValue="10")Integer pageSize,
			HttpServletResponse resp ) {

		List<Employee> us= this.ub.getUserList(userName,pageNum,pageSize);
		
		
		/*Page<Employee>  ppp = new Page<>();
		ppp.addAll(us);*/

		PageInfo  pi =  new PageInfo (us);
		
		/*ppp.getPageNum();//当前低级页
		ppp.getPageSize();//每页行数
		ppp.getTotal();//总记录数
		ppp.getPages();//总页数

		ppp.getResult();//数据
*/
		//System.out.println( us.get(0).getName() );
		WebUtils.writeData2Page( pi ,resp );

	}


	@RequestMapping("deleteUserById.action")
	public  void  deleteUserById(int  userId,HttpServletResponse  resp) {
		this.ub.deleteUser(userId);

		WebUtils.writeData2Page(new Object(), resp);
	}

	@RequestMapping("updateUser.action")
	public void updateUser(@RequestBody  Employee  uuu,HttpServletResponse resp ) {
		this.ub.saveUser(uuu);

		//System.out.println(uuu.getLoginname());

		WebUtils.writeData2Page(new Object(), resp);
	}




	@RequestMapping("logout.action")
	public  String   logout(HttpSession hs) {
		hs.invalidate();

		return "redirect:login.html";
	}

	@RequestMapping("login.action")
	public  void  login(String  uName,String pwd,HttpServletRequest  req,
						HttpServletResponse resp) throws IOException {
//		System.out.println(uName);
//		System.out.println(pwd);

//	   for(String nnn: req.getParameterMap().keySet() ) {
//		   System.out.println(nnn);
//	   }

		Employee  uuu = this.ub.login(uName,pwd);

		//{id:123,name:xxx,....}
		//JSON解析：

		//{retCode:0|1, msg:'lxlxdfdfj',data:{} }
		if (uuu != null) {
			ReturnData  rd = new ReturnData();
			rd.setData(uuu);
			rd.setRetCode(1);
			rd.setMsg("success");

			WebUtils.writeData2Page(JSONObject.fromObject(rd).toString(), resp);
		}else {
			ReturnData  rd = new ReturnData();
			rd.setData(null);
			rd.setRetCode(0);
			rd.setMsg("登录失败，请求检查用户名称和密码");


			WebUtils.writeData2Page( JSONObject.fromObject(rd).toString(), resp);
		}


	}


}
