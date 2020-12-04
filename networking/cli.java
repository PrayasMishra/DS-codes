import java.net.*;
import java.io.*;
public class cli
{
public static void main(String[] args) throws Exception
{
Socket e=null;
BufferedReader in=null;
String s=null;
try
{
e=new Socket(InetAddress.getLocalHost(),9999);
in=new BufferedReader(new InputStreamReader(e.getInputStream()));
}
catch(Exception e1){}
while((s=in.readLine())!=null)
{
System.out.println(s);
}
in.close();
e.close();
}
}
