

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import customTools.DBUtil;

/**
 * Servlet implementation class ServletProductDetails
 */
@WebServlet("/ProductDetails")
public class ServletProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProductDetails() {
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
		int prodId = Integer.parseInt(request.getParameter("productId"));
		Product prodObj = DBUtil.getSelectedProducts(prodId);
		HttpSession session = request.getSession();
		session.setAttribute("product", prodObj);
		String details = "";
		if(prodObj!=null){
			details ="<div class='panel-group col-sm-6 col-sm-offset-3'<div class='panel-primary panel' style=text-align:center>"+
					"<div class='panel-heading'>" + prodObj.getProductname() + "</div></div><div class='panel panel-default'>"
							+ "<div class='panel-body'>";
			details+= "<br><img src='" + prodObj.getPicturepath() + "' width ='200' height='200' style=align:center>";
			details += "<br><br><p><b> Description: </b>" ;
			details +=prodObj.getDescription() + "</p>";
			details += "<br><br><p><b>Price: 	$</b>" ;
			details +=prodObj.getPrice() + "</p></div</div>";
			
		}
		details += "<br><form action=Cart method='post'> <label>Quantity</label> <input type='number' name='quantity'></input><br><br>"
				+ " <input type='submit'class='btn pull-left btn-success btn-lg' value='Purchase'></input> "
				+ "<input type='submit'	class='btn pull-right btn-warning btn-lg' value='Cancel'></input></form>";
		System.out.println(details);
		request.setAttribute("details", details);
		getServletContext().getRequestDispatcher("/ProductDetails.jsp").forward(request, response);
	}

}
