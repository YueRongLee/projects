package com.khh.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
//htp://..../gjun/v1/hello
@Path("/hello")
public class HelloService {
	//htp://..../gjun/v1/hello/gjunhelloworld
	//決定傳送方法
	@Path("/gjunhellworld")
	@POST
	@Produces("text/html")// MIME Type(Media type)-content type
	public String helloWorld()
	{
		return "<font size='5' color='red'>Hello World</font>";
	}
	
	//互通前端資訊 採用QueryString
	@Path("/helloworld")
	@GET
	@Produces("text/plain")
	public String hello(@QueryParam("yourname")String who)
	{
		return "Hello World!!"+who+" 您好!!";
	}
	
	//使用Path當作參數內容
	@Path("/twhello/name/{yourname}/message/{message}")
	@GET
	@Produces("text/plain")
	public String twHello(@PathParam("yourname")String who,@PathParam("message")String msg)
	{
		return String.format("%s 您好 您的訊息:%s",who,msg);
	}

}
