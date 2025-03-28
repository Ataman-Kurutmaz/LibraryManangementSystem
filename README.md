# 📚 Java Konsol Tabanlı Kütüphane Yönetim Sistemi

Bu proje, Java dilinde yazılmış **konsol tabanlı bir Kütüphane Yönetim Sistemi**'dir. Kullanıcı, sistem üzerinden kitap ekleme, listeleme, arama, ödünç alma ve iade işlemlerini gerçekleştirebilir. Uygulama, temiz mimari prensiplerine uygun olarak katmanlı şekilde tasarlanmıştır.

---

## 🧩 Proje Özellikleri

- 📖 Yeni kitap ekleyebilme
- 📚 Tüm kitapları listeleme
- 🔍 Kitap başlığına göre arama
- 📦 Kitap ödünç alma
- 🔄 Kitap iade etme
- ❌ Uygulamadan çıkış yapma

---

## 🗂️ Proje Mimarisi

Uygulama **Clean Architecture (Temiz Mimari)** yapısına göre dört ana katmana ayrılmıştır:

### 1. **`domain.entities`**
- Projenin iş modelini tanımlar.
- `Book.java`: Kitap nesnesini oluşturur ve ödünç alma/iade etme işlemlerini kontrol eder.

### 2. **`infrastructure.repositories`**
- Verilerin saklandığı yerdir (şimdilik sadece bellekte).
- `BookRepository.java`: Kitap ekleme, listeleme ve başlığa göre arama işlemlerini yapar.

### 3. **`usecase`**
- İş kurallarını tanımlar.
- `BookService.java`: Kitap ekleme, arama, ödünç alma ve iade işlemlerinin iş mantığını içerir.

### 4. **`interface_adapters.controllers`**
- Kullanıcı etkileşiminden sorumlu katmandır.
- `BookController.java`: Kullanıcıdan gelen girdilere göre ilgili işlemleri başlatır.

### 5. **`org.example.Main`**
- Uygulamanın başlatıldığı sınıftır.
- Gerekli bağımlılıkları oluşturur ve uygulamayı başlatır.

---

## 🔧 Kurulum ve Çalıştırma

1. Bu projeyi yerel bilgisayarınıza klonlayın:
    ```bash
    git clone https://github.com/kullaniciadi/kutuphane-yonetim-sistemi.git
    ```

2. Projeyi bir Java IDE'si ile açın (Örn: IntelliJ IDEA, Eclipse).

3. `Main.java` dosyasını çalıştırarak uygulamayı başlatın.

---

## 🖥️ Konsol Görünümü

```text
--- Library Management System ---
1. Add Book
2. Show Books
3. Search Book by Title
4. Borrow Book
5. Return Book
6. Exit
Choose an option (1-6):

src/
├── domain/
│   └── entities/
│       └── Book.java
├── infrastructure/
│   └── repositories/
│       └── BookRepository.java
├── interface_adapters/
│   └── controllers/
│       └── BookController.java
├── usecase/
│   └── BookService.java
└── org/
    └── example/
        └── Main.java

