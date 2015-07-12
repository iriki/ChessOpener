package org.ips.ests.chessopener.xml;

import android.content.Context;

import org.ips.ests.chessopener.model.Opening;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hsousa on 12/07/15.
 */
public class OpeningsFromXml {

    // XML node keys
    static final String KEY_ITEM = "item"; // parent node
    static final String KEY_ID = "id"; // parent node
    static final String KEY_NAME = "name";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_YOUTUBEID = "youtubeId";
    static final String KEY_HISTORY = "history";
    static final String KEY_IMAGEURL = "imageUrl";

    public static ArrayList<Opening> createInitialList(Context context) {
        ArrayList<Opening> openings = new ArrayList<>();

        String xml = XmlUtils.readFileFromAssets(context); // ler XML dos assets
        Document doc = XmlUtils.getDomElement(xml); // capturar elemento DOM
        NodeList nl = doc.getElementsByTagName(KEY_ITEM);

        // looping through all item nodes <item>
        for (int i = 0; i < nl.getLength(); i++) {
            Element e = (Element) nl.item(i);

            String name = XmlUtils.getValue(e, KEY_NAME); // name child value
            String description = XmlUtils.getValue(e, KEY_DESCRIPTION); // cost child value
            String youtubeId = XmlUtils.getValue(e, KEY_YOUTUBEID); // cost child value
            String history = XmlUtils.getValue(e, KEY_HISTORY); // description child value
            String imageUrl = XmlUtils.getValue(e, KEY_IMAGEURL); // description child value
            int id = Integer.valueOf(XmlUtils.getValue(e, KEY_ID)); // description child value

            Opening opening = new Opening(id, name, description, youtubeId, history, imageUrl);
            openings.add(opening);
        }

        return openings;
    }


    public static CharSequence[] getNamesFromList(List<Opening> openings) {
        CharSequence[] names = new CharSequence[openings.size()];

        int i = 0;
        for (Iterator<Opening> it = openings.iterator(); it.hasNext(); i++) {
            Opening s = it.next();
            names[i] = s.getName();
        }

        return names;
    }

}
