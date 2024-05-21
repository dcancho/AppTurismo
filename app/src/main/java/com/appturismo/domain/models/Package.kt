package com.appturismo.domain.models

import com.google.gson.annotations.SerializedName

data class Package(
    @SerializedName("idProducto")
    val productId: Int,
    @SerializedName("nombre")
    val name: String,
    @SerializedName("descripcion")
    val description: String,
    @SerializedName("ubicacin")
    val location: String,
    @SerializedName("idSitio")
    val destinationId: String,
    @SerializedName("estrellas")
    val stars: Int,
    @SerializedName("imagen")
    val imageUrl: String,
    @SerializedName("idTipo")
    val typeId: Int,
    @SerializedName("des1")
    val des1: String,
    @SerializedName("pre1")
    val pre1: Float,
    @SerializedName("des2")
    val des2: String,
    @SerializedName("pre2")
    val pre2: Float,
    @SerializedName("des3")
    val des3: String,
    @SerializedName("pre3")
    val pre3: Float,
)
