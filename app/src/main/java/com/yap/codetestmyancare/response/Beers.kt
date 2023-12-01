/*
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beers")
data class Beers(
    @PrimaryKey val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val imageUrl: String
)*/


package com.yap.myancare.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "beers")
data class Beer(
    @SerializedName("id")
    @PrimaryKey val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image_url")
    val imageUrl: String
)
