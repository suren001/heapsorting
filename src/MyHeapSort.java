import java.util.Arrays;

public class MyHeapSort {
    public static void main(String[] args) {
        int[] arr = {20, 2, 8, 4, 5, 4, 63, 9};
        System.out.println("unsorted---->" + Arrays.toString(arr));
        MyHeapSort ob = new MyHeapSort();
        ob.heapSort(arr);
        System.out.println("Sorted---->" + Arrays.toString(arr));
    }

    public void heapSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int child = i;
            int parent = (child - 1) / 2;
            while (arr[parent] < arr[child]) {
                swap(arr, child, parent);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
        System.out.println("MaxHeap--->" + Arrays.toString(arr));
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            int parent = 0;
            int maxchild = getMaxChild(arr, parent, i);
            while (arr[parent] < arr[maxchild]) {
                swap(arr, maxchild, parent);
                parent = maxchild;
                maxchild = getMaxChild(arr, parent, i);
                if (maxchild == 0) {
                    break;
                }
            }
        }
    }

    private int getMaxChild(int[] arr, int parent, int lastsortedindex) {
        int response = 0;
        int leftchild = parent * 2 + 1;
        int rightchild = parent * 2 + 2;
        if (leftchild < lastsortedindex && rightchild < lastsortedindex) {
            if (arr[leftchild] >= arr[rightchild]) {
                response = leftchild;
            } else {
                response = rightchild;
            }
        }
        return response;
    }

    private void swap(int[] arr, int child, int parent) {
        int temp = arr[child];
        arr[child] = arr[parent];
        arr[parent] = temp;
    }

}
