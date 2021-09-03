import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author zhangnan
 * @date 2021/9/3
 */
public class LFUCache {

    public static final int INTEGER_ONE_VALUE = 1;
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    int minFreq;
    int capacity;


    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
        minFreq = 0;
    }


    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        increaseFreq(key);

        return keyToVal.get(key);
    }

    private void increaseFreq(int key) {
        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        freqToKeys.get(key).remove(key);

        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);

        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }

    }

    public void put(int key, int value) {
        if (this.capacity <= 0) {
            return;
        }

        if (keyToVal.containsKey(key)) {
            // 修改value
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        if (this.capacity <= keyToVal.size()) {
            removeMinFreqElement();
        }

        keyToVal.put(key, value);
        keyToFreq.put(key, INTEGER_ONE_VALUE);
        freqToKeys.putIfAbsent(INTEGER_ONE_VALUE, new LinkedHashSet<>());
        freqToKeys.get(INTEGER_ONE_VALUE).add(key);
        this.minFreq = INTEGER_ONE_VALUE;
    }

    private void removeMinFreqElement() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        Integer deleteKdy = keyList.iterator().next();
        keyList.remove(deleteKdy);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
        keyToVal.remove(deleteKdy);
        keyToFreq.remove(deleteKdy);
    }


}
