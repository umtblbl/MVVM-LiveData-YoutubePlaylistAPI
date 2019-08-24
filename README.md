# Kotlin - MVVM - LiveData - Retrofit - CallBack 

Youtube Data V3 API üzerinden kullanıcının kanalındaki playlistleri LiveData ile anlık olarak listeleyen ve güncelleyen android mobil uygulama.

- MVVM mimarisi ile uygulamadaki UI ve iş mantığı birbirinden ayrılmış ve daha okunabilir bir kod tasarımı sağlanmıştır.
- LiveData kullanılarak; ViewModel içerisinde API'dan dönen playlistleri tutan MutableLiveData listesinde değişiklik olması durumunda veri UIda da anında güncellenmektedir.
- Retrofit ile API'dan gelen response değerleri CallBack interface'i ile ViewModel'a aktarılmıştır.


![](https://i.resimyukle.xyz/bef52c.png)
