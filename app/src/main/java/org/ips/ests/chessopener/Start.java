package org.ips.ests.chessopener;

import android.app.Application;

import org.ips.ests.chessopener.model.Opening;
import org.ips.ests.chessopener.xml.OpeningsFromXml;

import java.util.ArrayList;

/**
 * Ponto de entrada inicial da aplicação.
 * Created by hsousa on 12/07/15.
 */
public class Start extends Application {

    public static ArrayList<Opening> openings;

    @Override
    public void onCreate() {
        //openings = OpeningsFromXml.createInitialList(this);


        openings = populateFromArray();


        super.onCreate();
    }

    private ArrayList<Opening> populateFromArray() {
        ArrayList<Opening> openings = new ArrayList<>();

        String[] description = getResources().getStringArray(R.array.openings_description);
        String[] histories = getResources().getStringArray(R.array.openings_history);
        String[] names = getResources().getStringArray(R.array.openings_names);

        if(description.length != histories.length && histories.length != names.length && description.length != names.length) {
            throw new RuntimeException("arrays lenght dont match");
        }

        for (int i = 0; i < histories.length; i++) {
            openings.add(new Opening(i, names[i], description[i], "you", histories[i], "url" ));
        }


        return openings;
    }
}

