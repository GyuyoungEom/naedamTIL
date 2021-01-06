<template>
  <!-- template 루트는 최상위에 하나만 존재함 
  즉, 하나의 div안에 계속 작성해야 함-->
  <div>
    <app-header 
      v-bind:propsdata="str" 
      v-on:renew="renewStr"></app-header>
    <!-- components태그 -->
    <!-- <app-header v-bind:프롭스 속성 이름="상위 컴포넌트의 데이터 이름"></app-header>
    프롭스 속성 이름은 하위 컴포넌트에서 정리한 속성의 이름 (AppHeader.vue /script에 정의) -->
  </div>
</template>

<script>
import AppHeader from './components/AppHeader.vue'
// import 변수 명 from root 로 작성해서 파일을 받아 올 수 있음
export default {
  data: function() {
    return {
      str: 'Header'
    }
    // 함수 반드시 return 해야함
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