package editor.aesthetics;

import editor.aesthetics.color.Color;
import editor.aesthetics.font.Font;
import editor.aesthetics.style.Style;

public interface Aesthetics {
    public Font getFont(String choice);
    public Color getColor();
    public Style getStyle();
    public void show();
}
