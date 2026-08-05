class DynamicArray {
    private Integer[] arr;

    public DynamicArray(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException();
        }
        arr = new Integer[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        int idx = 0;
        while(idx < arr.length && arr[idx] != null){
            idx++;
        }
        if(idx < arr.length){
            arr[idx] = n;
        }else{
            resize();
            arr[idx] = n;
        }
    }

    public int popback() {
        boolean lastElementFound = false;
        int idx = arr.length - 1;
        int lastElement = -1;
        while(!lastElementFound){
            if(arr[idx] != null){
                lastElement = arr[idx];
                arr[idx] = null;
                lastElementFound = true;
            }
            idx--;
        }
        return lastElement;
    }

    private void resize() {
        Integer[] biggerArr = new Integer[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            biggerArr[i] = arr[i];
        }
        arr = biggerArr;
    }

    public int getSize() {
        int size = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null){
                size++;
            }
        }
        return size;
    }

    public int getCapacity() {
        return arr.length;
    }
}
