

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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("email");
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		List<Product> proList = DBUtil.getAllProducts();
		
		String tableData ="";
		
		tableData += "<tr>";
		tableData += "<thead>";
		tableData += "<th>";
		tableData += "Product ID";
		tableData += "</th>";
		tableData += "<th>"; 
		tableData += "Product Name";
		tableData += "</th>";
		tableData += "<th>";
		tableData += "Price";
		tableData += "</thead>";
		tableData += "</tr>";
		
		for(Product p : proList){
			System.out.println(p.getProductname());
			
			tableData += "<tr>";
			tableData += "<td>";
			tableData += p.getProductid();
			tableData += "</td>";
			tableData += "<td>";
			tableData += "<a href='ProductDetails?productId=" + p.getProductid() + "'>"+p.getProductname() + "</a>";
			tableData += "</td>";
			tableData += "<td>";
			tableData +=  "$"+p.getPrice();
			tableData += "</td>";
			tableData += "</tr>";
		}
		request.setAttribute("tableData", tableData);
		getServletContext().getRequestDispatcher("/ProductList.jsp").forward(request, response);
	}

}
