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

## 404 에러



