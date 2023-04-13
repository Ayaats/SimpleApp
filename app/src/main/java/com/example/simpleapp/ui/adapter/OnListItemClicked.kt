package com.example.simpleapp.ui.adapter

import com.example.simpleapp.model.entity.User

interface OnListItemClicked {
    fun onItemClicked(user: User)
}