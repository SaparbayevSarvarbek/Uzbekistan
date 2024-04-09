package com.example.uzbekistan.Data

interface Interface {
    fun addData(all: ALL)
    fun editData(all: ALL)
    fun deleteData(all: ALL)
    fun list():List<ALL>
    fun addUser(user: User)
    fun userlist():List<User>
    fun getDataByString(string: String):List<String>
}