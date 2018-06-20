import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sokoban {
    public static void main(String[] args) {

//        Khoi tao ban do
        String [][] map = {
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"}
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
        Point point = positions.remove(rand.nextInt(positions.size()));
        int player_x = point.x;
        int player_y = point.y;


//        Chi dinh hien thi player tai vi tri da random
        map[player_y][player_x] = "P";

//        Xoa vi tri cua player ra khoi mang vi tri va random vi tri cho enemy trong mang da duoc remove
        point = positions.remove(rand.nextInt(positions.size()));
        int enemy_x = point.x;
        int enemy_y = point.y;

//        Hien thi Enemy tai vi tri da random
        map[enemy_y][enemy_x] = "E";



        // Enemy thu 2
        point = positions.remove(rand.nextInt(positions.size()));
        int enemy_2_x = point.x;
        int enemy_2_y = point.y;

        // Hien thi Enemy thu 2
        map[enemy_2_y][enemy_2_x] = "E";

//        Sinh box tren ban do
        point = positions.remove(rand.nextInt(positions.size()));
        int box_x = point.x;
        int box_y = point.y;

        map[box_y][box_x] = "B";

//        Sinh box tren ban do
            point = positions.remove(rand.nextInt(positions.size()));
        int box_2_x = point.x;
        int box_2_y = point.y;

        map[box_2_y][box_2_x] = "B";

//        Sinh box tren ban do
            point = positions.remove(rand.nextInt(positions.size()));
        int box_3_x = point.x;
        int box_3_y = point.y;

        map[box_3_y][box_3_x] = "B";


//        Sinh vi tri qua' tren ban do
        int gift_x = rand.nextInt(map.length);
        int gift_y = rand.nextInt(map.length);

// Hien thi qua tren ban do
        map[gift_y][gift_x] = "G";



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


//           Vẽ lại vị trí của enemy là *
            map[enemy_y][enemy_x] = "*";
            map[enemy_2_y][enemy_2_x] = "*";

            //Kiểm tra vị trí của enemy có trùng với quà hay không? Nếu không thì hiển thị quà, nếu có thì vẽ Enemy:
            if((enemy_x !=gift_x && enemy_y != gift_y) || (enemy_2_x !=gift_x && enemy_2_y !=gift_y)){
                map[gift_y][gift_x] = "G";
            }
// Di chuyen vi tri Enemy theo chieu ngang va chieu doc
// khong vuot ra khoi vi tri cua ban do !
            enemy_x = (enemy_x + 1) % map.length;
            enemy_2_y = (enemy_2_y + 1) % map[0].length;

//            Enemy gặp tường thì bật lại
            if(enemy_x==(map.length -1)){
                enemy_x = ((enemy_x - rand.nextInt(map.length))%map.length);
            }

            if(enemy_2_y ==(map[0].length -1)){
                enemy_2_y = ((enemy_2_y - rand.nextInt(map[0].length))%map[0].length);
            }

//            Kiem tra vi tri cua player va qua, neu player an qua thi thong bao chien thang, game ket thuc,
// neu player cham enemy thi thong bao thu cuoc va ket thuc game.
            if (player_x == gift_x && player_y == gift_y){
                System.out.println("You Win! Cheeeeeeerrrr !");
                break;
            }

            //Vẽ lại vị trí của enemy là E
            map[enemy_y][enemy_x] = "E";
            map[enemy_2_y][enemy_2_x] = "E";



//      Gan vi tri sau khi thay doi toa do x va y cho player
            map[player_y][player_x] = "P";

            if ((player_x == enemy_x && player_y == enemy_y) || (player_x == enemy_2_x && player_y == enemy_2_y)){
                System.out.println("OMG! You Losssseeeeee!");
                break;
            }
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
