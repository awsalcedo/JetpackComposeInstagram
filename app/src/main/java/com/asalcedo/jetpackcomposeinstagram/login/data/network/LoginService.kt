package com.asalcedo.jetpackcomposeinstagram.login.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject

//class LoginService @Inject constructor(private val retrofit: Retrofit) {
//No interesa tener retrofit lo que interesa es la interfaz donde se implementan los métodos GET
class LoginService @Inject constructor(private val loginClient: LoginClient) {
    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin()
            response.body()?.success ?: false
        }
    }
}