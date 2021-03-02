## Backend

- 김낙현 
- 신채원 
- 이한솔

## Skill
- Swagger
- MongoDB

## Swagger
> https://t4coach38.p.ssafy.io/askme/swagger-ui.html


## API

- #### User Controller

  > 유저에 대한 API

  - **/users/signup**

    ```assembly
    # 회원가입
    # RequestBody
    Method : POST
    ```
    
    | Parameter | Type   | Description     |
    | --------- | ------ | --------------- |
    | name      | String | 사용자 이름     |
    | password  | String | 사용자 비밀번호 |
    
    ```assembly
    # Response
    success : 200 OK
    fail : 404 NOT FOUND
    ```
  
    
  
  - **/users/login**
  
    ```assembly
    # 로그인
    # RequestBody
    Method : POST
    ```
  
    | Parameter | Type   | Description     |
    | --------- | ------ | --------------- |
    | name      | String | 사용자 이름     |
    | password  | String | 사용자 비밀번호 |
  
    ```assembly
    # Response
    success : 200 OK
    fail : 404 NOT FOUND
    ```
  
    
    
  - **/users**
  
    ```assembly
    # 사용자 상세정보 가져오기
    Method : Get
    ```
  
    | Parameter | Type   | Description |
    | --------- | ------ | ----------- |
    | token     | String | 사용자 토큰 |
  
    ```assembly
    # Response
    {
      "name": "string",
      "mid": "string",
    }
    ```
  
    
  
- #### Question Controller

  > 질문 게시글에 대한 API

  - **/questions**

    ```assembly
    # 질문 전체 리스트 
    Method : GET
    ```

    | Parameter | Type | Description |
    | --------- | ---- | ----------- |
    | No        |      |             |
    
    ```assembly
    # Response
    # List 반환
    [
    	{
              "author": "string",
              "content": "string",
              "count": 0,
              "createDate": "2021-02-09T02:27:57.107Z",
              "mainCategory": "string",
              "qid": 0,
              "subCategory": "string",
              "title": "string"
    	}
    ]
    ```
    
    
    
  - **/questions/{qid}**

    ```assembly
    # 질문 상세정보
    Method : GET
    ```

    | Parameter | Type | Description |
    | --------- | ---- | ----------- |
    | qid       | Long | 질문 번호   |

    ```assembly
    # Response
    {
        "author": "string",
        "content": "string",
        "count": 0,
        "createDate": "2021-02-09T02:27:57.107Z",
        "mainCategory": "string",
        "qid": 0,
        "subCategory": "string",
        "title": "string"
    }
    ```

    

  - **/questions**

    ```assembly
    # 질문 등록 
    # RequestBody
    Method : POST
    ```

    | Parameter           | Type   | Description |
    | ------------------- | ------ | ----------- |
    | title               | String | 질문 제목   |
    | content             | String | 질문 내용   |
    | author              | String | 작성자      |
    | mainCategory (보류) | String | 대분류      |
    | subCategory (보류)  | String | 소분류      |

    ```assembly
    # Response
    success : 200 OK
    fail : 404 NOT FOUND
    ```

    

  - **/questions**

    ```assembly
    # 질문 수정
    # RequestBody
    Method : PUT
    ```

    | Parameter           | Type   | Description |
    | ------------------- | ------ | ----------- |
    | qid                 | Long   | 질문 번호   |
    | title               | String | 질문 제목   |
    | content             | String | 질문 내용   |
    | author              | String | 질문 작성자 |
    | mainCategory (보류) | String | 대분류      |
    | subCategory (보류)  | String | 소분류      |

    ```assembly
    # Response
    success : 200 OK
    fail : 404 NOT FOUND
    ```

    

  - **/questions/{qid}**

    ```assembly
    # 질문 삭제
    Method : DELETE
    ```

    | Parameter | Type | Description |
    | --------- | ---- | ----------- |
    | qid       | Long | 질문 번호   |

    ```assembly
    # Response
    success : 200 OK
    fail : 404 NOT FOUND
    ```

  

  - **/question/search (보류)**

    ```assembly
    # 질문 필터링
    Method : GET
    ```

    | Parameter           | Type   | Description |
    | ------------------- | ------ | ----------- |
    | mainCategory (보류) | String | 대분류      |
    | subCategory (보류)  | String | 소분류      |

    ```assembly
    # Response
    # List 반환
    [
    	{
              "author": "string",
              "content": "string",
              "count": 0,
              "createDate": "2021-02-09T02:27:57.107Z",
              "mainCategory": "string",
              "qid": 0,
              "subCategory": "string",
              "title": "string"
    	}
    ]
    ```

    

- #### Answer Controller

  > 답글에 대한 API
  - **/answers**

    ```assembly
    # 답글 전체 리스트 
    Method : GET
    ```

    | Parameter | Type | Description |
    | --------- | ---- | ----------- |
    | No        |      |             |

    ```assembly
    # Response
    # List 반환
    [
          {
              "author": "String",
              "content": "String",
              "createDate": "2021-02-09T01:21:42.007Z",
              "qid": 0
          }
    ]
    ```
  
  
  
  - **/answers/{qid}**
    
      ```assembly
      # 질문에 대한 답글 전체 리스트 
      Method : GET
    ```
    
    | Parameter | Type | Description |
    | --------- | ---- | ----------- |
    | qid       | Long | 질문 번호   |
    
      ```assembly
      # Response
      # List 반환
      [
            {
                "author": "String",
                "content": "String",
                "createDate": "2021-02-09T01:21:42.007Z",
                "qid": 0
          }
      ]
      ```
  
    
  
  - **/answers/{aid}**
  
    ```assembly
    # 답글 상세정보
    Method : GET
    ```
  
    | Parameter | Type | Description |
    | --------- | ---- | ----------- |
    | aid       | Long | 답글 번호   |
  
      ```assembly
      # Response
    {
          "author": "String",
          "content": "String",
          "createDate": "2021-02-09T01:21:42.007Z",
          "qid": 0
      }
      ```
  
    
  
  - **/answers**
    
      ```assembly
      # 답글 등록 
      # RequestBody
      Method : POST
    ```
    
    | Parameter | Type   | Description |
    | --------- | ------ | ----------- |
    | author    | String | 답글 제목   |
    | content   | String | 답글 내용   |
    | qid       | Long   | 질문 번호   |
    
    ```assembly
    # Response
    success : 200 OK
    fail : 404 NOT FOUND
    ```
  
    
  
  - **/answers**
  
    ```assembly
    # 답글 수정
    # RequestBody
    Method : PUT
    ```
    
    | Parameter | Type   | Description |
    | --------- | ------ | ----------- |
    | aid       | String | 답글 번호   |
    | author    | String | 답글 제목   |
    | content   | String | 답글 내용   |
    | qid       | Long   | 질문 번호   |
    
      ```assembly
    # Response
    success : 200 OK
    fail : 404 NOT FOUND
      ```
  
    
  
  - **/answers/{aid}**
  
    ```assembly
    # 답글 삭제
    Method : DELETE
    ```
  
    | Parameter | Type | Description |
    | --------- | ---- | ----------- |
    | aid       | Long | 답글 번호   |
  
    ```assembly
    # Response
    success : 200 OK
    fail : 404 NOT FOUND
    ```
  
    
