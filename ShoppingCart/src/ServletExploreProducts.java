

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;
import model.Product;

/**
 * Servlet implementation class ServletExploreProducts
 */
@WebServlet("/ExploreProducts")
public class ServletExploreProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExploreProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gotoStr =request.getParameter("goto");
		HttpSession session = request.getSession();
		String user ="";
		if(gotoStr!=null){
			if(gotoStr.equalsIgnoreCase("y"))
				user=(String) session.getAttribute("user");
		}else
			user = request.getParameter("name");
		
		session.setAttribute("user", user);
		List<Product> proList = DBUtil.getAllProducts();
		
		String tableData ="";
		
		tableData += "<tr>";
		tableData += "<thead>";
		tableData += "<th>";
		tableData += "";
		tableData += "</th>";
		tableData += "<th>"; 
		tableData += "Product Name";
		tableData += "</th>";
		tableData += "<th>";
		tableData += "Price";
		tableData += "</th>";
		tableData += "</thead>";
		tableData += "</tr>";
		
		for(Product p : proList){
			System.out.println(p.getProductname());
			
			tableData += "<tr>";
			tableData += "<td>";
			tableData += "<img src='" + p.getPicturepath() + "' width ='200' height='200' style=align:center>";
			tableData += "</td>";
			tableData += "<td>";
			tableData += "<a href='ProductDetails?productId=" + p.getProductid() + "'>"+p.getProductname() + "</a>";
			tableData += "</td>";
			tableData += "<td>";
			tableData +=  "$"+p.getPrice();
			tableData += "</td>";
			tableData += "</tr>";
		}
		System.out.println("user " + session.getAttribute("user"));
		request.setAttribute("tableData", tableData);
		getServletContext().getRequestDispatcher("/ProductList.jsp").forward(request, response);
	}

}
