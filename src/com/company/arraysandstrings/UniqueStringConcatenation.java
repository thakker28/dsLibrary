package arraysandstrings;

import java.util.Scanner;

public class UniqueStringConcatenation {


        public static void main (String args[]) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            String arr[] = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = scanner.next();
            }
            String ans[] =  subsequenceHelper(arr,0);
            int max =0;
            for(String s : ans)
            {
                if(s.length()>max)
                {
                    max = s.length();
                }
            }
            System.out.print(max);
        }

        private static boolean concatenate (String s1 , String s2)
        {
            int freq[] = new int[26];
            for(int i=0 ; i <s1.length();i++)
            {
                if(freq[s1.charAt(i)-'a']==1)
                {
                    return false;
                }
                else
                {
                    freq[s1.charAt(i)-'a']++;
                }
            }
            for(int i=0;i<s2.length();i++)
            {
                if(freq[s2.charAt(i)-'a']==1)
                {
                    return false;
                }
            }

            return true;
        }


        private static String[] subsequenceHelper (String arr[],int index)
        {
            if(index== arr.length)
            {

                String s[] = new String[]{""};
                return s;
            }
            String smallOutput1[] = subsequenceHelper(arr,index+1);
         //  String smallOutput2[] = subsequenceHelper(arr,index);
            String output[] = new String[smallOutput1.length*2];
            int k=0;
            for(int i=0;i<smallOutput1.length;i++)
            {
                if(concatenate(arr[index],smallOutput1[i]))
                {
                    output[k] = arr[index]+smallOutput1[i];
                }
                else
                {
                    output[k] = smallOutput1[i];
                }
                k++;
            }
  //          output[k] = concatenate(arr[0],smallOutput1[0]) ? arr[0]+smallOutput1[0] : "";
            for(String s : smallOutput1)
            {
                output[k] = s;
                k++;
            }
            return output;
        }


    }

