# API testing project 
Projek automation testing api untuk menguji management user pada tautan https://dummyapi.io/. Proyek ini dikembangkan menggunakan bahasa java (pembuatan script test) dan Gradle (build management)

# Build With
Proyek pengujian otomatis melibatkan tiga buah library yang dibutuhkan.
- Junit
- rest assure
- testng

# Getting Started

## Prerequisite
Sebelum menjalankan proyek ini, diperlukan persyaratan environment yang harus disiapkan pada device eksekusi proyek
1. JDK diatas versi 8
2. Gradle Wrapper

## Installation
Proses instalasi proyek ini pada local environment
1. Download source code git hub
2. Buka IDE pemrograman. Misalnya VsCode
3. Buat proyek baru dengan mode import source code existing
4. Lakukan pengaturan project bagian Java dan Gradle dengan
   - Arahkan path Java ke lokasi instalasi JDK
   - Gradle distribution diisi dengan Gradle Wrapper

## File Configuration
Proses konfigurasi project menggunakan build automation pada File build.gradle. 
1. Semua dependency yang dibutuhkan harus ditambahkan di dalam dependencies. Penambahan kode dependency cukup mencari pada maven central. Berikut dependency yang dibutuhkan:
   a. Junit, library untuk melakukan testing dengan menggunakan bahasa java
   ```
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.1'
   ```
   b. Rest Assurace, library untuk melakukan hit API
   ```
    testImplementation 'io.rest-assured:rest-assured:5.4.0'
   ```
   c. TestNG dan Assertion, library untuk memutuskan test result (PASS / FAIL) dari sebuah kondisi pengujian
   ```
    testImplementation 'org.testng:testng:7.9.0'
   ```
3. Pengaturan testing dengan kode:
```
test {
    useTestNG()
}
```
3. Penambahan gradle task web testing dengan kode:
```
tasks.named('test') {
    useJUnitPlatform()
}
```    

# Struture Project Test
Tujuan project adalah proses pengujian automation web dan api, sehingga kode program tersimpan dalam package test. Adapun struktur package sbb:
```
test-api/
├── .gradle/
├── .vscode/
├── app/
│   ├── build/
│   │   ├── distributions/
│   │   ├── libs/
│   │   ├── reports/
│   │   │   └── tests/
│   │   │       ├── css/
│   │   │       ├── js/
│   │   │       └── test/
│   │   │           ├── classes/
│   │   │           ├── css/
│   │   │           ├── js/
│   │   │           ├── packages/
│   │   │           └── index.html
│   │   ├── resources/
│   │   │   ├── main/
│   │   │   └── test/
│   │   └── scripts/
│   │       └── app/
│   │           └── app.bat
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── test/
│   │   │   │       └── api/
│   │   │   │           └── App.java
│   │   │   └── resources/
│   │   └── test/
│   │       ├── java/
│   │       │   └── test/
│   │       │       └── api/
│   │       │           ├── UserApiTestDelete.java
│   │       │           └── UserApiTestGet.java
│   │       └── resources/
├── .gitattributes
├── .gitignore
├── README.md
├── gradle/
├── gradlew
├── gradlew.bat
├── settings.gradle
    
```
.gradle/: Direktori ini berisi file-file yang terkait dengan konfigurasi dan dependensi dari sistem build Gradle. Gradle adalah alat yang sering digunakan dalam pengembangan perangkat lunak Java untuk mengotomatisasi proses build dan manajemen dependensi.
.vscode/: Direktori ini mungkin berisi konfigurasi proyek yang spesifik untuk pengembangan dengan Visual Studio Code, seperti file pengaturan atau ekstensi yang digunakan.
app/: Ini adalah direktori utama dari aplikasi. Biasanya, kode aplikasi Java atau Android ditempatkan di sini.
build/: Direktori ini berisi hasil dari proses build, termasuk file-file yang dihasilkan seperti file distribusi, laporan, dan sumber daya yang telah dikompilasi.
src/: Ini adalah tempat untuk kode sumber aplikasi.
main/: Kode sumber utama aplikasi.
java/: Kode Java untuk aplikasi utama.
test/: Kode pengujian untuk aplikasi.
resources/: Sumber daya tambahan yang digunakan oleh aplikasi utama, seperti file konfigurasi atau gambar.
test/: Kode pengujian untuk aplikasi.
build.gradle: File konfigurasi Gradle untuk aplikasi. Ini berisi informasi tentang dependensi, pengaturan build, dan tugas-tugas lain yang perlu dilakukan selama proses build.
.gitattributes: File konfigurasi untuk Git yang menentukan cara Git mengelola berbagai jenis file dalam proyek.
.gitignore: File yang berisi pola-pola file dan direktori yang ingin diabaikan oleh Git, misalnya file build atau file konfigurasi lokal.
README.md: Ini adalah file Markdown yang berisi informasi penting tentang proyek, seperti panduan penggunaan, dokumentasi, atau instruksi instalasi.
gradle/: Direktori yang mungkin berisi skrip atau plugin tambahan untuk Gradle.
gradlew dan gradlew.bat: Skrip untuk menjalankan Gradle dari baris perintah di lingkungan UNIX dan Windows, secara berturut-turut.
settings.gradle: File konfigurasi untuk Gradle yang berisi informasi tentang modul-modul yang ada dalam proyek.


