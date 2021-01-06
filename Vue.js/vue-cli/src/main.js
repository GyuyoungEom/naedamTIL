import Vue from 'vue'
import App from './App.vue' //이게 component 파일

Vue.config.productionTip = false

// var App = {
//   template: '<div>app</div>'
// };

new Vue({
  render: h => h(App),
  components: {
    'app': App
  }
}).$mount('#app');

// new Vue({
//   render: h => h(App),
// }).$mount('#app');
// 위에 나와 있는 new Vue객체는 앞서 사용했던
// new Vue({
//   el: '#app',
//   render: h => h(App),
// })
// 와 동일한 의미이다.