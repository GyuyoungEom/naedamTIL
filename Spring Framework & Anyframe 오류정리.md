# Spring Framework & Anyframe 오류정리

## 500 에러

### js 에러

1. jQuery에러

   ``` console
   org.anyframe.exception.BaseRuntimeException: Page unit or page size should be over 0.
   혹은
   jquery-1.9.1.js:8526
   ```

   - 원인
     - ajax 사용 시 data 부재
   - 해결방안
     - data 추가

### sql 에러

1. jdbc 에러

   ``` console
   [ERROR] jdbc.sqltiming > 2. PreparedStatement.getParameterMetaData()
   com.microsoft.sqlserver.jdbc.SQLServerException: com.microsoft.sqlserver.jdbc.SQLServerException: ',' 근처의 구문이 잘못되었습니다.
   ```

   - 원인
     - 변수값이 제대로 들어오지 않았을때
     - 해당 항목의 타입에 맞지 않는 값이 들어왔을 때
     - 값이 비거나 다른 값이 들어와 구문에 값이 제대로 삽입되지 않은 경우
   - 해결방안
     - 값을 다시 확인
     - controller에서 dto 누락값 추가

## 404 에러



