import Vue from 'vue'
import App from './App.vue'
import router from './routes';

//выбрать лучшее место для импорта vue-select или оставить тут
import vSelect from 'vue-select'
import 'vue-select/dist/vue-select.css';
Vue.component('v-select', vSelect)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
