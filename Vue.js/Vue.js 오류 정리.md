# Vue.js 오류 정리

### npm axios 설치 오류

```bash
found 2 vulnerabilities (1 moderate, 1 high)
	run 'npm audit fix' to fix them, or 'npm audit' for details
```

- 발생원인

  - npm install시 package의 취약점을 검사함.
  - 이 때, 취약점이 발견되어 `npm audit fix`가 필요

- 해결 방법

  `npm audit fix`

  - 취약점이 다 해결되지 않는 경우가 많음
  - 취약점이 더 줄어들지 않을 때까지 `npm audit fix`를 진행
  - 그래도 취약점이 0이 되지 않으면
    1. `npm audit`
       - 문제를 확인하고 수작업 해결
       - 확인되는 문제를 update
       - `npm install --save-dev 문제명@version
    2. `npm audit fix --force`
       - 강제로 취약점을 모두 해결함



### vue-cli 내 console.log 에러(compile 에러)

```bash
Failed to compile.
Module Error (from ./node_modules/eslint-loader/index.js):
error: Unexpected console statement (no-console) at src\App.vue:31:7:
  29 |       event.preventDefault();
  30 |       //submit에 대해서 기본적인 동작을 막기위함
> 31 |       console.log(this.username, this.password);
     |       ^
  32 |       var url = 'https://jsonplaceholder.typicode.com/users';
  33 |       var data = {
  34 |         username: this.username,
```

- 발생원인

  - ESLint에서 console.log에 대해 인식하지 못함
    - ESLint : JavaScript 코드에서 발견된 문제 패턴을 식별하기 위한 정적 코드 분석 도구

- 해결 방안

  1. <mark>window.console.log();</mark>

     - 제일 간단한 방법

  2. `vue.config.js`

     - 프로젝트 폴더 루트 위치에 `vue.config.js` 파일을 만들고 아래 코드 추가

     ``` javascript
     // vue.config.js
     module.exports = {
         devServer: {
             overlay:false
         }
     }
     ```

  3. `package.json`

     - package.json파일을 열어 아래 코드 추가

     ``` json
     "rules": {
         "no-console": "off"
     },
     ```

     