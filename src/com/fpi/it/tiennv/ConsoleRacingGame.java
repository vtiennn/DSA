/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpi.it.tiennv;

/**
 *
 * @author ROG
 */
import java.util.Random;
import java.util.Scanner;

public class ConsoleRacingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Chào mừng đến với Trò chơi Đua Xe!");
        System.out.println("Bạn sẽ thi đấu với 3 đối thủ khác trong cuộc đua.");
        
        String[] racers = {"Bạn", "Đối thủ 1", "Đối thủ 2", "Đối thủ 3"};
        int[] positions = {0, 0, 0, 0};

        System.out.println("\nCuộc đua bắt đầu!");
        boolean raceOver = false;

        while (!raceOver) {
            System.out.println("\nNhấn Enter để tiến về phía trước...");
            scanner.nextLine();

            // Di chuyển từng tay đua ngẫu nhiên
            for (int i = 0; i < racers.length; i++) {
                positions[i] += random.nextInt(6) + 1;
                System.out.println(racers[i] + " đang ở vị trí: " + positions[i]);

                // Kiểm tra nếu ai đó đã đến vị trí 100
                if (positions[i] >= 100) {
                    System.out.println("\n" + racers[i] + " đã chiến thắng cuộc đua!");
                    raceOver = true;
                    break;
                }
            }
        }

        System.out.println("\nTrò chơi kết thúc! Cảm ơn bạn đã chơi!");
    }
}


