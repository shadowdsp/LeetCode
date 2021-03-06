class MyHashSet {
private:
    const static int N = 1000001;
    bool a[N];

public:
    /** Initialize your data structure here. */
    MyHashSet() {
        for (int i = 0; i < N; i++) {
            a[i] = false;
        }
    }
    
    void add(int key) {
        a[key] = true;
    }
    
    void remove(int key) {
        a[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        return a[key];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */