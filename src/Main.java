import java.util.Random;

public class Main {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.Insert(18);
        linkedList.Insert(45);
        linkedList.Insert(12);
        linkedList.InsertAtStart(25);
        linkedList.InsertAt(1, 2);
        linkedList.InsertAt(2, 3);
        linkedList.Show();
        linkedList.Delete(4);
        System.out.println();
        linkedList.Show();
        linkedList.Delete(14);

        //Sorting(10000);

        //Searching();
    }

    private static void Sorting(int size) {
        Random random = new Random();
        int[] nums = new int[size];
        for(int i = 0; i < size; i++){
            nums[i] = i + 1 + random.nextInt(10);
        }
        int steps = BubbleSort(nums, size);
        System.out.println("Post bubble sort in " + steps + " steps");

        for(int i = 0; i < size; i++){
            nums[i] = i + 1 + random.nextInt(10);
        }
        steps = SelectionSort(size, nums);
        System.out.println("Post selection sort in " + steps + " steps");

        for(int i = 0; i < size; i++){
            nums[i] = i + 1 + random.nextInt(10);
        }
        steps = QuickSort(nums, 0, nums.length-1);
        System.out.println("Post quick sort in " + steps + " steps");

        for(int i = 0; i < size; i++){
            nums[i] = i + 1 + random.nextInt(10);
        }
        steps = MergeSort(nums, 0, nums.length-1);
        System.out.println("Post merge sort in " + steps + " steps");
    }

    public static int BubbleSort(int[] nums, int size){
        int steps = 0;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size - i - 1; j++) {
                steps++;
                if(nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        return steps;
    }

    private static int SelectionSort(int size, int[] nums) {
        int steps = 0;
        int smallestValueIndex = 0;
        for(int i = 0; i < size - 1; i++) {
            smallestValueIndex = i;
            for(int j = i + 1; j < size; j++) {
                steps++;
                if(nums[smallestValueIndex] > nums[j]) {
                    smallestValueIndex = j;
                }
            }

            int tmp = nums[smallestValueIndex];
            nums[smallestValueIndex] = nums[i];
            nums[i] = tmp;
        }
        return steps;
    }

    private static int InsertionSort(int[] nums) {
        int steps = 0;
        for(int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;

            while(j >= 0 && nums[j] > key) {
                steps++;
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key;
        }
        return steps;
    }

    private static int QuickSort(int[] nums, int low, int high) {
        int steps = 0;

        if(low < high) {
            steps++;

            int pivot = Partition(nums, low, high);

            steps += QuickSort(nums, low, pivot - 1);
            steps += QuickSort(nums, pivot + 1, high);
        }

        return steps;
    }

    private static int Partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for(int j = low; j < high; j++) {
            if(nums[j] < pivot) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        int tmp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = tmp;

        return i + 1;
    }

    private static int MergeSort(int[] nums, int l, int r) {
        int steps = 0;

        if(l < r) {
            steps++;

            int mid = (l + r) / 2;
            steps += MergeSort(nums, l, mid);
            steps += MergeSort(nums, mid + 1, r);

            steps += Merge(nums, l, mid, r);
        }

        return steps;
    }

    private static int Merge(int[] nums, int l, int mid, int r) {
        int steps = 0;

        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] lArr = new int[n1];
        int[] rArr = new int[n2];

        for(int i = 0; i < n1; i++) {
            steps++;
            lArr[i] = nums[l + i];
        }
        for(int i = 0; i < n2; i++) {
            steps++;
            rArr[i] = nums[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i < n1 && j < n2) {
            steps++;

            if(lArr[i] <= rArr[j]) {
                nums[k] = lArr[i];
                i++;
            }
            else {
                nums[k] = rArr[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            nums[k] = lArr[i];
            i++;
            k++;
        }

        while(j < n2) {
            nums[k] = rArr[j];
            j++;
            k++;
        }

        return steps;
    }

    private static void Searching() {
        Random rand  = new Random();
        int arraySize = rand.nextInt(1000000);
        int[] nums = new int[arraySize];
        for(int i = 0; i < arraySize; i++){
            nums[i] = i + 1;
        }

        int target = rand.nextInt(arraySize);
        System.out.println("Number of elements: " + arraySize + " Target = " + target);

        int resultLinear = LinearSearch(nums, target);
        int resultBinary = BinarySearch(nums, target);
        int resultBinaryRecursive = BinarySearchRecursive(nums, target, 0, nums.length - 1, 0);

        if(resultLinear >= 0) {
            System.out.println("Linear search: Element found at Index = " + resultLinear);
        }
        else {
            System.out.println("Linear search: Element not found");
        }

        if(resultBinary >= 0) {
            System.out.println("Binary search: Element found at Index = " + resultBinary);
        }
        else {
            System.out.println("Binary search: Element not found");
        }

        if(resultLinear >= 0) {
            System.out.println("Binary (recursive) search: Element found at Index = " + resultBinaryRecursive);
        }
        else {
            System.out.println("Binary (recursive) search: Element not found");
        }
    }

    public static int LinearSearch(int[] nums, int target) {

        int steps = 0;

        for(int i = 0; i < nums.length; i++){
            steps++;
            if(nums[i] == target){
                System.out.println("Steps for linear search: " + steps);
                return i;
            }
        }

        System.out.println("Steps for linear search: " + steps);
        return -1;
    }

    public static int BinarySearch(int[] nums, int target) {

        int steps = 0;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            steps++;

            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                System.out.println("Steps for binary search: " + steps);
                return mid;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            }
            else if(nums[mid] > target) {
                right = mid - 1;
            }
        }

        System.out.println("Steps for binary search: " + steps);
        return -1;
    }



    public static int BinarySearchRecursive(int[] nums, int target, int left, int right, int steps){
        steps++;

        int mid = (left + right) / 2;

        if(left <= right) {
            if(nums[mid] == target) {
                System.out.println("Steps for binary search (recursive): " + steps);
                return mid;
            }
            else if(nums[mid] < target) {
                return BinarySearchRecursive(nums, target, mid + 1, right, steps);
            }
            else if(nums[mid] > target) {
                return BinarySearchRecursive(nums, target, left, mid - 1, steps);
            }
        }

        System.out.println("Steps for binary search (recursive): " + steps);
        return -1;
    }
}