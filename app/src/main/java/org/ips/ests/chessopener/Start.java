package org.ips.ests.chessopener;

import android.app.Application;

import org.ips.ests.chessopener.model.Opening;
import org.ips.ests.chessopener.utils.OpeningUtils;

import java.util.ArrayList;

/**
 * Ponto de entrada inicial da aplicação.
 * Created by hsousa on 12/07/15.
 */
public class Start extends Application {

    public static ArrayList<Opening> openings;

    @Override
    public void onCreate() {

        openings = OpeningUtils.populateFromArray(this);

        super.onCreate();
    }


}

