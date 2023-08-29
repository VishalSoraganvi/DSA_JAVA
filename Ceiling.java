public class Ceiling {
    public static int ceilingFunc(int[] arr, int target) {
        if(target > arr[arr.length-1]) return -1;

        int start =0 ;
        int end = arr.length-1;

        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid]< target){
                start = mid+1;
            }
            else if(target<arr[mid]) {
                end =mid;
            }
            else {
                return arr[mid];
            }
        }
        return arr[end];
    }
}
