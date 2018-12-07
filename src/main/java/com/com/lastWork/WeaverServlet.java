//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.utils.HashMap;
//import java.utils.Map;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.alibaba.fastjson.JSONObject;
//import weaver.general.BaseBean;
//
//import net.sf.json.JSONObject;
//
///*
//**
//* OA接口服务类，主要用于接收门户请求
//* @author feng
//*
//*/
//public class WeaverServlet extends HttpServlet {
//
//	public BaseBean baseBean=new BaseBean();
//
//	/**
//	 * Constructor of the object.
//	 */
//	public WeaverServlet() {
//		super();
//	}
//
//	/**
//	 * Destruction of the servlet. <br>
//	 */
//	public void destroy() {
//		super.destroy(); // Just puts "destroy" string in log
//		// Put your code here
//	}
//
//	/**
//	 * The doGet method of the servlet. <br>
//	 *
//	 * This method is called when a form has its tag value method equals to get.
//	 *
//	 * @param request the request send by the client to the server
//	 * @param response the response send by the server to the client
//	 * @throws ServletException if an error occurred
//	 * @throws IOException if an error occurred
//	 */
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		doPost(request,response);
//	}
//
//	/**
//	 * The doPost method of the servlet. <br>
//	 *
//	 * This method is called when a form has its tag value method equals to post.
//	 *
//	 * @param request the request send by the client to the server
//	 * @param response the response send by the server to the client
//	 * @throws ServletException if an error occurred
//	 * @throws IOException if an error occurred
//	 */
//	public void doPost(HttpServletRequest request, HttpServletResponse response){
//
//		PrintWriter out =null;
//		JSONObject resultObj=null;
//		try {
//			String contentType = request.getContentType();
//	        response.setContentType(contentType);
//	        response.setCharacterEncoding("UTF-8");
//
//			out = response.getWriter();
//
//			baseBean.writeLog("[WeaverServlet.doPost] "+request.getRequestURI()+"/"+request.getQueryString());
//
//			JSONObject requestdata=receivePost(request);
//
//			WeaverService service=new WeaverService();
//
//			if(requestdata!=null){
//
//				baseBean.writeLog("[WeaverServlet.doPost] requestdata:"+requestdata.toString());
//
//				JSONObject item=ESBUtil.parseRequestData(requestdata);
//
//				String appid=item.getString("appid"); //应用ID
//				String action=item.getString("action");//动作
//
//				baseBean.writeLog("[WeaverServlet.doPost] action:"+action);
//
//				if(action.equals("documentList")){ //文档列表
//
//					resultObj=service.getDocumentList(item);
//
//				}else if(action.equals("openaccount")){
//
//					resultObj=service.openAccount(item);
//
//				}else{
//					resultObj=ESBUtil.returnResultMsg(null,"0","没有找到对应动作,action:"+action);
//				}
//
//			}else{
//				baseBean.writeLog("[WeaverServlet.doPost] 接口部署成功");
//				resultObj=ESBUtil.returnResultMsg(null,"0","接口部署成功");
//			}
//
//			String result=JSONObject.fromObject(resultObj).toString();
//			baseBean.writeLog("[WeaverServlet.doPost] result:"+result);
//			out.print(result);
//
//		}catch (Exception e) {
//			baseBean.writeLog("[WeaverServlet.doPost] 接口处理失败 error:"+e.toString());
//			baseBean.writeLog(e);
//
//			resultObj=ESBUtil.returnResultMsg(null,"-1","接口调用失败 error:"+e.toString());
//			String result=JSONObject.fromObject(resultObj).toString();
//			out.print(result);
//
//		}finally{
//			out.flush();
//			out.close();
//		}
//	}
//
//	public JSONObject receivePost(HttpServletRequest request){
//
//		StringBuilder sb = new StringBuilder();
//		JSONObject json=null;
//		try {
//			// 读取请求内容
//	        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
//	        String line = null;
//	        while ((line = br.readLine()) != null) {
//	            sb.append(line);
//	        }
//	        //将json字符串转换为json对象
//	        json=JSONObject.fromObject(sb.toString());
//		} catch (Exception e) {
//			baseBean.writeLog("[WeaverServlet.receivePost] json解析失败 data:"+sb.toString());
//			baseBean.writeLog(e);
//		}
//
//        return json;
//    }
//
//	/**
//	 * Initialization of the servlet. <br>
//	 *
//	 * @throws ServletException if an error occurs
//	 */
//	public void init() throws ServletException {
//		// Put your code here
//	}
//
//}