Note.
1. Setiap kali menjalankan automation testing, akan terbentuk hasil test report yang dapat diakses pada folder test-api\app\build\reports\tests\test\index.html

# Workflow
Langkah pembuatan test script
Buat Direktori Test: Pastikan Anda memiliki direktori yang sesuai untuk menyimpan file test. Dalam struktur folder yang Anda berikan, direktori untuk test sudah disediakan di app/src/test/java.
Buat Kelas Test: Di dalam direktori test tersebut, buat kelas-kelas test untuk menguji kelas-kelas utama Anda. Misalnya, Anda dapat membuat UserApiTestGet.java untuk menguji fitur-fitur pengambilan data dari API dan UserApiTestDelete.java untuk menguji fitur-fitur penghapusan data dari API.
Gunakan Kerangka Pengujian: Dalam kelas-kelas test yang Anda buat, Anda akan menggunakan kerangka pengujian seperti JUnit. Anda dapat menambahkan anotasi JUnit seperti @Test pada metode-metode yang ingin Anda uji.
Tulis Test Case: Di dalam metode-metode yang dianotasi sebagai @Test, tulis kode yang menguji fungsionalitas dari kelas atau metode yang Anda inginkan. Anda dapat menggunakan berbagai metode asserst dari JUnit seperti assertEquals atau assertTrue untuk memeriksa apakah perilaku kelas atau metode sesuai dengan yang diharapkan.
Jalankan Test Case: Setelah Anda menulis test case, Anda dapat menjalankannya dengan menggunakan perintah build Gradle. Biasanya, Anda dapat menjalankan test case dengan menjalankan perintah ./gradlew test dari terminal di direktori proyek Anda. Ini akan menjalankan semua test case yang ditemukan dalam proyek Anda dan memberikan laporan tentang hasilnya.


# How to Run Execution Testing
Proses menjalankan eksekusi testing terdiri dari dua cara, yaitu Terminal dan Class testRunner

## Terminal
Proses menjalankan eksekusi testing melalui terminal dengan menjalankan kode berikut:
```
./gradlew test
```
Namun, sebelumnya harus dilakukan build terlebih dahulu agar library dependency sudah terkonfigurasi pada project. Kode build sbb:
```
./gradlew build
```
## Class TestRunner
Cukup dengan melakukan running test menggunakan icon run IDE pada Class TestRunner 

## Persiapan Data
Sebelum menjalankan test case, diperlukan persiapan data test: 
1. Pastikan App-id yang digunakan valid 
2. Pastikan id user valid saat menguji update user, delete user
3. Ubah parameter id user untuk update dan delete 

# Software Under test
pengujian API dilakukan dengan menggunakan api management user yang diakses pada tautan Dummy API - User Data Controllers
* hit api get profile user by id
* hit api post new user
* hit api update user by id
* hit api delete user by id

# Test Case
Pembuatan test case meliputi test positif dan test negatif, yaitu
## Test Case API User Method Post
    1. Pemeriksaan berhasil melakukan get semua daftar user
    2. Pemeriksaan berhasil melakukan get profile user by id
    3. Pemeriksaan gagal get profile user, karena user id tidak ditemukan
    4. Pemeriksaan berhasil ubah profile user by id
    5. Pemeriksaan berhasil hapus profile user by id
## Test Case API User Method Get
    1. Operasi tidak punya authorization
    2. app-id valid, dan user id ada pada sistem
    3. app-id valid, dan user id tidak ada pada sistem
    4. app-id valid, dan user id tidak sesuai format
    5. api-id tidak valid, dan user id ada pada sistem
## Test Case API User Method Put

## Test Case API User Method Delete
    1. Operasi tidak punya authorization
    2. app-id valid, dan user id ada pada sistem
    3. app-id valid, dan user id tidak ada pada sistem
    4. app-id valid, dan user id tidak sesuai format
    5. api-id tidak valid, dan user id ada pada sistem



