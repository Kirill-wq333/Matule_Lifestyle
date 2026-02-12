package com.example.matule20.ui.presentation.feature.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ui.feature.auth.interactor.AuthInteractor
import com.example.domain.ui.feature.profile.interactor.ProfileInteractor
import com.example.domain.ui.feature.profile.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class ProfileViewModel @Inject constructor(
//    private val profileInteractor: ProfileInteractor,
//    private val authInteractor: AuthInteractor
//): ViewModel() {
//
//    private val _profile: MutableStateFlow<User> = MutableStateFlow(User())
//    val profile = _profile.asStateFlow()
//
//
//
//    fun profile(userId: Int){
//        viewModelScope.launch {
//            val result = profileInteractor.user(userId)
//            result
//                .onSuccess {
//                    _profile.emit(it)
//                }
//        }
//    }
//
////    fun exitProfile(){
////        viewModelScope.launch {
////            authInteractor.exitSystem()
////        }
////    }
//}