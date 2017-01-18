package rpg;

import java.io.IOException;

public interface Icommand{
	String show();
	Dialog action() throws IOException;
}
