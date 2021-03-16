import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TestTest {
    public static void main(String[] args) {
        Solution solution =new Solution();
        int[] a ={1,2};
        int[] n ={3,4};
        solution.findMedianSortedArrays(a,n);

    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int mergeNumsLength;
        int[] mergeNums = new int[nums1Length+nums2Length];
        int i=0,j=0,k=0;
        while(i!=nums1Length&&j!=nums2Length){
            if(nums1[i]<=nums2[j]){
                mergeNums[k]=nums1[i];
                i++;
                k++;
                continue;
            }
            if(nums2[j]<=nums1[i]){
                mergeNums[k]=nums2[j];
                j++;
                k++;
                continue;
            }
        }
        if(i==nums1Length&&j!=nums2Length){
            for(j=j;j<nums2Length;j++){
                mergeNums[k]=nums2[j];
                k++;
            }
        }
        if(j==nums2Length&&i!=nums1Length){
            for(i=i;i<nums1Length;i++){
                mergeNums[k]=nums1[i];
                k++;
            }
        }
        mergeNumsLength=mergeNums.length;
        if(mergeNumsLength%2==0){
            System.out.println((double)(mergeNums[mergeNumsLength/2-1]+mergeNums[mergeNumsLength/2])/2);
            return    mergeNums[mergeNumsLength/2-1]+mergeNums[mergeNumsLength/2];
        }else{
            System.out.println(mergeNums[mergeNumsLength/2]);
            return mergeNums[mergeNumsLength/2];
        }
    }
}