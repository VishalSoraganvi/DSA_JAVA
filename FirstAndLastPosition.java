public class FirstAndLastPosition {
    static int[] firstAndLastPos(int[] arr , int target){
        int[] ans = {-1,-1};
        ans[0] = search(arr,target,true);
        ans[1] = search(arr,target,false);
        return ans;
    }

    static int search(int[] arr , int target, boolean isFirstIndex){
        int start= 0;
        int end = arr.length-1;
        int ans= -1;
        while(start<=end){
            int mid = start + (end-start)/2;

            if(target > arr[mid] ){
                start = mid+1 ;
            } else if (target < arr[mid]) {
                end= mid -1 ;
            }
            else if(target==arr[mid]){
                ans= mid;
                if(isFirstIndex){
                    end=mid-1;
                }
                else {
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}
