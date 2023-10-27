

 class HashTable{
    private int size;
    private int count = 0;
    private String[] keys;
    private String[] values;

    public HashTable(int size) {
        this.size = size;
        this.keys = new String[size];
        this.values = new String[size];
    }

    private int hash(String key) {
        int hash = 0;

        for (int i = 0; i < key.length(); i++)
            hash = (2 * hash + 3 * key.charAt(i)) % size;   // h1(k) = 2k+3

        return hash;
    }

    private int doubleHash(String key) {
        int hash = 0;

        for (int i = 0; i < key.length(); i++)
            hash = (3 * hash + 1) % size;

        return hash;
    }

    public int getSize() {
        return this.count;
    }

    // for both insertion and updating the key
    public void insert(String key, String value) {
        System.out.println("Inserting key " + key);
        int hash1 = hash(key);
        int hash2 = doubleHash(key);
        int index = hash1 % this.size;
        int step = hash2 % this.size;
        int initialIndex = index;

        do {
            if (this.keys[index] == null) {
                this.keys[index] = key;
                this.values[index] = value;
                this.count++;
                return;
            }

            if (this.keys[index].equals(key)) {
                this.values[index] = value;
                return;
            }

            index = (index + step) % this.size;
        } while (index != initialIndex);

        System.out.println("HashTable is full");
    }

    // remove an element, by marking it as null
    public void remove(String key) {
        int hash1 = hash(key);
        int hash2 = doubleHash(key);
        int index = hash1 % this.size;
        int step = hash2 % this.size;

        while (this.keys[index] != null) {
            if (this.keys[index].equals(key)) {
                this.keys[index] = null;
                this.values[index] = null;
                this.count--;
                return;
            }

            index = (index + step) % this.size;
        }

        System.out.println("Key could not be found");
    }

    // search and print the values
    public String search(String key) {
        int hash1 = hash(key);
        int hash2 = doubleHash(key);
        int index = hash1 % size;
        int step = hash2 % size;

        while (this.keys[index] != null) {
            if (this.keys[index].equals(key))
                return this.values[index];
            
            index = (index + step) % this.size;
        }

        return null;
    }

    // print the values using iterator
    private class HashIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            while (index < size && keys[index] == null)
                index++;

            return index < size && keys[index] != null;
        }

        @Override
        public String next() {
            if (!hasNext())
                return null;

            return keys[index] + ":" + values[index++];
        }
    }

    public Iterator<String> iterator() {
        return new HashIterator();
    }
}