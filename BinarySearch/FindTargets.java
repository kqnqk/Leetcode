package BinarySearch;
public class FindTargets {
    public static void main(String[] args) {
        int [] arr  ={1,3,5,6,6,6,8,8,9};

        var lI = findTargetL(arr,6);
        var rI = findTargetR(arr,6);

        if(lI == -1 && rI == -1) System.out.println(-1);
        else System.out.println(rI - lI + 1);
    }

    public static int findTargetL(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int lTI = -1;
        while(l <= r) {
            int m = (l+r)/2;
            if(target<=arr[m]){
                if(arr[m] == target) lTI = m;
                r = m-1;
            }else{
                l  = m+1;
            }
        }
        return lTI;
    }

    public static int findTargetR(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int rTI = -1;
        while(l <= r) {
            int m = (l+r)/2;
            if(target>=arr[m]){
                if(arr[m] == target) rTI = m;
                l= m +1;
            }else{
                r = m-1;
            }
        }
        return rTI;
    }
}

//  0 1 2 3 4 5 6 7 8 9
// {1,3,5,6,7,7,7,7,8,9}
//                  l r
//                r


// {1,3,5,6,8,8,9}
//  l           r
//        r 