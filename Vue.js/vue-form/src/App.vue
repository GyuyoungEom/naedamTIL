<template>
  <form v-on:submit="submitForm">
  <!-- <form v-on:submit.prevent="submitForm"> 
    submit.prevent는 methods안에 있는 event.preventDefault();의 역할을 함-->
    <div>
      <label for="username">id : </label>
      <input type="text" id="username" v-model="username">
    </div>
    <div>
      <label for="password">password : </label>
      <input type="password" id="password" v-model="password">
    </div>
    <button type="submit">login</button>
  </form>
</template>

<script>
import axios from 'axios';
export default {
  data: function() {
    return {
      username:'',
      password:'',
    }
  },
  methods: {
    submitForm: function(event) {
      //event를 인자로 받아야함
      event.preventDefault();
      //submit에 대해서 기본적인 동작을 막기위함
      window.console.log(this.username, this.password);
      var url = 'https://jsonplaceholder.typicode.com/users';
      var data = {
        username: this.username,
        password: this.password,
      }
      // axios.post(url, data);   //데이터를 생성하거나 조작할 때 이용
      // 브라우저에서 서버로 주고 받기 위해 사용하는 라이브러리
      //axios.get();, axios.post(); 두 가지 http방식이 있음

      axios.post(url,data)
        .then(function(response) {
          window.console.log(response);
        })
        .catch(function(error){
          window.console.log(error);
        });
    
    }
  }
}
</script>

<style>

</style>