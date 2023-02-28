package abstractfactory;

import editor.aesthetics.*;
import editor.parsers.*;

public class CPPFactory extends AbstractFactory {


    @Override
    public Aesthetics createAesthetics() {
        return new CPPAesthetics();
    }

    @Override
    public Parser createParser() {
        return new CPP();
    }
}
