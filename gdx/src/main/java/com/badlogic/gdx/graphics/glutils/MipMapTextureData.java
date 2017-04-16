package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.GdxRuntimeException;

/** This class will load each contained TextureData to the chosen mipmap level.
 *  All the mipmap levels must be defined and cannot be null. */
public class MipMapTextureData implements TextureData{
	TextureData[] mips;
	
	/** @param mipMapData must be != null and its length must be >= 1 */
	public MipMapTextureData(TextureData... mipMapData){
		mips = new TextureData[mipMapData.length];
		System.arraycopy(mipMapData, 0, mips, 0, mipMapData.length);
	}
	
	
	public TextureDataType getType () {
		return TextureDataType.Custom;
	}

	
	public boolean isPrepared () {
		return true;
	}

	
	public void prepare () {}

	
	public Pixmap consumePixmap () {
		throw new GdxRuntimeException("It's compressed, use the compressed method");
	}

	
	public boolean disposePixmap () {
		return false;
	}

	
	public void consumeCustomData (int target) {
		for(int i=0; i < mips.length; ++i){
			GLTexture.uploadImageData(target, mips[i], i);
		}
	}

	
	public int getWidth () {
		return mips[0].getWidth();
	}

	
	public int getHeight () {
		return mips[0].getHeight();
	}

	
	public Format getFormat () {
		return mips[0].getFormat();
	}

	
	public boolean useMipMaps () {
		return false;
	}

	
	public boolean isManaged () {
		return true;
	}
}