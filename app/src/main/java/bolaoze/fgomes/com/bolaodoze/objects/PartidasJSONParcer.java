package bolaoze.fgomes.com.bolaodoze.objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PartidasJSONParcer {
        public static List<Partidas> parseDados(String content) {
            try {
                JSONArray jsonArray = new JSONArray(content);
                List<Partidas> partidasList = new ArrayList<>();

                for (int i = 0; i< jsonArray.length(); i++){

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Partidas partidas = new Partidas();

                    partidas.setPartida_id(jsonObject.getInt("partida_id"));
                    partidas.setClube_casa_id(jsonObject.getInt("clube_casa_id"));
                    partidas.setClube_casa_id(jsonObject.getInt("clube_casa_posicao"));
                    partidas.setClube_casa_id(jsonObject.getInt("clube_visitante_id"));
                    partidas.setAproveitamento_mandante(jsonObject.getString("aproveitamento_mandante"));
                    partidas.setAproveitamento_visitante(jsonObject.getString("aproveitamento_visitante"));
                    partidas.setClube_visitante_posicao(jsonObject.getInt("clube_visitante_posicao"));
                    partidas.setPartida_data(jsonObject.getString("partida_data"));
                    partidas.setLocal(jsonObject.getString("local"));
                    partidas.setValida(jsonObject.getBoolean("valida"));
                    partidas.setPlacar_oficial_mandante(jsonObject.getInt("placar_oficial_mandante"));
                    partidas.setPlacar_oficial_visitante(jsonObject.getInt("placar_oficial_visitante"));
                    partidas.setUrl_confronto(jsonObject.getString("url_confronto"));
                    partidas.setUrl_transmissao(jsonObject.getString("url_transmissao"));
                    partidasList.add(partidas);
                }
                return partidasList;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
}
