import java.util.*;

class MaxHeap {
  private ArrayList<Integer> heap;

  public MaxHeap() {
    heap = new ArrayList<>();
  }

  public boolean isEmpty() {
    return heap.isEmpty();
  }

  private int parent(int i) {
    return (i - 1) / 2;
  }

  private int leftChild(int i) {
    return (2 * i) + 1;
  }

  private int rightChild(int i) {
    return (2 * i) + 2;
  }

  private void swap(int i, int j) {
    int temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

  public void insert(int value) {
    heap.add(value);

    int currentIndex = heap.size() - 1;

    while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parent(currentIndex))) {
      swap(currentIndex, parent(currentIndex));

      currentIndex = parent(currentIndex);
      System.out.println(currentIndex);
    }
  }

  public int extractMax() {
    if (heap.isEmpty())
      throw new RuntimeException("heap is empty");

    int max = heap.get(0);

    int lastElement = heap.get(heap.size() - 1);

    if (!heap.isEmpty()) {
      heap.set(0, lastElement);

      int currentIndex = 0;

      while (true) {
        int left = leftChild(currentIndex);
        int right = rightChild(currentIndex);

        int largest = currentIndex;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
          largest = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
          largest = right;
        }

        if (largest == currentIndex) {
          break;
        }

        swap(currentIndex, largest);

        currentIndex = largest;
      }
    }

    return max;
  }
}
