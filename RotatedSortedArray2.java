public class RotatedSortedArray2 {

     boolean search(int[] arr, int target) {
        int pivot = findPivotDuplicate(arr);
        if(pivot==-1){
            return binarySearch(arr,target,0,arr.length-1);
        }
        if(arr[pivot]==target) return true;
        if(target  >= arr[0]){
            return binarySearch(arr,target,0,pivot-1);
        }
        return binarySearch(arr,target,pivot+1,arr.length-1);
    }

     int findPivotDuplicate(int[] arr){
        if(arr[0] < arr[arr.length-1] ){
            return arr.length-1;
        }

        int start= 0 ;
        int end =  arr.length-1;
        while (start <= end){
            int mid = start + (end-start)/2;

            if(mid <  end && arr[mid] > arr[mid+1]){
                return mid;
            }

            if (mid > start && arr[mid]< arr[mid-1]){
                return mid-1;
            }
            // in this block we are going to skip duplicates
            if(arr[start]== arr[mid] && arr[mid]== arr[end]){
                //check before ignoring start
                if(arr[start] > arr[start+1]){
                    return start;
                }
                start++;
                //check before ignoring end

                if(arr[end] < arr[end-1]){
                    return end-1;
                }
                end--;
            }

            else if(arr[start] < arr[mid] || (arr[mid] == arr[start] && arr[end]< arr[mid])){
                start = mid +1 ;

            }

            else {
                end = mid -1 ;
            }

        }
        return -1;
    }

      boolean binarySearch(int[] arr, int target, int start, int end){
        while(start<= end){
            int mid = start + (end-start)/2;
            if (arr[mid] == target) return true;
            if(target > arr[mid] ){
                start=mid+1;
            } else if (target<arr[mid]) {
                end = mid - 1;
            }
        }
        return false;
    }
}
