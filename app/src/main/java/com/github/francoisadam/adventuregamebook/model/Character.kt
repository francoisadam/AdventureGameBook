package com.github.francoisadam.adventuregamebook.model

import android.os.Parcel
import android.os.Parcelable

class Character() : Parcelable {
    var id: String? = ""
    var name: String? = ""
    var race: String? = ""
    var job: String? = ""
    var destinyPoint: Int? = null
    var level: Int? = null
    var xp: Int? = null
    var gender: String? = ""
    var courage: Int? = null
    var intelligence: Int? = null
    var charisma: Int? = null
    var dexterity: Int? = null
    var strenght: Int? = null
    var vitality: Int? = null
    var vitalityMax: Int? = null
    var attack: Int? = null
    var parry: Int? = null
    var protection: Int? = null
    var money: Int? = null
    var magicProtection: Int? = null
    var maxWeigh: Int? = null
    var pageId: String? = null
    var onOfficialMission: Boolean? = null
    var creationDate: String? = null
    var userId: String? = null
    var objects: ArrayList<Object>? = null
    var fight: Fight? = null
    var companions: ArrayList<Companion>? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        name = parcel.readString()
        race = parcel.readString()
        job = parcel.readString()
        destinyPoint = parcel.readValue(Int::class.java.classLoader) as? Int
        level = parcel.readValue(Int::class.java.classLoader) as? Int
        xp = parcel.readValue(Int::class.java.classLoader) as? Int
        gender = parcel.readString()
        courage = parcel.readValue(Int::class.java.classLoader) as? Int
        intelligence = parcel.readValue(Int::class.java.classLoader) as? Int
        charisma = parcel.readValue(Int::class.java.classLoader) as? Int
        dexterity = parcel.readValue(Int::class.java.classLoader) as? Int
        strenght = parcel.readValue(Int::class.java.classLoader) as? Int
        vitality = parcel.readValue(Int::class.java.classLoader) as? Int
        vitalityMax = parcel.readValue(Int::class.java.classLoader) as? Int
        attack = parcel.readValue(Int::class.java.classLoader) as? Int
        parry = parcel.readValue(Int::class.java.classLoader) as? Int
        protection = parcel.readValue(Int::class.java.classLoader) as? Int
        money = parcel.readValue(Int::class.java.classLoader) as? Int
        magicProtection = parcel.readValue(Int::class.java.classLoader) as? Int
        maxWeigh = parcel.readValue(Int::class.java.classLoader) as? Int
        pageId = parcel.readString()
        onOfficialMission = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        creationDate = parcel.readString()
        userId = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(race)
        parcel.writeString(job)
        parcel.writeValue(destinyPoint)
        parcel.writeValue(level)
        parcel.writeValue(xp)
        parcel.writeString(gender)
        parcel.writeValue(courage)
        parcel.writeValue(intelligence)
        parcel.writeValue(charisma)
        parcel.writeValue(dexterity)
        parcel.writeValue(strenght)
        parcel.writeValue(vitality)
        parcel.writeValue(vitalityMax)
        parcel.writeValue(attack)
        parcel.writeValue(parry)
        parcel.writeValue(protection)
        parcel.writeValue(money)
        parcel.writeValue(magicProtection)
        parcel.writeValue(maxWeigh)
        parcel.writeString(pageId)
        parcel.writeValue(onOfficialMission)
        parcel.writeString(creationDate)
        parcel.writeString(userId)
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