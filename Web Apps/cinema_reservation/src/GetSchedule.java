
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utilities.DatabaseConnector;

/**
 * Servlet implementation class GetSchedule
 */
@WebServlet("/GetSchedule")
public class GetSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		DatabaseConnector dc = new DatabaseConnector();
		dc.init();
		HttpSession session = request.getSession(false);
		String dayString = request.getParameter("q");

		// out.println("<form name=\"mainForm\" action=\"ticket.jsp\" method=\"POST\">");
		try {
			out.println("<tr>");
			out.println("<th bgcolor=\"lightblue\">Time</th>");
			out.println("<th bgcolor=\"lightblue\">Title</th>");
			out.println("<th bgcolor=\"lightblue\">Genre</th>");
			out.println("<th bgcolor=\"lightblue\">Duration</th>");
			out.println("<td>Choose</td>");
			out.println("</tr>");
			ResultSet rs = dc.st
					.executeQuery("SELECT schedule.Day, schedule.Time, film.FilmTitle, "
							+ "film.Genre, film.Duration FROM schedule INNER JOIN "
							+ "film ON schedule.FilmID=film.filmID WHERE schedule.Day='"
							+ dayString + "'");
			int k = 0;
			while (rs.next()) {
				out.println("<tr id=\""+"row"+k+"\">");

				for (int i = 2; i <= 5; i++) {
					String id="cell"+k+i;
					
					out.println("<td id=\""+id+"\">");
					out.print(rs.getObject(i).toString().trim());
					out.println("</td>");
				}
				out.println("<td>");
				String arg="cell"+k+3;
				out.println("<input value=\"" + rs.getObject(2)
						+ "\" type=\"radio\" name=\"radiogroup1\" onchange=\'setTitle(\""+arg+"\")\'");
				out.println("/>");
				out.println("</td></tr>");
				k++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println(e.getMessage());
			out.println("<script >alert(\"error!!\")</script>");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
