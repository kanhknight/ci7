import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sokoban {
    public static void main(String[] args) {

//        Khoi tao ban do
        String [][] map = {
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"}
        };

//        Khai báo một Array List chứa tất cả các tọa độ trên bản đồ
        ArrayList<Point> positions = new ArrayList<>();
        for (int i = 0; i<map.length; i++){
            for(int j = 0; j<map[i].length; j++){
                positions.add(new Point(j,i));
            }
        }


//        Sinh vi tri ngau nhien cho player!
        Random rand = new Random();
        int player_x = rand.nextInt(3);
        int player_y = rand.nextInt(3);


        System.out.println(positions);

//        Chi dinh hien thi player tai vi tri da sinh
        map[player_y][player_x] = "P";



        while (true) {

//      In ban do
            printmap(map);

//      Ve lai vi tri cu cua player la *
            map[player_y][player_x] = "*";

//      Bam phim de di chuyen
            Scanner scanner = new Scanner(System.in);
            String key = scanner.next();

//            Kiem tra phim duoc bam de di chuyen
            switch (key) {
                case "a":
                    if (player_x ==0){
                        player_x = map.length-1;
                    } else {
                        player_x -=1;
                    }
                    break;
                case "d":
                    if(player_x==map.length-1){
                        player_x =0;
                    } else {
                        player_x +=1;
                    }
                    break;
                case "w":
                    if (player_y ==0){
                        player_y = map.length-1;
                    } else {
                        player_y -=1;
                    }
                    break;
                case "s":
                    if (player_y==map.length-1){
                        player_y=0;
                    } else {
                        player_y +=1;
                    }
                    break;
                    default:
                        System.out.println("Ban da nhap sai phim di chuyen!");

            }

//      Gan vi tri sau khi thay doi toa do x va y cho player
            map[player_y][player_x] = "P";
        }
    }

//    Ham ve ban do
    static void printmap(String[][] map){
        for (int i =0; i < map.length; i++){
            for (int j = 0; j<map.length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
