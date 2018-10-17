package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class Page() : Parcelable {
    var storyID: String? = null
    var pageNumber: String? = null
    var imageUri: String? = null
    var entryPoint: Boolean? = false
    var fight: Fight? = null
    var text: String? = null
    var actions: ArrayList<Action>? = null
    var pageAccess: ArrayList<Page>? = null

    constructor(parcel: Parcel) : this() {
        storyID = parcel.readString()
        pageNumber = parcel.readString()
        imageUri = parcel.readString()
        entryPoint = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        text = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(storyID)
        parcel.writeString(pageNumber)
        parcel.writeString(imageUri)
        parcel.writeValue(entryPoint)
        parcel.writeString(text)
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