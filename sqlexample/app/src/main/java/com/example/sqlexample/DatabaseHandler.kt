package com.example.sqlexample

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "db"
val TABLE_NAME = "Users"
val COL_NAME = "name"
val COL_AGE = "age"

class DataBaseHandler (var context: Context) :SQLiteOpenHelper(context, DATABASE_NAME, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {

        var table = " create table $TABLE_NAME( $COL_NAME varchar(200), $COL_AGE  int not null)"
        db?.execSQL(table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun insertData (user:User){
        val db:SQLiteDatabase = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_AGE, user.age)
        var result:Long = db.insert(TABLE_NAME, null, cv)
        if(result == -1.toLong()) {
            Toast.makeText(context,"FAILED",Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(context,"SUCCESS", Toast.LENGTH_LONG).show()
        }
    }

}