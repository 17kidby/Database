package com.company;


public class Main {

    public static void main(String[] args) {
        // test the database works
        System.out.println("Database");
        Database db = new Database("test.txt", 10);
        //db.appendRecord("1.ABCDEFGH");
        //db.appendRecord("2.ABCDEFGH");
        //db.appendRecord("3.ABCDEFGH");
       // db.appendRecord("4.ABCDEFGH");
        //System.out.println(db.getRecord(2));	 // should be "3.ABCDEFGH"
        //System.out.println(db.findRecord("EBCDEFGHIJ")); // false
       // System.out.println(db.findRecord("2.ABCDEFGH")); // true
       // System.out.println("count = " + db.getRecordCount()); // 4
        FileHandler.appendLine("test.txt", "sans");
        FileHandler.appendLine("test.txt", "jesus");
        System.out.println(FileHandler.readLineAt("test.txt", 0));
        System.out.println(FileHandler.readLineAt("test.txt", 1));
        FileHandler.writeLineAt("test.txt", "peor", 2);
    }
}
