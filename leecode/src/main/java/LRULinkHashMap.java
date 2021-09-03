import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhangnan
 * @date 2021/9/2
 */
public class LRULinkHashMap extends LinkedHashMap {

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > 10;
    }
}
