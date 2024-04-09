package com.example.uzbekistan.Data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLite(context: Context) : SQLiteOpenHelper(context, DB_Name, null, DB_version),Interface {
    companion object {
        const val DB_Name = "Uzbekistan"
        const val DB_version = 1
        const val TB_name="TB_name"
        const val ID="ID"
        const val viloyat = "viloyat"
        const val tuman = "Tuman"
        const val mahalla = "Mahalla"
        const val User_TB="Foydalanuvchilar"
        const val Ismi = "Ismi"
        const val Familiyasi = "Familiyasi"
        const val telefon = "Telefon"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query0="Create table $TB_name($ID integer not null primary key autoincrement,$viloyat text not null,$tuman text, $mahalla text )"
        val query1="Create table $User_TB($ID integer not null primary key autoincrement,$Ismi text not null,$Familiyasi text, $telefon text )"
       db?.execSQL(query0)
       db?.execSQL(query1)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    override fun addUser(user: User) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Ismi, user.Ismi)
        contentValues.put(Familiyasi, user.Familiyasi)
        contentValues.put(telefon, user.telraqami)
        database.insert(User_TB, null, contentValues)
    }

    override fun userlist(): List<User> {
        val list = ArrayList<User>()
        val database = this.readableDatabase
        val query = "select * from $User_TB"
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val Ismi = cursor.getString(1)
                val Familiyai = cursor.getString(2)
                val telraqami = cursor.getString(3)
                val data = User(id, Ismi, Familiyai, telraqami)
                list.add(data)
            } while (cursor.moveToNext())
        }
        return list
    }

    override fun addData(all: ALL) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(viloyat, all.viloyat)
        contentValues.put(tuman, all.tuman)
        contentValues.put(mahalla, all.mahalla)
        database.insert(TB_name, null, contentValues)
    }

    override fun editData(all: ALL) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(viloyat, all.viloyat)
        contentValues.put(tuman, all.tuman)
        contentValues.put(mahalla, all.mahalla)
        database.update(TB_name, contentValues, "ID=?", arrayOf(all.id.toString()))
    }

    override fun deleteData(all: ALL) {
        val database = this.writableDatabase
        database.delete(TB_name, "$ID=?", arrayOf(all.id.toString()))
    }
    override fun list(): List<ALL> {
        val list = ArrayList<ALL>()
        val database = this.readableDatabase
        val query = "select * from $TB_name"
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val viloyat = cursor.getString(1)
                val tuman = cursor.getString(2)
                val mahalla = cursor.getString(3)
                val data = ALL(id, viloyat, tuman, mahalla)
                list.add(data)
            } while (cursor.moveToNext())
        }
        return list
    }

    override fun getDataByString(string: String): List<String> {
        val list = ArrayList<String>()
        val database = this.readableDatabase
        val query = "select $tuman from $TB_name where $viloyat='$string'"
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val tuman = cursor.getString(0)
                list.add(tuman)
            } while (cursor.moveToNext())
        }
        return list
    }

}
