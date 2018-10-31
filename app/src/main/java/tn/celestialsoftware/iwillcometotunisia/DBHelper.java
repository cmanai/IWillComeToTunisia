package tn.celestialsoftware.iwillcometotunisia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public static final String TABLE_NEWS = "news";

	// Nutrition
	public static final String TITLE_NEWS= "titre";
	public static final String GOLDEN_NEWS = "golden";
    public static final String SILVER_NEWS = "silver";
    public static final String DESC_NEWS = "description";
    public static final String LONG_NEWS = "longitude";
    public static final String LAT_NEWS = "latitude";



		


	private static final String CREATE_NEWS = "CREATE TABLE " + TABLE_NEWS
			+ " (" + TITLE_NEWS + " TEXT," + DESC_NEWS + " TEXT,"+ GOLDEN_NEWS + " TEXT,"+ SILVER_NEWS + " TEXT,"+ LONG_NEWS +" TEXT,"+ LAT_NEWS +" TEXT)";

	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Create Data Base
		db.execSQL(CREATE_NEWS);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int old, int newVersion) {

		// TODO Re-Create Data Base

		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NEWS);
		onCreate(db);
	}

}
