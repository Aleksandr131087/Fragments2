package com.example.fragments2

import java.io.Serializable

class Note(val count: Int, var textNote: String, val dateCreate: String, var checkBoxCondition: Boolean) : Serializable {
}