package com.daniel.evaluacion04.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "player")
@Parcelize
data class Player(
    @PrimaryKey
    val id:Int,
    @SerializedName("image_path")
    val urlImage: String,

    val firstname: String,
    val lastname: String,
    val height: Int,
    val weight: Int,
    @SerializedName("date_of_birth")
    val date_of_birth:  String
): Parcelable

fun  getData(): List<Player>{
    return  listOf(
        Player(1,"","jugador1","apellidos1",195, 80, "17/04/2000"),
        Player(2,"","jugador2","apellidos2",175, 80, "17/04/2000"),
        Player(3,"","jugador3","apellidos3",195, 70, "17/04/2000"),
        Player(4,"","jugador4","apellidos4",195, 80, "17/04/2000"),
        Player(5, "","jugador5","apellidos5",155, 60, "17/04/2000"),
        Player(6,"","jugador6","apellidos6",195, 80, "17/04/2000"),
    )
}