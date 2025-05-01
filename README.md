# Mobile Computing Week 2

![Project Status](https://img.shields.io/badge/status-completed-brightgreen)

This project is created for the **Mobile Computing** course. It includes learning materials about **Kotlin in Android Studio**, focusing on fundamental concepts such as **ListView, Intents, RecyclerView, Room Database CRUD**, and **REST API consumption**.

## **Technologies Used**
- **Android Studio**: For developing and structuring Android applications.
- **Kotlin**: The primary programming language used for building Android apps.
- **ListView**: For displaying a list of items in a vertical scrollable list.
- **RecyclerView**: For efficiently displaying large data sets.
- **Room Database**: For local data persistence using SQLite.
- **Intent & Parcelable**: For transferring data between activities.
- **Retrofit2**: For consuming REST APIs.
- **Glide**: For image loading.
- **SwipeRefreshLayout**: For pull-to-refresh UI interactions.

## **Demo**

### **Studi Kasus 1: ListView Implementation**
This project demonstrates the implementation of ListView using `listOf`, `mutableListOf`, `ArrayAdapter`, `setOnItemClickListener` for displaying a `Toast`, and `setOnItemLongClickListener` for removing items from the list.

<img src="https://github.com/user-attachments/assets/bea8db50-a4b6-44d0-8c7b-b98a53cc49a3" alt="Screenshot 1" style="height: 300px; width: auto;">
<img src="https://github.com/user-attachments/assets/8459c8c9-deea-454c-9e0f-e3f6016af9a6" alt="Screenshot 2" style="height: 300px; width: auto;">
<img src="https://github.com/user-attachments/assets/935eaf5a-4e78-4b19-9de1-cdad13724ee9" alt="Screenshot 3" style="height: 300px; width: auto;">

### **Studi Kasus 2: Daftar Mahasiswa**
This project demonstrates a ListView implementation with a separate adapter. It aims to send data from one screen to another using `Intent` and `putExtra`. It involves a data class, a custom adapter, and a detail activity that displays when an item is clicked.

<img src="https://github.com/user-attachments/assets/020469df-eed4-4c30-91cd-985d128c4d09" alt="Screenshot 4" style="height: 300px; width: auto;">
<img src="https://github.com/user-attachments/assets/d58d121f-e003-420f-b807-18dae4a56c57" alt="Screenshot 5" style="height: 300px; width: auto;">

### **Studi Kasus 3: RecyclerView with Heroes**
This project showcases the usage of RecyclerView with `Parcelize` for passing data between activities. It includes options for list and grid layouts using `LinearLayoutManager` and `GridLayoutManager`, displays `Toast` messages, and uses a custom adapter.

<img src="https://github.com/user-attachments/assets/096e7ac5-bd29-453c-a8fa-6fcf19adbcb5" alt="Screenshot 7" style="height: 300px; width: auto;">
<img src="https://github.com/user-attachments/assets/f1fefda6-380a-417e-8251-379b050cb9b1" alt="Screenshot 8" style="height: 300px; width: auto;">
<img src="https://github.com/user-attachments/assets/2f376c32-c1d9-4e06-9bc0-745980fc7033" alt="Screenshot 9" style="height: 300px; width: auto;">

### **Studi Kasus 4: CRUD Room Database**
This project implements a CRUD (Create, Read, Update, Delete) application using **Room Database**, **SQLite**, and **ViewModel** architecture. It includes DAO, Database, Repository, ViewModel, Adapter, and RecyclerView for listing and managing records.

<img src="https://github.com/user-attachments/assets/7b697e14-e019-40d4-bb34-5cd2f5c8b6c8" alt="Screenshot 10" style="height: 300px; width: auto;">
<img src="https://github.com/user-attachments/assets/e3441587-27c2-44da-9fae-b3631a54739e" alt="Screenshot 11" style="height: 300px; width: auto;">
<img src="https://github.com/user-attachments/assets/02f3055a-73e1-4d09-a790-fe844740630b" alt="Screenshot 12" style="height: 300px; width: auto;">
<img src="https://github.com/user-attachments/assets/a3b2ce91-bc0e-4ca8-a1ac-9f2ac280b5be" alt="Screenshot 13" style="height: 300px; width: auto;">

### **Studi Kasus 5: REST API Consumption**
This project implements a REST API using [DummyJSON](https://dummyjson.com/products). It demonstrates fetching JSON data using Retrofit2, displaying images with Glide, and implementing pull-to-refresh with SwipeRefreshLayout. The structure includes folders for API Client, Adapter, Model, and Service.

**Reference**: [Trisna Sejati - Penggunaan REST API Dasar di Kotlin Android Studio](https://www.youtube.com/watch?v=0zS99KS17pA)

<img src="https://github.com/user-attachments/assets/f6998f8f-809d-40d8-a9a3-962e01e820e8" alt="Screenshot 14" style="height: 300px; width: auto;">
<img src="https://github.com/user-attachments/assets/095f5e00-4da4-4ac9-a70b-d1ae473add4e" alt="Screenshot 15" style="height: 300px; width: auto;">

## **Setup**
1. Clone the repository to your local machine.
2. Open the project folder in **Android Studio**.
3. Make sure you have the required SDKs and dependencies installed.
4. Build and run the project on an emulator or a physical device.
5. APK files are provided in the repository for direct installation if needed.

## **Usage**
1. Explore and learn the implementations of **ListView, Intents, RecyclerView, Room CRUD operations, and REST API integration**.
2. Test each application using APKs or by building through Android Studio.
3. Modify and experiment with the code to improve understanding and gain hands-on experience.

## **Project Status**
This project is **completed** and was developed for educational purposes as part of the **Mobile Computing (Komputasi Bergerak)** course.

## **Important Notice**
Some logos and images used in the applications are for educational and illustrative purposes only. They are not intended for commercial use.

## **Contributions**
Contributions are welcome! Feel free to submit issues or create pull requests to improve the project.
