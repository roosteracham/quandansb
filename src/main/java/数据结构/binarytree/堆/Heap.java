package 数据结构.binarytree.堆;

public abstract class Heap {
    protected int[] heap;
    protected int size;
    protected int capicity;

    //默认堆大小为16
    public Heap() {
        this.capicity = 17;
        this.heap = new int[17];
        this.size = 0;
    }

    public Heap(int capicity) {
        this.capicity = capicity;
        this.heap = new int[capicity + 1];
        this.size = 0;
    }

    public abstract boolean insert(int value);

    public static void swapPos(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    public abstract int delete();

    public static int getMaxPos(int index, int size, int[] heap) {
        if (index * 2 <= size && index * 2 + 1 <= size) {
            if (heap[index * 2] > heap[index * 2 + 1]) {
                index = index * 2;
            } else {
                index = index * 2 + 1;
            }
        } else if (index * 2 <= size) {
            index = index * 2;
        }
        return index;
    }
    public static int getMinPos(int index, int size, int[] heap) {
        if (index * 2 <= size && index * 2 + 1 <= size) {
            if (heap[index * 2] < heap[index * 2 + 1]) {
                index = index * 2;
            } else {
                index = index * 2 + 1;
            }
        } else if (index * 2 <= size) {
            index = index * 2;
        }
        return index;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 1; i <= size; i++) {
            stringBuilder.append((heap[i]));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Heap maxHeap = new MaxHeap();
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(8);
        maxHeap.insert(9);
        maxHeap.insert(1);
        maxHeap.insert(42);
        //System.out.println(maxHeap.delete());
        System.out.println(maxHeap.size);
        System.out.println(maxHeap);

        int[] array = {0,2,3,4,5,6,7,8,9,1,42};

        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
        MaxHeap.build(array, array.length - 1);
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i]);
        }

        maxHeap = new MinHeap();
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(8);
        maxHeap.insert(9);
        maxHeap.insert(1);
        maxHeap.insert(42);
        //System.out.println(maxHeap.delete());
        System.out.println(maxHeap.size);
        System.out.println(maxHeap);

        int[] array1 = {0,2,3,4,5,6,7,8,9,1,42};

        for (int i = 1; i < array1.length; i++) {
            System.out.print(array1[i]);
        }
        System.out.println();
        MaxHeap.build(array1, array1.length - 1);
        for (int i = 1; i < array1.length; i++) {
            System.out.print(array1[i]);
        }
    }
}
