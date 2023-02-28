package factorycreator;

import abstractfactory.AbstractFactory;
import abstractfactory.CFactory;
import abstractfactory.CPPFactory;
import abstractfactory.PythonFactory;

public class FactoryCreator {

    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("c")){
            return new CFactory();
        }

        else if(choice.equalsIgnoreCase("cpp")){
            return new CPPFactory();
        }

        else if(choice.equalsIgnoreCase("py")){
            return new PythonFactory();
        }

        return null;
    }

}
