
/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */







public class saeedMergeSort {

    

    private int[] numbers;

    private int[] temp;



    public void sorter(int[] values){

        numbers = values;

        temp = new int [values.length];

        

        recMerge(0, values.length - 1);

    }

    

    private void recMerge(int low, int high){

        

        if (low < high){

            //this is wrong middle equals to (low+high)/2

           // int middle = (low + (high - low))/2;

            int middle = (low+high)/2;/*chenyi's change*/

            recMerge(low, middle);

            recMerge(middle+1, high);

            

            merge(low, middle, high);

            

        }

        

    }

    

    public void merge(int low, int middle, int high){

        

        for(int i = low; i <= high ; i++){

            temp[i] = numbers[i];

        }

        

        int i = low;

        int j = middle+1;

        int k = low;

        

        

        while(i <= middle && j <= high){

           if(temp[i] <= numbers[j]){

                numbers[k] = temp[i];

                i++;

                

            }else{

                numbers[k] = temp[j];

                j++;

            }

            k++;   

        }

        

        while(i <= middle){

            numbers[k] = temp[i];

            k++;

            i++;

            

        }

         

    }

    public static void main(String[]args)

    {

    saeedMergeSort mergeSort = new saeedMergeSort();

    int[]numbers = {13, 15, 6 , 1, 22, 44, 1, 3, 6,66,100};

    mergeSort.sorter(numbers);

    for(int i =0;i<numbers.length;i++)

    System.out.print(numbers[i]+" ");

    }

    

    

     

    

}



