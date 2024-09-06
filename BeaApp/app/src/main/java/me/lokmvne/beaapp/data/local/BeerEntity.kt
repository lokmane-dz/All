package me.lokmvne.beaapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(primaryKeys = ["id"])      // This is the same as the @PrimaryKey annotation
@Entity()
data class BeerEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val firstBrewed: String,
    val imageUrl: String?
)