package 数据结构.binarytree.堆;

public class MaxHeap extends Heap {

    public MaxHeap() {
        super();
    }

    public MaxHeap(int capicity) {
        super(capicity);
    }

    @Override
    public boolean insert(int value) {
        boolean success = false;
        if (size == 0) {
            size++;
            heap[1] = value;
            return true;
        }
        if (this.size <= capicity - 1) {
            size++;
            this.heap[size] = value;
            int index = size;
            while (index > 1) {
                if (heap[index] > heap[index / 2]) {
                    swapPos(heap, index, index / 2);
                }
                index /= 2;
            }
            success = true;
        }
        return success;
    }

    @Override
    public int delete() {
        int remove = heap[1];
        swapPos(heap, 1, size);
        heap[size] = 0;
        int index = 1;
        size--;
        adjust(index, size, heap);
        return remove;
    }

    public static void adjust(int index, int size, int[] heap) {
        while (index <= size) {
            int maxChildPos = getMaxPos(index, size, heap);
            if (heap[index] >= heap[maxChildPos]) {
                break;
            } else {
                swapPos(heap, index, maxChildPos);
            }
            index = maxChildPos;
        }
    }

    public static void build(int[] maxHeap, int N)  {
        int index = N / 2;

        while (index >= 1) {
            adjust(index, N, maxHeap);
            index--;
        }
    }
}
