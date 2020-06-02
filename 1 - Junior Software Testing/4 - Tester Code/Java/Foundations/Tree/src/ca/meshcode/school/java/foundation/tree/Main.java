package ca.meshcode.school.java.foundation.tree;

public class Main {

    public static void main(String[] args) {

        //
        //ACTUAL WORKING TREE
        //
        String drawTreePart = "*";
        int treeHeight = 5;

        for (int rowFromTop = 0; rowFromTop < treeHeight; rowFromTop++) {
            for (int spot = 0; spot < treeHeight * 2; spot++) {
                if (spot < (treeHeight - rowFromTop) || spot > (treeHeight + rowFromTop)) {
                    System.out.print(" ");
                } else {
                    System.out.print(drawTreePart);
                }
            }
            System.out.println("");
        }

        //
        //MY OWN ATTEMPT
        //
//        int treeheight = 3;
//        for(int i=treeheight; i>=1; i--){
//            for(int j=treeheight*2+1;j>=1;j--){
//                if (j!=treeheight+1){
//                    System.out.println("o");
//                } else { System.out.println("x");
//                }
//                System.out.println("The value of i is: "+i);
//            }
//            System.out.println("The value of i is: "+i);
//        }

        //
        //RAPID PROTOTYPER
        //
        String rysuj = "*";
        int ileLinii = 5;

        for (int linia = 0; linia < ileLinii; linia++) {
            for (int ktoryZnak = 0; ktoryZnak < ileLinii * 2; ktoryZnak++) {
                if (ktoryZnak < (ileLinii - linia) || ktoryZnak > (ileLinii + linia)) {

                    System.out.print("Rw " + linia);
                    System.out.print(" Spot: " + ktoryZnak);
                    if (ktoryZnak < (ileLinii - linia)) { System.out.print(" is SMALLER than: ");}
                    System.out.print(" Ht - Rw: " + (ileLinii - linia));
                    if (ktoryZnak > (ileLinii + linia)) { System.out.print(" Spot is GREATER than: ");}
                    System.out.print(" Ht + Rw: " + (ileLinii + linia) + " ");
                    System.out.println("<SPACE> ");
                   //System.out.print(" ");
                } else {
                    System.out.print("Rw " + linia);
                    System.out.print(" Spot: " + ktoryZnak);
                    System.out.print(" Ht - Rw: " + (ileLinii - linia));
                    System.out.print(" Ht + Rw: " + (ileLinii + linia) + " ");
                    System.out.print("<STAR>");
                    System.out.println();
                }
            }
            System.out.println("");
        }
    }



}
