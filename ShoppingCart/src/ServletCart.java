

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;

/**
 * Servlet implementation class ServletCart
 */
@WebServlet("/Cart")
public class ServletCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCart() {
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
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		HttpSession session = request.getSession();
		Product prodObj= (Product) session.getAttribute("product");
		
		String tableData ="";
		
		tableData += "<tr>";
		tableData += "<thead>";
		tableData += "<th>";
		tableData += "Product Name";
		tableData += "</th>";
		tableData += "<th>"; 
		tableData += "Price";
		tableData += "</th>";
		tableData += "<th>";
		tableData += "Quantity";
		tableData += "</th>";
		tableData += "<th>";
		tableData += "Total Price";
		tableData += "</th>";		
		tableData += "</thead>";
		tableData += "</tr>";
		
		tableData+="<tr>";
		tableData += "<td>";
		tableData += prodObj.getProductname();
		tableData += "</td>";
		tableData += "<td>";
		tableData += "$"+prodObj.getPrice();
		tableData += "</td>";
		tableData += "<td>";
		tableData += quantity;
		tableData += "</td>";
		tableData += "<td>";
		Double totalPrice = quantity * prodObj.getPrice().doubleValue();  
		tableData +=  "$"+(totalPrice);
		tableData += "</td>";
		tableData += "</tr>";	}

}
