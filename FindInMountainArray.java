public class FindInMountainArray {

    static int searchInMountain(int[] arr , int target){
        int peakElement = peakIndexSearch(arr);
        int ascSearch =binarySearch(arr,target,0,peakElement,true);
        if(ascSearch != -1) {
            return ascSearch;
        }
        return binarySearch(arr,target,peakElement,arr.length-1,false);
    }

    static int peakIndexSearch(int[] arr){

        int start = 0 ;
        int end = arr.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1]){
                end=mid;
            } else  {
                start=mid+1;
            }
        }

        return arr[start];
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
