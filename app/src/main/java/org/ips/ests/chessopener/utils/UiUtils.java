package org.ips.ests.chessopener.utils;

import android.content.Context;
import android.widget.Toast;

public class UiUtils {

	public static void doToast(Context ctx, String msg) {
		Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
	}
}
