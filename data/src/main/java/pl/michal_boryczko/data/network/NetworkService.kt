package pl.dentaltree.data.network

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ${michal_boryczko} on 10.08.2018.
 */
interface NetworkService {

	@GET("products/pln/list")
	fun getProductList(
			@Query("lang") lang: String = "pl",
			@Query("currency") currency: String = "pln",
			@Query("page") page: String = "",
			@Query("limit") limit: String = ""
	): Single<Response<Int>>
}