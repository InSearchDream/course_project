import Vue from 'vue'
import App from './App.vue'
import router from './routes';

//выбрать лучшее место для импорта vue-select или оставить тут
import vSelect from 'vue-select'
import 'vue-select/dist/vue-select.css';
Vue.component('v-select', vSelect)

import { BootstrapVue } from 'bootstrap-vue'
Vue.use(BootstrapVue)
//import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
