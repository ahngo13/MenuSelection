# 오늘 뭐 먹지? (MenuSelection)

### 개요

본인 위치 근처에 있는 음식점을 조회하여 먹을 음식을 고를 수 있는 웹 어플리케이션 서비스



### 개발환경

OS : Windows 10

Web Browser : Google Chrome

IDE : Spring Tool Suite 3 Version: 3.9.11.RELEASE

Language : Java (JDK 1.8.0_231), javascirpt, JSP

Skill : Ajax, CSS

Server : Tomcat 8.0

Framework : Spring 5.2.2.RELEASE, Mybatis, JQuery, Bootstrap

DBMS : MariaDB 10.4

Configuration Management : Git



### 사이트맵

![img](https://lh4.googleusercontent.com/YeRMIWH27cXpNDVLkCJ_f_y0qTdaWAFUOvhzBa8ChZsA43wnv7-J1Bw0hvTmixbCfCUsbu-enXnvHkefw_FXUsVW1mm0UoTqU7pXnDxfwAshzUjRxJdpChusLh_phY3SuehtGthB8zE)





### ER-Diagram

![img](https://lh6.googleusercontent.com/-avZcqTOKdw824ouZVr99VIlcg3OD-k5RaIt4hOWHr9EOImyWtK8AZv20ztVO6IpxaAs9MUeKvArn2lCAgaYMZCJFt6ef6grXmDGl6YBsDSh6aef8yod1CkRo-V3zwSHLez_-cSleKI)



### 패키지 분류

 ![img](https://lh6.googleusercontent.com/oG3PGvNor4hAu_KBckAvHKRcrzg9tolNbJ_jagfA3swnjpa0R86b33SB1VNgkmClAxZaSjwOAYk_korAhQTwJmJqgTfXNj7NdFdQ54-Xmz2XRInfyl_CPxkr0yR0y2SSxlboLi8dNkM)

#### com.menuselection.multicam.bean

- 각 Bean 클래스

#### com.menuselection.multicam.common

- 공통적으로 사용하는 클래스

#### com.menuselection.multicam.controller

- 각 controller 클래스

#### com.menuselection.multicam.DAO

- 각 DAO 인터페이스 및 DAOImpl 클래스

#### com.menuselection.multicam.service

- 각 service 인터페이스 및 serviceImpl 클래스



### 페이지 분류

![img](https://lh6.googleusercontent.com/fGfe3FyZgfCbkTf9WimoetDsIUyBy7vnJDub9SEKT7yi2Rrgriz38XUKy79dKnKmZ0gUF7ZhAyE9Co2gu-lbo0tL8smy61UA3mFa_2AcCPqUJTUor2FGpeeqhIby9BnIJXS-XAwazVE)

#### views/common

- include 필요한 header, footer.jsp 파일 포함

#### views

- 공통 jsp 파일 제외 모든 jsp 파일 포함
  - home : 메인페이지
  - kakao : 카카오 맵 API 연동 페이지(개발 작업을 위한 임시 페이지)
  - addressList, roadAddressList : 지번주소, 도로명주소 더보기 페이지
  - placeList : 음식점 리스트 페이지
  - worldcupmain : 음식 월드컵 페이지
  - board, boardAction, writeBoard, content : 맛집 공유 게시판 페이지

#### resources

- js, image 파일 포함



### 실제 실행화면 및 기능 설명

#### 메인 화면

- 상단 메뉴 클릭 시 메인페이지, 음식 월드컵, 맛집공유 게시판 페이지 이동 가능

![img](https://lh4.googleusercontent.com/UwSQbYXVRAIInKsw-rYJHGC0s4rh_kIFBIInatSu5Irl-YIFVKrnCFibiNH__zTrqwf4bRlCvEQ-dawAvfK23SW5gWgcstYSe_1zrlWdZk0SCR2pKFiHA4GZoFIIvIaSrOXkQzBdQEI)



#### 카카오맵 주소 검색 화면

- 현재 위치 조회 (SSL 미적용 시 geolocation 적용 불가)

![img](https://lh6.googleusercontent.com/NJzha5NTsWvQCo2zAKKlUOtlFwm8TTTx9faxstjZ2bI340iJtgLLov7cE4ORnS_kzOldDye9pWzGfA6M1M-l-SwMCuy_ezHEcvu4ihHNe3k7zgNXvAONJWswO8AFMiCjkY7p38m-lBA)



- 지번, 도로명 주소 조회
- 지번, 도로명 주소 페이징 처리(10개씩 조회가능)

![img](https://lh3.googleusercontent.com/dfzJKNKgFKCI_cTJri51fa_j_rSUM0z2BptPI4D2fUWO4waITY-F240wOQGw1x6Fnl25eUxf3joZ33PeHvVSoe6rhaZAia7h2oHs38TlAMmI7N4QepKRn4W63Xu7ecjbI3p04WN4zkU)



- 주소 검색 후 해당 주소 선택 시 현위치로 표시 후 주변 음식점 45개씩 조회가능(별표로 표시)

(Kakao API 기준 최대 15개까지 , 연속 호출시 최대 45개까지 조회가능)

![img](https://lh5.googleusercontent.com/R6AKw_i0S3L_PzGDD4srbOqLch_6Yqj4B8C3iFN7uzToBVoD4CipPoqtfW5IoradG1Aibv5dvOVzrWZmjqi4ApB-90TtqKwIGu5wGTIITZO1B1uafR0vG7kveO7KTIke5GgI_aJXujY)



- 해당 음식점 선택 시 해당 음식점의 상단에 아이콘 및 ToolTip 박스 표시
- 해당 음식점의 상세보기 클릭시 해당 음식점 URL로 이동 

![img](https://lh5.googleusercontent.com/wXBYam7EK1Jt2BLOveMw-ksKH9BQxwOZzKzu3x_owTPSbDDKSHATl7Kq5-tuI3n_B98HQ5MiOAMbg9B7t4TC2b3G6FCBk_00V4m38Hy6vQi2LnuGcTN2hD3XjJvH9a0wMigf8l2SV_4)



### 음식 월드컵

- 메인 메뉴에서 음식 월드컵 메뉴 선택시 음식월드컵 메인으로 이동
- 월드컵 시작 버튼으로 진행 가능

![img](https://lh5.googleusercontent.com/bP-sab2CqCxMch_zS_jn_ixjgegvZQh0OOA7EzkHh_I7YAzqA0CyZWfP6pWNJqRcGybWaLaUJCaWgu-brrzsPxuwIVX19KRJZvmg4_st5h_mRxmwpTE5dihBJiCsTO3IIWZmTTvQC3c)





- 2개의 메뉴씩 이미지가 나오며, 원하는 메뉴 선택 시 선택한 메뉴가 누적됨

![img](https://lh3.googleusercontent.com/q0KoAL8ttoD0_oGgcopkUirNdf-s5TuoAXq_W-kx2uh6pb-co9D1sCZASrdT4mM_ZIBu1tEepv3MkEnSWNJ3ut7TIsxK6F6PTsFm9uLdZuceUYRTQFpH8R42ZyMh8giy-dJCFBYyy3U)





- 모든 단계를 선택했을 경우 최종으로 선택한 메뉴가 노출되면서 끝마침

![img](https://lh5.googleusercontent.com/78T6l-dxi_zH4g45Mi41pIqxQcFNkHNe3bd9eQhiuCeHD9tOXzshpE5CWMfa-puoIj4ZdU2_oVQ7d_vktlDnxR5RyUfxjcV5LEinp3Le-73Hc3WDL5QQXE6LAFyLkAVh4XmnuEKEsNw)



### 맛집 공유 게시판

- 본인이 먹은 음식점의 메뉴 평가를 후기 형식으로 공유가능
- 제목을 클릭할 경우 해당 게시글에 대한 상세 내용 확인가능

![img](https://lh4.googleusercontent.com/8fmDk2X0d1LOUFYKc3gT-kDrAZccVgUfuxL6ZiSc4tXsBVO1fZ-yFXRGoKZGSvKnGATipP9W_XFbl-wj02x8DsBzRQpkx_0lCJgT-yEsBhPLCxtBXO8eQLnXOLCziWikhUarlsUs1Bg)



- 글쓰기 버튼을 클릭 시 게시글 작성 페이지로 이동가능
- 제목, 내용, 작성자, 비밀번호를 입력하여 새로운 게시글 추가가능
- 비밀번호는 수정 및 삭제시 활용가능

![img](https://lh5.googleusercontent.com/27k_D-rg9AIR_bPjYRaU68TbMzt7kl049ZmqJUddaMd_DNwo35YdjODlXzbaBvuO3R2J-W7LiJxQLJdo_MIomTwu2yG9vHDibCzq16aOdh2eq05WYUnlwStllpr7glbaoYhmERvY8IM)