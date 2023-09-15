public class FindInRotatedSortedArray {
    static int findInRotatedArray(int[] arr , int target){
        int pivot = findPivot(arr);
        int firstBlock = binarySearch(arr,target,0,pivot,true);
        if (firstBlock!=-1){
            return firstBlock;

        }

        return binarySearch(arr,target,pivot+1,arr.length-1,true);
    }

    static int findPivot(int[] arr){
        if(arr[0] < arr[arr.length-1] ){
            return 0;
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

            if (arr[mid] <= arr[start]){
                end = mid -1 ;
            }
            else start = mid+1;

        }
        return -1;

    }

    static int binarySearch(int[] arr, int target, int start, int end,boolean isAscending){
        while(start<= end){
            int mid = start + (end-start)/2;
            if (arr[mid] == target) return mid;
            if(isAscending){
                if(target > arr[mid] ){
                    start=mid+1;
                } else if (target<arr[mid]) {
                    end = mid-1;
                }
            }
            else{
                if(target > arr[mid] ){
                    end = mid-1;
                } else if (target<arr[mid]) {
                    start  = mid+1;

                }
            }
        }
        return -1;
    }
}
