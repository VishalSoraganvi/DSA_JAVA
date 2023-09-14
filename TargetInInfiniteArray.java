public class TargetInInfiniteArray {
    static int binarySearchInInfiniteArray(int[] arr , int target){
        int start = 0;
        int end =1 ;

        //since its infinite array we are guessing that it does not have an end
        while(target > arr[end]){
            int newStart = end +1 ;
            end = newStart + (end-start +1)*2;
            start = newStart;
        }

        while(start <= end){
            int mid = start + (end-start)/2;

            if (target < arr[mid]){
                end=mid-1;
            } else if (target>arr[mid]) {
                start= mid + 1;
            } else{
                return mid;
            }
        }

        return -1;
    }
}
