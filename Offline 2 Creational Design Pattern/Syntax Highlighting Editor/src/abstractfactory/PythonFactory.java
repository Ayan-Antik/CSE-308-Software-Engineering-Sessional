package abstractfactory;

import editor.aesthetics.*;
import editor.parsers.*;

public class PythonFactory extends AbstractFactory {
    @Override
    public Aesthetics createAesthetics() {
        return new PythonAesthetics();
    }

    @Override
    public Parser createParser() {
        return new Python();
    }
}
