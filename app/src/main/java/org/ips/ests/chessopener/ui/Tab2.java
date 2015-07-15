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
public class Tab2 extends Fragment implements IUpdateableFragment {

    TextView tvHistory;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2, container, false);
        tvHistory = (TextView) v.findViewById(R.id.tv_history);
        if (savedInstanceState != null) {
            Bundle args = getArguments();
            Opening opening = (Opening) args.getSerializable(Opening.OPENING_TAG);
            System.out.println(opening.getHistory());
            tvHistory.setText(Html.fromHtml(opening.getHistory()));
        } else {
            System.out.println(Start.openings.get(0).getHistory());
            tvHistory.setText(Html.fromHtml(Start.openings.get(0).getHistory()));
        }
        return v;
    }

    public static Fragment newInstance(Opening opening) {
        Bundle args = new Bundle();
        args.putSerializable(Opening.OPENING_TAG, opening);
        Fragment tab2 = new Tab2();
        tab2.setArguments(args);

        return tab2;
    }

    @Override
    public void update(Opening opening) {

        System.out.println(opening.getHistory());

//        tvDescription.setText(Html.fromHtml(getString(R.string.nice_html)));
        tvHistory.setText(Html.fromHtml(opening.getHistory()));
        tvHistory.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
