package com.kingOf0.aboutdormitories.entity

import com.kingOf0.aboutdormitories.model.Gender
import javax.persistence.*

@Entity
@Table(name = "dormitories")
class Dormitory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dormitory_id")
    val id: Int,

    @Column(name = "dormitory_name")
    var name: String,

    @ElementCollection
    @Column(name = "dormitory_images")
    var images: List<String>,

    @Column(name = "dormitory_capacity")
    var capacity: Int,

    @Column(name = "dormitory_gender")
    var gender: Gender,

    @Column(name = "room_size")
    var roomSize: String,

    @Column(name = "buildings")
    var nearBuildings: String,

    @Column(name = "dormitory_canteen")
    var hasCanteen: Boolean,

    @Column(name = "dormitory_garden")
    var gardenSize: String,

    )