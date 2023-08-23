package com.daniel.evaluacion04.data

import com.daniel.evaluacion04.data.response.PlayerListResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface PlayerService {
    @GET("football/players?api_token=KGvmEHD7Vjpihj4kPlMpRVS4x1KmgKl4HFd0bUMt81yWs8aSmxbCCQILPPpq")
    suspend fun getPlayers():PlayerListResponse
}