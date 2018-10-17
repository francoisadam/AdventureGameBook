package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class Story() : Parcelable {
    var userId: String? = null
    var name: String? = null
    var description: String? = null
    var rangeLevel: String? = null
    var adminApproved: Boolean? = null
    var creationDate: String? = null
    var lastUpdateDate: String? = null
    var approvedDate: String? = null
    var likes: Int? = null
    var dislikes: Int? = null
    var imageUri: String? = null

    constructor(parcel: Parcel) : this() {
        userId = parcel.readString()
        name = parcel.readString()
        description = parcel.readString()
        rangeLevel = parcel.readString()
        adminApproved = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        creationDate = parcel.readString()
        lastUpdateDate = parcel.readString()
        approvedDate = parcel.readString()
        likes = parcel.readValue(Int::class.java.classLoader) as? Int
        dislikes = parcel.readValue(Int::class.java.classLoader) as? Int
        imageUri = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userId)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(rangeLevel)
        parcel.writeValue(adminApproved)
        parcel.writeString(creationDate)
        parcel.writeString(lastUpdateDate)
        parcel.writeString(approvedDate)
        parcel.writeValue(likes)
        parcel.writeValue(dislikes)
        parcel.writeString(imageUri)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Story> {
        override fun createFromParcel(parcel: Parcel): Story {
            return Story(parcel)
        }

        override fun newArray(size: Int): Array<Story?> {
            return arrayOfNulls(size)
        }
    }

}