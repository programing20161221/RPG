package rpg;

import java.io.IOException;

public interface Icommand{
	String showname();
	Dialog action() throws IOException;
}
