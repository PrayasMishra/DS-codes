import java.net.*;
import java.io.*;

public class ser{
	public static void main(String[] args) throws Exception {
		ServerSocket ss=null;
		try {
			ss=new ServerSocket(9999);
		}
		catch(IOException e){

		}
		Socket c=null;
		try{
			c=ss.accept();
			System.out.println("connected to client"+c);
		}
		catch(Exception e){

		}
		PrintWriter out=new PrintWriter(c.getOutputStream(),true);
		String inline,outputline;
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter file name");
		String s=stdin.readLine();
		File f=new File(s);
		if(f.exists())
		{
			BufferedReader d=new BufferedReader(new FileReader(s));
			String line;
			while((line=d.readLine())!=null) {
				out.write(line);
				out.flush();
			}
		d.close();
		c.close();
		ss.close();
		}
	}
}
