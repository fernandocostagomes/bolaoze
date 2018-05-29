package bolaoze.fgomes.com.bolaodoze.utils;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import bolaoze.fgomes.com.bolaodoze.objects.Clubes;

public class DbHelper extends SQLiteOpenHelper
{
    /**
     * Constante com o nome do banco de Dados.
     */
    private static final String DATABASE_NAME = "bolaodoze";

    /**
     * Constante com a versao do Banco de Dados.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Array de string com as querys para criar as tabelas do banco de dados.
     */
    private static final String[] SCRIPT_DATABASE_CREATE = new String[] {
            "CREATE TABLE Clubes (id INTEGER NOT NULL, nome VARCHAR(30) NOT NULL, abreviacao VARCHAR(10) NOT NULL, , escudos VARCHAR(100) NOT NULL);",
    };

    /**
     * Construtor padrao que recebe um contexto.
     *
     * @param p_context
     */
    public DbHelper( Context p_context )
    {
        super( p_context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    /**
     * Metodo onCreate para criar as tabelas no banco de dados.
     */
    @Override
    public void onCreate( SQLiteDatabase p_db )
    {
        String SqlCreateTableClubes = "CREATE TABLE Clubes (id INTEGER NOT NULL, nome VARCHAR(30) NOT NULL, abreviacao VARCHAR(10) NOT NULL, escudos VARCHAR(100) NOT NULL);";
        String SqlCreateTablePartidas = "CREATE TABLE Partidas (" +
                "partida_id INTEGER NOT NULL," +
                "clube_casa_id INTEGER NOT NULL," +
                "clube_casa_posicao INTEGER NOT NULL," +
                "clube_visitante_id INTEGER NOT NULL," +
                " aproveitamento_mandante VARCHAR(100) NOT NULL," +
                " aproveitamento_visitante VARCHAR(100) NOT NULL," +
                "clube_visitante_posicao INTEGER NOT NULL," +
                " partida_data VARCHAR(30) NOT NULL," +
                " local VARCHAR(30) NOT NULL," +
                " valida BOOLEAN NOT NULL," +
                "placar_oficial_mandante; INTEGER NOT NULL," +
                "placar_oficial_visitante; INTEGER NOT NULL," +
                " url_confronto; VARCHAR(30) NOT NULL," +
                " url_transmissao; VARCHAR(100) NOT NULL);";
        p_db.execSQL( SqlCreateTableClubes );
    }

    /**
     * Metodo que atualiza o banco de dados.
     */
    @Override
    public void onUpgrade( SQLiteDatabase p_db, int p_oldVersion, int p_newVersion ){
        String SqlDropTabelaClubes = "DROP TABLE Clubes";
        p_db.execSQL( SqlDropTabelaClubes );
    }

    /**
     * Metodo que insere no banco os nomes dos clubes.
     *
     * @param p_clubes Clubes.
     */
    public void insertClubes(Clubes p_clubes )
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put( "id", p_clubes.getId());
        cv.put( "nome", p_clubes.getNome().toString() );
        cv.put( "abreviacao", p_clubes.getAbreviacao().toString() );
        cv.put( "escudos", p_clubes.getEscudos().toString());

        db.insert( "Clubes", null, cv );

        db.close();
    }

    /*
     * Metodo que inseri no banco o parametro inexistente.
     */
    public boolean insertParameter( int p_parameter, String p_parameterValue )
    {
        boolean result = false;

        SQLiteDatabase db = getWritableDatabase();

        try
        {
            ContentValues cv = new ContentValues();
            cv.put( "PAR_NUM_Number", p_parameter );
            cv.put( "PAR_TXT_Value", p_parameterValue );
            cv.put( "PAR_TXT_OldValue", "0" );

            db.insert( "Parameter_PAR", null, cv );

            db.close();

            result = true;
        }
        catch ( Exception p_e )
        {
            p_e.printStackTrace();
        }

        return result;
    }

    /**
     * Metodo que seleciona um clube pelo "name" pesquisado.
     *
     * @param p_nameClube a ser pesquisado.
     *
     * @return resultado com o name pesquisado.
     */
    public String selectClubeName( String p_nameClube )
    {
        String nameClube = "";

        SQLiteDatabase db = getReadableDatabase();

        String SqlSelectClube = "SELECT * FROM Clube WHERE nome = '"
                + nameClube + "';";

        Cursor c = db.rawQuery( SqlSelectClube, null );

        if ( c.moveToFirst() )
        {
            nameClube = c.getString( 0 );
        }
        else
        {
            nameClube = "no";
        }
        c.close();

        return nameClube;
    }

    /*
     * Metodo que lista os clubes.
     *
     * @return listClubes retorna a lista de clubes.
     */
    public List<Clubes> selectAllClubes() {
        List<Clubes> listClubes = new ArrayList<Clubes>();
        SQLiteDatabase db = getReadableDatabase();
        String SqlSelectClube = "SELECT * FROM Clubes";
        Cursor c = db.rawQuery( SqlSelectClube, null );
        if ( c.moveToFirst() ){
            do{
                Clubes clubes = new Clubes();
                clubes.setId( c.getInt( 0 ) );
                clubes.setNome(c.getString( 1 ) );
                clubes.setAbreviacao(c.getString( 2 ) );
                clubes.setAbreviacao( c.getString( 3 ) );
                listClubes.add( clubes );
            } while ( c.moveToNext() );
        }
        db.close();
        return listClubes;
    }

    /**
     * Metodo que altera a permissao dos Apps.
     *
     * @param p_name Nome do App.
     *
     * @param p_permission Novo valor de permissao - 0 / 1.
     */
    public void updatePartidas( String p_name, String p_permission )
    {
        try {
            SQLiteDatabase db = getWritableDatabase();
            String SqlUpdatePermissionAppInfo = "UPDATE AppInfo_APP set APP_TXT_Permission = '" + p_permission
                    + "' WHERE APP_TXT_Name = '"
                    + p_name + "';";
            db.execSQL( SqlUpdatePermissionAppInfo );
            db.close();
        }
        catch (Exception p_e)
        {
            p_e.printStackTrace();
        }
    }

    /**
     * Metodo que altera o status do App para desativado ou ativado.
     *
     * @param p_pkg Pacote do App.
     *
     * @param p_status Novo valor de status.
     */
    public boolean updateStatusAppInfo( String p_pkg, String p_status )
    {
        boolean result = false;
        try {
            SQLiteDatabase db = getWritableDatabase();
            String SqlUpdateStatusAppInfo = "UPDATE AppInfo_APP set APP_TXT_Status = '" + p_status
                    + "' WHERE APP_TXT_Name = '"
                    + p_pkg + "';";
            db.execSQL(SqlUpdateStatusAppInfo);
            db.close();
            result = true;
        }
        catch (Exception p_e)
        {
            p_e.printStackTrace();
        }
        return result;
    }

    /**
     * Metodo que altera a permissao de todos os Apps de uma so vez.
     *
     * @param p_valuePermission valor para qual quer alterar 0;1;
     *
     * @return resultUpdateAllPermissionApp booleando para caso true: sucesso ou false: erro.
     */
    public boolean updateAllAppPermission( String p_valuePermission )
    {
        boolean resultUpdateAllPermissionApp = false;
        SQLiteDatabase db = getWritableDatabase();

        try
        {
            String SqlUpdateAllPermissionApp = "UPDATE AppInfo_APP set APP_TXT_Permission = '" + p_valuePermission + "';";

            db.execSQL( SqlUpdateAllPermissionApp );

            db.close();
            resultUpdateAllPermissionApp = true;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        return resultUpdateAllPermissionApp;
    }



    /**
     * Metodo que faz uma limpeza nas tabelas do banco de dados.
     *
     * @return true / false.
     */
    public boolean dropDB()
    {
        boolean confirmDeleteTable = false;
        try
        {
            SQLiteDatabase db = getWritableDatabase();

            String SqlDropDbClube = "DELETE FROM Clubes";
            String SqlDropDbPartidas = "DELETE FROM Partidas";

            db.execSQL( SqlDropDbClube );
            db.execSQL( SqlDropDbPartidas );

            db.close();
            confirmDeleteTable = true;
        }
        catch ( Exception p_e )
        {
            p_e.printStackTrace();
        }
        return confirmDeleteTable;
    }
}
