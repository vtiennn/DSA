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

public class ConsoleFightingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Chào mừng đến với Trò chơi Đấu Võ!");

        // Khởi tạo nhân vật
        int playerHealth = 100;
        int enemyHealth = 100;

        while (playerHealth > 0 && enemyHealth > 0) {
            System.out.println("\n--- Lượt của bạn ---");
            System.out.println("1. Tấn công");
            System.out.println("2. Phòng thủ");
            System.out.print("Chọn hành động: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                int damage = random.nextInt(20) + 5;
                enemyHealth -= damage;
                System.out.println("Bạn đã tấn công đối thủ gây " + damage + " sát thương!");
            } else if (choice == 2) {
                int heal = random.nextInt(10) + 5;
                playerHealth += heal;
                System.out.println("Bạn đã phòng thủ và hồi phục " + heal + " máu!");
            } else {
                System.out.println("Hành động không hợp lệ!");
                continue;
            }

            // Đối thủ tấn công
            if (enemyHealth > 0) {
                System.out.println("\n--- Lượt của Đối thủ ---");
                int enemyChoice = random.nextInt(2);
                if (enemyChoice == 0) {
                    int enemyDamage = random.nextInt(20) + 5;
                    playerHealth -= enemyDamage;
                    System.out.println("Đối thủ đã tấn công bạn gây " + enemyDamage + " sát thương!");
                } else {
                    int enemyHeal = random.nextInt(10) + 5;
                    enemyHealth += enemyHeal;
                    System.out.println("Đối thủ đã phòng thủ và hồi phục " + enemyHeal + " máu!");
                }
            }

            // Hiển thị trạng thái sức khỏe
            System.out.println("\n--- Trạng thái ---");
            System.out.println("Máu của bạn: " + playerHealth);
            System.out.println("Máu của đối thủ: " + enemyHealth);
        }

        if (playerHealth <= 0) {
            System.out.println("\nBạn đã thua trong trận đấu!");
        } else {
            System.out.println("\nChúc mừng! Bạn đã chiến thắng trận đấu!");
        }

        System.out.println("\nTrò chơi kết thúc! Cảm ơn bạn đã chơi!");
    }
}
