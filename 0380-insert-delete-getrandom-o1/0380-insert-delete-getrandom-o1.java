class RandomizedSet {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {

        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }
    
    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int last = list.get(list.size() - 1);

        // Move last element to the deleted element's position
        list.set(index, last);

        // Update last element's index
        map.put(last, index);

        // Remove last position
        list.remove(list.size() - 1);

        // Remove val from map
        map.remove(val);

        return true;
    }
    
    public int getRandom() {

        int index = (int)(Math.random() * list.size());

        return list.get(index);
    }
}