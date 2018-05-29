package bolaoze.fgomes.com.bolaodoze.objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ClubesJSONParcer {
    public static List<Clubes> ParseClubes(String content) {
        try {
            JSONArray jsonArray = new JSONArray(content);
            List<Clubes> clubesList = new ArrayList<>();

            for (int i = 0; i< jsonArray.length(); i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Clubes clubes = new Clubes();

                clubes.setId(jsonObject.getInt("id"));
                clubes.setNome(jsonObject.getString("nome"));
                clubes.setAbreviacao(jsonObject.getString("abreviacao"));
                clubes.setEscudos(jsonObject.getString("escudos"));

                clubesList.add(clubes);
            }
            return clubesList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
