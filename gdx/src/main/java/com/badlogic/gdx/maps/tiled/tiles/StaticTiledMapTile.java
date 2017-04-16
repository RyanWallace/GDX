/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.maps.tiled.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;

/** @brief Represents a non changing {@link TiledMapTile} (can be cached) */
public class StaticTiledMapTile implements TiledMapTile {

	private int id;

	private BlendMode blendMode = BlendMode.ALPHA;

	private MapProperties properties;

	private TextureRegion textureRegion;

	private float offsetX;

	private float offsetY;

	
	public int getId () {
		return id;
	}

	
	public void setId (int id) {
		this.id = id;
	}

	
	public BlendMode getBlendMode () {
		return blendMode;
	}

	
	public void setBlendMode (BlendMode blendMode) {
		this.blendMode = blendMode;
	}

	
	public MapProperties getProperties () {
		if (properties == null) {
			properties = new MapProperties();
		}
		return properties;
	}

	
	public TextureRegion getTextureRegion () {
		return textureRegion;
	}

	
	public void setTextureRegion(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
	}

	
	public float getOffsetX () {
		return offsetX;
	}

	
	public void setOffsetX (float offsetX) {
		this.offsetX = offsetX;
	}

	
	public float getOffsetY () {
		return offsetY;
	}

	
	public void setOffsetY (float offsetY) {
		this.offsetY = offsetY;
	}

	/** Creates a static tile with the given region
	 * 
	 * @param textureRegion the {@link TextureRegion} to use. */
	public StaticTiledMapTile (TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
	}

	/** Copy constructor
	 * 
	 * @param copy the StaticTiledMapTile to copy. */
	public StaticTiledMapTile (StaticTiledMapTile copy) {
		if (copy.properties != null) {
			getProperties().putAll(copy.properties);
		}
		this.textureRegion = copy.textureRegion;
		this.id = copy.id;
	}

}
