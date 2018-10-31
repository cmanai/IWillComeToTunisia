package tn.celestialsoftware.iwillcometotunisia;

import java.util.ArrayList;
import java.util.List;
import  tn.celestialsoftware.iwillcometotunisia.News;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class NewsBDD {

	private static final int VERSION_BDD = 4;
	private static final String NAME_BDD = "newz.db";

	private SQLiteDatabase bdd;

	private DBHelper dbHelper;

	public NewsBDD(Context context) {
		super();
		dbHelper = new DBHelper(context, NAME_BDD, null, VERSION_BDD);
	}

	public void open() {
		// TODO Open Data Base
		bdd = dbHelper.getWritableDatabase();
	}

	public void close() {
		// TODO Close Data Base
		dbHelper.close();
	}

	public SQLiteDatabase getBDD() {
		return bdd;
	}

	public long insertTop(News tps) {

		// TODO Add Article to data base
		ContentValues values = new ContentValues();

		values.put(DBHelper.TITLE_NEWS, tps.getTitle());
		values.put(DBHelper.DESC_NEWS, tps.getDesc());
        values.put(DBHelper.GOLDEN_NEWS, tps.getPrice1());

        values.put(DBHelper.SILVER_NEWS, tps.getPrice2());

        values.put(DBHelper.LONG_NEWS, tps.getA());
        values.put(DBHelper.LAT_NEWS, tps.getB());
		bdd.insert(DBHelper.TABLE_NEWS, null, values);

		return 0;
	}

	public int removeAllArticles() { // TODO Remove all Table
		bdd.execSQL("DELETE FROM " + DBHelper.TABLE_NEWS);
		return 0;
	}

	public List<News> selectAll() {
		List<News> list = new ArrayList<News>();
		// TODO Get list of Article
		Cursor cursor = bdd.query(DBHelper.TABLE_NEWS, new String[] {

		DBHelper.TITLE_NEWS, DBHelper.DESC_NEWS,DBHelper.GOLDEN_NEWS,DBHelper.SILVER_NEWS,DBHelper.LONG_NEWS,DBHelper.LAT_NEWS }, null,
				null, null, null, null);

		if (cursor.moveToFirst()) {
			do {
				News p = new News(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4),cursor.getString(5)

                        );
				list.add(p);
			} while (cursor.moveToNext());
		}
		return list;
	}
}
