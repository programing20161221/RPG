package rpg;

import java.io.IOException;

public interface Bcommand {
	String show();
	Dialog action(Character c) throws IOException;
}
