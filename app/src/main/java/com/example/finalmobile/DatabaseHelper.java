package com.example.finalmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.finalmobile.DataModels.PlaceData;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, 3);
    }

    // To create table on DB
    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("CREATE TABLE USERS(username TEXT primary key, password TEXT)");
        myDB.execSQL("CREATE TABLE PLACES(name TEXT primary key, type TEXT, lat REAL, lng REAL, rating REAL, imageUrl INTEGER, address TEXT, description TEXT, isVisited BOOLEAN)");
        myDB.execSQL("CREATE TABLE SAVED_PLACES(name TEXT primary key, type TEXT, lat REAL, lng REAL, rating REAL, imageUrl INTEGER, address TEXT, description TEXT, isVisited BOOLEAN)");
//        myDB.execSQL("CREATE TABLE PLACES(name TEXT primary key, type TEXT)");
    }

    // Drop Table if already exists
    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("DROP TABLE IF EXISTS USERS");
        myDB.execSQL("DROP TABLE IF EXISTS PLACES");
        myDB.execSQL("DROP TABLE IF EXISTS SAVED_PLACES");
        onCreate(myDB);
    }

    // To insert data
    public Boolean insertUserData(String username, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        Long result = myDB.insert("users", null, contentValues);
        Log.i("TAGGGGGGGGGGG", "RESULT = " + result.toString());

        if (result >= 1) return false;
        else return true;
    }

    // To insert data
    public Boolean insertPlaceData(String name, String type, double lat, double lng, float rating, int imageUrl, String address, String description, boolean isVisited) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("type", type);
        contentValues.put("lat", lat);
        contentValues.put("lng", lng);
        contentValues.put("rating", rating);
        contentValues.put("imageUrl", imageUrl);
        contentValues.put("address", address);
        contentValues.put("description", description);
        contentValues.put("isVisited", isVisited);
        Long result = myDB.insert("places", null, contentValues);
        Log.i("TAGGGGGGGGGGG", "RESULT = " + result.toString());

        if (result >= 0) return true;
        return false;
    }

    public Boolean savePlace(String name, String type, double lat, double lng, float rating, int imageUrl, String address, String description, boolean isVisited) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("type", type);
        contentValues.put("lat", lat);
        contentValues.put("lng", lng);
        contentValues.put("rating", rating);
        contentValues.put("imageUrl", imageUrl);
        contentValues.put("address", address);
        contentValues.put("description", description);
        contentValues.put("isVisited", isVisited);
        Long result = myDB.insert("saved_places", null, contentValues);
        Log.i("TAGGGGGGGGGGG", "RESULT = " + result.toString());

        if (result >= 0) return true;
        return false;
    }

    // To check username
    public Boolean checkUsername(String username) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM USERS WHERE username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }

    // To check password
    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?",
                new String[]{username, password});

        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }

    public Boolean deleteAccount(String username) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        int result = myDB.delete("users", "username = ?", new String[]{username});
        Log.i("TAGGGGGGGGGGG", "RESULT = " + result);

        if (result > 0) return true;
        return false;
    }

    public Boolean deleteSavedPlace(String name) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        int result = myDB.delete("saved_places", "name = ?", new String[]{name});
        Log.i("TAGGGGGGGGGGG", "Delete saved place = " + result);

        if (result > 0) return true;
        return false;
    }

    public Boolean changePassword(String username, String newPassword) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", newPassword);
        int result = myDB.update("users", contentValues, "username = ?", new String[]{username});
        Log.i("TAGGGGGGGGGGG", "RESULT = " + result);

        if (result > 0) return true;
        return false;
    }

    public Boolean isSavedPlace(String name) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        int result = myDB.update("saved_places", contentValues, "name = ?", new String[]{name});
        Log.i("TAGGGGGGGGGGG", "Saved Places RESULT = " + result);

        if (result > 0) return true;
        return false;
    }


    public Boolean changeVisited(String name, Boolean value) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isVisited", value);
        int result = myDB.update("places", contentValues, "name = ?", new String[]{name});
        Log.i("TAGGGGGGGGGGG", "isVisited RESULT = " + result);

        if (result > 0) return true;
        return false;
    }


    public ArrayList<PlaceData> getAllPlaces() {
        String query = "SELECT * FROM PLACES";
        SQLiteDatabase myDB = this.getWritableDatabase();

        Cursor cursor = myDB.rawQuery(query, null);
        ArrayList<PlaceData> places = new ArrayList<PlaceData>();

        if (cursor.getCount() > 0) {
            PlaceData placeData;
            while (cursor.moveToNext()) {
                placeData = new PlaceData(
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("type")),
                        cursor.getDouble(cursor.getColumnIndex("lat")),
                        cursor.getDouble(cursor.getColumnIndex("lng")),
                        cursor.getFloat(cursor.getColumnIndex("rating")),
                        cursor.getInt(cursor.getColumnIndex("imageUrl")),
                        cursor.getString(cursor.getColumnIndex("address")),
                        cursor.getString(cursor.getColumnIndex("description")),
                        cursor.getInt(cursor.getColumnIndex("isVisited")) > 0);
                places.add(placeData);
            }
        }
        return places;
    }

    public ArrayList<PlaceData> getAllSavedPlaces() {
        String query = "SELECT * FROM SAVED_PLACES";
        SQLiteDatabase myDB = this.getWritableDatabase();

        Cursor cursor = myDB.rawQuery(query, null);
        ArrayList<PlaceData> places = new ArrayList<PlaceData>();

        if (cursor.getCount() > 0) {
            PlaceData placeData;
            while (cursor.moveToNext()) {
                placeData = new PlaceData(
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("type")),
                        cursor.getDouble(cursor.getColumnIndex("lat")),
                        cursor.getDouble(cursor.getColumnIndex("lng")),
                        cursor.getFloat(cursor.getColumnIndex("rating")),
                        cursor.getInt(cursor.getColumnIndex("imageUrl")),
                        cursor.getString(cursor.getColumnIndex("address")),
                        cursor.getString(cursor.getColumnIndex("description")),
                        cursor.getInt(cursor.getColumnIndex("isVisited")) > 0);
                places.add(placeData);
            }
        }
        return places;
    }
}
