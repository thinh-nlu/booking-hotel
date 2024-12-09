package com.example.booking_hotel.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.booking_hotel.data.remote.HotelAPI
import com.example.booking_hotel.data.remote.HotelPagingSource
import com.example.booking_hotel.domain.model.Hotel
import com.example.booking_hotel.domain.repository.HotelRepository
import kotlinx.coroutines.flow.Flow

class HotelRepositoryImpl(
    private val hotelAPI: HotelAPI
): HotelRepository {

    override fun searchHotels(query: String): Flow<PagingData<Hotel>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                HotelPagingSource(
                    hotelAPI = hotelAPI,
                    searchQuery = query
                )
            }
        ).flow
    }
}
