package co.qingmei.pm.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import co.qingmei.pm.actions.ReturnData;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class WebUtils {

	
	
	public  static  void writeData2Page(
			Object  data,
		HttpServletResponse  resp ) {
	 
		resp.setCharacterEncoding("utf-8");
		
		ReturnData  rd = new ReturnData();
		rd.setRetCode(1);
		rd.setMsg("success");
		rd.setData(data);
		
		try {
			resp.getWriter().write( JSONObject.toJSONStringWithDateFormat(rd,"yyyy-MM-dd", new SerializerFeature[0] ));  //. toJSONString( rd) );
			resp.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 
		
	}
	public  static  void writeData2Page(String  data,
			HttpServletResponse  resp ) {
		
		    resp.setCharacterEncoding("utf-8"); 
			
			try {
				resp.getWriter().write(data);
				resp.getWriter().close();
			} catch (IOException e) {
				 System.out.println("дҳ�����ݱ���������");
				e.printStackTrace();
			}
		 
	}
}
