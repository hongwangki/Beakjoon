import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;


//2명 난쟁이들을 빼서 찾는 방식
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[9]; // 9명의 난쟁이 키 배열 선언
        int total = 0; //총 키를 미리 구함

        // 9명의 난쟁이 키 입력
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }


        //총합에서 두명의 난쟁이를 제외했을때 키가 100인 경우를 찾음
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(total-(arr[i]+arr[j])==100){
                    arr[i]=-1;
                    arr[j]=-1;
                    flag = true;
                }
            }
            if(flag) break;
        }


        Arrays.sort(arr);
        
        //정렬 시켰으므로 0번 1번 인덱스에는 -1이 있기에 2부터 출력
        for (int i = 2; i < arr.length; i++) {
            System.out.println(arr[i]);
        }



    }
}


//7명 난쟁이들을 찾는 방식
/*
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[9]; // 9명의 난쟁이 키 배열 선언
        Vector<Integer> v = new Vector<>(); // 합이 100인 난쟁이 키를 저장할 벡터

        // 9명의 난쟁이 키 입력
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // 7명의 합이 100이 되는 경우 찾기
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int l = k + 1; l < arr.length; l++) {
                        for (int m = l + 1; m < arr.length; m++) {
                            for (int n = m + 1; n < arr.length; n++) {
                                for (int o = n + 1; o < arr.length; o++) { // 7번째 난쟁이 추가
                                    if (arr[i] + arr[j] + arr[k] + arr[l] + arr[m] + arr[n] + arr[o] == 100) {
                                        v.add(arr[i]);
                                        v.add(arr[j]);
                                        v.add(arr[k]);
                                        v.add(arr[l]);
                                        v.add(arr[m]);
                                        v.add(arr[n]);
                                        v.add(arr[o]);

                                        // 정렬 후 출력
                                        Collections.sort(v);
                                        for (int num : v) {
                                            System.out.println(num);
                                        }
                                        return; // 정답을 찾으면 프로그램 종료
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
*/
