package bolaoze.fgomes.com.bolaodoze.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpManager {

    public static String getData(String p_uri){
        BufferedReader reader = null;
        try {
            URL url = new URL(p_uri);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader((huc.getInputStream())));
            String line;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            return sb.toString();
        }catch (Exception p_e){
            p_e.printStackTrace();
            return null;
        }finally {
            if (reader != null)
            {
                try {
                    reader.close();
                }catch (IOException p_ioe){
                    p_ioe.printStackTrace();
                    return null;
                }
            }
        }
    }
}
