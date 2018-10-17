package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class Choice() : Parcelable{
    var persoId: String? = null
    var targetPageNumberId: String? = null
    var targetStoryId: String? = null
    var input: String? = null

    constructor(parcel: Parcel) : this() {
        persoId = parcel.readString()
        targetPageNumberId = parcel.readString()
        targetStoryId = parcel.readString()
        input = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(persoId)
        parcel.writeString(targetPageNumberId)
        parcel.writeString(targetStoryId)
        parcel.writeString(input)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Choice> {
        override fun createFromParcel(parcel: Parcel): Choice {
            return Choice(parcel)
        }

        override fun newArray(size: Int): Array<Choice?> {
            return arrayOfNulls(size)
        }
    }
}