package org.ips.ests.chessopener;

import android.app.Application;

import org.ips.ests.chessopener.model.Opening;
import org.ips.ests.chessopener.xml.OpeningsFromXml;

import java.util.ArrayList;

/**
 * Created by hsousa on 12/07/15.
 */
public class Start extends Application {

    public static ArrayList<Opening> openings;

    @Override
    public void onCreate() {
        openings = OpeningsFromXml.createInitialList(this);

        super.onCreate();
    }
}
