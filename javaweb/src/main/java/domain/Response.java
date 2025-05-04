package domain;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @className: response
 * @author: wenzhuo4657
 * @date: 2024/3/24 11:26
 * @Version: 1.0
 * @description:
 */
public class Response {
    public static void dad(HttpServletResponse resp, String msg) throws IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8'>");
        printWriter.println("<title>dad</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>" + msg + "</h1>");
        printWriter.println("</body>");
        printWriter.println("</html>");


    }

    public static void success(HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8'>");
        printWriter.println("<title>success</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>success!!</h1>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}