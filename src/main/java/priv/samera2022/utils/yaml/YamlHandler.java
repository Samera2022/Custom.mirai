package priv.samera2022.utils.yaml;

import org.ho.yaml.YamlDecoder;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class YamlHandler {

    @Deprecated
    public static HashMap<?, ?> getAsMap(File folder, String fileName) throws FileNotFoundException {
        HashMap<?, ?> map_1 = new HashMap<>();
        YamlDecoder dec = new YamlDecoder(new FileInputStream(folder.getPath() + "/" + fileName));
        while (true) {
            try {
                map_1 = (HashMap<?, ?>) dec.readObject();
            } catch (EOFException e) {
                break;
            }
        }
        return map_1;
    }

    protected static HashMap<?, ?> get(File file, String key) throws FileNotFoundException {
        HashMap<?, ?> map_1;
        HashMap<?, ?> map_2 = null;
        YamlDecoder dec = new YamlDecoder(new FileInputStream(file));
        while (true) {
            try {
                map_1 = (HashMap<?, ?>) dec.readObject();
                map_2 = (HashMap<?, ?>) map_1.get(key);
            } catch (EOFException e) {
                break;
            }
        }
        return map_2;
    }
}