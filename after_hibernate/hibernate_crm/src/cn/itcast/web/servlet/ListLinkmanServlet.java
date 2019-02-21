package cn.itcast.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
import cn.itcast.service.impl.LinkManServiceImpl;

/**
 * Servlet implementation class ListLinkmanServlet
 */
public class ListLinkmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinkManService sevice = new LinkManServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLinkmanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lkm_name = request.getParameter("lkm_name");
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		if(lkm_name!=null&&!"".equals(lkm_name)){
			dc.add(Restrictions.like("lkm_name", "%"+lkm_name+"%"));
		}
		List<LinkMan> list = sevice.getAll(dc);
		request.setAttribute("list", list);
		request.getRequestDispatcher("jsp/linkman/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
