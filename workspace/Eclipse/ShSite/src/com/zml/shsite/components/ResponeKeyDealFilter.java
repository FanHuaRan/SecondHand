package com.zml.shsite.components;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
/**
 *  http拦截器,用于删除、替换返回内容正文关键字
 *  不适用！！！
  * @author fhr
 *  @date 2017/04/11
 */
public class ResponeKeyDealFilter implements Filter {
	/**
	 * 要删除的关键字数组
	 */
	private static final String[]DELETEKEYS=new String[]{};
	/**
	 * 要替换的关键字字典
	 */
	@SuppressWarnings("serial")
	private static final Map<String, String> REPLACEKEYS=new HashMap<String,String>(){
		{
		 put("评论","xxx");  
		 put("收藏", "yyy");
		}
	};
	/**
	 * 拦截方法，chain是拦截器链 chain.doFilter方法分割处理前和处理后
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//对返回内容进行包装
        ResponseWrapper wrapper = new ResponseWrapper((HttpServletResponse)response);  
        //方形http请求,二个参数是我们的包装器而不是response  
        //chain.doFilter(request, response);//放行让其走到下个链或目标资源中 
        chain.doFilter(request,wrapper);  
        // 处理截获的结果并进行处理 
       //获取返回内容
        String orgin=wrapper.getResult();
        //如果不是空串就要进行处理，
        //其一是防止静态文件，其二是不对空字符串进行处理
        if(orgin!=null&&!orgin.equals("")){
            // 输出最终的结果  
            outPutResult(response,dealResult(orgin));  
        }
	}
	/**
	 * 输出处理后的内容
	 * @param response
	 * @param result
	 * @throws IOException
	 */
	private void outPutResult(ServletResponse response, String result) throws IOException {
		// 重置响应输出的内容长度  
        response.setContentLength(-1);  
        //写入内容
		PrintWriter out = response.getWriter();  
        out.write(result);  
        out.flush();  
        out.close();
	}
	/**
	 * 对原始内容进行处理
	 * @param orgin
	 * @return
	 */
	private String dealResult(String orgin){
		//删除关键字
		for(String deleteKey:DELETEKEYS){
			orgin=orgin.replace(deleteKey,"");
		}
		//替换关键字
		for(Entry<String,String> replace:REPLACEKEYS.entrySet()){
			orgin=orgin.replace(replace.getKey(),replace.getValue());
		}
		return orgin;
	}
	/************************下面方法不用管*********************/
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}
}