package org.millenaire.client.texture;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureUtil;

import org.millenaire.common.Point;

public class TextureAmuletYddrasil extends TextureAtlasSprite {

	public TextureAmuletYddrasil(final String iconName) {
		super(iconName);
	}

	private int getScore(final Minecraft mc) {
		int level = 0;

		if (mc.theWorld != null && mc.thePlayer != null) {
			final Point p = new Point(mc.thePlayer);

			level = (int) Math.floor(p.getiY());
		}

		if (level > 127) {
			level = 127;
		}

		level = level / 8;

		return level;

	}

	@Override
	public void updateAnimation() {

		int iconPos = getScore(Minecraft.getMinecraft());

		if (iconPos > 15) {
			iconPos = 15;
		}
		if (iconPos < 0) {
			iconPos = 0;
		}

		if (iconPos != this.frameCounter) {
			this.frameCounter = iconPos;
			TextureUtil.uploadTextureMipmap((int[][]) this.framesTextureData.get(this.frameCounter), this.width, this.height, this.originX, this.originY, false, false);
		}
	}

}
