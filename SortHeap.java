public class SortHeap{

    static int[] heapsort(int arr[]){
     
    int n=arr.length;
    //conver array to heap
    for(int i=n/2-1;i>=0;i--){
    heapify(arr,n,i);
    }
    //extract the max and place it at the end
    for(int i=n-1;i>0;i--){
    // the max will  be the first element
    int temp=arr[0];
    arr[0]=arr[i];
    arr[i]=temp;
    heapify(arr,i,0);
    }
    return arr;
    }
    static void heapify(int arr[],int size,int start){

        //zero based indexing
        int largest=start;
        int left=start*2+1;
        int right=start*2+2;

        if(left<size && arr[left]>arr[largest])
        largest=left;
        if(right<size && arr[right]>arr[largest])
        largest=right;

        if(largest!=start){
            int temp=arr[largest];
            arr[largest]=arr[start];
            arr[start]=temp;
            heapify(arr,size,largest);
        }
    }
    public static void main(String[] args) {
        int arr[]={3,5,1,6,0,2};
        int[] res=heapsort(arr);
        for(int element:res){
            System.out.print(element+" ");
        }
    }
}
