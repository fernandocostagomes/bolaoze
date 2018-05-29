package bolaoze.fgomes.com.bolaodoze.activities;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bolaoze.fgomes.com.bolaodoze.R;
import bolaoze.fgomes.com.bolaodoze.objects.Rodada;
import bolaoze.fgomes.com.bolaodoze.utils.Utils;

public class MainActivity extends AppCompatActivity {
    private Utils m_u = new Utils(this);
    private SharedPreferences m_sp;
    private GridView m_gv;
    private List<Rodada> m_lr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_sp = PreferenceManager.getDefaultSharedPreferences(this);

        checkFirstTime();

    }

    /**
     * Metodo que verifica se eh o primeiro acesso ao app.    *
     */
    private void checkFirstTime() {
        //Primeiro acesso.
        if (m_sp.getBoolean("first_time", false)) {
            //Baixar times, escudos e rodadas anteriores.
        }
        loadClubes();
        loadRodada();
        loadGridView();
    }

    private void loadClubes(){

    }

    private void loadRodada()
    {
        m_lr = new ArrayList<>();
        Rodada rodada = new Rodada();

        rodada.setIdLogoTimeMan(1);
        rodada.setIdLogoTimeVis(2);

        rodada.setIdSiglaTimeMan(1);
        rodada.setIdSiglaTimeVis(2);

        rodada.setPlacarTimeMan(2);
        rodada.setPlacarTimeVis(0);
        m_lr.add(rodada);

        Rodada rodada2 = new Rodada();

        rodada2.setIdLogoTimeMan(1);
        rodada2.setIdLogoTimeVis(2);

        rodada2.setIdSiglaTimeMan(1);
        rodada2.setIdSiglaTimeVis(2);

        rodada2.setPlacarTimeMan(2);
        rodada2.setPlacarTimeVis(0);

        m_lr.add(rodada2);
    }

    private void loadGridView() {
        m_gv = findViewById(R.id.gvRodada);

        ArrayAdapter<Rodada> adapter = new ArrayAdapter<Rodada>(this, R.layout.activity_main_itens,
                m_lr) {
            @Override
            public View getView(int p_position, View p_convertView, ViewGroup p_parent) {
                // Use view holder patern to better performance with list view.
                ViewHolderItem viewHolder = null;

                if (p_convertView == null) {
                    p_convertView = getLayoutInflater().inflate(R.layout.activity_main_itens, p_parent,
                            false);
                    viewHolder = new ViewHolderItem();

                    viewHolder.iconTimeMan = (ImageView) p_convertView.findViewById(R.id.ivTimeMan);
                    viewHolder.tvSiglaTimeMan = (TextView) p_convertView.findViewById(R.id.tvSigTimeMan);
                    viewHolder.tvPlacarTimeMan = (TextView) p_convertView.findViewById(R.id.tvPlTimeMan);

                    viewHolder.iconTimeVis = (ImageView) p_convertView.findViewById(R.id.ivTimeVis);
                    viewHolder.tvSiglaTimeVis = (TextView) p_convertView.findViewById(R.id.tvSigTimeVis);
                    viewHolder.tvPlacarTimeVis = (TextView) p_convertView.findViewById(R.id.tvPlTimeVis);

                    // store holder with view.
                    p_convertView.setTag(viewHolder);
                }
                // get saved holder
                else {
                    viewHolder = (ViewHolderItem) p_convertView.getTag();
                }

                Rodada rodada = m_lr.get(p_position);
                // Display appInfo
                if (rodada != null) {
                    viewHolder.iconTimeMan.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                    viewHolder.iconTimeVis.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));

                    viewHolder.tvSiglaTimeMan.setText("FLA");
                    viewHolder.tvSiglaTimeVis.setText("PAL");

                    viewHolder.tvPlacarTimeMan.setText("2");
                    viewHolder.tvPlacarTimeVis.setText("1");

                    viewHolder.iconTimeMan.setMinimumHeight(15);
                    viewHolder.iconTimeMan.setMinimumWidth(15);
                    viewHolder.iconTimeMan.setMaxHeight(15);
                    viewHolder.iconTimeMan.setMaxWidth(15);

                    viewHolder.iconTimeVis.setMinimumHeight(15);
                    viewHolder.iconTimeVis.setMinimumWidth(15);
                    viewHolder.iconTimeVis.setMaxHeight(15);
                    viewHolder.iconTimeVis.setMaxWidth(15);
                }
                return p_convertView;
            }

            final class ViewHolderItem {
                ImageView iconTimeMan;
                ImageView iconTimeVis;
                TextView tvSiglaTimeMan;
                TextView tvPlacarTimeMan;
                TextView tvPlacarTimeVis;
                TextView tvSiglaTimeVis;
            }
        };
        m_gv.setAdapter(adapter);
    }
}
