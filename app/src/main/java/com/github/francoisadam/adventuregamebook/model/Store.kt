package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class Store() : Parcelable {
    var id: String? = null
    var name: String? = null
    var equipements: ArrayList<Object>? = null
    var food: ArrayList<Food>? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        name = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Store> {
        override fun createFromParcel(parcel: Parcel): Store {
            return Store(parcel)
        }

        override fun newArray(size: Int): Array<Store?> {
            return arrayOfNulls(size)
        }
    }
}