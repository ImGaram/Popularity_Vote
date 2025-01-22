# 🗳️ Popularity_Vote
**인기 투표 서비스**

<br>

## 🖥️ 화면 구성
|로그인 화면|메인 화면|
|:---:|:---:|
|<img src="https://github.com/user-attachments/assets/f52f5a88-7ffe-4025-9191-d607b9551013" height=550>|<img src="https://github.com/user-attachments/assets/c6ca8913-de05-4574-aed5-12b2768f6a61" height=550>|
|사용자 ID를 입력받고 메인 화면으로 이동합니다.|인기투표 포스터, 투표와 관련한 정보, 인기투표 후보자 목록이 있습니다. <br>2025년 2월 3일에 종료되는 카운트다운이 표시됩니다.|

|상세 정보 화면|투표하기|
|:---:|:---:|
|<img src="https://github.com/user-attachments/assets/b66a1303-3be5-4edc-87ae-b15f7941b755" height=550>|<img src="https://github.com/user-attachments/assets/a856479d-bcd4-4df8-9a90-3808b6709868" height=550>|
|후보자의 상세 정보를 표시합니다.|해당 후보자에게 투표를 진행합니다.<br> 한 번 투표한 후보자에게 재투표는 불가능하고, 최대 3명에게 투표할 수 있습니다.|
<br>

## 🔨 사용 기술 스택
- Retrofit
- Okhttp
- MVVM
- Coil
- Jetpack Compose
- Compose navigation
- Dagger hilt

<br>

## 📂 프로젝트 구조
```
📂 app
┣ 📂 common
┃ ┣ 📂 compose
┃ ┣ 📂 font
┃ ┣ 📂 navigation
┃ ┣ 📄 Constants
┃ ┗ 📄 Resources
┣ 📂 core
┃ ┣ 📂 api
┃ ┣ 📂 data
┃ ┃ ┣ 📂 request
┃ ┃ ┗ 📂 response
┃ ┗ 📂 repository
┣ 📂 di
┣ 📂 feature
┃ ┣ 📂 login
┃ ┃ ┣ 📂 component
┃ ┃ ┗ 📄 LoginScreen
┃ ┣ 📂 main
┃ ┃ ┣ 📂 component
┃ ┃ ┣ 📄 MainScreen
┃ ┃ ┗ 📄 MainViewModel
┃ ┣ 📂 profile
┃ ┃ ┣ 📂 component
┃ ┃ ┣ 📄 ProfileScreen
┃ ┃ ┗ 📄 ProfileViewModel
┃ ┣ 📂 state
┃ ┗ 📂 util
┣ 📂 ui
┃ ┗ 📂 theme
┣ 📄 MainActivity
┗ 📄 PopularityVoteApplication
```

<br>

## 🚨 기술적 이슈과 해결 과정
* **MainScreen에서 LazyColumn item으로 Grid Layout 적용 문제**
  * LazyColumn으로 scroll 가능한 screen 제작 중 후보자 정보를 Grid Layout으로 표시하던 중 발생한 문제
  * LazyColumn 안에 LazyVerticalGrid를 활용해 제작했는데, 두 Component의 scroll이 겹쳐서 발생한 문제임을 알게 됨.
    * LazyVerticalGrid의 scrollable을 disable로 바꾸고, maxHeight를 지정해 주어서 문제를 해결함.
* **ProfileScreen의 ProfileImageHorizontalPager에서 사용자 이미지 정보를 표시하는 AsyncImage에서 이미지를 로딩 중일 때, 순간 AsyncImage가 사라지는 문제**
  * AsyncImage의 height를 지정해 주지 않아서 이미지의 영역이 제대로 표시되지 않는다는 것을 알게 되었음.
    * AsyncImage 로딩 중 표시할 Composable을 정의하기 위해 SubcomposeAsyncImage으로 변경 후,
      height가 fillMaxWidth로 정의된 width와 1:1의 비율을 가질 수 있도록 aspectRatio를 이용해서 height를 정의함.


