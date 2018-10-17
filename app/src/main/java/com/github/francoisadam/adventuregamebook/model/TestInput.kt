package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class TestInput() : Parcelable {
    var persoId: String? = null
    var testName: String? = null
    var testResult: String? = null

    constructor(parcel: Parcel) : this() {
        persoId = parcel.readString()
        testName = parcel.readString()
        testResult = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(persoId)
        parcel.writeString(testName)
        parcel.writeString(testResult)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TestInput> {
        override fun createFromParcel(parcel: Parcel): TestInput {
            return TestInput(parcel)
        }

        override fun newArray(size: Int): Array<TestInput?> {
            return arrayOfNulls(size)
        }
    }
}