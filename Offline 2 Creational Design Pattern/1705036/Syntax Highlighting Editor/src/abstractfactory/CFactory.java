package abstractfactory;

import editor.aesthetics.*;
import editor.parsers.*;

public class CFactory extends AbstractFactory {


    @Override
    public Aesthetics createAesthetics() {
        return new CAesthetics();
    }

    @Override
    public Parser createParser() {
        return new C();
    }
}

