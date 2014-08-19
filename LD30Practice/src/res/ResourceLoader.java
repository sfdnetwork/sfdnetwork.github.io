package res;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class ResourceLoader {

	static ResourceLoader rl = new ResourceLoader();
	
	public static Texture getTexture(String filename){
		Texture tex = null;
		try{
			tex = TextureLoader.getTexture("PNG", ResourceLoader.class.getClassLoader().getResourceAsStream(filename));
		}catch(Exception e){
			e.printStackTrace();
		}
		return tex;
	}
	
}
