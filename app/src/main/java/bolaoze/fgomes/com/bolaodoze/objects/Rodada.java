package bolaoze.fgomes.com.bolaodoze.objects;

/**
 * Created by fernando.gomes on 23/04/2018.
 */

public class Rodada {

    private int idLogoTimeMan;
    private int idSiglaTimeMan;
    private int placarTimeMan;
    private int idLogoTimeVis;
    private int idSiglaTimeVis;
    private int placarTimeVis;

    public Rodada() {
    }

    public Rodada(int idLogoTimeMan, int idSiglaTimeMan, int placarTimeMan, int idLogoTimeVis, int idSiglaTimeVis, int placarTimeVis) {
        this.idLogoTimeMan = idLogoTimeMan;
        this.idSiglaTimeMan = idSiglaTimeMan;
        this.placarTimeMan = placarTimeMan;
        this.idLogoTimeVis = idLogoTimeVis;
        this.idSiglaTimeVis = idSiglaTimeVis;
        this.placarTimeVis = placarTimeVis;
    }

    @Override
    public String toString() {
        return "Rodada{" +
                "idLogoTimeMan=" + idLogoTimeMan +
                ", idSiglaTimeMan=" + idSiglaTimeMan +
                ", placarTimeMan=" + placarTimeMan +
                ", idLogoTimeVis=" + idLogoTimeVis +
                ", idSiglaTimeVis=" + idSiglaTimeVis +
                ", placarTimeVis=" + placarTimeVis +
                '}';
    }

    public int getIdLogoTimeMan() {
        return idLogoTimeMan;
    }

    public void setIdLogoTimeMan(int idLogoTimeMan) {
        this.idLogoTimeMan = idLogoTimeMan;
    }

    public int getIdSiglaTimeMan() {
        return idSiglaTimeMan;
    }

    public void setIdSiglaTimeMan(int idSiglaTimeMan) {
        this.idSiglaTimeMan = idSiglaTimeMan;
    }

    public int getPlacarTimeMan() {
        return placarTimeMan;
    }

    public void setPlacarTimeMan(int placarTimeMan) {
        this.placarTimeMan = placarTimeMan;
    }

    public int getIdLogoTimeVis() {
        return idLogoTimeVis;
    }

    public void setIdLogoTimeVis(int idLogoTimeVis) {
        this.idLogoTimeVis = idLogoTimeVis;
    }

    public int getIdSiglaTimeVis() {
        return idSiglaTimeVis;
    }

    public void setIdSiglaTimeVis(int idSiglaTimeVis) {
        this.idSiglaTimeVis = idSiglaTimeVis;
    }

    public int getPlacarTimeVis() {
        return placarTimeVis;
    }

    public void setPlacarTimeVis(int placarTimeVis) {
        this.placarTimeVis = placarTimeVis;
    }
}
