package tn.celestialsoftware.iwillcometotunisia;




        import android.app.Application;

        import com.parse.Parse;
        import com.parse.ParseACL;
        import com.parse.ParseUser;


public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this, "KhiXHjFywHmzvMadFVWAEnTz9lTdbrA4yDw8yWnr", "QDtdTFvzlwyEhVgfIyoNSVaZdJ0kkM0g2QJo2cPq");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }

}