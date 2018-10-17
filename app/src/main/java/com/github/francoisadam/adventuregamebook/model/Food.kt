package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class Food() : Parcelable{
    var id: String? = null
    var name: String? = null
    var dayLength: Int? = null
    var portions: Int? = null
    var buyingPrice: Int? = null
    var sellingPrice: Int? = null
    var creationDate: Int? = null
    var temporary: Temporary? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        name = parcel.readString()
        dayLength = parcel.readValue(Int::class.java.classLoader) as? Int
        portions = parcel.readValue(Int::class.java.classLoader) as? Int
        buyingPrice = parcel.readValue(Int::class.java.classLoader) as? Int
        sellingPrice = parcel.readValue(Int::class.java.classLoader) as? Int
        creationDate = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeValue(dayLength)
        parcel.writeValue(portions)
        parcel.writeValue(buyingPrice)
        parcel.writeValue(sellingPrice)
        parcel.writeValue(creationDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Food> {
        override fun createFromParcel(parcel: Parcel): Food {
            return Food(parcel)
        }

        override fun newArray(size: Int): Array<Food?> {
            return arrayOfNulls(size)
        }
    }
}