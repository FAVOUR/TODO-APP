package com.example.todo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by Olije Favour on 11/28/2019.
 *Copyright (c) 2019    All rights reserved.
 */


/**
 * Immutable model class for a Task. In order to compile with Room, we can't use @JvmOverloads to
 * generate multiple constructors.
 *
 * @param title       title of the task
 * @param description description of the task
 * @param isCompleted whether or not this task is completed
 * @param id          id of the task
 */


@Entity(tableName = "Tasks")
class Task @JvmOverloads constructor(

    @ColumnInfo(name = "title") val title:String="",
    @ColumnInfo(name = "description") val description:String="",
    @ColumnInfo(name = "completed") val isCompleted:Boolean=false,
    @PrimaryKey @ColumnInfo(name = "entryid") val id:String=UUID.randomUUID().toString()){

    val titleForList: String
        get() = if (title.isNotEmpty()) title else description


    val isActive
        get() = !isCompleted

    val isEmpty
        get() = title.isEmpty() || description.isEmpty()
}