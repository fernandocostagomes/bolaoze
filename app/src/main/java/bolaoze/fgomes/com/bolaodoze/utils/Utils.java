package bolaoze.fgomes.com.bolaodoze.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Classe com metodos diversos para o Autotrac Mobile Launcher.
 *
 * @author fernando.gomes
 *
 * */
public class Utils
{
    private Context m_c;
    public Utils(Context p_context) {
        this.m_c = p_context;
    }

    private boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager) m_c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if(ni != null && ni.isConnectedOrConnecting()){
            return true;
        }else return false;
    }



}
