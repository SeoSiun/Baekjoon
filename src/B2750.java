import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750 {
//****   O(n^2)    ****//
    // insertion sort
    public static void insertion(int[] nums){
        int tmp, j;
        for(int i=1; i<nums.length; i++){
            tmp = nums[i];
            j = i-1;
            while(j>=0 && nums[j]>tmp){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = tmp;
        }
    }

    // selection sort
    public static void selection(int[] nums){
        int min, tmp;
        for(int i=0; i<nums.length-1; i++){
            min = i;
            tmp = nums[i];
            for(int j=i+1; j< nums.length; j++){
                if(nums[min] > nums[j]) min = j;
            }
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }

    // bubble sort
    public static void bubble(int[] nums){
        int tmp;
        for(int i=0; i< nums.length-1; i++){
            for(int j=0; j< nums.length-i-1; j++){
                if(nums[j] > nums[j+1]){
                    tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int n;
        int[] nums;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        // read
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

//        insertion(nums);
//        selection(nums);
        bubble(nums);

        // print
        for(int i=0; i<n; i++){
            System.out.println(nums[i]);
        }
    }
}
