package editor.aesthetics.fontfactory;

import editor.aesthetics.font.*;

public class FontFactory {
    public Font getFont(String choice){
        if(choice.equalsIgnoreCase("consolas"))
            return new Consolas();
        else if(choice.equalsIgnoreCase("couriernew"))
            return new CourierNew();
        else if (choice.equalsIgnoreCase("monaco"))
            return new Monaco();
        return null;

    }
}
