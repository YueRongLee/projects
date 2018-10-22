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
	//�M�w�ǰe��k
	@Path("/gjunhellworld")
	@POST
	@Produces("text/html")// MIME Type(Media type)-content type
	public String helloWorld()
	{
		return "<font size='5' color='red'>Hello World</font>";
	}
	
	//���q�e�ݸ�T �ĥ�QueryString
	@Path("/helloworld")
	@GET
	@Produces("text/plain")
	public String hello(@QueryParam("yourname")String who)
	{
		return "Hello World!!"+who+" �z�n!!";
	}
	
	//�ϥ�Path��@�ѼƤ��e
	@Path("/twhello/name/{yourname}/message/{message}")
	@GET
	@Produces("text/plain")
	public String twHello(@PathParam("yourname")String who,@PathParam("message")String msg)
	{
		return String.format("%s �z�n �z���T��:%s",who,msg);
	}

}
