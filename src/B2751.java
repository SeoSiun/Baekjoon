import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B2751 {
//    //****  O(nlogn)   ****//
//
//    // merge sort
//    static int n;
//    static int[] nums;
//    static int[] tmp;
//
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        nums = new int[n];
//        tmp = new int[n];
//
//        for(int i=0; i<n; i++){
//            nums[i] = Integer.parseInt(br.readLine());
//        }
//
//        mergeSort(0, n - 1);
//
//        StringBuilder result = new StringBuilder();
//
//        for(int i=0; i<n; i++){
//            result.append(nums[i]).append("\n");
//        }
//        System.out.println(result);
//    }
//
//    public static void mergeSort(int start, int end)
//    {
//        if (start >= end)
//            return;
//
//        int mid = (end + start) / 2;
//        mergeSort(start, mid);
//        mergeSort(mid + 1, end);
//        merge(start, end);
//    }
//
//    // merge
//    public static void merge(int start, int end)
//    {
//        int mid = (end + start) / 2;
//        int i = start;
//        int j = mid + 1;
//        int k = start;
//
//        while (i <= mid && j <= end)
//        {
//            if (nums[i] <= nums[j])
//                tmp[k++] = nums[i++];
//            else
//                tmp[k++] = nums[j++];
//        }
//        if (i > mid)
//        {
//            while (j <= end)
//                tmp[k++] = nums[j++];
//        }
//        else
//        {
//            while (i <= mid)
//                tmp[k++] = nums[i++];
//        }
//        for (i = start; i <= end; i++)
//            nums[i] = tmp[i];
//    }

    // Collection.sort()
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();

        for(int i=0; i<n; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(nums);

        StringBuilder result = new StringBuilder();

        for(int i=0; i<n; i++){
            result.append(nums.get(i)).append("\n");
        }
        System.out.println(result);
    }
}
