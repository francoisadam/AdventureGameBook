package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class User() : Parcelable {
    var token: String? = ""
    var givenName: String? = ""
    var id: String? = ""

    constructor(parcel: Parcel) : this() {
        token = parcel.readString()
        givenName = parcel.readString()
        id = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(token)
        parcel.writeString(givenName)
        parcel.writeString(id)
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