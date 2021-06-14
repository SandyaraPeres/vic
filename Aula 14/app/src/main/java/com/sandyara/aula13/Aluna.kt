package com.sandyara.aula13

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//SEMPRE USAR PARCELABLE
//ELE FOI FEITO ESPECIALMENTE <3 PRO ANDROID
//O SERIALIZABLE É DO JAVA, GERA MAIS PROCESSAMENTO
//SEM NECESSIDADE
@Parcelize
open class Aluna(val nome: String,
                 val idade: Int,
                 val isLindaPraCaramba: Boolean = true) : Parcelable{
                     fun getIsLindaPraCaramba() : String{
                         return if(isLindaPraCaramba){
                             "Linda pra carambaaaaa"
                         } else {
                             "não é linda não :("
                         }
                     }
                 }