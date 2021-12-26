/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Arrays;

/**
 *
 * @author sahrul
 */


public class KotakOrder {
  private int maxAmount = 0;
  private int currentIndex = 0;
  private String[] items = new String[1];

  void setMaxItemAmount(int maxAmount) {
    this.maxAmount = maxAmount;
    this.items = new String[this.maxAmount];
  }

  void addItem(String item) throws ArrayIndexOutOfBoundsException {
    this.items[this.currentIndex] = item;
    this.currentIndex++;
  }

  String[] getItems() {
    return this.items;
  }
  
  public static void main(String[] args) {
    KotakOrder kotakOrder = new KotakOrder();
    Scanner jumlahItemHandler = new Scanner(System.in);
    Scanner productInput = new Scanner(System.in);
    Scanner statusInput = new Scanner(System.in);
    boolean addingProduct = true;

    System.out.print("Mau muat berapa baarang ? : ");
    int jumlahMaksimalProduk = jumlahItemHandler.nextInt();
    kotakOrder.setMaxItemAmount(jumlahMaksimalProduk);
    System.out.println(jumlahMaksimalProduk);

    try {
      while(addingProduct) {
        System.out.println();
        System.out.println("=======================");
        System.out.println("[1] Tambah Barang ");
        System.out.println("[2] Keluar ");
        System.out.println("=======================");
        System.out.println();

        System.out.print("Pilih : ");
        int decision = statusInput.nextInt();

        if (decision == 1) {
          System.out.print("Masukan nama produk      : ");
          String produk = productInput.nextLine();
          kotakOrder.addItem(produk);

          System.out.println("BARANG DITAMBAHKAN");
        }

        if (decision == 2) {
          addingProduct = false;
        }
      }


    } catch (ArrayIndexOutOfBoundsException err) {
      System.out.println("Kotak orderan anda sudah penuh");
    } finally {
      System.out.println("Isi kotak order anda : " + Arrays.deepToString(kotakOrder.getItems()));
    }
  } 
}