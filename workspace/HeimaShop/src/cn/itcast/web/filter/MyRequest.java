package cn.itcast.web.filter;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
	private boolean encoded = false;
	
	public MyRequest(HttpServletRequest request) {
		super(request);
	}
	/**
	 * 获得指定名称的所有参数
	 */
	@Override
	public String getParameter(String name) {
		String[] parameterValues = getParameterValues(name);
		if(parameterValues==null){
			return null;
		}
		return parameterValues[0];
	}
	/**
	 * 获得所有的内容，key：指定的名称;value：指定名称对象的所有值
	 */
	@Override
	public String[] getParameterValues(String name) {
		return getParameterMap().get(name);
	}
	
	@Override
	public Map<String, String[]> getParameterMap() {
		//1.获得原始数据
		Map<String, String[]> parameterMap = super.getParameterMap();
		//2.如果是get请求，存放栏目
		if(!encoded){
			if("get".equalsIgnoreCase(super.getMethod())){
				//遍历map,并遍历数组值
				for (Entry<String, String[]> map : parameterMap.entrySet()) {
					String[] values = map.getValue();
					for (int i=0;i<values.length;i++) {
						String encoding = super.getCharacterEncoding();
						if(encoding==null){
							encoding="UTF-8";
						}
						try {
							values[i] = new String(values[i].getBytes("iso8859-1"),encoding);
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
				}
			}
			//修改标记，表示已经编码
			encoded=true;
		}
		return parameterMap;
	}
}
