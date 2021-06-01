# Vue.js 내용 요약

## Reactivity

- 데이터에 대한 변화를 감지해서 화면에 반영
- 화면 조작에 대한 API 및 속성을 Vue에서 제공
- 웹 개발에 대한 동작들을 라이브러리에서 관리 해줌



## 인스턴스

- Vue를 개발할 때, 필수로 생성해야 하는 단위
- 실제로 데이터를 추가함으로써 화면을 조작할 수 있음



## 컴포넌트

- 화면의 영역을 구분해서 개발하는 방식
- Front-end에서 가장 중요한 역할을 하고 있음
- 대부분의 UI가 컴포넌트 기반으로 개발 진행
- 따라서 <mark> 재사용성,  코드의 반복을 줄이는 것</mark>이 핵심

##### 전역 컴포넌트 예시

``` html
<div id='app'>
	<app-header></app-header>
</div>
<script>
	Vue.component('app-header', {
           template: '<h1>Header</h1>'
    });
	new Vue({
            el: '#app'
    });
</script>
```

##### 지역 컴포넌트 예시

``` html
<div id='app'>
    <app-footer></app-footer>
</div>
<script>
	new Vue({
            el: '#app',
        	//Vue.component('key','value') 와 같은 의미
            components: {
                //'key' : 'value'
                'app-footer' : {
                    template : '<footer>footer</footer>'
                }
            }
    });
</script>
```

#### 전역 vs 지역 컴포넌트

- 개발자 도구로 확인하면 크게 차이나지 않음
- component 기반 방식으로 개발하게 되면, (싱글 파일 컴포넌트)  components 속성으로 바로 어떤 속성을 가졌는지 확인 가능
-  `Vue.component('key','value')`의 경우 대부분 플러그인이나 라이브러리 형태로 전역으로 사용해야 하는 component만 사용
- 일반적으로는 components에 계속 추가로 작성



## 컴포넌트와 인스턴스와의 관계

- 인스턴스는 여러 개 생길 수 있음
  - 전역 컴포넌트의 경우, 인스턴스를 생성할 때마다 따로 등록할 필요없이 기본적으로 모든 인스턴스가 등록이 되어있음
  - 지역 컴포넌트의 경우, 인스턴스마다 새로 생성해야 함
    - 인스턴스를 많이 생성해야 하는 단점이 있음



## 컴포넌트 통신

- 컴포넌트로 개발했을 때, 데이터의 어떤 흐름을 제어하기 위한 규칙들을 제한하면서
  - 장점
    - 여러명이 개발하더라도 서로 같은 데이터의 흐름을 예측 가능

#### props

- 데이터를 상위에서 하위로 내리는 것

#### event emit

- 하위에서 상위로 이벤트를 올리는, 컴포넌트를 대하는 방식



## HTTP 통신 라이브러리 (axios)

- axios가 가장 대중적



## 템플릿 문법

- 화면을 조작하기 위한 문법을 의미

#### 데이터 바인딩

- Reactivity와 비슷한 개념
- 데이터 변화에 따라서 화면에 반영해 주는 것 = reactivity
- 그 데이터를 화면에 엮어내는 것 = data binding

#### 뷰 디렉티브

- 화면을 조작하기 위해서 vue가 추가적으로 제공하는 문법
- 디렉티브는 모두 `v-`로 시작하는 속성을 가지고 있음



## Vue CLI

- 프로젝트를 생성할 때, 명령어로 생성하는 방식
- 그 안에 싱글파일 ('.vue')로 조작



## 싱글 파일 컴포넌트

- 웹팩의 공식문서 참조하면 도움이 됨

- 뷰 애플리케이션은 여러 개의 컴포넌트로 화면을 구성하고, 페이지 사이를 이동할 때에는 라우터 사용. But, 실제 제작시 파일 구조의 한계점을 느낌

- vue파일의 컴포넌트 구성은 여러개의 컴포넌트를 작성할 때, 내부의 코드의 가독성을 높임

  예시_ HTML파일에 모든 것을 등록했을 경우)

  ``` html
  <body>
      <div id="app">
          <app-header></app-header>
          <app-content></app-content>
          <app-footer></app-footer>
      </div>
      <div id="app2">
          <app-header></app-header>
          <app-footer></app-footer>
      </div>
      <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
      <script>
  
          Vue.component('app-header', {
              template: '<h1>Header</h1>'
          })
          Vue.component('app-content', {
              template: '<div>Content</div>'
          })
          new Vue({
              el:'#app',
              components: {
                  'app-footer':{
                      template: '<footer>footer</footer>'
                  }
              }
          })
  
          new Vue({
              el:'#app2',
              components: {
                  'app-footer':{
                      template: '<footer>footer</footer>'
                  }
              }
          })
          
      </script>
  </body>
  ```

  예시_싱글 컴포넌트로 변경시)

  ``` vue	
  <template>
    <div>
      <app-header 
        v-bind:propsdata="str" 
        v-on:renew="renewStr"></app-header>
  
    </div>
  </template>
  
  <script>
  import AppHeader from './components/AppHeader.vue'
  export default {
    data: function() {
      return {
        str: 'Header'
      }
    },
    components: {
      'app-header': AppHeader
    },
    methods: {
      renewStr: function() {
        this.str = 'hi';
      }
    }
  }
  </script>
  
  <style>
  
  </style>
  ```



## 라이프사이클 다이어그램

<img src="https://kr.vuejs.org/images/lifecycle.png" style="zoom: 50%;" />

​																												*` 출처 :  https://kr.vuejs.org/v2/guide/instance.html`*

