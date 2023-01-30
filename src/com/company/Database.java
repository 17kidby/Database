package com.company;

public class Database {

    private String filename;
    private int rowWidth;

    public Database(String filename, int rowWidth) {
        this.filename = filename;
        this.rowWidth = rowWidth;
    }

    // add a new record to the end of the database
    public void appendRecord(String data) {
        // TODO: Pad the data to the correct record width
        // TODO: Report an error if the data is too long for the record
        String temp = "";
        int rows = FileHandler.countLines(filename);
        String line = FileHandler.readLineAt(filename, rows);

        if (line != null) {
            if (line.length() < 10) {
                for (int i = 0; i < 10 - line.length(); i++) {
                    temp = temp + " ";
                }


            } else if (line.length() > 10) {
                line = line.substring(0, Math.min(line.length(), 10));
            }

            FileHandler.writeLineAt(filename, line + temp, rows);
            FileHandler.appendLine(filename, data);
        }
    }

    // delete the record at the specified row
    public void deleteRecord(int rowNumber) {
        // TODO: replace this placeholder code
    }

    // return the record at the specified row
    public String getRecord(int rowNumber) {


        return ""; // TODO: replace this placeholder code
    }

    // return the number of records in the database
    public int getRecordCount() {
        return (FileHandler.countLines(filename));

    }

    // search for a record matching data
    // return true if found
    public boolean findRecord(String data) {
        return false; // TODO: replace this placeholder code
    }

}

