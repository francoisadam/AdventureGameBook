package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class Adventure() : Parcelable {
    var page: Page? = null
    var perso: Character? = null

    constructor(parcel: Parcel) : this() {
        page = parcel.readParcelable(Page::class.java.classLoader)
        perso = parcel.readParcelable(Character::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(page, flags)
        parcel.writeParcelable(perso, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Adventure> {
        override fun createFromParcel(parcel: Parcel): Adventure {
            return Adventure(parcel)
        }

        override fun newArray(size: Int): Array<Adventure?> {
            return arrayOfNulls(size)
        }
    }
}