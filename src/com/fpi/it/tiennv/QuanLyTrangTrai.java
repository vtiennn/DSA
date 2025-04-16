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
import java.util.Scanner;
public class QuanLyTrangTrai {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tien = 1000;
        int cayTrong = 0;
        int ngay = 1;

        System.out.println("Chào mừng đến với Trò chơi Quản lý Trang trại!");
        System.out.println("Bạn có 1000 xu để bắt đầu trang trại của mình.");

        while (true) {
            System.out.println("\nNgày " + ngay + ":");
            System.out.println("1. Trồng cây (Chi phí: 100 xu mỗi cây)");
            System.out.println("2. Thu hoạch cây (Kiếm 200 xu mỗi cây)");
            System.out.println("3. Kiểm tra trạng thái");
            System.out.println("4. Kết thúc trò chơi");
            System.out.print("Chọn hành động: ");

            int luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.print("Bạn muốn trồng bao nhiêu cây? ");
                    int soCayTrong = scanner.nextInt();
                    int chiPhi = soCayTrong * 100;
                    if (tien >= chiPhi) {
                        tien -= chiPhi;
                        cayTrong += soCayTrong;
                        System.out.println("Bạn đã trồng " + soCayTrong + " cây.");
                    } else {
                        System.out.println("Không đủ tiền để trồng cây!");
                    }
                    break;
                case 2:
                    System.out.print("Bạn muốn thu hoạch bao nhiêu cây? ");
                    int soCayThuHoach = scanner.nextInt();
                    if (cayTrong >= soCayThuHoach) {
                        cayTrong -= soCayThuHoach;
                        tien += soCayThuHoach * 200;
                        System.out.println("Bạn đã thu hoạch " + soCayThuHoach + " cây.");
                    } else {
                        System.out.println("Bạn không có đủ cây để thu hoạch!");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Trạng thái Trang trại ---");
                    System.out.println("Tiền: " + tien + " xu");
                    System.out.println("Cây trồng: " + cayTrong);
                    break;
                case 4:
                    System.out.println("\nTrò chơi kết thúc! Trạng thái cuối cùng:");
                    System.out.println("Tiền: " + tien + " xu");
                    System.out.println("Cây trồng: " + cayTrong);
                    System.out.println("Cảm ơn bạn đã chơi!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
                    break;
            }

            ngay++;
        }
    }
}

