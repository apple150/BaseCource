

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JpgUsers
 */
@WebServlet("/JpgUsers")
public class JpgUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final String nameFile = "C:\\JAVA\\TestServlet\\CountUsers.txt";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JpgUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		BufferedImage image  = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = image.createGraphics();
		graphics.setFont(new Font("Serif", Font.ITALIC, 56));
		graphics.setColor(Color.green);		
		int i=ReadItem(nameFile); i++;
		WriteNewItem(nameFile, i);
		graphics.drawString(i+"", 50, 65);		
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpeg", out);	
	}

    public int ReadItem(String nameFile) {
    	int ret=0;
    	File fl = new File(nameFile);
    	if (fl.exists()==true) {
			BufferedReader fr = null;
			try {
				fr = new BufferedReader(new FileReader(nameFile)); //Открываем файл
				try {
					String res = fr.readLine();
					if (res.length() > 0) res=res.trim();
					ret = Integer.parseInt(res);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    	} else {
    		System.out.println("Файл не найден");
    	}
		return ret;
    }	

	public void WriteNewItem(String nameFile, int i) {
		File fl = new File(nameFile);
		if (fl.exists() == false) {
			try {
				fl.createNewFile();
			} catch (IOException e) {
				System.out.println("Файл не создался "+nameFile);
			}
		}
		
		try {
			PrintWriter pw = new PrintWriter(fl); 
			pw.println(i);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: "+nameFile);
			return;
		}
	}    
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
