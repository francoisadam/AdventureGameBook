package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class Page() : Parcelable {
    var storyID: String? = ""
    var pageNumber: String? = ""
    var text: String? = ""
    var entryPoint: Boolean? = false
    var actions: ArrayList<Action>? = null

    constructor(parcel: Parcel) : this() {
        storyID = parcel.readString()
        pageNumber = parcel.readString()
        text = parcel.readString()
        entryPoint = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(storyID)
        parcel.writeString(pageNumber)
        parcel.writeString(text)
        parcel.writeValue(entryPoint)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Page> {
        override fun createFromParcel(parcel: Parcel): Page {
            return Page(parcel)
        }

        override fun newArray(size: Int): Array<Page?> {
            return arrayOfNulls(size)
        }
    }
}