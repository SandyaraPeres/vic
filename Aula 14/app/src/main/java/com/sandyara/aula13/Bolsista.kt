package com.sandyara.aula13

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Bolsista(var nomeBolsista: String, var idadeBolsista: Int, val desconto: Double) : Aluna(nomeBolsista, idadeBolsista)