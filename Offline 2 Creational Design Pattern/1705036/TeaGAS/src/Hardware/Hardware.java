package Hardware;

import java.util.HashMap;
import java.util.Map;

public class Hardware {
    private HashMap<String, Components> components = new HashMap<String, Components>();

    public void addComponents(String key, Components c)
    {
        components.put(key, c);
    }
    public void showComponents(){
        for (Map.Entry me : components.entrySet()){
            System.out.println(me.getKey() + ": " + ((Components) me.getValue()).name());
        }
    }
}
