import java.util.HashMap;
import java.util.Map;


public class Mapping {
	static Map<String, String> decode(String arg) {
        HashMap<String, String> mapping = new HashMap<String, String>();

        if (arg.equals(null)){
        	return null;
        }else if (arg.isEmpty()){
        	mapping.clear();
        	return mapping;
        }
        
        try {
			String[] parts = arg.split("&");
			for (String str : parts) {
				String[] maps = str.split("=", 2);
				mapping.put(maps[0], maps[1]);
			}
		} catch (Exception e) {
		}
		return mapping;
    }
}
