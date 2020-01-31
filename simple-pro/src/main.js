// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
import {getToken,removeToken} from './utils/auth'
import {menuRender} from './common/js/public'

// 引用axios，并设置基础URL为后端服务api地址
var axios = require('axios');

// 将API方法绑定到全局
Vue.prototype.$axios = axios;

Vue.config.productionTip = false;

Vue.use(ElementUI);

//解决vue页面刷新后，根据url路径查询路由表无法找到对应的组件，所以将角色菜单权限保存至localStorage
//localStorage好像只能手动删除，不会随着会话的关闭而删除
// let token = getToken();
// let permission = JSON.parse(window.localStorage.getItem('permission'))
// if(typeof(token) =="undefined" || permission === null ){
//   window.localStorage.clear();
//   removeToken();
//   router.push({path: '/login'})
// }else{
//   let menus = [];
//   permission.forEach(menu => {
//     menus.push(menuRender(menu))
//   });
//   //Object.assign()浅拷贝，那就是直接对menus进行操作
//   store.commit('APPEND_MENU', Object.assign(menus));
//   router.options.routes.push(...menus);
//   router.addRoutes(router.options.routes)
// }

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
  components: { App },
  template: '<App/>'
});
export { router, store}
