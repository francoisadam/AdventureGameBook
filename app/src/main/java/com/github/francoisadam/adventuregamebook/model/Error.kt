package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class Error() : Parcelable {
    var code: Long? = null
    var message: String? = null

    constructor(parcel: Parcel) : this() {
        code = parcel.readValue(Long::class.java.classLoader) as? Long
        message = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(code)
        parcel.writeString(message)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Error> {
        override fun createFromParcel(parcel: Parcel): Error {
            return Error(parcel)
        }

        override fun newArray(size: Int): Array<Error?> {
            return arrayOfNulls(size)
        }
    }
}