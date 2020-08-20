class SortArr{
    public static void main(String[] args){
        int[] aray = {14,22,0,1,24,9};
        // bubbleSort(aray);
        selectionSort(aray);
    }

    public static void display(int[] arr){
        for (int index = 0; index < arr.length; index++) {
            System.out.println(arr[index]);
        }
    }

    // 22,11,44
    public static void selectionSort(int[] arr){
        for(int counter=0;counter<arr.length-1;counter++){
            int min = counter;

            for(int j=counter+1; j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp = arr[min];
            arr[min]=arr[counter];
            arr[counter]=temp;
        }
        display(arr);
    }



    public static void bubbleSort(int[] arr){
        // since after all sorted, last one will automatically at correct
        // position. saving one loop run
        for(int counter=0;counter<arr.length-1;counter++){
            // to ignore correctly placed elements towards end
            for(int j=0;j<(arr.length-1-counter);j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        display(arr);
    } 
}
