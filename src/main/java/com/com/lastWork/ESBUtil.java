//import java.utils.ArrayList;
//import java.utils.HashMap;
//import java.utils.List;
//import java.utils.Map;
//
//import weaver.conn.RecordSet;
//import weaver.general.BaseBean;
//
//import net.sf.json.JSONObject;
//
///**
// * ESB工具类，主要于封装与解析ESB请求
// * @author feng
// *
// */
//public class ESBUtil{
//
//	public static BaseBean baseBean=new BaseBean();
//
//	public static JSONObject getRequestData(Map<String, Object> item){
//
//		return getEbsData(item,"Request");
//	}
//
//	public static JSONObject getResponseData(Map<String, Object> item){
//
//		return getEbsData(item,"Response");
//	}
//
//	public static JSONObject getEbsData(Map<String, Object> item,String opt){
//
//		Map<String, Object> root=new HashMap<String, Object>();
//		Map<String, Object> data=new HashMap<String, Object>();
//		Map<String, Object> list=new HashMap<String, Object>();
//
//		Map<String, String> head=new HashMap<String, String>();
//		head.put("BIZTRANSACTIONID", "weaveroa_"+System.currentTimeMillis());
//		if(opt.equals("Request")){
//			head.put("COUNT", "1");
//			head.put("CONSUMER", "portal");
//			head.put("SRVLEVEL", "1");
//			head.put("ACCOUNT", "");
//			head.put("PASSWORD", "");
//		}else{
//			head.put("RESULT", "1");
//			head.put("ERRORCODE", "");
//			head.put("ERRORINFO", "");
//			head.put("COMMENTS", "");
//			head.put("SUCCESSCOUNT", "");
//		}
//
//		list.put("item", item);
//
//		data.put("head", head);
//		data.put("list", list);
//
//		root.put(opt, data);
//
//		JSONObject dataObj=JSONObject.fromObject(root);
//		String resutl=dataObj.toString();
//
//		System.out.println("resutl:"+resutl);
//		return dataObj;
//	}
//
//	public static JSONObject parseRequestData(JSONObject data){
//		return parseData(data,"Request");
//	}
//
//	public static JSONObject parseResponseData(JSONObject data){
//		return parseData(data,"Response");
//	}
//
//	public static JSONObject parseData(JSONObject data,String opt){
//
//		JSONObject item=null;
//		try {
//			JSONObject response=JSONObject.fromObject(data.getString(opt));
//			JSONObject list=JSONObject.fromObject(response.getString("list"));
//			item=JSONObject.fromObject(list.getString("item"));
//		} catch (Exception e) {
//			baseBean.writeLog("[ESBUtil.parseData] JSON格式异常 data:"+data);
//		}
//
//		return item;
//	}
//
//	/**
//	 * 返回结果
//	 * @param action
//	 * @return
//	 */
//	public static JSONObject returnResultMsg(Object data,String code,String msg){
//
//		if(data==null){
//			data=new Object();
//		}
//
//		Map<String,Object> item = new HashMap<String,Object>();
//        item.put("data", data);
//        item.put("code", code);
//        item.put("msg", msg);
//
//        JSONObject responseData=ESBUtil.getResponseData(item);
//
//        baseBean.writeLog("[ESBUtil.returnResultMsg] responseData:"+responseData);
//
//        return responseData;
//
//	}
//
//	public static void main(String[] args) {
//
//		//EBSUtil service=new EBSUtil();
//		//service.doPush();
//	}
//
//}
