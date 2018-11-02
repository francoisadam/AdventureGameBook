package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class User() : Parcelable {
    var id: String? = null
    var token: String? = null
    var givenName: String? = null
    var avatarUri: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        token = parcel.readString()
        givenName = parcel.readString()
        avatarUri = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(token)
        parcel.writeString(givenName)
        parcel.writeString(avatarUri)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}