import java.util.LinkedHashMap;
import java.util.Map;

public class lru_cache {
    class LRUCache extends LinkedHashMap<Integer,Integer> {
        private int _capacity;
        public LRUCache(int capacity) {
            super(capacity,0.75F,true);
            this._capacity =  capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            super.put(key,value);
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > _capacity;
        }
    }
}
