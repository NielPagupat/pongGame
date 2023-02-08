package pong1o5;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Tools {
	public static Toolkit tk = Toolkit.getDefaultToolkit();
	public static Dimension SCREEN = tk.getScreenSize();
	public static final int FRAMEWIDTH = SCREEN.width;
	public static final int FRAMEHEIGHT = SCREEN.height;
	public static final int PANELWIDTH = 400;
	public static final int PANELHEIGHT = 700;
	public static final int PXLOCATION = FRAMEWIDTH/2 - PANELWIDTH/2;
	public static final int PYLOCATION = FRAMEHEIGHT/2 - PANELHEIGHT/2;
}
