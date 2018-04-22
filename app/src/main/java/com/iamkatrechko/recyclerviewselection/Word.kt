package com.iamkatrechko.recyclerviewselection

import android.os.Parcel
import android.os.Parcelable

/**
 * Класс данных
 * @author iamkatrechko
 *         Date: 22.04.2018
 */
data class Word(
        /** Идентификатор */
        val id: Int,
        /** Текст */
        val text: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Word> {
        override fun createFromParcel(parcel: Parcel): Word {
            return Word(parcel)
        }

        override fun newArray(size: Int): Array<Word?> {
            return arrayOfNulls(size)
        }
    }
}