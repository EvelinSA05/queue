package queue;

import java.util.Scanner;

/**
 *
 * @author EVELIN
 */
class simpul {

    String barang;
    int harga;
    simpul prev, next;

    simpul(String b, int h) {
        barang = b;
        harga = h;
    }
}

class queue {

    simpul front, rear;

    queue() {
        front = rear = null;
    }

    void enqueue(simpul baru) {
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.prev = baru;
            baru.next = rear;
            rear = baru;
        }
        System.out.println("Enqueue Sukses...");
    }

    simpul dequeue() {
        simpul t = null;
        if (front == null) {
            System.out.println("Queue Kosong!");
        } else if (front.prev == null) {
            t = front; // simpan data sebelum menghapus
            front = rear = null;
            System.out.println("Dequeue Sukses..");
        } else {
            t = front;
            simpul temp = front.prev;
            front.prev = null;
            temp.next = null;
            front = temp;
            System.out.println("Dequeue Sukses...");
        }
        return t;
    }

    void view() {
        System.out.println("\nIsi Queue: ");
        for (simpul t = rear; t != null; t = t.next) {
            System.out.print(t.barang + "[" + t.harga + "] ");
        }
        System.out.println("");
    }
}

public class appQueue {

    public static void main(String[] args) {
        simpul s = new simpul("Sepatu", 200000);
        queue q = new queue();
        Scanner sc = new Scanner(System.in);
        int pilih = 0;
        int pemasukan = 0;
        do {
            System.out.println("\nAntrian Pembelian");
            System.out.println("1.Enqueue\n2.Dequeue");
            System.out.println("3.View\n4.Exit");
            System.out.print("Pilih = ");
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.println("\nDaftar Barang");
                    System.out.println("1.Sepatu\n2.Tas");
                    System.out.println("3.Sandal");
                    System.out.print("Pilih = ");
                    int pilih2 = sc.nextInt();
                    switch (pilih2) {
                        case 1:
                            s = new simpul("Sepatu", 200000);
                            break;
                        case 2:
                            s = new simpul("Tas", 150000);
                            break;
                        case 3:
                            s = new simpul("Sandal", 100000);
                            break;
                    }
                    q.enqueue(s);
                    break;
                case 2:
                    simpul t = q.dequeue();
                    if (t != null) {
                        System.out.println("Check out " + t.barang + " [" + t.harga + "] ");
                        //total pemasukan
                        pemasukan = pemasukan + t.harga;
                        System.out.println("Pemasukan: " + pemasukan);
                    }
                    break;
                case 3:
                    q.view();
                    int total = 0;
                    for (simpul temp = q.front; temp != null; temp = temp.prev) {
                        total = total + temp.harga;
                    }
                    System.out.println("Total Transaksi: " + total);
                    break;
                case 4:
                    System.out.println("Thanks..");
            }
        } while (pilih != 4);
    }
}
