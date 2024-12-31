import java.util.*;

class MinHeap {
  private ArrayList<Integer> heap;

  public MinHeap() {
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

    while (currentIndex > 0 && heap.get(currentIndex) < heap.get(parent(currentIndex))) {
      swap(currentIndex, parent(currentIndex));

      currentIndex = parent(currentIndex);
    }
  }

  public int extractMin() {
    if (heap.isEmpty())
      throw new RuntimeException("heap is empty");

    int min = heap.get(0);

    int lastElement = heap.remove(heap.size() - 1);

    if (!heap.isEmpty()) {
      heap.set(0, lastElement);

      int currentIndex = 0;
      while (true) {
        int left = leftChild(currentIndex);
        int right = rightChild(currentIndex);

        int smallest = currentIndex;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
          smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
          smallest = right;
        }

        if (smallest == currentIndex) {
          break;
        }

        swap(smallest, currentIndex);

        currentIndex = smallest;
      }
    }

    return min;
  }
}