package org.ips.ests.chessopener.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ChessImageView extends View {

	public static Bitmap[][] _arrPieceBitmaps = new Bitmap[2][6];
	public static Bitmap _bmpBorder, _bmpSelect, _bmpSelectLight;
	public static Bitmap _bmpTile;
	
	//public static SVG _svgTest = null;
	
	// 5 colorschemes with 2 colors each
	public static int[][] _arrColorScheme = new int[6][3];
	public static int _colorScheme = 0;
	//public static Bitmap _bmpBorder, _bmpSelect;
	//public static Bitmap[] _arrFieldBitmaps = new Bitmap[2];
	public static Paint _paint = new Paint();
	public static Matrix _matrix = null;
	public static Matrix _matrixTile = null;
	
	static {
		_paint.setFlags(Paint.ANTI_ALIAS_FLAG);
		_paint.setFilterBitmap(true);
	}
	
	private ImageCacheObject _ico;
	
	public ChessImageView(Context context) {
		super(context);
		setFocusable(true);
	}
	public ChessImageView(Context context, AttributeSet atts) {
		super(context, atts);
		setFocusable(true);
	}
	
	public void init(){
		
	}
	
	public void setICO(ImageCacheObject ico){

        if (ico == null) {
            System.out.println();
        }


		_ico = ico;
	}
	public ImageCacheObject getICO(){
		return _ico;
	}
	
    public void onDraw(Canvas canvas) {
        
    	if(_arrColorScheme[0][0] == 0){
    		return;
    	}
    	
    	if(_matrix == null){
			ChessImageView._matrix = new Matrix();
		
			float scale = 1.0F;
			Bitmap bmp = ChessImageView._arrPieceBitmaps[BoardConstants.WHITE][BoardConstants.PAWN]; // any dynamic
			
			scale = (float)getWidth() / bmp.getWidth();
			Log.i("paintBoard", "init " + scale + " : " + bmp.getWidth() + ", " + getWidth());
			
			ChessImageView._matrix.setScale(scale, scale);
			
			if(ChessImageView._bmpTile != null){
				ChessImageView._matrixTile = new Matrix();
				bmp = ChessImageView._bmpTile;
				scale = (float)getWidth() / bmp.getWidth();
				ChessImageView._matrixTile.setScale(scale, scale);
			}
		}
    	
    	Bitmap bmp;
        ImageCacheObject ico = _ico;
        
        // first draw field background
        if(ico == null) {
            Log.e("err", "err");

            return;
        }

        //_paint.setColor(Color.TRANSPARENT);
        if(hasFocus()){
        	_paint.setColor(0xffff9900);
        	canvas.drawRect(new Rect(0, 0, getWidth(), getHeight()), _paint);
        } else {
            _paint.setColor(ico._fieldColor == 0 ? _arrColorScheme[_colorScheme][0] : _arrColorScheme[_colorScheme][1]);

        	canvas.drawRect(new Rect(0, 0, getWidth(), getHeight()), _paint);
        	if(ico != null && ico._selected){
        		_paint.setColor(_arrColorScheme[_colorScheme][2]);
        		canvas.drawRect(new Rect(0, 0, getWidth(), getHeight()), _paint);
        	}
        }
        
        if(ChessImageView._bmpTile != null){
        	canvas.drawBitmap(_bmpTile, _matrixTile, _paint);
        }

        
        //_paint.setColor(Color.BLACK);
        /*
        if(ico._selected || hasFocus()){
        	canvas.drawBitmap(_bmpBorder, _matrix, _paint);
        }
        */
        
        if(ico._selectedPos){
        	//if(ico._fieldColor == 0){ 
        	//	canvas.drawBitmap(_bmpSelect, _matrix, _paint);
        	//} else {
        		canvas.drawBitmap(_bmpSelectLight, _matrix, _paint);
        	//}
       	}
        
        if(ico._bPiece){

	        bmp = _arrPieceBitmaps[ico._color][ico._piece];
	        
	        canvas.drawBitmap(bmp, _matrix, _paint);
	        
	        //Picture picture = _svgTest.getPicture();
	        //canvas.drawPicture(picture);
	        
	        //canvas.save();
	        //picture.draw(canvas);
	        //canvas.restore();
	        //canvas.scale(2.0f, 2.0f);
	        //canvas.save();
	        
	        
	    }
        //////////////////////////////////////
        if(ico._coord != null){
        	_paint.setColor(0x99ffffff);
        	//if(ImageCacheObject._flippedBoard){
        	//	canvas.drawRect(getWidth() - 14, getHeight() - 14, getWidth(), getHeight(), _paint);
        	//} else {
        		canvas.drawRect(0, getHeight() - 14,  _paint.measureText(ico._coord) + 4, getHeight(), _paint);
        	//}
        	_paint.setColor(Color.BLACK);
        	
        	_paint.setTextSize(getHeight() > 50 ? (int)(getHeight()/5) : 10);
        	//if(ImageCacheObject._flippedBoard){
        	//	canvas.drawText(ico._coord, getWidth() - 12, getHeight() - 2, _paint);
        	//} else {
        		canvas.drawText(ico._coord, 2, getHeight() - 2, _paint);
        	//}
        }
        //////////////////////////////////////
    }
    
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect){
    	//Log.i("ChessImageView", "onFocusChanged");
    	super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

}