package org.ips.ests.chessopener.library;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.Locale;

import org.ips.ests.chessopener.R;

/**
 * A fragment representing a single Planeta detail screen.
 * This fragment is either contained in a {@link PlanetaListActivity}
 * in two-pane mode (on tablets) or a {@link PlanetaDetailActivity}
 * on handsets.
 */
public class AberturaDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy nome this fragment is presenting.
     */
    private Abertura.AberturaItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AberturaDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy nome specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load nome from a nome provider.
            mItem = Abertura.ABERTURAS_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_abertura_detail, container, false);

        // Show the dummy nome as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.abertura_detail)).setText(mItem.nome);

            try {
                ((ImageView) rootView.findViewById(R.id.abertura_image)).setImageDrawable(
                        Drawable.createFromStream(getActivity().getAssets().open(mItem.nome.toLowerCase(Locale.getDefault()) + ".png"), null));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return rootView;
    }
}