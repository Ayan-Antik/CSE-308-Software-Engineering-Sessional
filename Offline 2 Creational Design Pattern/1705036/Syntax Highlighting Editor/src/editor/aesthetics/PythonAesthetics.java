package editor.aesthetics;

import editor.aesthetics.font.*;
import editor.aesthetics.fontfactory.*;
import editor.aesthetics.style.*;
import editor.aesthetics.color.*;

public class PythonAesthetics implements Aesthetics {
    @Override
    public Font getFont(String choice) {
        FontFactory ff = new FontFactory();
        return ff.getFont("consolas");
    }

    @Override
    public Color getColor() {
        return new Blue();
    }

    @Override
    public Style getStyle() {
        return new Normal();
    }

    @Override
    public void show() {
        System.out.println("Font used: Consolas");
    }
}
