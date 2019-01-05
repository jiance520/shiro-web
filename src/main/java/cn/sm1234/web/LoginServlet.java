package cn.sm1234.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
 
//登陆Servlet
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//接收用户名和密码
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		AuthenticationToken token = new UsernamePasswordToken(name, password);
		//调用login方法认证,先要Subject
		Subject subject = SecurityUtils.getSubject();//由于web.xml中配置了EnvironmentLoaderListener，其已经配置了SecurityManager，所以此处省略直接获取Subject
		
		try {
			subject.login(token);
			System.out.println("登陆成功");
			//认证成功，便可获取有效Principal
			String dName = (String)subject.getPrincipal();//dName=name
			request.getSession().setAttribute("userName", name);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (UnknownAccountException e) {
			System.out.println("用户不存在");
			request.setAttribute("msg", "用户不存在");
			request.getRequestDispatcher("/login.jsp").forward(request, response);//转发错误信息给前台。
		} catch (IncorrectCredentialsException e) {
			System.out.println("密码错误");
			request.setAttribute("msg", "密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/login.jsp");
			System.out.println("登陆失败");
			e.printStackTrace(); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
