package editor;


import abstractfactory.AbstractFactory;
import abstractfactory.CFactory;
import editor.aesthetics.Aesthetics;
import editor.parsers.Parser;
import factorycreator.FactoryCreator;

public class Editor {
    private static Editor instance = null;
    private Aesthetics ae;
    private AbstractFactory abstractFactory;
    private Parser p;


    public static Editor getinstance(){
        if(instance == null)
            instance = new Editor();

        return instance;
    }

    public void showContents(){
        p.ParseFile();
        ae.show();
    }

    public void setContents(String ext){

        if(ext.equalsIgnoreCase("c")){
            abstractFactory =  FactoryCreator.getFactory("c");
            ae = abstractFactory.createAesthetics();
            p = abstractFactory.createParser();
        }

        else if(ext.equalsIgnoreCase("cpp")){
            abstractFactory =  FactoryCreator.getFactory("cpp");
            ae = abstractFactory.createAesthetics();
            p = abstractFactory.createParser();
        }

        else if(ext.equalsIgnoreCase("py")){
            abstractFactory =  FactoryCreator.getFactory("py");
            ae = abstractFactory.createAesthetics();
            p = abstractFactory.createParser();
        }
    }
}
