package priv.samera2022.functions.as_system;

import net.mamoe.mirai.console.data.Value;
import net.mamoe.mirai.console.data.java.JAutoSavePluginData;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class asData extends JAutoSavePluginData {
    public static final asData INSTANCE = new asData("as_data");

    public final Value<String> string = value("test"); // 默认值 "test"

    public final Value<List<String>> list = typedValue(createKType(List.class, createKType(String.class))); // 无默认值, 自动创建空 List

    public final Value<Map<Long, Object>> custom = typedValue(
            createKType(Map.class, createKType(Long.class), createKType(Object.class)),
            new HashMap<Long, Object>() {{ // 带默认值
                put(123L, "ok");
            }}
    );

    public asData(@NotNull String savename) {
        super(savename);
    }
}
