
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Dajne Win
 */
public class API {

    private static final int timeOutInMillis = 10000;

    public static String requestToken() throws IOException {
        System.setProperty("jsse.enableSNIExtension", "false");
        URL url = new URL("https://python-dwin.rhcloud.com/requesttoken");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(timeOutInMillis);
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output = rd.readLine();
        rd.close();
        return output;
    }
    
    public static String register(String token, String publicKey, String number, int nonce) throws IOException
    {
        String data = "{\"token\":\"" + token + "\",\"publickey\":\"" + publicKey + "\",\"number\":\"" + number + "\",\"nonce\":\"" + nonce + "\"}";
        System.setProperty("jsse.enableSNIExtension", "false");
        URL url = new URL("https://python-dwin.rhcloud.com/register");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(timeOutInMillis);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output = rd.readLine();
        rd.close();
        return output;
    }
    
    public static String getPublicKey(String number) throws IOException
    {
        String data = "{\"number\":\"" + number + "\"}";
        System.setProperty("jsse.enableSNIExtension", "false");
        URL url = new URL("https://python-dwin.rhcloud.com/getkey");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(timeOutInMillis);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output = rd.readLine();
        rd.close();
        return output;
    }

}
