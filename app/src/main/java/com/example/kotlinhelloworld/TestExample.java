package com.example.kotlinhelloworld;

/**
 * Created by ManzarSiddique on 24-07-2017.
 */

public class TestExample {


    static String firstName = "makhmoorshakir";
    static String secondName = "substring(makhmoorshakir, 1, 5)";
    String[] temp;

    public static void main(String[] args){
        int asciiOne = 01;
//        System.out.println("Ascii to string : "+Character.toString((char)01));

//        System.out.println("Sub string is : "+javaSubString(firstName, 10, 3));
        test();
//        String[] temp = {"data111111111,1,5", "data22222222222,2,6", "data3333333333,3,7"};
//        example(temp);

    }

    public static String javaSubString(String data, int start, int count){
        int lastIndex = start + count + 1;
        String output = data.substring(start, lastIndex) + Character.toString((char)01);
        return output;
    }


    public static void example(String[] arr){
        String concatenate = "";
        for (int i=0; i<arr.length; i++){
            String extract = arr[i];
            String[] temp = extract.split(",");
            String data = temp[0];
            int start = Integer.parseInt(temp[1]);
            int end = Integer.parseInt(temp[2]);

            int lastIndex = start + end + 1;
            if (i==arr.length-1){
                concatenate = concatenate + data.substring(start, lastIndex);
            }else{
                concatenate = concatenate + data.substring(start, lastIndex) + Character.toString((char)01);
            }

//            String output = data.substring(start, lastIndex) + Character.toString((char)01);
//            System.out.println("Temp data : "+i + " :::::: "+concatenate);
        }
        System.out.println("Result Temp data : " + " :::::: "+concatenate);
    }

    public static void test(){
        String str="1,2|3,5|3,12|15,4|19,2";

        String data="m a n z a r hussainsiddiquetestexample";

        String[] temp;

        String concatenate = "";

        String delimiter = "\\|";

        temp = str.split(delimiter);
//        System.out.println("First Array : "+Arrays.toString(temp));

        for (int i =0; i<temp.length; i++){

            String str1= temp[i];

            String[] temp1 = str1.split(",");

//            System.out.println("Second Array : "+Arrays.toString(temp1));

            int start = Integer.parseInt(temp1[0]);

            int end = Integer.parseInt(temp1[1]);

            int firstIndex = start - 1;

            int lastIndex = start + end - 1;

            if (i==temp.length-1){

                concatenate = concatenate + data.substring(firstIndex, lastIndex).replaceFirst("\\s+$", "");

            }else{

                concatenate = concatenate + data.substring(firstIndex, lastIndex).replaceFirst("\\s+$", "") + Character.toString((char)01);

            }
            System.out.println("backspace data : " + concatenate);
        }
        System.out.println("concatenate data : " + concatenate);
//        DATA =concatenate;

    }

}

