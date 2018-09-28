package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class Character() : Parcelable {
    var id: String? = ""
    var name: String? = ""
    var race: String? = ""
    var job: String? = ""
    var destinyPoint: Int = 0
    var level: Int = 0
    var xp: Int = 0
    var gender: String? = ""
    var courage: Int = 0
    var intelligence: Int = 0
    var charisma: Int = 0
    var dexterity: Int = 0
    var strenght: Int = 0
    var vitality: Int = 0
    var vitalityMax: Int = 0
    var attack: Int = 0
    var parry: Int = 0
    var protection: Int = 0
    var money: Int = 0
    var magicProtection: Int = 0
    var maxWeigh: Int = 0

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        name = parcel.readString()
        race = parcel.readString()
        job = parcel.readString()
        destinyPoint = parcel.readInt()
        level = parcel.readInt()
        xp = parcel.readInt()
        gender = parcel.readString()
        courage = parcel.readInt()
        intelligence = parcel.readInt()
        charisma = parcel.readInt()
        dexterity = parcel.readInt()
        strenght = parcel.readInt()
        vitality = parcel.readInt()
        vitalityMax = parcel.readInt()
        attack = parcel.readInt()
        parry = parcel.readInt()
        protection = parcel.readInt()
        money = parcel.readInt()
        magicProtection = parcel.readInt()
        maxWeigh = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(race)
        parcel.writeString(job)
        parcel.writeInt(destinyPoint)
        parcel.writeInt(level)
        parcel.writeInt(xp)
        parcel.writeString(gender)
        parcel.writeInt(courage)
        parcel.writeInt(intelligence)
        parcel.writeInt(charisma)
        parcel.writeInt(dexterity)
        parcel.writeInt(strenght)
        parcel.writeInt(vitality)
        parcel.writeInt(vitalityMax)
        parcel.writeInt(attack)
        parcel.writeInt(parry)
        parcel.writeInt(protection)
        parcel.writeInt(money)
        parcel.writeInt(magicProtection)
        parcel.writeInt(maxWeigh)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }
}