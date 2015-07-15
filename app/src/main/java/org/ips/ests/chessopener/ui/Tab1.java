package org.ips.ests.chessopener.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ips.ests.chessopener.R;
import org.ips.ests.chessopener.Start;
import org.ips.ests.chessopener.model.Opening;

/**
 * A fragment representing (...)
 * This fragment is either contained in a {@link org.ips.ests.chessopener.biblioteca.BibliotecaActivity}
 * in two-pane mode (on tablets) or a {@link org.ips.ests.chessopener.biblioteca.BibliotecaActivity}
 * on handsets.
 */
public class Tab1 extends Fragment implements IUpdateableFragment {

    TextView tvDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_1, container, false);
        tvDescription = (TextView) v.findViewById(R.id.tv_description);
        if (savedInstanceState != null) {
            Bundle args = getArguments();
            Opening opening = (Opening) args.getSerializable(Opening.OPENING_TAG);
            System.out.println(opening.getDescription());
            tvDescription.setText(Html.fromHtml(opening.getDescription()));
        } else {
            System.out.println(Start.openings.get(0).getDescription());
            tvDescription.setText(Html.fromHtml(Start.openings.get(0).getDescription()));
        }
        return v;
    }

    public static Fragment newInstance(Opening opening) {
        Bundle args = new Bundle();
        args.putSerializable(Opening.OPENING_TAG, opening);
        Fragment tab1 = new Tab1();
        tab1.setArguments(args);

        return tab1;
    }

    @Override
    public void update(Opening opening) {

        System.out.println(opening.getDescription());

//        tvDescription.setText(Html.fromHtml(getString(R.string.nice_html)));
        tvDescription.setText(Html.fromHtml(opening.getDescription()));
        tvDescription.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
