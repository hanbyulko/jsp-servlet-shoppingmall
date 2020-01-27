# JSP&Servlet MVC(model2) 쇼핑몰 구현

  <br/>

## Introduction
19F/W 아우터 제품들을  구매할 수 있는 20~30대 여성을 대상으로 하는 의류 쇼핑몰 제작

  <br/>

## Technical Specification
![image](https://user-images.githubusercontent.com/49690751/73123190-af004780-3fd0-11ea-845c-a2c68e7ee32a.PNG)


  <br/>
  
## Required Library 
- cos.jar
- ojdbc6.jar
- standard.jar
- jstl.jar
- json-lib-2.4-jdk15.jar


  <br/>

## Requirements Specification

- Social 정보를 이용한 회원 가입
- Social 정보를 이용한 로그인, 로그아웃, 탈퇴
- 게시글 등록, 수정, 삭제, 조회 기능
- 게시글 답글 등록, 수정, 삭제 기능
- 게시글 댓글 등록, 수정, 삭제 기능 및 대댓글 등록, 수정, 삭제
- 게시글 관련 첨부파일(이미지) 업로드, 삭제 기능
- 게시글 편집 기능


  <br/>

## Database Modeling
![image](https://user-images.githubusercontent.com/49690751/73123189-adcf1a80-3fd0-11ea-8645-a810bd68e4c1.png)


  <br/>


## 주요 기능 설명
### ***사이트 메인화면***
![image](https://user-images.githubusercontent.com/49690751/73165359-ff91b500-4136-11ea-9661-0369b1d83479.gif)
> 메인화면에서는 가장 최근에 등록된 상품과 가장 판매량이 높은 상품을 확인할 수 있습니다.

  <br/>
    <br/>
  
### ***로그인***
![image](https://user-images.githubusercontent.com/49690751/73129473-8e171100-4027-11ea-97cd-7d36a81b26e0.gif)
![image](https://user-images.githubusercontent.com/49690751/73131551-65574180-4050-11ea-9367-4013c34088a5.png)
> **kakao javascript sdk**를 사용해 카카오 소셜 회원 가입 기능을 구현하였습니다. 로그인에 성공시 user테이블에 아이디와 비밀번호 값이 저장됩니다.

  <br/>
    <br/>
    
### ***회원가입***
![image](https://user-images.githubusercontent.com/49690751/73131552-66886e80-4050-11ea-9f81-a66d2293fa91.png)

> 회원가입은 **ajax 비동기 통신**으로 아이디 중복체크 기능을 구현하였으며, **우편번호 api**를 사용해 주소를 입력받을 수 있게 하였습니다.

  <br/>
    <br/>
    
### ***제품 리스트 조회***
![image](https://user-images.githubusercontent.com/49690751/73129477-9ff8b400-4027-11ea-8790-7bac764000d5.gif)
> 자켓, 코트, 패딩 3가지의 상품 카테고리가 존재하며 각각의 상품에 대해 페이징 처리를 하였습니다.

  <br/>
  <br/>
  
### ***제품 상세 조회***
![image](https://user-images.githubusercontent.com/49690751/73131383-7a7ea100-404d-11ea-8cd7-9c60c2e2cfc0.gif)
> 제품 상세조회 페이지에서는 제품에 대한 이미지와 해당 제품에 달린 리뷰를 확인할 수 있습니다.

  <br/>
  <br/>

### ***제품 바로 구매***
![image](https://user-images.githubusercontent.com/49690751/73129471-8c4d4d80-4027-11ea-9693-0b4f9618aef4.gif)
> 상품 상세보기 페이지에서 바로 구매하기를 눌러 제품을 구매할 수 있습니다. 제품 구매시 현재 보유중인 재고를 기준으로 옵션을 선택할 수 있게하였습니다.

  <br/>
  <br/>
  
  
### ***구매 시스템***  
![image](https://user-images.githubusercontent.com/49690751/73124219-2be4ee80-3fdc-11ea-83ec-4e5e589c4719.png)
> 구매에는 **iamport결제 api**를 사용하였습니다. 현재는 등록된 pg결제사가 카카오페이밖에 없어 이외의 결제 수단은 지원되지않습니다.

  <br/>
   <br/>
   

### ***장바구니를 통한 구매***  
![image](https://user-images.githubusercontent.com/49690751/73129476-91aa9800-4027-11ea-8616-52ad4e47b48e.gif)
> 장바구니 페이지에서는 상품의 수량을 변경하거나 장바구니에서 아이템을 삭제할 수 있습니다. 구매 완료시 구매 내역에 해당 제품이 추가되며 리뷰를 작성할 수 있습니다.

  <br/>
  <br/>




### ***상품 등록 및 이미지 업로드***
![image](https://user-images.githubusercontent.com/49690751/73124226-37381a00-3fdc-11ea-804b-faed8e5a5721.png)
> 상품 등록시 **cos library**를 활용해 **multipart/form-data**형식으로 이미지를 전송하여 이미지 업로드 기능을 구현했습니다.

  <br/>
  <br/>

### ***매출액 및 방문자수 통계***
![image](https://user-images.githubusercontent.com/49690751/73129475-90796b00-4027-11ea-9b38-0c31fb238a90.gif)
> 관리자 기능으로 매출액 및 방문자수 통계를 차트 형태로 확인할 수 있습니다. **jqchart 라이브러리**를 이용해 구현했습니다.
