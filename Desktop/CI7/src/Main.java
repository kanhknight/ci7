import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Helo!");

//        int a = 1;
//
//        long b = 5;
//
//        long c = a + b;
//
//        System.out.println(c);
//
//        double d = Math.pow(2,6);
//
//        System.out.println(d);
//
//        for (int i =0; i<6; i++){
//            System.out.println(i);
//        }
//
////        while:
//        int i = 0;
//        while (i<6){
//            System.out.print(i);
//            i+=1;
//        }
////        do while:
//        int j = 0;
//        do{
//            j++;
//            System.out.print(" " + j);
//        } while (j<6);


//        Array
//        int[] array = new int[10];
//        array[0] = 2;
//
//        System.out.println(array[0]);
//
//        for (int i = 0; i<array.length; i++){
//            array[i] = i;
//            System.out.println(i);
//        }
//
//        for (int element: array
//             ) {
//            System.out.print(element);
//
//        }

//        Mang tinh khong thay doi duoc
        String [] list = {
                "A", "B", "C", "D", "F"
        };

//        Mảng động thay đổi được
        ArrayList <String> arrayList = new ArrayList<>();

//        Them 1 phan tu vao mang
        arrayList.add("ABC");
        arrayList.add("DEF");

//        Them 1 phan tu vao dia chi xac dinh torng mang
        arrayList.add(2, "XTCS");

//        Xoa 1 vi tri nao do trong mang
        arrayList.remove(0);

//        Lay ra 1 phan tu trong mang
        String element = arrayList.get(2);

//        Duyet mang
//        for (int i = 0; i<arrayList.size(); i++){
//            System.out.println(arrayList.get(i));
//        }
// Cach Duyet thu 2:
//        for (String element : arrayList){
//            System.out.println(element);
//        }

//        Khoi Tao 1 mang ArrayList co gia tri cho truoc
//        hoi lai

//        Doc gia tri nhap vao tu ban phim
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
//        int x = scanner.nextInt();
    }
}
