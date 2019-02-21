package cn.itcast.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
import cn.itcast.service.impl.LinkManServiceImpl;

/**
 * Servlet implementation class AddLinkmanServlet
 */
public class AddLinkmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinkManService lms = new LinkManServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLinkmanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkMan lm = new LinkMan();
		try {
			BeanUtils.populate(lm, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		lms .save(lm);
		response.sendRedirect(request.getContextPath()+"/ListLinkManServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
