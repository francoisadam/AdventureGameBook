package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Action() : Parcelable {
    var actionType: String? = ""
    var quantity: Int = 0
    @SerializedName("object")
    var item: Object? = null

    constructor(parcel: Parcel) : this() {
        actionType = parcel.readString()
        quantity = parcel.readInt()
        item = parcel.readParcelable(Object::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(actionType)
        parcel.writeInt(quantity)
        parcel.writeParcelable(item, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Action> {
        override fun createFromParcel(parcel: Parcel): Action {
            return Action(parcel)
        }

        override fun newArray(size: Int): Array<Action?> {
            return arrayOfNulls(size)
        }
    }
}