import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
public class w{
    private static String openFile(String filePath) {
    	ArrayList<String> list = new ArrayList<String>();
        int HttpResult; // ���������ص�״̬
        String ee = new String();
        try
        {
            URL url =new URL(filePath); // ����URL
            URLConnection urlconn = url.openConnection(); // ��ͼ���Ӳ�ȡ�÷���״̬��
            urlconn.connect();
            HttpURLConnection httpconn =(HttpURLConnection)urlconn;
            HttpResult = httpconn.getResponseCode();
            if(HttpResult != HttpURLConnection.HTTP_OK) {
                System.out.print("�޷����ӵ�");
            } else {
                int filesize = urlconn.getContentLength(); // ȡ���ݳ���
                InputStreamReader isReader = new InputStreamReader(urlconn.getInputStream(),"UTF-8");
                BufferedReader reader = new BufferedReader(isReader);
                StringBuffer buffer = new StringBuffer();
                String line; // ��������ÿ�ж�ȡ������
                line = reader.readLine(); // ��ȡ��һ��
                while (line != null) { // ��� line Ϊ��˵��������
                    buffer.append(line); // ��������������ӵ� buffer ��
                    list.add(line);
                    buffer.append(" "); // ��ӻ��з�
                    line = reader.readLine(); // ��ȡ��һ��
                }
                System.out.print(buffer.toString());
                ee = buffer.toString();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return  ee;
    }
    public static void main(String[] args){    System.out.print(w.openFile("https://raw.githubusercontent.com/Micoael/FightForFLS/master/encouragement.fight"));
    }
}
