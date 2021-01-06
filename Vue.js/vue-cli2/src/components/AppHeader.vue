// components의 vue파일은 반드시 두단어의 조합으로 이루어져야 함
// 그 이유는 html의 표준 태그인지, 아닌지 모르기 때문에 충돌이 되지 않도록 하기 위함
<template>
  <header>
      <h1>{{ propsdata }}</h1>
      <button v-on:click="sendEvent">Send</button>
  </header>
</template>

<script>
export default {
    props: ['propsdata'],
    methods: {
        sendEvent: function() {
            this.$emit('renew');
        }
    }
}
</script>

<style>

</style>