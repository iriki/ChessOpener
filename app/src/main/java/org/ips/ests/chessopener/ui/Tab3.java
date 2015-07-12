package org.ips.ests.chessopener.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.ips.ests.chessopener.R;
import org.ips.ests.chessopener.xml.OpeningsFromXml;

/**
 * Created by Edwin on 15/02/2015.
 */
public class Tab3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_3,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 100; i++) {
//            sb.append(" ipsis lorum " + i);
//        }
//
//        TextView tv = (TextView) getActivity().findViewById(R.id.textView3);
//        tv.setText(sb.toString());

        Button btnVideo = (Button) getActivity().findViewById(R.id.btnVideo);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=G0ctAe7bGzs")));
                Log.i("Video", "Video Playing....");

            }
        });

        ImageView iv = (ImageView) getActivity().findViewById(R.id.thumbVideo);
        Glide.with(this)
                .load("http://img.youtube.com/vi/G0ctAe7bGzs/0.jpg")
//                .asGif()
//                .placeholder(R.drawable.loading_spinner)
//                .crossFade()
                .into(iv);

//        try {
//            XmlUtils.parseXml(getActivity());
//        } catch (XPathExpressionException | IOException e) {
//            e.printStackTrace();
//        }

        OpeningsFromXml.createInitialList(getActivity());

    }
}
