package com.zml.shsite.components;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
/**
 * http返回包装器
 * @author fhr
 * @date 2017/04/11
 */
public class ResponseWrapper extends HttpServletResponseWrapper  {
	//该书写器保持了http正文内容
	private PrintWriter cachedWriter;  
	//包装上面的书写器，让我们直接可以获取内容
	private CharArrayWriter bufferedWriter;  

	public ResponseWrapper(HttpServletResponse response) {
		super(response);
        bufferedWriter = new CharArrayWriter();  
        cachedWriter = new PrintWriter(bufferedWriter);  
	}
	/**
	 * 关键重写这个,
	 * 让我们的自定义书写器参与http处理中
	 */
	@Override  
	public PrintWriter getWriter() {
		return cachedWriter;
	}
	/**
	 * 获取原始的返回内容
	 * @return
	 */
    public String getResult() {  
        return bufferedWriter.toString();  
    }  
}
