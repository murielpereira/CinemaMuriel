package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.cinema.R;

import Filme.Filme;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cinema";
    private static final String TABLE_FILME = "filme";

    private static final String CREATE_TABLE_FILME = "CREATE TABLE" + TABLE_FILME + "(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "nome VARCHAR(50)," +
            "genero VARCHAR(50)," +
            "duracao INTEGER(3)," +
            "descricao VARCHAR(100)," +
            "cidade VARCHAR(30));";

    private static final String DROP_TABLE_FILME = "DROP TABLE IF EXISTS" + TABLE_FILME;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FILME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_FILME);
        onCreate(db);
    }

    /*Início CRUD Filme*/

    public long createFilme(Filme f){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", f.getNome());
        cv.put("genero",f.getGenero());
        cv.put("duracao",f.getDuracao());
        cv.put("descricao",f.getDescricao());
        cv.put("cidade",f.getCidade());
        long id = db.insert(TABLE_FILME, null, cv);
        db.close();
        return  id;
    }

    public long updateFilme(Filme f){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", f.getNome());
        cv.put("genero",f.getGenero());
        cv.put("duracao",f.getDuracao());
        cv.put("descricao",f.getDescricao());
        cv.put("cidade",f.getCidade());
        long id = db.update(TABLE_FILME, cv, "_id = ?", new String[]{String.valueOf(f.getId())});
        db.close();
        return  id;
    }

    public long deleteFilme(Filme f){
        SQLiteDatabase db = this.getWritableDatabase();
        long id = db.delete(TABLE_FILME,"_id = ?", new String[]{String.valueOf(f.getId())});
        db.close();
        return  id;
    }

    public void getAllFilme (Context context, ListView lv){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "nome", "genero"};
        Cursor data = db.query(TABLE_FILME, columns, null, null, null, null, "nome");
        int[] to = {R.id.textViewIdListarFilme, R.id.textViewNomeListarFilme, R.id.textViewGeneroListarFilme};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(context, R.layout.filme_item_listview, data, columns, to, 0);
        lv.setAdapter(simpleCursorAdapter);
        db.close();
    }

    public Filme getByIdFilme (int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "nome", "genero", "cidade"};
        String[] args = {String.valueOf(id)};
        Cursor data = db.query(TABLE_FILME, columns, "_id = ?", args, null, null, null);
        data.moveToFirst();
        Filme f = new Filme();
        f.setId(data.getInt(0));
        f.setNome(data.getString(1));
        f.setGenero(data.getString(2));
        f.setCidade(data.getString(3));
        data.close();
        db.close();
        return f;
    }

    /*Fim CRUD Filme*/
}
