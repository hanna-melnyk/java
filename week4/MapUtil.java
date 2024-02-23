package ss.week4;

import java.util.*;

public class MapUtil {

    /** Checks whether function provided as a parameter is an injection
     * @param map - map of function keys and values
     * @return  true if for every K key there exists exactly one V value; false otherwise*/
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        // TODO: implement, see exercise P-4.10
        Map<V, Integer> valueOccurences = new HashMap<>();
        for (Map.Entry<K, V> entry: map.entrySet()) {
            K key = entry.getKey();
            V value  = entry.getValue();
            if (valueOccurences.containsKey(value)) {
                valueOccurences.put(value, valueOccurences.get(value)+1);
                if (valueOccurences.get(value) >1 ) {
                    return false;
                }
            } else {
                valueOccurences.put(value, 1);
            }
        }
        return true;
    }


    /**Checks whether parameter map is surjective
     * @param map of type Map<K, V> containing key and value pairs of a function
     * @param range of type Set<V> containing all values of a function
     * @return true if  all elements in Set<V> range exist as values in Map<K, V> map; false otherwise
     * */
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        // TODO: implement, see exercise P-4.11
        Collection<V> valuesList = map.values();
        for (V value: range) {
            if (!valuesList.contains(value)) {
               return false;
            }
        }
        return true;
    }

    /**
     * @return inverseMap of type Map<V, Set<K>>,
     * where key is the value of Map<K, V> map, and
     * value is a set containing all keys  of Map<K, V> for a value given
     * @param map of type Map<K, V> - amp of keys and values of a function
     * @ensure the map returned is an inverse of the map Map<K, V> from the parameter*/
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> inverseMap = new HashMap<>();
        // TODO: implement, see exercise P-4.12
        for (K k: map.keySet()) {
            V mapValue = map.get(k);
            Set<K> keys = inverseMap.get(mapValue); // obtain a keys set from inverseMap map (to refer to it further in the loop)
            //we create an if-statement to add the keys set to inverseMap
            if (keys == null) { // if keys set DOESNT exist
                keys = new HashSet<>(); // initialize the keys
                inverseMap.put(mapValue, keys); // insert a new keys set in the inverseMap
            }
            keys.add(k); // now that we checked that keys set exists & we can refer to it, add the value to the set
        }
        return inverseMap;
    }

    /**Checks whether the two maps passed as parameter can be composed
     * @return true if  all values of map f are in the key set of the g map; false otherwise
     * @param f - fisrt map (containing key and value pairs of a function)
     * @param g - second map (containing key and value pairs of a function)*/
    public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-4.13
        for (V valueF:
             f.values()) {
            if (!g.containsKey(valueF)) {
                return false;
            }
        }
        return true;
    }
    /**
     * @return inverse function, if function is inverse bijection (isOneOnOne() && isSurjectiveOnRange())
     * @param map - map containing key and value pairs of a function
     * @ensure result is null if function is not injective and surjective.; result is a map representing inverse bijection of function set in parameters, if map from the parameters satisfies (isOneOnOne(map) && isSurjectiveOnRange(map,v))
     * */
    public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        // TODO: implement, see exercise P-4.12
        Set<V> v = new HashSet<V>(map.values()); // range
        Map<V, K> inverseBijection = new HashMap<>(); // create map to store the result
        if (isOneOnOne(map) && isSurjectiveOnRange(map,v)) {  // is one-on-one and surjective
        for (Map.Entry<K,V> entry: map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            inverseBijection.put(value, key);
        }
        return inverseBijection;
        }
        return null;
    }



    /**Provides a composition of two maps, if they are compatible
     * @param f - first map (containing key and value pairs of a function)
     * @param g - second map (containing key and value pairs of a function)
     * @return map of type Map<K, W> that contains keys of function f in its key =s set, and values of function g in its values set
     * @ensure result of a method  == null if !compatible(f,g); result is a map where keys are from f and values are from g, and f and g are compatible*/
    public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-4.13
        if (!compatible(f, g)) {
            return null;
        }
        Map<K,W> composed = new HashMap<>();
        for (Map.Entry<K,V> entry: f.entrySet()) {
            K keyF = entry.getKey();
            V valueF = entry.getValue();
            W valueG = g.get(valueF);
            composed.put(keyF, valueG);
        }
        return composed;
    }
	
}
