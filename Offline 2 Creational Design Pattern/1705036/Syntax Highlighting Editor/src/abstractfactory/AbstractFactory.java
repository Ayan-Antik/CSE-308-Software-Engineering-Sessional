package abstractfactory;

import editor.aesthetics.Aesthetics;
import editor.parsers.Parser;

public abstract class AbstractFactory {
    public abstract Aesthetics createAesthetics();
    public abstract Parser createParser();

}
