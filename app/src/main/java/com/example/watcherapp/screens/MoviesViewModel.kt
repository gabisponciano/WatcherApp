package com.example.watcherapp.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watcherapp.network.MoviesApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

// Representa esses três estados no aplicativo, use uma interface.
// No caso dos estados Loading e Error, não é necessário definir
// novos dados nem criar objetos, já que você apenas transmite a
// resposta da Web. Para criar objetos para as respostas da Web,
// mude a classe data para Object.
sealed interface MoviesUiState {
    data class Success(val photos: String) : MoviesUiState
    object Error : MoviesUiState
    object Loading : MoviesUiState
}


class MoviesViewModel : ViewModel() {
    // um objeto de estado mutável que guarda o status da requisição
    // A requisição pode estar: "loading", "success" e "failure".
    var moviesUiState: MoviesUiState by mutableStateOf(MoviesUiState.Loading)
        private set

    // Call getMarsPhotos() on init so we can display status immediately.
    init {getMoviesPhotos()}

    // Pega as informações das fotos pela API do serviço do Retrofit e
    // atualiza os dados [MarsPhoto] [List] [MutableList].
    // inicie a corrotina usando viewModelScope.launch
    // use o objeto Singleton MoviesApi para chamar o método getPhotos()
    // Atribua o resultado recebido do servidor de back-end ao moviesUiState.
    // O marsUiState é um objeto de estado mutável que representa o status
    // da solicitação da Web mais recente.
    private fun getMoviesPhotos() {
        fun getMarsPhotos() {
            viewModelScope.launch {
                moviesUiState = MoviesUiState.Loading
                moviesUiState = try {
                    val listResult = MoviesApi.retrofitService.getPhotos()
                    MoviesUiState.Success("Success: ${listResult.size} Mars photos retrieved")
                } catch (e: IOException) {
                    MoviesUiState.Error
                } catch (e: HttpException) {
                    MoviesUiState.Error
                }
            }
        }
    }
}