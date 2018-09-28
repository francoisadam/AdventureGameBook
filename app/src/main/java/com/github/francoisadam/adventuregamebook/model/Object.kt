package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class Object() : Parcelable {
    var type: String? = ""
    var id: String? = ""
    var localisation: String? = ""
    var weight: Int = 0
    var name: String? = ""

    constructor(parcel: Parcel) : this() {
        type = parcel.readString()
        id = parcel.readString()
        localisation = parcel.readString()
        weight = parcel.readInt()
        name = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(id)
        parcel.writeString(localisation)
        parcel.writeInt(weight)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Object> {
        override fun createFromParcel(parcel: Parcel): Object {
            return Object(parcel)
        }

        override fun newArray(size: Int): Array<Object?> {
            return arrayOfNulls(size)
        }
    }
}