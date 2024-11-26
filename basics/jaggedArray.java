public class jaggedArray {
    

    public static void main(String args[]){

        // jagged array

        int arr[][] = new int [3][];   // just tell the row number

        arr[0] = new int [4];   // columns size
        arr[1] = new int [1];   // columns size
        arr[2] = new int [5];   // columns size

        

        // taking random input

        for(int i = 0; i < 3 ; i++){


            for(int j = 0; j < arr[i].length; i++){


                arr[i][j] = (int)(Math.random() * 10); 

            }

        }


        // printing

        for(int n[] : arr){


            for(int m : n){

                System.out.print(m);

            }

            System.out.println();

        }



    }

}
